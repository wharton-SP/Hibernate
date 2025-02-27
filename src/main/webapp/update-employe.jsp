<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier un Employé</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            width: 50%;
            margin: auto;
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            border-radius: 8px;
        }
        label {
            font-weight: bold;
        }
        input, button {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<h2 style="text-align:center;">Modifier un Employé</h2>

<form action="EmployeUpdate" method="post">
    <input type="hidden" name="codeemp" value="${employe.codeemp}">
    
    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" value="${employe.nom}" required>
    
    <label for="prenom">Prénom :</label>
    <input type="text" id="prenom" name="prenom" value="${employe.prenom}" required>
    
    <label for="poste">Poste :</label>
    <input type="text" id="poste" name="poste" value="${employe.poste}" required>

    <button type="submit">Mettre à jour</button>
</form>

</body>
</html>
