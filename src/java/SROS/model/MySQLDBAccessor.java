/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SROS.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author LPM
 */
public class MySQLDBAccessor {

    private String url = "jdbc:mysql://localhost:3306/restaurant_db";
    private String username = "root";
    private String password = "admin";

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection good");
            return connection;
        } catch (SQLException e) {
            System.out.println("connection bad");
            String message = e.getMessage().toString();
            String title = "Class MySQLDBAccessor method getConnection";
            System.err.println(message + " " + title);
            //outputExceptionMessage(message, title);
            return null;
        }
    }

    public final ArrayList<ArrayList> getResultSetRows() {
        String sql = "SELECT menu_id, item_desc, unit_of_measure, unit_price FROM menu";
        //String sql = "SELECT * FROM menu";

        ArrayList<ArrayList> tablerows = new ArrayList<ArrayList>();

        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            tablerows = getRows(rs);
            ps.close();
            connection.close();

            
            return tablerows;

        } catch (SQLException e) {
            String message = e.getMessage().toString();
            String title = "Class MySQLDBAccessor method getResultSetRows";
            System.err.println(message + " " + title);
            //outputExceptionMessage(message, title);
            return null;
        }
    }

    public final ArrayList getResultSetRow(int id) {
        String sql = "SELECT menu_id, item_desc, unit_of_measure, unit_price "
                + "FROM menu WHERE menu_id = ?";


        ArrayList tablerows = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            tablerows = getSingleRow(rs);
            ps.close();
            connection.close();

            
            return tablerows;

        } catch (SQLException e) {
            String message = e.getMessage().toString();
            String title = "Class MySQLDBAccessor method getResultSetRows";
            System.err.println(message + " " + title);
            //outputExceptionMessage(message, title);
            return null;
        }
    }

    public ArrayList<String> getColumnNames(ResultSet results)
            throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        return columnNames;
    }

    public ArrayList<ArrayList> getRows(ResultSet results)
            throws SQLException {
        ArrayList<ArrayList> rows = new ArrayList<>();
        ResultSetMetaData metaData = results.getMetaData();
        
        while (results.next()) {
            ArrayList<Object> row = new ArrayList<>();
            
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                if (metaData.getColumnType(i) == Types.VARCHAR) {
                    row.add(results.getString(i));
                } else if (metaData.getColumnType(i) == Types.INTEGER) {
                    row.add(results.getInt(i));
                } else if (metaData.getColumnType(i) == Types.DOUBLE) {
                    row.add(results.getDouble(i));
                }
            }

            rows.add(row);

        }

        return rows;
    }
    
    public ArrayList getSingleRow(ResultSet results)
            throws SQLException {
        ArrayList rows = new ArrayList<>();
        ResultSetMetaData metaData = results.getMetaData();
        
        System.out.println("metaData.getTableName" + metaData.getTableName(1));
                
                
        while (results.next()) {
            ArrayList<Object> row = new ArrayList<>();
            
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                if (metaData.getColumnType(i) == Types.VARCHAR) {
                    row.add(results.getString(i));
                } else if (metaData.getColumnType(i) == Types.INTEGER) {
                    row.add(results.getInt(i));
                } else if (metaData.getColumnType(i) == Types.DOUBLE) {
                    row.add(results.getDouble(i));
                }
            }

            //rows.add(row);
            rows = row;

        }

        return rows;
       
    }
    
    public final boolean insertRow(final String itemDesc,
            final String unitOfMeasure, final double unitPrice) {
        
        int numberOfRowsInserted = 0;
        String sql = "INSERT INTO menu "
                + "(item_desc, unit_of_measure, unit_price) "
                + "VALUES(?, ?, ?)";

        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, itemDesc);
            ps.setString(2, unitOfMeasure);
            ps.setDouble(3, unitPrice);
            
            numberOfRowsInserted = ps.executeUpdate();
            System.out.println("numberOfRowsInserted = " + numberOfRowsInserted);

            ps.close();
            connection.close();

            return true;

        } catch (SQLException e) {
            String message = e.getMessage().toString();
            String title = "Class MySQLDBAccessor method insertRow";
            //outputExceptionMessage(message, title);
            System.err.println("message" + " " + title);
            System.err.println("error code= " + e.getErrorCode());
            return false;
        }
    }
    
    public final boolean updateRow(final int menuId, final String itemDesc, 
            final String unitOfMeasure, final double unitPrice) throws SQLException {
        int numberOfRowsUpdated = 0;
        
        String sql = "UPDATE menu SET item_desx = ?, unit_of_measure = ?, unit_price = ? WHERE menu_id = ?";

        //UPDATE menu SET menu_id = 17, item_desc = "Whisky", unit_of_measure = "1oz", unit_price = 3.50 WHERE menu_id = 18;
        
           Connection connection = getConnection();
           PreparedStatement ps = connection.prepareStatement(sql);            

            ps.setString(1, itemDesc);
            
            ps.setString(2, unitOfMeasure);

            ps.setDouble(3, unitPrice);
            
            ps.setInt(4, menuId);

            numberOfRowsUpdated = ps.executeUpdate();
            System.out.println("numberOfRowsUpdated = " + numberOfRowsUpdated);

            ps.close();

            connection.close();

            return true;


    }

// public final boolean updateRow(final int menuId, final String itemDesc, 
//            final String unitOfMeasure, final double unitPrice) {
//        int numberOfRowsUpdated = 0;
//        
//        String sql = "UPDATE menu SET item_desc = ?, unit_of_measure = ?, unit_price = ? WHERE menu_id = ?";
//
//        //UPDATE menu SET menu_id = 17, item_desc = "Whisky", unit_of_measure = "1oz", unit_price = 3.50 WHERE menu_id = 18;
//        
//        try (Connection connection = getConnection();
//                PreparedStatement ps = connection.prepareStatement(sql)) {            
//
//            ps.setString(1, itemDesc);
//            
//            ps.setString(2, unitOfMeasure);
//
//            ps.setDouble(3, unitPrice);
//            
//            ps.setInt(4, menuId);
//
//            numberOfRowsUpdated = ps.executeUpdate();
//            System.out.println("numberOfRowsUpdated = " + numberOfRowsUpdated);
//
//            ps.close();
//
//            connection.close();
//
//            return true;
//
//        } catch (SQLException e) {
//            String message = e.getMessage().toString();
//            String title = "Class MySQLDBAccessor method updateRow";
//            //outputExceptionMessage(message, title);
//            System.err.println("message" + " " + title);
//            System.err.println("error code= " + e.getErrorCode());
//            return false;
//        }
//    }
    
     public final boolean deleteRow(final int id) {
        int numberOfRowsDeleted = 0;
        String sql = "DELETE FROM menu WHERE menu_id = ?";

        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            System.out.println("deleteRow id =" + id);
            ps.setInt(1, id);

            numberOfRowsDeleted = ps.executeUpdate();
            
            System.out.println("numberOfRowsDeleted =" + numberOfRowsDeleted);

            ps.close();
            connection.close();

            return true;
        } catch (SQLException e) {
            String message = e.getMessage().toString();
            String title = "Class MySQLDBAccessor method deleteRow";
            //outputExceptionMessage(message, title);
            System.err.println("message" + " " + title);
            System.err.println("error code= " + e.getErrorCode());
            return false;
        }
    }

    
    public static void main(String[] args) {
        MySQLDBAccessor db = new MySQLDBAccessor();
        db.getConnection();
        db.getResultSetRow(0);
        //db.deleteRow(17);
        //db.updateRow("Gin", "1 oz", 2.50, 17);
        //db.insertRow("Moz Sticks", "6n pc", 5.50);
       
        
    }
    
    
    
}//end of class MySQLDBAccessor
