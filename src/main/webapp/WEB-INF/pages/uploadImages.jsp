<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <form:form action="uploadImage.htm" modelAttribute="uploadItem" name="frm" method="post"
                   enctype="multipart/form-data" onSubmit="return Validate();">
            <table>
                <tr>
                    <td>Event Name: <br/></td>
                    <td><form:input path="eventName" id="eventNameId" type="text"/></td>
                </tr>
                <tr>
                    <td><form:label for="fileData" path="fileData">File</form:label><br/>
                    </td>
                    <td><form:input path="fileData" id="image" type="file"/></td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td><input type="submit" value="Upload"/></td>
                </tr>
            </table>
        </form:form>
        <form id="eventsFormId" name="eventsFormId">
             <select onchange="loadImages();" id="eventSelectBoxId" name="imagesDirectory">
                <c:forEach items="${imagesLocationList}" var="imagesLocation">
                    <option value="${imagesLocation.imagesLocation}">${imagesLocation.eventName}</option>
                </c:forEach>
            </select>
        </form>
        <div id="imagesId">
            <c:if test="${noOfImages > 0}">
            <c:forEach var="i" begin="0" end="${noOfImages-1}">
                <img src="showImage?index=${i}" alt="Upload Image" height="250" width="250"/>
            </c:forEach>
            </c:if>
        </div>
    </div>
</body>
</html>