<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container mx-auto p-4">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">Alimentação dos Animais</h2>
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








