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
<html lang="en" class="no-js">
<form:errors/>
<body>
<div class="bg">
    <div class="registerOverlay"></div>
    <div id="login-box" class="registerOverlayWindow">
        <form:form method="POST" action="registerBean" commandName="registerCommandName">
            <form:errors/>
            <table>
                <tr>
                    <td><label for="firstName">First Name:</label></td>
                    <td><form:input path="firstName"  id="fn" placeholder="First Name"/></td>
                </tr>
                <tr>
                    <td><label for="lastName">Last Name:</label></td>
                    <td><form:input path="lastName" placeholder="Last Name"/></td>
                </tr>
                <tr>
                    <td><label for="emailId">E-Mail:</label></td>
                    <td><form:input path="emailId" placeholder="Enter E-Mail"/></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><form:input path="password" placeholder="Enter Password"/></td>
                </tr>
                <tr>
                    <td><label for="confirmPassword">Re-Enter Password:</label></td>
                    <td><form:input path="confirmPassword" placeholder="Re-Enter Password"/></td>
                </tr>
                <tr>
                    <td><label for="dateOfBirth">DOB:</label></td>
                    <td><form:input path="dateOfBirth" placeholder="DD/MM/YYYY"/></td>
                </tr>
                <tr>
                    <td><label for="mobileNo">Mobile No:</label></td>
                    <td><form:input path="mobileNo" placeholder="Enter mobile no"/></td>
                </tr>
                <tr>
                    <td><label for="aadharNo">Aadhar No:</label></td>
                    <td><form:input path="aadharNo" placeholder="Enter aadhar no"/></td>
                </tr>
                <tr>
                    <td><label for="pinCode">PIN Code:</label></td>
                    <td><form:input path="pinCode" placeholder="Enter PIN code"/></td>
                </tr>
                <input type="submit" value="submit" />
            </table>
        </form:form>
    </div>
</div>
</body>
</html>
