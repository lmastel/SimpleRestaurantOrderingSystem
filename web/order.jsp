<%-- 
    Document   : order
    Created on : Sep 11, 2013, 8:29:38 PM
    Author     : LPM
--%>


<%@page import="java.text.NumberFormat"%>
<%@page import="SROS.model.MySQLDBAccessor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SROS.model.MenuService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LPM Pizza Restaurant Order Page</title>
        <link rel="stylesheet" type="text/css" href="css/order.css">
        <script>
            function validate() {
                var namelist = "";
                with (document.form1) {
                    for (var i = 0; i < menuitems.length; i++) {
                        if (menuitems[i].checked) {
                            namelist += menuitems[i].value + "\n";

                        }
                    }
                }
                if (namelist == "") {
                    alert("select menuitems");
                } else {
                    document.form1.submit();
                }
                return false;
            }




        </script>
    </head>
    <body>
        <form id="form1" name="form1" method="POST" action="OrderController.jsp"
              onsubmit="return validate();">
            <h1>LPM Pizza Restaurant</h1>
            <h2>Select Your Pizza and Extras Here</h2>
            <table>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Item</th>
                    <th></th>
                    
                    <th>Price</th>
                </tr>

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
                <tr><td></td>


                    <td> <input type="checkbox" name="menuitems" value="<%=id%>"><td><%=desc%></td><td><%=um%></td><td></td><td><%=price%></td></tr>

                <%


                    }
                %>
            </table>

            <h1>
                <input type="submit" value="Place Order">
                <input type="reset" value="Start Over">
            </h1>
        </form>

    </body>
</html>
