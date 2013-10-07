<%-- 
    Document   : test1
    Created on : Sep 30, 2013, 3:29:25 PM
    Author     : LPM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script type="text/javascript">
function val_many(f, n){
for (var e = f.elements, i = e.length - 1; i > -1; --i)
if (e[i].type && e[i].type == 'text' && e[i].name && e[i].name == n && (e[i].value == ''
|| isNaN(e[i].value - 0) || /\./.test(e[i].value) || e[i].value > 9999)){
alert('Some Message');
e[i].focus();
return false;
}
return true;
}
</script>
</head>
<body>
<form action="#" onsubmit="return val_many(this, 'some_name');">
<input type="text" name="some_name"><br>
<input type="text" name="some_name"><br>
<input type="text" name="some_name"><br>
<input type="text" name="some_name"><br>
<input type="submit" value="Go!">
</form>
</body>
</html>
