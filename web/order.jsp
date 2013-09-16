<%-- 
    Document   : order
    Created on : Sep 11, 2013, 8:29:38 PM
    Author     : LPM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LPM Pizza Restaurant Order Page</title>
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
                    //alert(namelist);
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

            <input type="checkbox" name="menuitems" value="01 Cheese Pizza">01 Cheese Pizza $10.00<br>
            <input type="checkbox" name="menuitems" value="02 Pepperoni Pizza">02 Pepperoni Pizza $12.00<br>
            <input type="checkbox" name="menuitems" value="03 Sausage Pizza">03 Sausage Pizza $13.00<br>
            <input type="checkbox" name="menuitems" value="04 Veggie Pizza">04 Veggie Pizza $11.00<br>
            <input type="checkbox" name="menuitems" value="05 BBQ Chicken Pizza">05 BBQ Chicken Pizza $13.00<br>
            <input type="checkbox" name="menuitems" value="06 Hawiian Pizza">06 Hawiian Pizza $ 14.00<br>
            <input type="checkbox" name="menuitems" value="07 Mexican Pizza">07 Mexican Pizza $14.00<br>
            <input type="checkbox" name="menuitems" value="08 Margherita Pizza">08 Margherita Pizza $14.00<br>
            <input type="checkbox" name="menuitems" value="09 Extra Cheese">09 Extra Cheese $2.50 <br>
            <input type="checkbox" name="menuitems" value="10 Extra Pepperoni">10 Extra Pepperoni $2.50<br>
            <input type="checkbox" name="menuitems" value="11 Extra Sausage">11 Extra Sausage $ 2.75<br>
            <input type="checkbox" name="menuitems" value="12 Onions">12 Onions $1.00<br>
            <input type="checkbox" name="menuitems" value="13 Black Olives">13 Black Olives $1.50<br>
            <input type="checkbox" name="menuitems" value="14 Peppers">14 Peppers $1.75<br>
            <input type="checkbox" name="menuitems" value="15 Mushrooms">15 Mushrooms $1.75<br>
            <input type="checkbox" name="menuitems" value="16 Garlic Bread">16 Garlic Bread $4.00<br>
            <input type="checkbox" name="menuitems" value="17 Soda">17 Soda $3.50<br>
            <input type="checkbox" name="menuitems" value="18 Beer">18 Beer $5.25<br>

            <p></p>
            <input type="submit" value="Place Order">
            <input type="reset" value="Start Over">
        </form>

    </body>
</html>
