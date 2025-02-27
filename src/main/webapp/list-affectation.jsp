<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Affectations</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            padding: 5px 10px;
            text-decoration: none;
            background-color: red;
            color: white;
            border-radius: 3px;
        }
        .btn:hover {
            background-color: darkred;
        }
        .search-bar {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Liste des Affectations</h2>

    <!-- Formulaire de recherche -->
    <div class="search-bar">
        <form action="AffecterSearch" method="get">
            <input type="text" name="keyword" placeholder="Rechercher..." value="${param.keyword}">
            <button type="submit">Rechercher</button>
        </form>
    </div>

    <table>
        <tr>
            <th>ID Affectation</th>
            <th>Employé</th>
            <th>Lieu</th>
            <th>Date</th>
            <th>Action</th>
        </tr>

        <c:choose>
            <c:when test="${not empty affectations}">
                <c:forEach var="affectation" items="${affectations}">
                    <tr>
                        <td>${affectation.codeaffecter}</td>
                        <td>${affectation.employe.nom} ${affectation.employe.prenom}</td>
                        <td>${affectation.lieu.designation}</td>
                        <td>${affectation.date}</td>
                        <td>
                            <a href="AffecterEdit?id=${affectation.codeaffecter}" class="btn">Modifier</a>
                            <a href="AffecterDelete?id=${affectation.codeaffecter}" class="btn">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5">Aucune affectation trouvée.</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>

    <div style="text-align: center; margin-top: 20px;">
        <a href="add-affectation.jsp">Ajouter une nouvelle affectation</a>
    </div>

</body>
</html>
