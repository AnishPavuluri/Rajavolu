<%--
  Created by IntelliJ IDEA.
  User: Srinivas.V
  Date: 26/03/2016
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</script>
<body>
<div class="bg">
  <div class="overlay"></div>
  <div class="overlayWindow">
    <form:form method="POST" action="forgot" commandName="forgotCommandName">
      <div class="forgot" id="forgotPwd">
          <spring:bind path="forgotPwd">
              <span class="form-group ${status.error ? 'has-error' : ''}">
              <form:input path="forgotPwd" id="forgotPwd" class="form-control"
                          placeholder="Enter your register email"/>
              <form:errors path="forgotPwd" cssClass="error"/>
          </spring:bind>
          <input type="submit" id="sendId" value="Email Password"/>
      </div>
    </form:form>
    <span id="loginCloseIcon" onclick="loginOverLay()" class="btn_Close" title="Close Window" alt="close"></span>
  </div>
</div>
</body>
</html>