<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 05/03/2016
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
<body>
<div style='overflow:hidden;height:440px;width:700px;'>
  <div id='gmap_canvas' style='height:440px;width:700px;'></div>
  <div>
    <small><a href="http://embedgooglemaps.com"> embed google map </a></small>
  </div>
  <div>
    <small><a href="http://www.freedirectorysubmissionsites.com/">link directories</a></small>
  </div>
  <style>#gmap_canvas img {
    max-width: none !important;
    background: none !important
  }</style>
</div>
<script type='text/javascript'>function init_map() {
  var myOptions = {
    zoom: 10,
    center: new google.maps.LatLng(14.716695320854493, 79.63161309335942),
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
  marker = new google.maps.Marker({
    map: map,
    position: new google.maps.LatLng(14.716695320854493, 79.63161309335942)
  });
  infowindow = new google.maps.InfoWindow({content: '<strong>Rajavolu</strong><br>Rajavolu,Atmakur,Nellore,Andhra Pradesh<br>'});
  google.maps.event.addListener(marker, 'click', function () {
    infowindow.open(map, marker);
  });
  infowindow.open(map, marker);
}
google.maps.event.addDomListener(window, 'load', init_map);</script>
</body>
</html>

