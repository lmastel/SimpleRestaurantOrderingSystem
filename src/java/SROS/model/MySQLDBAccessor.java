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
            return connection;
        } catch (SQLException e) {
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

    
}
