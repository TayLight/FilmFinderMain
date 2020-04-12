<%@ page import="com.filmlibrary.DAO" %>
<%@ page import="com.filmlibrary.entities.Serial" %>
<%@ page import="com.filmlibrary.entities.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.filmlibrary.entities.EntityDB" %>
<%@ page import="com.filmlibrary.entities.Position" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor='#ffffff'>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<jsp:useBean id="serial" class="com.filmlibrary.entities.Serial" scope="request"/>
<h1> Добавление нового сериала </h1>
<%
    DAO dao = new DAO();
    if (request.getParameter("action") != null) {
        int id = Integer.parseInt(request.getParameter("action"));
        serial = (Serial) dao.getEntityById(id, new Serial());
    } else {
        serial = null;
    }
    ArrayList<EntityDB> listPerson = dao.getAllEntity(new Person());
%>
<form method='POST' action='serial.jsp'>
    <input type="hidden" readonly name="serialId" value="<%if(serial!=null)out.print(serial.getId());%>"/>
    <input type="hidden" name="action" value="<% if(serial!=null) out.print("Edit"); else out.print("Add");%>"/>
    Название: <input required name="title" value="<% if(serial!=null) out.print(serial.getTitle());%>"/>
    <br><br>
    Дата запуска: <input required name="yearStart" value="<% if(serial!=null) out.print(serial.getYearStart());%>"/>
    <br><br>
    Дата окончания: <input required name="yearFinish" value="<% if(serial!=null) out.print(serial.getYearFinish());%>"/>
    <br><br>
    Кол-во эпизодов: <input required name="numEpisodes" value="<% if(serial!=null) out.print(serial.getNumEpisodes());%>"/>
    <br><br>
    Кол-во сезонов: <input required name="numSeasons" value="<% if(serial!=null) out.print(serial.getNumSeasons());%>"/>
    <br><br>
    Оценка: <input required name="imdb" value="<% if(serial!=null) out.print(serial.getImdb());%>"/>
    <br><br>

    <%
        if (request.getParameter("action") != null){
            ArrayList<EntityDB> listPosition = dao.getAllEntity(new Position());
            ArrayList<EntityDB> listPersonOnSerial = new ArrayList<>();
            ArrayList<EntityDB> listProjects;
            ArrayList<Position> positions = new ArrayList<>();
            Position position;
            for (EntityDB entityDB : listPosition) {
                position = (Position) entityDB;
                listProjects = dao.getPersonByProject("serial", position.getNamePosition(), serial.getId(), new Person());
                for (EntityDB listProject : listProjects) {
                    listPersonOnSerial.add(listProject);
                    positions.add(position);
                }
            }
            out.println("Выберите личностей, которые участвовали в создании сериала:");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"><html>");
            out.println("<table  id=\"centerPlacement\" border=\"1\"><tbody>");
            out.println("<tr><th></th><th>Позиция</th><th>Имя</th><th>Фамилия</th><th>Дата рождения</th><th>Страна</th></tr>");
            boolean join;
            for (int i = 0; i < listPerson.size(); i++) {
                join=false;
                Object o = listPerson.get(i);
                Person person = (Person) o;
                Person person1;
                Position positionOnSerial= new Position();
                for(int j=0;j<listPersonOnSerial.size();j++){
                    person1= (Person) listPersonOnSerial.get(j);
                    if(person.getId()==person1.getId()){
                        join=true;
                        positionOnSerial=positions.get(j);
                    }
                }
                out.println("<tr>");
                if(join) {
                    out.print("<td><input type=\"checkBox\" name=\"check" + person.getId() + "\"  value=\"" + person.getId() + "\" checked >");
                    if(positionOnSerial.getId()==1) out.print("</td><td> <select name=\"position" + person.getId() + "\"> <option value=\"Актер\">Актер</option><option selected value=\"Режиссер\">Режиссер</option><option value=\"Продюсер\">Продюсер</option><option value=\"Сценарист\">Сценарист</option></select>");
                    if(positionOnSerial.getId()==2) out.print("</td><td> <select name=\"position" + person.getId() + "\"> <option selected value=\"Актер\">Актер</option><option value=\"Режиссер\">Режиссер</option><option value=\"Продюсер\">Продюсер</option><option value=\"Сценарист\">Сценарист</option></select>");
                    if(positionOnSerial.getId()==3) out.print("</td><td> <select name=\"position" + person.getId() + "\"> <option value=\"Актер\">Актер</option><option value=\"Режиссер\">Режиссер</option><option selected value=\"Продюсер\">Продюсер</option><option value=\"Сценарист\">Сценарист</option></select>");
                    if(positionOnSerial.getId()==4) out.print("</td><td> <select name=\"position" + person.getId() + "\"> <option value=\"Актер\">Актер</option><option value=\"Режиссер\">Режиссер</option><option value=\"Продюсер\">Продюсер</option><option selected value=\"Сценарист\">Сценарист</option></select>");
                }else {
                    out.print("<td><input type=\"checkBox\" name=\"check" + person.getId() + "\"  value=\"" + person.getId() + "\" >");
                    out.print("</td><td> <select name=\"position" + person.getId() + "\"> <option value=\"Актер\">Актер</option><option value=\"Режиссер\">Режиссер</option><option value=\"Продюсер\">Продюсер</option><option value=\"Сценарист\">Сценарист</option></select>");
                }
                        out.print("</td><td>" + person.getFirstName() +
                        "</td><td>" + person.getLastName() +
                        "</td><td>" + person.getBirthday() +
                        "</td><td>" + person.getCountry());
            }
            out.print("</tbody></table>");
        }
    %>
    <div style="padding: 5px;">
        <button type="submit">Сохранить</button>
        <button onclick="location.href ='serial.jsp'">Назад</button>
    </div>
</form>
<jsp:include page="_footer.jsp"/>
</body>
</html>