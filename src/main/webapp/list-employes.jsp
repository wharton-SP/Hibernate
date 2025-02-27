<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Employés</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Liste des Employés</h1>
    <form action="EmployeSearch" method="get">
        <input type="text" name="keyword" placeholder="Rechercher un employé..." required>
        <button type="submit">Rechercher</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Poste</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty employes}">
                    <c:forEach var="employe" items="${employes}">
                        <tr>
                            <td>${employe.codeemp}</td>
                            <td>${employe.nom}</td>
                            <td>${employe.prenom}</td>
                            <td>${employe.poste}</td>
                            <td>
                                <a href="EmployeUpdate?codeemp=${employe.codeemp}">Modifier</a> |
                                <a href="EmployeDelete?codeemp=${employe.codeemp}" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet employé ?');">Supprimer</a> |
                                <a href="add-affectation.jsp?codeemp=${employe.codeemp}">Affecter</a> <!-- Lien vers l'ajout d'affectation -->
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr><td colspan="5" style="text-align: center;">Aucun employé trouvé.</td></tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>

    <a href="EmployeAdd">Ajouter un employé</a>
    <a href="LieuList">Voir les Lieux</a>
</body>
</html>
