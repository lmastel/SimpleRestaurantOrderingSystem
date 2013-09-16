<%-- 
    Document   : invoice
    Created on : Sep 12, 2013, 2:22:15 PM
    Author     : LPM
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LPM Pizza Restaurant</title>
        <link rel="stylesheet" type="text/css" href="css/invoice.css">
        
    </head>
    <body>
        
        <h1>LPM Pizza Restaurant</h1>
        <h4>INVOICE</h4>
        <table>
            <tr>
                <th>Item</th>
                <th>Price</th>
            </tr>
            <%
                TreeMap<String, String> ii = (TreeMap<String, String>) request.getAttribute("orderitem");

                for (Map.Entry invoice : ii.entrySet()) {
            %>
            <tr><td><%=invoice.getKey()%></td>
                <td><%=invoice.getValue()%></td></tr>

            <%
                }
            %>     

            <%
                //String total = request.getAttribute("ordertotal");
                
            %> 
            <tr><td>Total</td>
                <td><%out.print(request.getAttribute("ordertotal"));%></td></tr>
        </table>
    </body>
</html>
