<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Seção de Edição de Funcionario -->
<div id="edicao" class="max-w-md mx-auto">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center dark:text-white">
        Editar Funcionario
    </h2>

    <div id="editarFuncionario">

      <form class="max-w-md mx-auto space-y-6 gap-4" method="POST" action="web?ac=updateFunc">

        <!-- Campo oculto com o ID -->
        <input type="hidden" name="cpId" value="${id}" />

        <!-- Nome & Cargo -->
        <div class="flex gap-4">
          <div class="flex-1">
            <label for="cpNome" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nome</label>
            <input type="text" id="cpNome" name="cpNome" required
              value="${funcionario.nome}"
              class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" />
          </div>

          <div class="flex-1">
            <label for="cargo" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Selecione o cargo</label>
            <select id="cargo" name="cpCargo"
              class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white">
              <c:forEach var="cg" items="${requestScope.cargos}">
                <option value="${cg}" <c:if test="${cg == funcionario.cargo}">selected</c:if>>${cg}</option>
              </c:forEach>
            </select>
          </div>
        </div>

        <!-- Salário -->
        <div class="pb-5">
          <label for="salario" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Salário</label>
          <div class="relative w-full">
            <input name="cpSalario" type="number" id="currency-input" required
              value="${funcionario.salario}"
              class="block p-2.5 w-full z-20 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" />
          </div>
        </div>

        <!-- Login  -->

          <div class="pb-5">
            <label for="cpLogin" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Login do Funcionário</label>
            <input type="text" id="cpLogin" name="cpLogin"
              value="${funcionario.login}"
              class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
              placeholder="Login" required />
          </div>


        <!-- Botão -->
        <div class="mt-0">
          <button type="submit"
            class="text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">
            Salvar Alterações
          </button>
        </div>
      </form>
    </div>

</div>