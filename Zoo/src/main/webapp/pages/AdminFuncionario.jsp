<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container mx-auto p-4 ">

<h2 id="titulo" class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center dark:text-white">
    Cadastro Funcionário
</h2>
    <div class="mt-0">
      <button type="submit" id="btnCad"
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
        Deletar Funcionário
      </button>
    </div>

<div id="cadastro">

  <form class="max-w-md mx-auto space-y-6 gap-4" method="POST" action="web?ac=saveFunc">

    <!-- Campo oculto com o ID -->
    <input type="hidden" name="cpId" value="${funcionario.id}" />

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
    <div class="border-2 border-transparent">
    <div class=" mb-5">
      <label for="salario" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Salário</label>
      <div class="relative w-full">
        <input name="cpSalario" type="number" id="currency-input" required
          value="${funcionario.salario}"
          class="block p-2.5 w-full z-20 text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" />
      </div>
    <div class="relative mb-3 mu-0">
        <label for="price-range-input" class="sr-only">Default range</label>
        <input id="price-range-input" type="range" value="100" min="0" max="8000" class="w-full h-2 bg-gray-200 rounded-lg appearance-none cursor-pointer dark:bg-gray-700">
        <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-0 -bottom-6">Min (R$0)</span>
        <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-1/3 -translate-x-1/2 rtl:translate-x-1/2 -bottom-6">R$500</span>
        <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-2/3 -translate-x-1/2 rtl:translate-x-1/2 -bottom-6">R$1000</span>
        <span class="text-sm text-gray-500 dark:text-gray-400 absolute end-0 -bottom-6">Max (R$1500)</span>
    </div>
    </div>
    </div>

    <!-- Login e Senha -->
    <div class="flex gap-8 pb-0">
      <div class="mb-0">
        <label for="cpLogin" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Login do Funcionário</label>
        <input type="text" id="cpLogin" name="cpLogin"
          value="${funcionario.login}"
          class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white"
          placeholder="Login" required />
      </div>

      <div class="mb-5">
        <label for="cpSenha" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Senha</label>
        <input type="password" id="cpSenha" name="cpSenha"
          class="bg-gray-50  border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white" />
        <div class="flex items-start mb-0 pt-6">
          <jsp:include page="../componentes/exibeSenha.jsp" />
        </div>
      </div>
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

<div id="delete" class="w-full hidden">
    <form class="max-w-md mx-auto space-y-6 gap-4" method="POST" action="web?ac=delFunc">
    <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Funcionários:</label>
    <select  name="cpId" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" required>
    <option value="">Selecione um Funcionário</option>
    <c:forEach var="lf" items="${requestScope.funcionarios}">
        <option value="${lf.id}">${lf.nome}</option>
    </c:forEach>
    </select>

    <div class="mt-0">
      <button type="submit"
        class="justify-center text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
        EXCLUIR
      </button>
    </div>
    </form>
</div>
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

<!-- troca tela -->
    let btn = document.querySelector("#btnCad");
    let dvN = document.querySelector("#cadastro");
    let dvL = document.querySelector("#delete");
    let title = document.querySelector("#titulo");

    btn.addEventListener("click", () => {
        if (btn.innerText === 'Deletar Funcionário') {
            btn.innerText = 'Cadastrar Funcionário';
            dvL.classList.remove('hidden');
            dvN.classList.add('hidden');
            title.innerText = 'Remoção de  Funcionário';
        } else {
            btn.innerText = 'Deletar Funcionário';
            dvN.classList.remove('hidden');
            dvL.classList.add('hidden');
            title.innerText = 'Cadastro de Funcionário';
        }
    })
</script>



