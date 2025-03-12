<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Employés</title>
    <script src="./assets/style/tailwind_cdn.js"></script>
    <style>
        table {
            width: 70%;
        }
        th, td {
            padding: 0.5rem;
        }
        th {
            background-color: #f3f4f6;
        }
        tr:nth-child(even) {
            background-color: #f3f4f6;
        }
        tr:nth-child(odd) {
            background-color: #fff;
        }
    </style>
</head>
<body class="bg-gray-50">
    <h1>Liste des Employés</h1>
    <form action="EmployeSearch" method="get">
        <input type="text" name="keyword" placeholder="Rechercher un employé..." required>
        <button type="submit">Rechercher</button>
    </form>

    <table class="table-auto border-collapse mx-auto">
        <thead>
            <tr>
                <th class="border-2">ID</th>
                <th class="border-2">Nom</th>
                <th class="border-2">Prénom</th>
                <th class="border-2">Poste</th>
                <th class="border-2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty employes}">
                    <c:forEach var="employe" items="${employes}">
                        <tr>
                            <td class="border-2">${employe.codeemp}</td>
                            <td class="border-2">${employe.nom}</td>
                            <td class="border-2">${employe.prenom}</td>
                            <td class="border-2">${employe.poste}</td>
                            <td class="border-2">
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
