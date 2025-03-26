<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <script src="./assets/style/tailwind_cdn.js"></script>
    </head>

    <body class="w-screen h-screen bg-gray-50">
        <div class="flex flex-col justify-center items-center h-full">
            <div class="text-center w-full text-5xl font-bold uppercase transition-all">
                Gestion d'affectation
            </div>
            <div class="flex justify-center space-x-10 w-full mt-10">
                <a href="EmployeList" class="flex gap-2 items-center bg-[#1c1c1c] text-gray-50 px-4 py-2 rounded-md hover:scale-110 hover:shadow-md transition-all">
                    <img src="./assets/icons/employe-2.png" alt="logo-employé" class="w-5 h-5">
                    Employé(e)s
                </a>
                <a href="AffecterList" class="flex gap-2 items-center bg-[#1c1c1c] text-gray-50 px-4 py-2 rounded-md hover:scale-110 hover:shadow-md transition-all">
                    <img src="./assets/icons/transfert-2.png" alt="logo-transfert" class="w-5 h-5">
                    Affectation
                </a>
                <a href="LieuList" class="flex gap-2 items-center bg-[#1c1c1c] text-gray-50 px-4 py-2 rounded-md hover:scale-110 hover:shadow-md transition-all">
                    <img src="./assets/icons/location-2.png" alt="logo-lieu" class="w-5 h-5">
                    Lieux
                </a>
            </div>
        </div>
    </body>

    </html>