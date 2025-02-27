<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier un Lieu</title>
</head>
<body>
    <h1>Modifier un Lieu</h1>
    <form action="LieuUpdate" method="post">
        <input type="hidden" name="codelieu" value="${lieu.codelieu}" />
        <label for="designation">Désignation:</label>
        <input type="text" name="designation" value="${lieu.designation}" required /><br>
        <label for="province">Province:</label>
        <input type="text" name="province" value="${lieu.province}" required /><br>
        <button type="submit">Modifier</button>
    </form>
</body>
</html>
