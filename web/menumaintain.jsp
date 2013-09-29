<%-- 
    Document   : menumaintain
    Created on : Sep 26, 2013, 12:28:26 PM
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
        <link rel="stylesheet" type="text/css" href="css/menumaintain.css">


    </head>
    <body >
        <form id="form1" name="form1" method="POST" action="MenuMaintainController.jsp">       

            <h1>LPM Pizza Restaurant - Menu Maintenance</h1>

            <div id="head1">

                <div id="item"><input class ="head1" type="text" size ="5" value="Item"></div>

                <div id="desc"><input class ="head1" type="text" size ="30" value="Item Description"></div>

                <div id="um"><input class ="head1" type="text" size ="15" value="Unit of Measure"></div>

                <div id="price"><input class ="head1" type="text" size ="7" value="Unit Price"></div>


            </div>
            <%
                ArrayList<ArrayList> a = (ArrayList<ArrayList>) request.getAttribute("menuitems");
                String id = "";
                String desc = "";
                String um = "";
                Double price = 0.0;


                String[] xrefRows = new String[100];
                for (int r = 0; r < a.size(); r++) {

                    id = a.get(r).get(0).toString();

                    xrefRows[r] = id;
                    //out.print(xrefRows[r]);

                    desc = (String) a.get(r).get(1);
                    um = (String) a.get(r).get(2);
                    NumberFormat currency = NumberFormat.getNumberInstance();
                    //price = currency.format(a.get(r).get(3));
                    //price = (Double) a.get(r).get(3);
                    NumberFormat number = NumberFormat.getNumberInstance();
                    number.setMaximumFractionDigits(2);
                    number.setMinimumFractionDigits(2);
                    String strPrice =
                            number.format(a.get(r).get(3));


            %>

            <div id="body">
                <input type="hidden" name="jspname"  value="/menumaintain"/>  
                <input type="hidden" name="xrefRows"  value="<%=id%>"/>  
                <div id="viewrow"><input type="text" name="viewrows" size ="5" value="<%=r + 1%>"></div> 
                <div id="desc"><input type="text" name="descs" size ="30" value="<%=desc%>"></div>                 
                <div id="um"><input type="text" name="ums" size ="15" value="<%=um%>"></div>
                <div id="price"><input type="text" name="prices" size ="7" value="<%=strPrice%>"></div>

                <input id="change" type="radio" name="radiocd"  value="CHANGE"> change
                <input id="delete" type="radio" name="radiocd"  value="DELETE"> delete

                <input id ="chgdel" name="dbpkey" type ="submit" value="<%=id%>"> submit

            </div>
            <%
                }

            %>

        </form>

        <form id="form2" name="form2" method="POST" action="MenuAddController.jsp">

            <div id="head2">

                <div id="desc"><input class ="head2" type="text" size ="30" value="Item Description"></div>

                <div id="um"><input class ="head2" type="text" size ="16" value="Unit of Measure"></div>

                <div id="price"><input class ="head2" type="text" size ="7" value="Unit Price"></div>
            </div>

            <div id="body2">

                <div id="desc2"><input class ="add" name="desc2" type="text" size ="30" value="description"></div>

                <div id="um2"><input class ="add" name="um2" type="text" size ="15" value="unit of measure"></div>

                <div id="price2"><input class ="add" name="price2" type="text" size ="7" value="unit price"></div>


                <div><input id ="add" type ="submit" name ="add" value="add"> </div> 
            </div>
        </form>
    </body>
</html>
