<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%--
  Created by IntelliJ IDEA.
  User: Dogore
  Date: 08.05.2020
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="personStyle.xsl" var="xslt"/>
<c:import url="WEB-INF/entity.xml" var="articles"/>
<x:transform xml="${articles}" xslt="${xslt}"/>
</body>
</html>
