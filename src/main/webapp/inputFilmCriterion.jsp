<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FilmFinder: критерии выборки</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<h3>Введите критерии выборки персон в XML файл</h3>
<form method="post" action="filmXml.jsp">
    <br><br>
    Id: <input name="filmId"/>
    <br><br>
    Название: <input name="title"/>
    <br><br>
    Дата выхода: <input  name="issueYear"/>
    <br><br>
    Оценка: <input  name="imdb"/>
    <br><br>
    Длина: <input name="length">
    <br><br>
    <button type="submit" name="action">Отправить</button>
</form>
<jsp:include page="_footer.jsp"/>
</body>
</html>