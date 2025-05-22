<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container mx-auto p-4">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">Animais em Exposição</h2>

    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
            <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                    <th scope="col" class="px-6 py-3">Nome Popular</th>
                    <th scope="col" class="px-6 py-3">Nome Científico</th>
                    <th scope="col" class="px-6 py-3">Espécie</th>
                    <th scope="col" class="px-6 py-3">Habitat</th>

                    <th scope="col" class="px-6 py-3">Idade</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="a" items="${requestScope.animais}">
                    <c:if test="${a.emExpo}"> <!-- Só mostra se estiver em exposição -->
                        <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                            <td class="px-6 py-4 font-medium text-gray-900 dark:text-white">
                                ${a.nome}
                            </td>
                            <td class="px-6 py-4">${a.nomeCientifico}</td>
                            <td class="px-6 py-4">${a.especie}</td>
                            <td class="px-6 py-4">${a.habitat}</td>

                            <td class="px-6 py-4">${a.idade} anos</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>

        <c:if test="${empty requestScope.animais}">
            <div class="p-4 text-center text-gray-500 dark:text-gray-400">
                Nenhum animal em exposição no momento
            </div>
        </c:if>
    </div>
</div>