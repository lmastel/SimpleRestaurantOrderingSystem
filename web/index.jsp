<%-- 
    Document   : index
    Created on : Oct 5, 2013, 11:30:07 PM
    Author     : LPM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LPM Pizza Restaurant</title>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <form id="form1" name="form1" method="POST" action="MenuController.jsp">
            <h1>LPM Pizza Restaurant</h1>
            <h2>Order Brookfield's Best Pizza</h2>
            <h1><input type="submit" value="Order Now !"></h1>


            <p>
               <a href="MenuMaintainController.jsp">LPM Employee Menu Maintenance</a> 
            </p>
            <p>
                ${applicationScope.dailySpecial}
            </p>
        </form>
    </body>
</html>
