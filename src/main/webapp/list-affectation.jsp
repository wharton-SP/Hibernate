<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Affectations</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white text-black">

    <h2 class="text-3xl font-bold text-center my-6">Liste des Affectations</h2>

    <!-- Formulaire de recherche -->
    <div class="flex justify-center mb-6">
        <form action="AffecterSearch" method="get" class="flex space-x-2">
            <input type="text" name="keyword" placeholder="Rechercher..." value="${param.keyword}"
                class="p-2 border border-black rounded-md bg-white text-black">
            <button type="submit" class="px-4 py-2 bg-black text-white rounded-md hover:bg-gray-800">Rechercher</button>
        </form>
    </div>

    <!-- Tableau des affectations -->
    <div class="overflow-x-auto">
        <table class="table-auto w-full max-w-4xl mx-auto border-collapse border border-black">
            <thead>
                <tr class="bg-gray-100">
                    <th class="border border-black p-2">ID Affectation</th>
                    <th class="border border-black p-2">Employé</th>
                    <th class="border border-black p-2">Lieu</th>
                    <th class="border border-black p-2">Date</th>
                    <th class="border border-black p-2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty affectations}">
                        <c:forEach var="affectation" items="${affectations}">
                            <tr class="hover:bg-gray-200">
                                <td class="border border-black p-2 text-center">${affectation.codeaffecter}</td>
                                <td class="border border-black p-2">${affectation.employe.nom} ${affectation.employe.prenom}</td>
                                <td class="border border-black p-2">${affectation.lieu.designation}</td>
                                <td class="border border-black p-2 text-center">${affectation.date}</td>
                                <td class="border border-black p-2 text-center">
                                    <a href="AffecterEdit?id=${affectation.codeaffecter}" 
                                        class="px-3 py-1 bg-black text-white rounded-md hover:bg-gray-800">Modifier</a>
                                    <a href="AffecterDelete?id=${affectation.codeaffecter}" 
                                        class="px-3 py-1 bg-black text-white rounded-md hover:bg-red-700 ml-2">Supprimer</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="5" class="border border-black p-4 text-center text-gray-500">Aucune affectation trouvée.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>

    <div class="text-center mt-6">
        <a href="add-affectation.jsp" class="text-black font-semibold hover:underline">Ajouter une nouvelle affectation</a>
    </div>

</body>
</html>
