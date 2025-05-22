<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container mx-auto p-4">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">Registro de Visitas Veterinárias</h2>

    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
            <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                    <th scope="col" class="px-6 py-3">Data</th>
                    <th scope="col" class="px-6 py-3">Animal</th>
                    <th scope="col" class="px-6 py-3">Veterinário</th>
                    <th scope="col" class="px-6 py-3">Tipo de Serviço</th>
                    <th scope="col" class="px-6 py-3">Valor (R$)</th>
                    <th scope="col" class="px-6 py-3">Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="visita" items="${visitas}">
                    <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                        <td class="px-6 py-4">
                            <fmt:formatDate value="${visita.data}" pattern="dd/MM/yyyy"/>
                        </td>
                        <td class="px-6 py-4 font-medium text-gray-900 dark:text-white">
                            ${visita.animal.nome} (${visita.animal.especie})
                        </td>
                        <td class="px-6 py-4">
                            ${visita.vet.nome}
                        </td>
                        <td class="px-6 py-4">
                            <span class="px-2 py-1 rounded-full text-xs
                                ${visita.servico == 'CONSULTA' ? 'bg-blue-100 text-blue-800' :
                                  visita.servico == 'CIRURGIA' ? 'bg-red-100 text-red-800' :
                                  'bg-green-100 text-green-800'}">
                                ${visita.servico}
                            </span>
                        </td>
                        <td class="px-6 py-4">
                            <fmt:formatNumber value="${visita.valor}" type="currency" currencyCode="BRL"/>
                        </td>
                        <td class="px-6 py-4 text-right">
                            <a href="web?ac=editarVisitaVet&id=${visita.id}"
                               class="font-medium text-blue-600 dark:text-blue-500 hover:underline mr-2">Editar</a>
                            <a href="web?ac=excluirVisitaVet&id=${visita.id}"
                               class="font-medium text-red-600 dark:text-red-500 hover:underline">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>