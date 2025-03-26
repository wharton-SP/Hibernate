<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier un Employé</title>
    <script src="./assets/style/tailwind_cdn.js"></script>
</head>
<body class="bg-white text-black">
    <div class="max-w-md mx-auto mt-10 p-6 border border-black rounded-md shadow-lg">
        <h2 class="text-2xl font-bold text-center mb-6">Modifier un Employé</h2>

        <form action="EmployeUpdate" method="post" class="space-y-4">
            <div>
                <label for="codeemp" class="block font-semibold">Code Employé :</label>
                <input type="text" id="codeemp" name="codeemp" value="${employe.codeemp}" readonly
                    class="w-full p-2 border border-black rounded-md bg-gray-200 text-black">
            </div>

            <div>
                <label for="nom" class="block font-semibold">Nom :</label>
                <input type="text" id="nom" name="nom" value="${employe.nom}" required
                    class="w-full p-2 border border-black rounded-md bg-white text-black">
            </div>

            <div>
                <label for="prenom" class="block font-semibold">Prénom :</label>
                <input type="text" id="prenom" name="prenom" value="${employe.prenom}" required
                    class="w-full p-2 border border-black rounded-md bg-white text-black">
            </div>

            <div>
                <label for="poste" class="block font-semibold">Poste :</label>
                <input type="text" id="poste" name="poste" value="${employe.poste}" required
                    class="w-full p-2 border border-black rounded-md bg-white text-black">
            </div>

            <button type="submit" class="w-full px-4 py-2 bg-black text-white rounded-md hover:bg-gray-800">
                Mettre à jour
            </button>
        </form>

        <div class="text-center mt-4">
            <a href="EmployeList" class="text-black font-semibold hover:underline">Retour à la liste des employés</a>
        </div>
    </div>
</body>
</html>