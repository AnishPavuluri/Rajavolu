<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Welcome</title>
</head>
<body>
<h2><a href="uploadfile.jsp">Upload Example</a></h2>
<%
    if (session.getAttribute("uploadImage") != null
            && !(session.getAttribute("uploadImage")).equals("")) {
%>
<h3>Uploaded File</h3>
<br>
<img src="<%=session.getAttribute("uploadImage")%>" alt="Upload Image"/>
showImage
<img src="showImage" alt="Upload Image"/>

<%
        //session.removeAttribute("uploadImage");
    }
%>
</body>
</html>