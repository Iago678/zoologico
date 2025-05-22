<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container mx-auto p-4">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">Visita Vetérinaria</h2>
    <form class="max-w-md mx-auto space-y-4" method="POST" action="web?ac=saveVisitaVet">
      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Animais:</label>
      <select name="cpAnimal" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" required>
        <option value="">Selecione um animal</option>
        <c:forEach var="anm" items="${requestScope.animais}">
            <option value="${anm.id}">${anm.nome}</option>
        </c:forEach>
      </select>

      <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Vetérinario(a):</label>
      <select name="cpVet" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" required>
        <option value="">Selecione um Vetérinario</option>
        <c:forEach var="vets" items="${requestScope.vets}">
            <option value="${vets.id}">${vets.nome}</option>
        </c:forEach>
      </select>

       <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white" for="data">Data da visita:</label>
              <input type="date" id="data" name="cpData" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required>

       <div class="flex-1">
         <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Selecione o serviço</label>
         <select name="cpServ" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" placeholder="Serviços">
           <option>Serviços</option>
           <c:forEach var="serv" items="${requestScope.serv}">
               <option value="${serv}">${serv}</option>
           </c:forEach>
         </select>
       </div>
       <div class="border-2 border-transparent">
           <div class=" mb-5">
             <label  class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Valor do Serviço</label>
             <div class="relative w-full">
               <input  type="number" id="currency-input" name="cpValor" required
               placeholder="R$ 1000"
                 class="block p-2.5 w-full z-20 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" />
             </div>
           <div class="relative mb-3 mu-0">
               <label for="price-range-input" class="sr-only">Default range</label>
               <input id="price-range-input" type="range" value="100" min="0" max="3000" class="w-full h-2 bg-gray-200 rounded-lg appearance-none cursor-pointer dark:bg-gray-700">
               <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-0 -bottom-6">Min (R$0)</span>
               <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-1/3 -translate-x-1/2 rtl:translate-x-1/2 -bottom-6">R$500</span>
               <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-2/3 -translate-x-1/2 rtl:translate-x-1/2 -bottom-6">R$1000</span>
               <span class="text-sm text-gray-500 dark:text-gray-400 absolute end-0 -bottom-6">Max (R$3000)</span>
           </div>
           </div>
           </div>

       <div class=class="z-50 flex justify-center w-full px-4 py-3 border border-b border-gray-200 bg-gray-50 dark:border-gray-600 lg:py-4 dark:bg-gray-700">
       <button type="submit"
           class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Cadastrar</button>
       </div>
    </form>
</div>
<script>
      const slider = document.getElementById('price-range-input');
      const inputNumber = document.getElementById('currency-input');

      slider.addEventListener('input', () => {
        inputNumber.value = slider.value;
      });

      inputNumber.addEventListener('input', () => {
        let val = Math.min(Math.max(inputNumber.value, slider.min), slider.max);
        slider.value = val;
        inputNumber.value = val;
      });
</script>







