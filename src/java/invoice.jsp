<%-- 
    Document   : invoice
    Created on : Sep 12, 2013, 2:22:15 PM
    Author     : LPM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice Page</title>

    </head>
    <body>
        <h1>INVOICE</h1>
        <%
            Object objOrderitem = new Object();
            int i = 0;
            do {
                String orderitem = "";
                objOrderitem = request.getAttribute("orderitem"+i++);
                if (objOrderitem != null) {
                    orderitem = objOrderitem.toString();
                    out.print(orderitem);
                }
            } while (objOrderitem != null);


            /*
            String orderitem0 = "";
            Object objOrderitem0 = request.getAttribute("orderitem0");
            if (objOrderitem0 != null) {
                orderitem0 = objOrderitem0.toString();
                out.print(orderitem0);
            }

            String orderitem1 = "";
            Object objOrderitem1 = request.getAttribute("orderitem1");
            if (objOrderitem1 != null) {
                orderitem1 = objOrderitem1.toString();
                out.print(orderitem1);
            }
            */


        %>     
    </body>
</html>
