<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center" id="titulo"
>Lista de animais</h2>

<div class="mt-0 mb-6">
    <button type="button" id="btn"
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
        Registrar Alimentação
    </button>
</div>

<div class="relative overflow-x-auto shadow-md sm:rounded-lg" id="lista">
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
            </tr>
        </tbody>
     </c:forEach>
    </table>
</div>


<div class="container mx-auto p-4 hidden" id="alimentacao">
    <form class="max-w-md mx-auto space-y-6 gap-4" method="POST" action="web?ac=saveAlimentacao">
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white" for="animais">Animal:</label>
      <select id="animais" name="cpId" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" required>
        <option value="">Selecione um animal</option>
        <c:forEach var="ta" items="${requestScope.animais}">
            <option value="${ta.id}">${ta.nome}</option>
        </c:forEach>
      </select>
      <div class="flex-1 flex items-center mt-6">
          <input id="default-checkbox" type="checkbox" name="cpExpo" value="true"
              class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 rounded-sm focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
          <label for="default-checkbox" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Foi alimentado</label>
      </div>
      <div class="mt-6">
          <button type="submit"
              class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
              Feito
          </button>
      </div>
    </form>
</div>

<script>
    const normal = document.querySelector("#lista");
    const alimentacao = document.querySelector("#alimentacao");
    const btn = document.querySelector("#btn");
    const title = document.querySelector("#titulo");

    btn.addEventListener("click", () => {
        if (btn.innerText === 'Registrar Alimentação') {
            btn.innerText = 'Voltar';
            alimentacao.classList.remove('hidden');
            normal.classList.add('hidden');
            title.innerText = 'Alimentação Animal';
        } else {
            btn.innerText = 'Registrar Alimentação';
            normal.classList.remove('hidden');
            alimentacao.classList.add('hidden');
            title.innerText = 'Lista de Animais';
        }
    });
</script>








