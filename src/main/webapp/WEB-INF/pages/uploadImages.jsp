<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/gallery.css"/>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
     <script language="JavaScript">
         function loadImages(){
              $("#imagesId").load("loadImagesByEvent", $("#eventsFormId").serialize());
         }
     </script>
</head>
<body>
    <div class="bodyUpload">
        <c:if test="${sessionScope.user != null}">
            <form:form action="uploadImage" modelAttribute="uploadItem" name="frm" method="post"
                       enctype="multipart/form-data" onSubmit="return Validate();">
                <span style="color:#FF7800;font-weight:bold;font-size:16px;margin-left:-577px;margin-right:-60px;font-family:Microsoft YaHei">Event Name:</span>
                <form:input path="eventName" id="eventNameId" class="form-control" placeholder="ex:sriramanavami" type="text"/>
                <span class="file-wrapper">
                    <span class="button">Browse</span>
                        <form:input path="fileData" id="image" type="file"/>
                </span>
                <div class="">
                    <input type="submit" value="Upload"/>
                </div>
            </form:form>
            <c:if test="${errorMessage != null}">
            <div class="uploadError">
                <c:out value="${errorMessage}"/>
            </div>
            </c:if>
        </c:if>
        <form id="eventsFormId" name="eventsFormId">
            <span style="color:#FF7800;font-weight:bold;font-size:16px;margin-left:115px;font-family:Microsoft YaHei">Select Event:</span>
            <select onchange="loadImages();" id="eventSelectBoxId" name="imagesDirectory">
                <c:forEach items="${imagesLocationList}" var="imagesLocation">
                    <option class="form-control" value="${imagesLocation.imagesLocation}">${imagesLocation.eventName}</option>
                </c:forEach>
            </select>
        </form>
        <div id="imagesId">
            <c:if test="${noOfImages > 0}">
                <jsp:include page="imagesPage.jsp"/>
            </c:if>
        </div>
    </div>
</body>
</html>