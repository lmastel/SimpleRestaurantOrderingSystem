<%-- 
    Document   : invoice
    Created on : Sep 12, 2013, 2:22:15 PM
    Author     : LPM
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SROS.model.MenuService"%>
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
        <form id="form1" name="form1" method="POST" action="MenuController.jsp"
              >

            <h1>LPM Pizza Restaurant</h1>
            <h4>INVOICE</h4>
            <table>
                <tr>
                    <th>Item</th>
                    <th></th>
                    <th></th>
                    <th>Price</th>
                </tr>
                <%
                    ArrayList<ArrayList> ii = (ArrayList<ArrayList>) request.getAttribute("invoiceitem");
                    String id = "";
                    String desc = "";
                    String um = "";
                    String price = "";
                    //out.print(ii.size());
                    for (int r = 0; r < ii.size(); r++) {

                        id = ii.get(r).get(0).toString();
                        desc = (String) ii.get(r).get(1).toString();
                        //desc = (String) ii.get(r).toString();
                        um = (String) ii.get(r).get(2);
                        NumberFormat currency = NumberFormat.getCurrencyInstance();
                        price = currency.format(ii.get(r).get(3));
                        //price = currency.format(ii.get(r));



                %>
                <tr><td><%=id%></td>
                    <td><%=desc%></td>
                    <td><%=um%></td>
                    <td><%=price%></td></tr>

                <%
                    }
                %>     

                <%
                    //String total = request.getAttribute("ordertotal");

                %> 
                <tr><td></td>
                    <td></td>
                    <td><h4>Total</h4></td>                
                    <td><%out.print(request.getAttribute("ordertotal"));%></td></tr>
            </table>

        </form>
        <form id="form1" name="form1" method="GET" action="index.html">
            <h1>
                <input type="submit" value="Submit Payment">
                
            </h1>
        </form>
    </body>
</html>
