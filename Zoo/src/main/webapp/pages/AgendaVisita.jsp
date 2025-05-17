<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container mx-auto p-4">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">Agende sua Visita</h2>
      <form class="max-w-md mx-auto space-y-4" action="web?ac=saveVisita" method="POST">

        <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white" for="data">Data da visita:</label>
        <input type="date" id="data" name="cpData" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

        <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white" for="horario">Horário:</label>
        <select id="horario" name="cpHorario" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" required>
          <option value="">Selecione um horário</option>
          <option value="09:00">09:00</option>
          <option value="11:00">11:00</option>
          <option value="13:00">13:00</option>
          <option value="15:00">15:00</option>
        </select>

        <label name="quantidade" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Número de visitantes:
        <span class="mt-2 text-sm text-gray-500 dark:text-gray-400">(máximo 8 pessoas)</span></label>
        <input type="number" id="quantidade" name="cpQtd" min="1" max="8" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

        <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Agendar Visita</button>
      </form>
</div>




