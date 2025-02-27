<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Lieux</title>
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
    <h1>Liste des Lieux</h1>

    <form action="LieuList" method="post">
        <label for="designation">Désignation:</label>
        <input type="text" name="designation" required />
        <label for="province">Province:</label>
        <input type="text" name="province" required />
        <button type="submit">Ajouter un Lieu</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>Codelieu</th>
                <th>Désignation</th>
                <th>Province</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="lieu" items="${lieux}">
                <tr>
                    <td>${lieu.codelieu}</td>
                    <td>${lieu.designation}</td>
                    <td>${lieu.province}</td>
                    <td>
                        <a href="LieuUpdate?codelieu=${lieu.codelieu}">Modifier</a> |
                        <a href="LieuDelete?codelieu=${lieu.codelieu}">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
