<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container mx-auto p-4">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">Lista dos Animais</h2>
    <div class="mt-0 mb-6">
        <button type="button" id="btnToggle"
            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            Editar Animais
        </button>
    </div>

<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
    <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3">
                    Nome Popular
                </th>
                <th scope="col" class="px-6 py-3">
                    Nome Cientifico
                </th>
                <th scope="col" class="px-6 py-3">
                    Especie
                </th>
                <th scope="col" class="px-6 py-3">
                    Data de Chegada
                </th>
                <th scope="col" class="px-6 py-3">
                    Estado de Saude
                </th>
                <th scope="col" class="px-6 py-3">
                    Sexo
                </th>
                <th scope="col" class="px-6 py-3">
                    Idade(anos)
                </th>
                <th scope="col" class="px-6 py-3">
                    Em Exposição
                </th>
                <th scope="col" class="px-6 py-3">
                    Foi Alimentado Hoje
                </th>
                <th scope="col" class="px-6 py-3">
                    <span class="sr-only">Edit</span>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="a" items="${requestScope.animais}">
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 border-gray-200 hover:bg-gray-50 dark:hover:bg-gray-600">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    ${a.nome}
                </th>
                <td class="px-6 py-4">
                    ${a.nomeCientifico}
                </td>
                <td class="px-6 py-4">
                    ${a.especie}
                </td>
                <td class="px-6 py-4">
                    ${a.dataChegada}
                </td>
                <td class="px-6 py-4">
                    ${a.estadoSaude}
                </td>
                <td class="px-6 py-4">
                    ${a.sexoAnimal}
                </td>
                <td class="px-6 py-4">
                    ${a.idade}
                </td>
                <td class="px-6 py-4">
                    ${a.emExpo ? "SIM" : "NÃO"}
                </td>
                <td class="px-6 py-4">
                    ${a.foiAlimentado ? "SIM": "NÃO"}
                </td>
                <td class="px-6 py-4 text-right">
                    <a href="web?ac=editarAnimal&id=${a.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                </td>
            </tr>
        </tbody>
     </c:forEach>
    </table>
</div>
</div>