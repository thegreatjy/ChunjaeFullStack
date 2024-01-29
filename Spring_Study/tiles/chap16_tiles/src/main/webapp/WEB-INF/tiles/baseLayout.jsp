<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<html>
<head><title><tiles:getAsString name="title"/></title> </head>
<body>
   <table>
      <tr><td><tiles:insertAttribute name="menu" /></td></tr>
      <tr><td> <tiles:getAsString name="header" /></td></tr>
      <tr><td><tiles:insertAttribute name="body" /> </td> </tr>
      <tr><td><tiles:insertAttribute name="footer" /></td></tr>
   </table>
</body>
</html>