<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container mx-auto p-4 ">
    <div class="mt-0">
      <button type="submit" id="btnCad"
        class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
        Deletar Funcionário
      </button>
    </div>

<div id="cadastro" >
<h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center dark:text-white">
    Cadastro Funcionário
</h2>


    <form class="max-w-md mx-auto space-y-6 gap-4" method="POST" action="web?ac=saveFunc">

          <!-- Nome & Cargo-->
          <div class="flex gap-4">
            <div class="flex-1">
              <label for="cpNome" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nome</label>
              <input type="text" id="cpNome" name="cpNome" placeholder="Nome" required
                class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" />
            </div>

            <div class="flex-1">
              <label for="cargo" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Selecione o cargo</label>
              <select id="cargo" name="cpCargo" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                <c:forEach var="cg" items="${requestScope.cargos}">
                    <option value="${cg}">${cg}</option>
                </c:forEach>
              </select>
            </div>
          </div>

          <!--  salário  -->
          <div class="pb-5">
            <label for="salario" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Salário</label>
                <label for="currency-input" class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Your Email</label>
                <div class="relative w-full">
                    <input name="cpSalario" type="number" id="currency-input" class="block p-2.5 w-full z-20 text-sm text-gray-900 bg-gray-50 rounded-l-lg rounded-r-lg border-s-gray-50 border-s-2 border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-s-gray-700  dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:border-blue-500" placeholder="Enter amount" value="1000" required />
                </div>
            <div class="flex mb-4">
            </div>
            <div class="relative">
                <label for="price-range-input" class="sr-only">Default range</label>
                <input id="price-range-input" type="range" value="1000" min="0" max="8000" class="w-full h-2 bg-gray-200 rounded-lg appearance-none cursor-pointer dark:bg-gray-700">
                <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-0 -bottom-6">Min (R$ 0)</span>
                <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-1/3 -translate-x-1/2 rtl:translate-x-1/2 -bottom-6">R$500</span>
                <span class="text-sm text-gray-500 dark:text-gray-400 absolute start-2/3 -translate-x-1/2 rtl:translate-x-1/2 -bottom-6">R$1000</span>
                <span class="text-sm text-gray-500 dark:text-gray-400 absolute end-0 -bottom-6">Max (R$ 8000)</span>
            </div>
          </div>
          <div class="flex gap-8 pb-0">
            <div class="mb-0">
                <label for="cpLogin" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Login do Funcionário</label>
                <input type="text" id="cpLogin" name="cpLogin"
                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    placeholder="Login" required />
            </div>
            <div class="mb-5">
                <label for="cpSenha"
                    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Senha</label>
                <input type="password" id="cpSenha" name="cpSenha"
                    class="bg-gray-50  border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    placeholder="Senha" required />
                <div class="flex items-start mb-0 pb-0 pt-6">
                        <jsp:include page="../componentes/exibeSenha.jsp" />
                </div>
            </div>
            </div
          </div>
          <div class="mt-0">
              <button type="submit"
                class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                Cadastrar
              </button>
            </div>


        </form>
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
    let btn = document.querySelector("#btnCad")
    let dvN = document.querySelector("#cadastro")
    let dvL = document.querySelector("#delete")

    btn.addEventListener("click", () => {
        if (btn.innerText === 'Deletar Funcionário') {
            btn.innerText = 'Cadastrar Funcionário'
            dvL.classList.remove('hidden')
            dvN.classList.add('hidden')
        } else {
            btn.innerText = 'Deletar Funcionário'
            dvN.classList.remove('hidden')
            dvL.classList.add('hidden')
        }
    })
</script>



