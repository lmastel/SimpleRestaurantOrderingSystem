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
        <script>
            function validateForm1() {
                var namelist = "";
                with (document.form1) {
                    for (var i = 0; i < radiocd.length; i++) {
                        if (radiocd[i].checked) {
                            namelist += radiocd[i].value + "\n";
                        }
                    }

                    if (namelist == "") {
                        alert("select change or delete");
                        return false;
                    }
                }
            }


            function validateForm2() {

                var x = document.forms["form2"]["desc2"].value;
                if (x == null || x == "")
                {
                    alert("Item Description name must be filled out");
                    return false;
                }

                x = document.forms["form2"]["um2"].value;
                if (x == null || x == "")
                {
                    alert("Unit of Measure must be filled out");
                    return false;
                }
                x = document.forms["form2"]["price2"].value;
                if (x == 0 || x < 0)
                {
                    alert("Unit Price must be greater than 0");
                    return false;
                }
                if (x == null || x == "")
                {
                    alert("Unit Price must be filled out");
                    return false;
                }

                if (x.match(/[^.\d]/))
                {
                    alert("Unit Price must be a number");
                    return false;
                }
            }
        </script>


    </head>
    <body >
        <form id="form1" name="form1" method="POST" action="MenuMaintainController.jsp"
              onsubmit="return validateForm1();">

            <h1>LPM Pizza Restaurant - Menu Maintenance</h1>

            <div id="head1">

                <div id="item"><input class ="head1" type="text" size ="5" value="Item"></div>

                <div id="desc"><input class ="head1" type="text" size ="30" value="Item Description"></div>

                <div id="um"><input class ="head1" type="text" size ="15" value="Unit of Measure"></div>

                <div id="price"><input class ="head1" type="text" size ="7" value="Unit Price"></div>


            </div>
            <%
               
                String message = (String)request.getAttribute("message");
                if (message == null){
                    message = "";
                }
                
                ArrayList<ArrayList> a = (ArrayList<ArrayList>) request.getAttribute("menuitems");
                String id = "";
                String desc = "";
                String um = "";
                Double price = 0.0;


                String[] xrefRows = new String[100];
                for (int r = 0; r < a.size(); r++) {

                    id = a.get(r).get(0).toString();
                    
                    xrefRows[r] = id;
                   
                    desc = (String) a.get(r).get(1);
                    um = (String) a.get(r).get(2);
                    
                    NumberFormat number = NumberFormat.getNumberInstance();
                    number.setMaximumFractionDigits(2);
                    number.setMinimumFractionDigits(2);
                    String strPrice = number.format(a.get(r).get(3));


            %>

            <div id="body">
                
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
            
             <div ><input id="msg" type="text" name="message" size ="68" value="<%=message%>"></div>
             
             <p>
                <%=request.getAttribute("webMaster")%>
             </p>

        </form>

        <form id="form2" name="form2" method="POST" action="MenuAddController.jsp" 
              onsubmit="return validateForm2();">


            <div id="head2">

                <div id="desc"><input class ="head2" type="text" size ="30" value="Item Description"></div>

                <div id="um"><input class ="head2" type="text" size ="16" value="Unit of Measure"></div>

                <div id="price"><input class ="head2" type="text" size ="7" value="Unit Price"></div>
            </div>

            <div id="body2">

                <div id="desc2"><input class ="add" name="desc2" type="text" size ="30" value=""></div>

                <div id="um2"><input class ="add" name="um2" type="text" size ="15" value=""></div>

                <div id="price2"><input class ="add" name="price2" type="text" size ="7" value="0.00"></div>

                <!--<div id="price2"><input class ="add" name="price2" type="number"  min="1" max="5" value="0.00"></div>-->

                <div><input id ="add" type ="submit" name ="add" value="add"> </div> 
            </div>
            <p>
                <a href="index.html">Exit Menu Maintenance</a> 
        </form>
    </body>
</html>
