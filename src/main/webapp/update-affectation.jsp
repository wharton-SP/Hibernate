<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier l'Affectation</title>
</head>
<body>
    <h2>Modifier l'Affectation</h2>

    <form action="AffecterUpdate" method="post">
        <input type="hidden" name="id" value="${affecter.codeaffecter}">

        <!-- Liste déroulante pour l'employé -->
        <label for="employe">Nom de l'Employé:</label>
        <select id="employe" name="employe" required>
            <c:forEach var="employe" items="${employes}">
                <option value="${employe.codeemp}" <c:if test="${employe.codeemp == affecter.employe.codeemp}">selected</c:if>>
                    ${employe.nom} ${employe.prenom}
                </option>
            </c:forEach>
        </select><br>

        <!-- Liste déroulante pour le lieu -->
        <label for="lieu">Nom du Lieu:</label>
        <select id="lieu" name="lieu" required>
            <c:forEach var="lieu" items="${lieux}">
                <option value="${lieu.codelieu}" <c:if test="${lieu.codelieu == affecter.lieu.codelieu}">selected</c:if>>
                    ${lieu.designation}
                </option>
            </c:forEach>
        </select><br>

        <!-- Champ de date -->
        <label for="date">Date d'affectation:</label>
        <input type="date" id="date" name="date" value="${affecter.date}" required><br>

        <button type="submit">Mettre à jour l'affectation</button>
    </form>

    <br>
    <a href="list-affectation.jsp">Retour à la liste des affectations</a>
</body>
</html>
