<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<c:forEach var="i" begin="0" end="${noOfImages-1}">
    <img src="showImage?index=${i}" alt="Upload Image" height="250" width="250"/>
</c:forEach>