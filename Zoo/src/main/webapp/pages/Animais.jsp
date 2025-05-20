<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container mx-auto p-4">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">Animais</h2>
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white" for="animais">Animais:</label>
      <select id="animais" name="cpNome" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" required>
        <option value="">Selecione um animal</option>
        <c:forEach var="ta" items="${requestScope.animais}">
            <option value="${ta}">${ta.nome}</option>
        </c:forEach>

      </select>
</div>








