<%-- 
    Document   : test2
    Created on : Sep 27, 2013, 8:22:57 PM
    Author     : LPM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function getRadioCheckedValue(radio_name)
            {
                //alert(radio_name);
                var oRadio = document.forms[0].elements[radio_name];

                for (var i = 0; i < oRadio.length; i++)
                {
                    if (oRadio[i].checked)
                    {
                        alert("checked");
                        return oRadio[i].value;
                    }
                    alert("not checked");
                }
                alert("return");
                return '';
            }
        </script>
    </head>
    <body>
        <input type="radio" id="work_abroad_y" name="work_abroad" value="y" /><label for="work_abroad_y">Yes</label>
        <input type="radio" id="work_abroad_n" name="work_abroad" value="n" /><label for="work_abroad_n">No</label>
        <

        <input type="button" onclick="getRadioCheckedValue('work_abroad');">Add To Cart




    </body>
</html>
