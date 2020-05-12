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
<%
    Context context = new InitialContext();
    XmlBean personBeanObject = (XmlBean) javax.rmi.PortableRemoteObject.narrow(context.lookup("java:global/FilmFinder-1.0/PersonXmlBean"), XmlBean.class);
    EntityFactory ef = new EntityFactory();
    DAO dao = new DAO();
    LinkedList<Criterion> criteria = new LinkedList<>();
    if(request.getParameter("filmId")!=null){
        Criterion criterionId = new Criterion();
        criterionId.setNameCriterion("id_film");
        criterionId.setValue(request.getParameter("filmId"));
        criteria.add(criterionId);
    }
    if(request.getParameter("title")!=null){
        Criterion criterionFirstName = new Criterion();
        criterionFirstName.setNameCriterion("title");
        criterionFirstName.setValue(request.getParameter("title"));
        criteria.add(criterionFirstName);
    }
    if(request.getParameter("issueYear")!=null){
        Criterion criterionSecondName = new Criterion();
        criterionSecondName.setNameCriterion("issue_year");
        criterionSecondName.setValue(request.getParameter("issueYear"));
        criteria.add(criterionSecondName);
    }
    if(request.getParameter("imdb")!=null){
        Criterion criterionBirthday = new Criterion();
        criterionBirthday.setNameCriterion("imdb");
        criterionBirthday.setValue(request.getParameter("imdb"));
        criteria.add(criterionBirthday);
    }
    if(request.getParameter("length")!=null){
        Criterion criterionCountry = new Criterion();
        criterionCountry.setNameCriterion("length");
        criterionCountry.setValue(request.getParameter("length"));
        criteria.add(criterionCountry);
    }
    CriterionListType criterionListType = new CriterionListType();
    criterionListType.setPerson(criteria);
    ObjectCriterion objectCriterion = new ObjectCriterion();
    objectCriterion.setCriterions(criterionListType);
    objectCriterion.setType("film");
    Document docCriterion= personBeanObject.convertCriterionToNode(objectCriterion);
    Document docResult = dao.searchEntityByCriterion(docCriterion);
    Result result = personBeanObject.fromXmlNodeToEntity(docResult);
    personBeanObject.convertEntityToXmlFile(result);
%>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<c:import url="filmStyle.xsl" var="xslt"/>
<c:import url="WEB-INF/entity.xml" var="entity"/>
<x:transform xml="${entity}" xslt="${xslt}"/>
<a href="WEB-INF/entity.xml" download>Скачать</a>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
