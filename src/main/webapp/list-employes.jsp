<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jsp" %>
        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Liste des Employés</title>
            <script src="./assets/style/tailwind_cdn.js"></script>
        </head>

        <body class="bg-white text-black">
            <div class="container mx-auto p-6">
                <h1 class="text-3xl font-bold text-center mb-6">Liste des Employés</h1>

                <form action="EmployeSearch" method="get" class="flex justify-center mb-4">
                    <input type="text" name="keyword" placeholder="Rechercher un employé..." required
                        class="p-2 border border-black bg-white text-black rounded-md">
                    <button type="submit"
                        class="ml-2 px-4 py-2 bg-black text-white font-bold rounded-md hover:bg-gray-800">
                        Rechercher
                    </button>
                </form>

                <table class="w-full border border-black">
                    <thead>
                        <tr class="bg-gray-200">
                            <th class="border border-black p-2">ID</th>
                            <th class="border border-black p-2">Nom</th>
                            <th class="border border-black p-2">Prénom</th>
                            <th class="border border-black p-2">Poste</th>
                            <th class="border border-black p-2">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${not empty employes}">
                                <c:forEach var="employe" items="${employes}">
                                    <tr class="hover:bg-gray-100">
                                        <td class="border border-black p-2">${employe.codeemp}</td>
                                        <td class="border border-black p-2">${employe.nom}</td>
                                        <td class="border border-black p-2">${employe.prenom}</td>
                                        <td class="border border-black p-2">${employe.poste}</td>
                                        <td class="border border-black p-2">
                                            <a href="EmployeUpdate?codeemp=${employe.codeemp}"
                                                class="text-blue-600 hover:underline">Modifier</a> |
                                            <a href="EmployeDelete?codeemp=${employe.codeemp}"
                                                class="text-red-600 hover:underline"
                                                onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet employé ?');">Supprimer</a>
                                            |
                                            <a href="add-affectation.jsp?codeemp=${employe.codeemp}"
                                                class="text-green-600 hover:underline">Affecter</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5" class="text-center p-4">Aucun employé trouvé.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
                <div class="flex justify-center mt-6 space-x-4">
                    <a href="EmployeAdd"
                        class="px-4 py-2 bg-black text-white font-bold rounded-md hover:bg-gray-800">Ajouter un
                        employé</a>
                    <a href="LieuList" class="px-4 py-2 bg-black text-white font-bold rounded-md hover:bg-gray-800">Voir
                        les Lieux</a>
                </div>
            </div>
        </body>

        </html>