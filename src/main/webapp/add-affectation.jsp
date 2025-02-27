<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hib.model.Employe, com.hib.model.Lieu" %>
<%@ page import="com.hib.dao.EmployeDao, com.hib.dao.LieuDao" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une affectation</title>
</head>
<body>
    <h2>Ajouter une affectation</h2>

    <form action="AffecterAdd" method="post">
        <!-- Champ caché pour passer l'ID de l'employé -->
        <input type="hidden" name="codeemp" value="${param.codeemp}">

        <label for="codelieu">Lieu :</label>
        <select id="codelieu" name="codelieu" required>
            <option value="">Sélectionner un lieu</option>
            <%
                LieuDao lieuDao = new LieuDao();
                List<Lieu> lieux = lieuDao.getLieux();
                for (Lieu lieu : lieux) {
            %>
                <option value="<%= lieu.getCodelieu() %>"><%= lieu.getDesignation() %> - <%= lieu.getProvince() %></option>
            <%
                }
            %>
        </select>
        <br>

        <label for="date">Date :</label>
        <input type="date" id="date" name="date" required><br>

        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
