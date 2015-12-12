<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 21/11/2015
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="css/calendar.css">
<html lang="en" class="no-js">
<script>
    $(document).ready(function() {
        $(function() {
            $("#dob").datepicker({
                changeMonth: true,
                changeYear: true,
                yearRange: "1980:2015"
            });
        });
    });
    function closeOverLay() {
            $(".registerOverlay").fadeOut("fast");
            $(".registerOverlayWindow").fadeOut("fast");
            $('.registerOverlayWindow').css("display", "none");
            $('.registerOverlay').remove();
    }
</script>
<body>
<div class="bg">
    <div class="registerOverlay"></div>
    <div id="login-box" class="registerOverlayWindow">
        <div class="registerheaderOverlay">
            <span style="color:#FF7800;font-weight:bold;font-size:1.4rem;font-family:Microsoft YaHei"> Register Now </span>
        </div>
        <form:form method="POST" action="registerBean" commandName="registerCommandName">
            <table>
                <tr>
                    <td><form:input path="firstName"  placeholder="First Name"/></td>
                </tr>
                <tr>
                    <td><form:input path="lastName" placeholder="Last Name"/></td>
                </tr>
                <tr>
                    <td><form:input path="emailId" placeholder="Enter E-Mail"/></td>
                </tr>
                <tr>
                    <td><form:input path="password" type="password" placeholder="Enter Password"/></td>
                </tr>
                <tr>
                    <td><form:input path="confirmPassword" type="password" placeholder="Confirm Password"/></td>
                </tr>
                <tr>
                    <td><form:input path="dateOfBirth" id = "dob" placeholder="Enter date of birth"/></td>
                </tr>
                <tr>
                    <td><form:input path="mobileNo" placeholder="Enter mobile no"/></td>
                </tr>
                <tr>
                    <td><form:input path="aadharNo" placeholder="Enter aadhar no"/></td>
                </tr>
                <tr>
                    <td><form:input path="pinCode" placeholder="Enter PIN code"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="submit" /></td>
                </tr>
            </table>
        </form:form>
        <span id="closeIcon" onclick="closeOverLay()" class="btn_Close" title="Close Window" alt="close"></span>
    </div>
</div>
</body>
</html>
