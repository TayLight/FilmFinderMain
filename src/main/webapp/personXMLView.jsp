<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dogore
  Date: 13.05.2020
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FilmFinder: Личности теперь в XML!</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<c:import url="personStyle.xsl" var="xslt"/>
<c:import url="entity.xml" var="entity"/>
<x:transform xml="${entity}" xslt="${xslt}"/>
<a href="entity.xml" download>Скачать</a>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
