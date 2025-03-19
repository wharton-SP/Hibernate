<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hib.model.Employe, com.hib.model.Lieu" %>
<%@ page import="com.hib.dao.EmployeDao, com.hib.dao.LieuDao" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une affectation</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white text-black">
    <div class="container mx-auto p-6">
        <h2 class="text-3xl font-bold text-center mb-6">Ajouter une affectation</h2>

        <form action="AffecterAdd" method="post" class="max-w-lg mx-auto bg-gray-100 p-6 rounded-md shadow-md">
            <!-- Champ caché pour passer l'ID de l'employé -->
            <input type="hidden" name="codeemp" value="${param.codeemp}">

            <div class="mb-4">
                <label for="codelieu" class="block font-semibold">Lieu :</label>
                <select id="codelieu" name="codelieu" required class="w-full p-2 border border-black rounded-md bg-white text-black">
                    <option value="">Sélectionner un lieu</option>
                    <%
                        LieuDao lieuDao = new LieuDao();
                        List<Lieu> lieux = lieuDao.getLieux();
                        for (Lieu lieu : lieux) {
                    %>
                        <option value="<%= lieu.getCodelieu() %>"><%= lieu.getDesignation() %> - <%= lieu.getProvince() %></option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div class="mb-4">
                <label for="date" class="block font-semibold">Date :</label>
                <input type="date" id="date" name="date" required class="w-full p-2 border border-black rounded-md bg-white text-black">
            </div>

            <button type="submit" class="w-full px-4 py-2 bg-black text-white font-bold rounded-md hover:bg-gray-800">
                Ajouter
            </button>
        </form>
    </div>
</body>
</html>
