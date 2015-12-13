<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <form:form method="POST" action="loginFrom" commandName="loginCommandName">
            <table>
                <tr>
                    <td><form:input path="emailId" placeholder="Enter E-Mail/Mobile No"/></td>
                </tr>
                <tr>
                    <td><form:input path="password" type="password" placeholder="Enter Password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"/></td>
                    <td>
                        <a href="#" class="forgot">forgot password?</a>
                    </td>
                </tr>
            </table>
        </form:form>
        <span id="loginCloseIcon" onclick="loginOverLay()" class="btn_Close" title="Close Window" alt="close"></span>
    </div>
</div>
</body>
</html>