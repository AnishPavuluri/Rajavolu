<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<form action="/sample">
<center>Web Pages</center>
<select name="pageName">
    <option>option1</option>
    <option>option2</option>
    <option>option3</option>
    <option>option4</option>
</select>
    <input type="SUBMIT">
</form>
</body>
</html>
############<s:property/><--------
--><s:property value="name"/><br/>
--><s:property value="#session['a']"/><br/>
--><s:property value="#session['b']"/>     <br/>
