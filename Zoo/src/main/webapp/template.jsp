<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zoo Web</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <div class="min-h-screen flex flex-col">
        <!-- Header -->
        <header class="bg-blue-600 text-white p-4 shadow-md">
                    <jsp:include page="componentes/header.jsp" />
        </header>
        <!-- Main -->

        <main class="flex-grow container mx-auto p-4">
            <div class="bg-white rounded-lg shadow-md p-6">
                <jsp:include page="/pages/${param.page}.jsp" />
            </div>
        </main>

        <!--Footer-->
        <footer class="bg-gray-800 text-white p-4">
            <div class="container mx-auto text-center">
                <p>&copy; 2025 Zoologico.</p>
            </div>
        </footer>
    </div>
</body>
</html>