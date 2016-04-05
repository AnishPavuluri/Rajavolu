<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<c:forEach var="i" begin="0" end="${noOfImages-1}">
    <img src="showImage?index=${i}&filePath=${filePath}" alt="Upload Image" height="300" width="300"/>
</c:forEach>