<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <%-- <script language="JavaScript">
         function Validate() {
             var image = document.getElementById("image").value;
             if (image != '') {
                 var checkimg = image.toLowerCase();
                 if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
                     alert("Please enter Image File Extensions .jpg,.png,.jpeg");
                     document.getElementById("image").focus();
                     return false;
                 }
             }
             return true;
         }
     </script>--%>
</head>
<body>
    <div class="bodyUpload">
        <form:form action="uploadImage.htm" modelAttribute="uploadItem" name="frm" method="post"
                   enctype="multipart/form-data" onSubmit="return Validate();">
            <table>
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
    </div>
</body>
</html>