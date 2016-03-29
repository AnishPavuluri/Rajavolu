<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>--%>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<link rel="stylesheet" href="css/login.css">
<html lang="en" class="no-js">
<script>
    function loginOverLay() {
        $(".overlay").fadeOut("fast");
        $(".overlayWindow").fadeOut("fast");
        $('.overlayWindow').css("display", "none");
        $('.overlay').remove();
    }
    function forgot() {
        $(".loginDev").hide();
        $("#forgotId").show();
    }
</script>
<body>
<div class="bg">
    <div class="overlay"></div>
    <div class="overlayWindow">
        <form:form method="POST" action="loginFrom" commandName="loginCommandName">
            <div class="loginDev" id="loginDev">
                <spring:bind path="emailId">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="emailId" id="emailId" class="form-control" placeholder="Enter E-Mail address"/>
                    <form:errors path="emailId" id="error" cssClass="error"/>
                    </span>
                </spring:bind>
                <spring:bind path="password">
                    <span class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input path="password" id="password" type="password" class="form-control"
                                placeholder="Enter Password"/>
                    <form:errors path="password" id="error" cssClass="error"/>
                    </span>
                </spring:bind>
                <input type="submit" id="login" value="Login"/>
                <a href="forgot" class="forgot">forgot password?</a>
            </div>
        </form:form>
        <span id="loginCloseIcon" onclick="loginOverLay()" class="btn_Close" title="Close Window" alt="close"></span>
    </div>
</div>
</body>
</html>