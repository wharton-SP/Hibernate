<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ include file="navbar.jsp" %>
        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Liste des Lieux</title>
            <script src="https://cdn.tailwindcss.com"></script>
        </head>

        <body class="bg-white text-black">
            <div class="container mx-auto p-6">
                <h1 class="text-3xl font-bold text-center mb-6">Liste des Lieux</h1>

                <form action="LieuList" method="post" class="max-w-lg mx-auto bg-gray-100 p-4 rounded-md shadow-md">
                    <div class="mb-4">
                        <label for="designation" class="block font-semibold">Désignation:</label>
                        <input type="text" name="designation" required
                            class="w-full p-2 border border-black rounded-md bg-white text-black">
                    </div>
                    <div class="mb-4">
                        <label for="province" class="block font-semibold">Province:</label>
                        <input type="text" name="province" required
                            class="w-full p-2 border border-black rounded-md bg-white text-black">
                    </div>
                    <button type="submit"
                        class="w-full px-4 py-2 bg-black text-white font-bold rounded-md hover:bg-gray-800">
                        Ajouter un Lieu
                    </button>
                </form>

                <table class="w-full mt-6 border border-black">
                    <thead>
                        <tr class="bg-gray-200">
                            <th class="border border-black p-2">Codelieu</th>
                            <th class="border border-black p-2">Désignation</th>
                            <th class="border border-black p-2">Province</th>
                            <th class="border border-black p-2">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="lieu" items="${lieux}">
                            <tr class="hover:bg-gray-100">
                                <td class="border border-black p-2">${lieu.codelieu}</td>
                                <td class="border border-black p-2">${lieu.designation}</td>
                                <td class="border border-black p-2">${lieu.province}</td>
                                <td class="border border-black p-2">
                                    <a href="LieuUpdate?codelieu=${lieu.codelieu}"
                                        class="text-blue-600 hover:underline">Modifier</a> |
                                    <a href="LieuDelete?codelieu=${lieu.codelieu}" class="text-red-600 hover:underline"
                                        onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce lieu ?');">Supprimer</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </body>

        </html>