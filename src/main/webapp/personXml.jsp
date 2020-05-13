<%@ page import="com.filmlibrary.DAO" %>
<%@ page import="generated.EntityFactory" %>
<%@ page import="com.filmlibrary.beans.XmlBean" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="criteriongenerated.Criterion" %>
<%@ page import="org.w3c.dom.Document" %>
<%@ page import="generated.Result" %>
<%@ page import="criteriongenerated.CriterionListType" %>
<%@ page import="criteriongenerated.ObjectCriterion" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FilmFinder:Личности теперь в XML!</title>
</head>
<%@page pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    Context context = new InitialContext();
    XmlBean personBeanObject = (XmlBean) javax.rmi.PortableRemoteObject.narrow(context.lookup("java:global/FilmFinder-1.0/PersonXmlBean"), XmlBean.class);
    EntityFactory ef = new EntityFactory();
    DAO dao = new DAO();
    LinkedList<Criterion> criteria = new LinkedList<>();
    if(!request.getParameter("personId").equals("")){
        Criterion criterionId = new Criterion();
        criterionId.setNameCriterion("id_person");
        criterionId.setValue(request.getParameter("personId"));
        criteria.add(criterionId);
    }
    if(!request.getParameter("firstName").equals("")){
        Criterion criterionFirstName = new Criterion();
        criterionFirstName.setNameCriterion("first_name");
        criterionFirstName.setValue(request.getParameter("firstName"));
        criteria.add(criterionFirstName);
    }
    if(!request.getParameter("lastName").equals("")){
        Criterion criterionSecondName = new Criterion();
        criterionSecondName.setNameCriterion("second_name");
        criterionSecondName.setValue(request.getParameter("lastName"));
        criteria.add(criterionSecondName);
    }
    if(!request.getParameter("birthday").equals("")){
        Criterion criterionBirthday = new Criterion();
        criterionBirthday.setNameCriterion("birthday");
        criterionBirthday.setValue(request.getParameter("birthday"));
        criteria.add(criterionBirthday);
    }
    if(!request.getParameter("country").equals("")){
        Criterion criterionCountry = new Criterion();
        criterionCountry.setNameCriterion("country");
        criterionCountry.setValue(request.getParameter("country"));
        criteria.add(criterionCountry);
    }
    CriterionListType criterionListType = new CriterionListType();
    criterionListType.setPerson(criteria);
    ObjectCriterion objectCriterion = new ObjectCriterion();
    objectCriterion.setCriterions(criterionListType);
    objectCriterion.setType("person");
    Document docCriterion= personBeanObject.convertCriterionToNode(objectCriterion);
    Document docResult = dao.searchEntityByCriterion(docCriterion);
    Result result = personBeanObject.fromXmlNodeToEntity(docResult);
    personBeanObject.convertEntityToXmlFile(result);
%>
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
