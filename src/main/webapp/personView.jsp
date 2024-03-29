<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FilmFinder: Личности</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        td, th {
            padding: 4px;
            border: 1px solid #000080;
        }

        th {
            background: #000080;
            color: #ffe;
            text-align: left;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<%@page import="com.filmlibrary.DAO" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.filmlibrary.entities.*" %>
<%@ page import="com.filmlibrary.beans.PersonXmlBean" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="generated.EntityFactory" %>
<%@ page import="generated.EntityXml" %>
<%@ page import="java.io.File" %>
<%@ page import="javax.ejb.EJB" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="generated.PersonType" %>
<%@ page import="generated.FilmType" %>
<%@ page import="java.lang.reflect.InvocationTargetException" %>
<%@ page import="com.filmlibrary.beans.XmlBean" %>
<jsp:useBean id="listPerson" class="java.util.ArrayList" scope="application"/>
<jsp:useBean id="listPosition" class="java.util.ArrayList" scope="application"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<form action="personView.jsp" method="post">
    <input type="text" name="search" value="<% if(request.getParameter("search")!=null) out.print(request.getParameter("search"));%>">
    <select name="column">
        <option value="first_name">Имя</option>
        <option value="second_name">Фамилия</option>
        <option value="country">Страна</option>
    </select>
    <button type="submit" name="searchButton" value="Search">Поиск</button>
    <button type="button" name="reset" onclick="location.href ='personView.jsp'" value="Reset">Сбросить</button>
</form>
<form id="checkedForm" action="personView.jsp" method="post">
    <%
        Context context = new InitialContext();
        XmlBean personBeanObject = (XmlBean) javax.rmi.PortableRemoteObject.narrow(context.lookup("java:global/FilmFinder-1.0/PersonXmlBean"), XmlBean.class);
        EntityFactory ef = new EntityFactory();
        DAO dao = new DAO();
        listPerson = dao.getAllEntity(new Person());
        listPosition = dao.getAllEntity(new Position());
        ArrayList<EntityDB> films = dao.getAllEntity(new Film());
        ArrayList<EntityDB> serials = dao.getAllEntity(new Serial());
        Person copyPerson;
        if (request.getParameter("action") != null) {
            if (request.getParameter("personId") != null) {
                if (request.getParameter("personId").equals("")) {
                    String firstName = request.getParameter("firstName");
                    String secondName = request.getParameter("lastName");
                    String country = request.getParameter("country");
                    LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
                    dao.addEntity(new Person(firstName, secondName, birthday, country));
                } else if (!request.getParameter("personId").equals("")) {
                    String firstName = request.getParameter("firstName");
                    String secondName = request.getParameter("lastName");
                    String country = request.getParameter("country");
                    LocalDate date = LocalDate.parse(request.getParameter("birthday"));
                    int id = Integer.parseInt(request.getParameter("personId"));
                    Person newPerson = new Person(id, firstName, secondName, date, country);
                    for (int i = 0; i < listPosition.size(); i++) {
                        Position pos = (Position) listPosition.get(i);
                        for (int j = 0; j < films.size(); j++) {
                            Film film = (Film) films.get(j);
                            if (request.getParameter("checkFilm" + film.getId()) != null) {
                                String position = request.getParameter("positionFilm" + film.getId());
                                if (position.equals(pos.getNamePosition())) {
                                    dao.setProjectToPerson("film", film.getId(), id, pos.getId());
                                }
                            }
                        }
                        for (int j = 0; j < serials.size(); j++) {
                            Serial serial = (Serial) serials.get(j);
                            if (request.getParameter("checkSerial" + serial.getId()) != null) {
                                String position = request.getParameter("positionSerial" + serial.getId());
                                if (position.equals(pos.getNamePosition())) {
                                    dao.setProjectToPerson("serial", serial.getId(), id, pos.getId());
                                }
                            }
                        }
                    }
                    dao.updateEntity(newPerson);
                }
            } else {
                for (int i = 0; i < listPerson.size(); i++) {
                    if (request.getParameter("checkBox" + i) != null) {
                        switch (request.getParameter("action")) {
                            case "Delete":
                                dao.deleteEntity(Integer.parseInt(request.getParameter("checkBox" + i)), new Person());
                                break;
                            case "Copy":
                                copyPerson = (Person) dao.getEntityById(Integer.parseInt(request.getParameter("checkBox" + i)), new Person());
                                dao.addEntity(copyPerson);
                                Person newPerson = (Person) dao.getTopEntity(new Person());
                                for (int k = 0; k < listPosition.size(); k++) {
                                    Position pos = (Position) listPosition.get(k);
                                    ArrayList<EntityDB> listProject = dao.getProjectsByPerson("film", pos.getNamePosition(), Integer.parseInt(request.getParameter("checkBox" + i)), new Film());
                                    for (int j = 0; j < listProject.size(); j++) {
                                        Film film = (Film) listProject.get(j);
                                        dao.setProjectToPerson("film", film.getId(), newPerson.getId(), pos.getId());
                                    }
                                    listProject = dao.getProjectsByPerson("serial", pos.getNamePosition(), Integer.parseInt(request.getParameter("checkBox" + i)), new Serial());
                                    for (int j = 0; j < listProject.size(); j++) {
                                        Serial serial = (Serial) listProject.get(j);
                                        dao.setProjectToPerson("serial", serial.getId(), newPerson.getId(), pos.getId());
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
        if (request.getParameter("search") != null) {
            listPerson = dao.searchEntity(request.getParameter("column"), request.getParameter("search"), new Person());
        } else {

            listPerson = dao.getAllEntity(new Person());
        }
    %>
    <div style="padding: 5px;">
        <button type="button" name="action" onclick="location.href ='inputPerson.jsp'" value="Add">Добавить новую
            личность
        </button>
        <button type="submit" name="action" value="Delete">Удалить</button>
        <button type="submit" name="action" value="Copy">Копировать</button>
    </div>
</form>
    <button onclick="location.href ='inputPersonCriterion.jsp'">Экспорт в Xml</button>
<%
    out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"><html>");
    out.print("<body>");
    out.print("<table  id=\"centerPlacement\" border=\"1\"><tbody>");
    out.print("<tr><th></th><th>Имя</th><th>Фамилия</th><th>Дата рождения</th><th>Страна</th><th></th></tr>");
    for (int i = 0; i < listPerson.size(); i++) {
        Object o = listPerson.get(i);
        Person person = (Person) o;
        out.print("<tr><td><input form=\"checkedForm\" type=\"checkBox\" name=\"checkBox" + i + "\"  value=\"" + person.getId() + "\" >" +
                "</td><td>" + person.getFirstName() +
                "</td><td>" + person.getLastName() +
                "</td><td>" + person.getBirthday() +
                "</td><td>" + person.getCountry() +
                "</td><td> <div style=\"padding: 5px;\"><form action=\"inputPerson.jsp\" method=\"post\"><button type=\"submit\" name=\"action\" value=\"" + person.getId() + "\">Edit</button> </form>" +
                "<form action=\"personInfo.jsp\" method=\"post\"><button type=\"submit\" name=\"action\" value=\"" + person.getId() + "\">Info</button> </form></div>");

    }
    out.print("</tbody></table></body>");
    out.print("</html>");
%>
<jsp:include page="_footer.jsp"/>
</body>
</html>