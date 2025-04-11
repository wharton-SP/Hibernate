<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Liste des Lieux</title>
            <script src="./assets/style/tailwind_cdn.js"></script>
        </head>

        <%@ include file="navbar.jsp" %>

            <body class="bg-white text-black">
                <div class="container mx-auto p-6">
                    <h1 class="text-3xl font-bold text-center mb-6">Liste des Lieux</h1>
                    <div class="flex justify-center items-center gap-4 w-screen my-3 ">
                        <!-- Formulaire de recherche combinée -->
                        <form action="LieuList" method="get"
                            class="flex items-center justify-center border rounded-full w-3/5">
                            <input type="text" name="search" placeholder="Rechercher..."
                                class="w-full p-2 rounded-full bg-white text-black focus:outline-none"
                                value="${param.search != null ? param.search : ''}">

                            <button type="submit" class=" bg-black text-white font-bold rounded-full p-2 mx-1">
                                <img src="./assets/icons/search.png" class="w-5">
                            </button>
                        </form>

                        <!-- <a href="LieuList"
                        class="px-4 py-2 bg-gray-500 text-white font-bold rounded-md hover:bg-gray-700 h-max">
                        Réinitialiser
                    </a> -->
                    </div>

                    <form action="LieuList" method="post"
                        class="w-max gap-3 flex items-center mx-auto bg-gray-100 p-4 rounded-md shadow-md">
                        <div class="">
                            <input type="text" name="designation" required placeholder="Désigantion"
                                class="w-full p-2 border border-black rounded-md bg-white text-black">
                        </div>
                        <div class="">
                            <input type="text" name="province" required placeholder="Province"
                                class="w-full p-2 border border-black rounded-md bg-white text-black">
                        </div>
                        <button type="submit"
                            class="px-4 py-2 bg-black text-white font-bold rounded-md hover:bg-gray-800 h-max">
                            Ajouter un Lieu
                        </button>
                    </form>

                    <table class="w-full mt-6 border border-black">
                        <thead>
                            <tr class="bg-gray-200">
                                <th class="border border-black p-2">Code Lieu</th>
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
                                            class="px-3 py-1 bg-black text-white rounded-md hover:bg-gray-800">Modifier</a>
                                        |
                                        <a href="LieuDelete?codelieu=${lieu.codelieu}"
                                            class="px-3 py-1 bg-black text-white rounded-md hover:bg-red-700 ml-2"
                                            onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce lieu ?');">Supprimer</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </body>

        </html>