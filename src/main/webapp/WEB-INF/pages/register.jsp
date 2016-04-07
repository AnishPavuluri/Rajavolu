<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 21/11/2015
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="css/calendar.css">
<html lang="en" class="no-js">
<script>
    var loginController = function(){
        window.location= "login";
    };
    $(document).ready(function () {
        $(function () {
            $("#dob").datepicker({
                changeMonth: true,
                changeYear: true,
                yearRange: "1980:2016"
            });
        });
        if ($("#newUser").text().trim() != '') {
            $(function () {
                $(".registerOverlayWindow").fadeOut("fast");
            });
            setTimeout(loginController, 3000);
        }
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
    <div class="registerOverlay">
        <%
            Object newUser = request.getAttribute("newUser");
            Object userName = request.getAttribute("userName");
            if (newUser != null) {
        %>
        <div id="newUser">
            <span style="color:green">
                <%=userName%>,&nbsp;<%=newUser%>
            </span>
        </div>
        <% }%>
    </div>
    <div id="login-box" class="registerOverlayWindow">
        <div class="registerheaderOverlay">
            <span style="color:#FF7800;font-weight:bold;font-size:1.3rem;margin-left:-36px;font-family:Microsoft YaHei"> Register Now </span>
        </div>
        <form:form class="cd-form" method="POST" action="registerBean" commandName="registerCommandName">
            <spring:bind path="firstName">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="firstName" id="firstName" class="form-control" placeholder="First Name"/>
                    <form:errors path="firstName" cssClass="error"/>
                    </span>
            </spring:bind>
            <spring:bind path="lastName">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="lastName" class="form-control" placeholder="Last Name"/>
                    <form:errors path="lastName" cssClass="error"/>
                    </span>
            </spring:bind>
            <spring:bind path="emailId">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="emailId" class="form-control" placeholder="Enter E-Mail"/>
                    <form:errors path="emailId" cssClass="error"/>
                    </span>
            </spring:bind>
            <spring:bind path="emailId">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="password" type="password" class="form-control" placeholder="Enter Password"/>
                    <form:errors path="password" cssClass="error"/>
                    </span>
            </spring:bind>
            <spring:bind path="confirmPassword">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="confirmPassword" type="password" class="form-control"
                                placeholder="Confirm Password"/>
                    <form:errors path="confirmPassword" cssClass="error"/>
                    </span>
            </spring:bind>
            <spring:bind path="dateOfBirth">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="dateOfBirth" id="dob" class="form-control" placeholder="Enter date of birth"/>
                    <form:errors path="dateOfBirth" cssClass="error"/>
                    </span>
            </spring:bind>
            <spring:bind path="mobileNo">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="mobileNo" class="form-control" placeholder="Enter mobile no"/>
                    <form:errors path="mobileNo" cssClass="error"/>
                </span>
            </spring:bind>
            <spring:bind path="aadharNo">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="aadharNo" class="form-control" placeholder="Enter aadhar no"/>
                    <form:errors path="aadharNo" cssClass="error"/>
                    </span>
            </spring:bind>
            <spring:bind path="pinCode">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="pinCode" class="form-control" placeholder="Enter PIN code"/>
                    <form:errors path="pinCode" cssClass="error"/>
                    </span>
            </spring:bind>
            <input type="submit" value="submit"/>
        </form:form>
        <span id="closeIcon" onclick="closeOverLay()" class="btn_Close" title="Close Window" alt="close"></span>
    </div>
</div>
</body>
</html>
