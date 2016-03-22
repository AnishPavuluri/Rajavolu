<!DOCTYPE HTML>
<html>
<link>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<head>
    <script>
        $(document).ready(function() {
            $("#map").click(function(){
                window.open("https://www.google.co.in/maps/dir//Rajavolu,+Andhra+Pradesh+524322/@14.5433761,78.8365066,9z/data=!4m8!4m7!1m0!1m5!1m1!1s0x3a4ca66255e43e55:0x55f2f59e7ed221ae!2m2!1d79.6055745!2d14.7187643?hl=en")
            });
        });

    </script>
</head>
<body>

    <div class="header">
     <%--<img src="images/LOGO1.PNG">--%>
    </div>
    <div id="border">
        <div class="menu">
            <a href="home"><span id="home">Home</span></a>
            <a href="#"><span id="about">About</span></a>
            <a href="uploadImage"><span id="uploadImage">Gallery</span></a>
            <a href="#"><span id="events">Events</span></a>
            <a href="#"><span id="map">Route Map</span></a>
            <%
                String username = (String) session.getAttribute("user");
                String firstName = (String) session.getAttribute("firstName");
                if (username == null || firstName == null) {
            %>
            <a href="login"><span id="login">Login</span></a>
            <a href="register"><span id="register">Register Now</span></a>
            <% } else {
            %>
            <a href="logout"><span id="logout">Logout</span></a>
            <a href="#"><span id="userName"> Hi,  <%=firstName%></span></a>
            <% }%>
        </div>
    </div>

</body>
</html>

