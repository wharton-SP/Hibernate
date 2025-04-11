<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Liste des Affectations</title>
            <script src="./assets/style/tailwind_cdn.js"></script>
        </head>

        <%@ include file="navbar.jsp" %>

            <body class="bg-white text-black">

                <h2 class="text-3xl font-bold text-center my-6">Liste des Affectations</h2>

                <!-- Formulaire de recherche -->
                <div class="flex justify-center items-center gap-4 w-screen my-3">
                    <form action="AffecterSearch" method="get"
                        class="flex items-center justify-center border rounded-full w-3/5">
                        <input type="text" name="keyword" placeholder="Rechercher..." value="${param.keyword}"
                            class="w-full p-2 rounded-full bg-white text-black focus:outline-none">
                        <button type="submit" class=" bg-black text-white font-bold rounded-full p-2 mx-1">
                            <img src="./assets/icons/search.png" class="w-5">
                        </button>
                    </form>
                </div>

                <!-- Tableau des affectations -->
                <div class="overflow-x-auto">
                    <table class="table-auto w-full max-w-4xl mx-auto border-collapse border border-black">
                        <thead>
                            <tr class="bg-gray-100">
                                <th class="border border-black p-2">Code Affectation</th>
                                <th class="border border-black p-2">Employé(e)</th>
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
                                            <td class="border border-black p-2 text-center">${affectation.codeaffecter}
                                            </td>
                                            <td class="border border-black p-2">${affectation.employe.nom}
                                                ${affectation.employe.prenom}</td>
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
                                        <td colspan="5" class="border border-black p-4 text-center text-gray-500">Aucune
                                            affectation trouvée.</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>

            </body>

        </html>