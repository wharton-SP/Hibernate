<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="fr">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Modifier un Lieu</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>

    <body class="bg-white text-black">

        <div class="max-w-md mx-auto mt-10 p-6 border border-black rounded-md shadow-lg">
            <h2 class="text-2xl font-bold text-center mb-6">Modifier un Lieu</h2>

            <form action="LieuUpdate" method="post" class="space-y-4">
                <input type="hidden" name="codelieu" value="${lieu.codelieu}" />

                <label for="designation" class="block font-semibold">Désignation :</label>
                <input type="text" name="designation" value="${lieu.designation}" required
                    class="w-full p-2 border border-black rounded-md bg-white text-black" />

                <label for="province" class="block font-semibold">Province :</label>
                <input type="text" name="province" value="${lieu.province}" required
                    class="w-full p-2 border border-black rounded-md bg-white text-black" />

                <button type="submit" class="w-full px-4 py-2 bg-black text-white rounded-md hover:bg-gray-800">
                    Modifier
                </button>
            </form>

            <div class="text-center mt-4">
                <a href="LieuList" class="text-black font-semibold hover:underline">Retour à la liste des lieux</a>
            </div>
        </div>

    </body>

    </html>