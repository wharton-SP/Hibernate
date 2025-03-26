<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un Employé</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white text-black">
    <div class="container mx-auto max-w-md p-6 bg-gray-100 rounded-md shadow-md mt-10">
        <h2 class="text-2xl font-bold text-center mb-4">Ajouter un Employé</h2>

        <form action="EmployeAdd" method="post" class="space-y-4">
            <div>
                <label for="codeemp" class="block font-semibold">Code Employé :</label>
                <input type="text" id="codeemp" name="codeemp" required 
                    class="w-full p-2 border border-black rounded-md bg-white text-black"
                    placeholder="Ex: EMP-001">
            </div>

            <div>
                <label for="nom" class="block font-semibold">Nom :</label>
                <input type="text" id="nom" name="nom" required 
                    class="w-full p-2 border border-black rounded-md bg-white text-black">
            </div>

            <div>
                <label for="prenom" class="block font-semibold">Prénom :</label>
                <input type="text" id="prenom" name="prenom" required 
                    class="w-full p-2 border border-black rounded-md bg-white text-black">
            </div>

            <div>
                <label for="poste" class="block font-semibold">Poste :</label>
                <input type="text" id="poste" name="poste" required 
                    class="w-full p-2 border border-black rounded-md bg-white text-black">
            </div>

            <button type="submit" 
                class="w-full px-4 py-2 bg-black text-white font-bold rounded-md hover:bg-gray-800">
                Ajouter
            </button>
        </form>

        <div class="mt-4 text-center">
            <a href="EmployeList" class="text-black font-semibold hover:underline">Voir la liste des employés</a>
        </div>
    </div>
</body>
</html>