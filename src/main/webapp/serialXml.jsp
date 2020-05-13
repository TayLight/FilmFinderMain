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
    request.setCharacterEncoding("UTF-8");
    Context context = new InitialContext();
    XmlBean personBeanObject = (XmlBean) javax.rmi.PortableRemoteObject.narrow(context.lookup("java:global/FilmFinder-1.0/PersonXmlBean"), XmlBean.class);
    EntityFactory ef = new EntityFactory();
    DAO dao = new DAO();
    LinkedList<Criterion> criteria = new LinkedList<>();
    if(!request.getParameter("serialId").equals("")){
        Criterion criterionId = new Criterion();
        criterionId.setNameCriterion("id_serial");
        criterionId.setValue(request.getParameter("serialId"));
        criteria.add(criterionId);
    }
    if(!request.getParameter("title").equals("")){
        Criterion criterionFirstName = new Criterion();
        criterionFirstName.setNameCriterion("title");
        criterionFirstName.setValue(request.getParameter("title"));
        criteria.add(criterionFirstName);
    }
    if(!request.getParameter("yearStart").equals("")){
        Criterion criterionSecondName = new Criterion();
        criterionSecondName.setNameCriterion("year_start");
        criterionSecondName.setValue(request.getParameter("yearStart"));
        criteria.add(criterionSecondName);
    }
    if(!request.getParameter("yearFinish").equals("")){
        Criterion criterionBirthday = new Criterion();
        criterionBirthday.setNameCriterion("year_finish");
        criterionBirthday.setValue(request.getParameter("yearFinish"));
        criteria.add(criterionBirthday);
    }
    if(!request.getParameter("numEpisodes").equals("")){
        Criterion criterionCountry = new Criterion();
        criterionCountry.setNameCriterion("num_of_episodes");
        criterionCountry.setValue(request.getParameter("numEpisodes"));
        criteria.add(criterionCountry);
    }
    if(!request.getParameter("numSeasons").equals("")){
        Criterion criterionCountry = new Criterion();
        criterionCountry.setNameCriterion("num_of_seasons");
        criterionCountry.setValue(request.getParameter("numSeasons"));
        criteria.add(criterionCountry);
    }
    if(!request.getParameter("imdb").equals("")){
        Criterion criterionCountry = new Criterion();
        criterionCountry.setNameCriterion("imdb");
        criterionCountry.setValue(request.getParameter("imdb"));
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
<c:import url="serialStyle.xsl" var="xslt"/>
<c:import url="entity.xml" var="entity"/>
<x:transform xml="${entity}" xslt="${xslt}"/>
<a href="entity.xml" download>Скачать</a>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
