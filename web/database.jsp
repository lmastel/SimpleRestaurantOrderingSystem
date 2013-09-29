<%-- 
    Document   : database
    Created on : Sep 25, 2013, 2:03:36 PM
    Author     : LPM
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Maintenance</title>
        <link rel="stylesheet" type="text/css" href="css/database.css">
    </head>
    <body>
        <form id="form1" name="form1" method="POST" action="DatabaseController.jsp">
            <h1>Menu Maintenance - Change/Delete</h1>
            <table>
                <tr>
                    <th>Item Description</th>
                    <th>Unit of Measure</th>
                    <th>Unit Price</th></tr>            
            </table>

            <%
                ArrayList<ArrayList> a = (ArrayList<ArrayList>) request.getAttribute("menuitems");
                String id = "";
                String desc = "";
                String um = "";
                String price = "";
                for (int r = 0; r < a.size(); r++) {

                    id = a.get(r).get(0).toString();
                    desc = (String) a.get(r).get(1);
                    um = (String) a.get(r).get(2);
                    NumberFormat currency = NumberFormat.getCurrencyInstance();
                    price = currency.format(a.get(r).get(3));


            %>
            <table>

                <tr><td><input type="text" size ="45" value="<%=desc%>"></td>
                    <td><input type="text" size="25" value="<%=um%>"></td>
                    <td><input type="text" size ="10" value="<%=price%>"></td>
                    <td><input id ="chg" type ="button" name ="change" value="change"></td>
                    <td><input id ="del" type ="button" name ="delete" value="delete"></td></tr>
            </table>
            <%
                }
            %>
        </form>
        <form id="form2" name="form2" method="POST" action="DatabaseController.jsp">
            <h1>Menu Maintenance- Add</h1>
            <table>
                <tr>
                    <th>Item Description</th>
                    <th>Unit of Measure</th>
                    <th>Unit Price</th></tr>  
                

                <tr><td><input type="text" size ="45" value="<%=desc%>"></td>
                    <td><input type="text" size="25" value="<%=um%>"></td>
                    <td><input type="text" size ="10" value="<%=price%>"></td>
                    <td><input id ="add" type ="button" name ="add" value="add"></td></tr>
            </table>
            </form>
    </body>
</html>
