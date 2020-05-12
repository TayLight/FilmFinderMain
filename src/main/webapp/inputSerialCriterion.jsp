<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FilmFinder: критерии выборки сериалов</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<h3>Введите критерии выборки сериалов в XML файл</h3>
<form method="post" action="serialXml.jsp">
    <br><br>
    Id: <input name="serialId"/>
    <br><br>
    Название: <input name="title"/>
    <br><br>
    Дата запуска: <input name="yearStart"/>
    <br><br>
    Дата окончания: <input name="yearFinish"/>
    <br><br>
    Кол-во эпизодов: <input name="numEpisodes"/>
    <br><br>
    Кол-во сезонов: <input name="numSeasons"/>
    <br><br>
    Оценка: <input name="imdb"/>
    <br><br>
    <button type="submit" name="action">Отправить</button>
</form>
<jsp:include page="_footer.jsp"/>
</body>
</html>