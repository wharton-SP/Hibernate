<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier l'Affectation</title>
    <script src="./assets/style/tailwind_cdn.js"></script>
</head>
<body class="bg-white text-black">

    <div class="max-w-xl mx-auto mt-10 p-6 border border-black rounded-md shadow-lg">
        <h2 class="text-2xl font-bold text-center mb-6">Modifier l'Affectation</h2>

        <form action="AffecterUpdate" method="post" class="space-y-4">
            <input type="hidden" name="id" value="${affecter.codeaffecter}">

            <!-- Liste déroulante pour l'employé -->
            <label for="employe" class="block font-semibold">Nom de l'Employé:</label>
            <select id="employe" name="employe" required 
                class="w-full p-2 border border-black rounded-md bg-white text-black">
                <c:forEach var="employe" items="${employes}">
                    <option value="${employe.codeemp}" <c:if test="${employe.codeemp == affecter.employe.codeemp}">selected</c:if>>
                        ${employe.nom} ${employe.prenom}
                    </option>
                </c:forEach>
            </select>

            <!-- Liste déroulante pour le lieu -->
            <label for="lieu" class="block font-semibold">Nom du Lieu:</label>
            <select id="lieu" name="lieu" required 
                class="w-full p-2 border border-black rounded-md bg-white text-black">
                <c:forEach var="lieu" items="${lieux}">
                    <option value="${lieu.codelieu}" <c:if test="${lieu.codelieu == affecter.lieu.codelieu}">selected</c:if>>
                        ${lieu.designation}
                    </option>
                </c:forEach>
            </select>

            <!-- Champ de date -->
            <label for="date" class="block font-semibold">Date d'affectation:</label>
            <input type="date" id="date" name="date" value="${affecter.date}" required
                class="w-full p-2 border border-black rounded-md bg-white text-black">

            <button type="submit" 
                class="w-full px-4 py-2 bg-black text-white rounded-md hover:bg-gray-800">
                Mettre à jour l'affectation
            </button>
        </form>

        <div class="text-center mt-4">
            <a href="list-affectation.jsp" class="text-black font-semibold hover:underline">Retour à la liste des affectations</a>
        </div>
    </div>

</body>
</html>
