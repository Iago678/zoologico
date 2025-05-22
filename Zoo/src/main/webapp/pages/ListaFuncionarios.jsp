<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container mx-auto p-4">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">Lista de Funcionários</h2>
    <div class="mt-0 mb-6">
        <a href="web?ac=cadastroFunc">
        <button type="button" id="btnToggle"
            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            Administrar Funcionários
        </button>
        </a>
    </div>

<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
    <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3">
                    Nome
                </th>
                <th scope="col" class="px-6 py-3">
                    Login
                </th>
                <th scope="col" class="px-6 py-3">
                    Data de Ultimo acesso
                </th>
                <th scope="col" class="px-6 py-3">
                    Cargo
                </th>
                <th scope="col" class="px-6 py-3">
                    Salário
                </th>

                <th scope="col" class="px-6 py-3">
                    <span class="sr-only">Edit</span>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="f" items="${requestScope.funcionarios}">
            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 border-gray-200 hover:bg-gray-50 dark:hover:bg-gray-600">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    ${f.nome}
                </th>
                <td class="px-6 py-4">
                    ${f.login}
                </td>
                <td class="px-6 py-4">
                    ${f.dataUltimoAcesso}
                </td>
                <td class="px-6 py-4">
                    ${f.cargo}
                </td>
                <td class="px-6 py-4">
                    ${f.salario}
                </td>
                <td class="px-6 py-4 text-right">
                    <a href="web?ac=editarFunc&id=${f.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                </td>
            </tr>
        </tbody>
     </c:forEach>
    </table>
</div>
</div>