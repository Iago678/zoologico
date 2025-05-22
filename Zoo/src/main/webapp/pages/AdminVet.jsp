<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/inputmask/5.0.7/inputmask.min.js"></script>

        <h2 id="titulo" class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">
            Cadastro de Veterinário
        </h2>
            <div class="mt-0 mb-6">
                <button type="button" id="btn"
                    class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    Visita Veterinário
                </button>
            </div>
<div class="mt-0">
        <div id="normal" class="container mx-auto p-4">
            <form class="max-w-md mx-auto space-y-4" method="POST" action="web?ac=saveVet">
                <div class="container mx-auto p-4">
                    <div class="mb-5">
                        <label
                            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nome</label>
                        <input type="text" name="cpNomeVet"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                            placeholder="Nome" required />
                    </div>
                    <div class="mb-5">
                        <label
                            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Telefone</label>
                        <input type="text" id="telefone" name="cpTel" maxlength="15"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                            placeholder="(00) 00000-0000" required />
                    </div>
                    <div class="mb-5">
                        <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
                            Registro no CRMV <span class="mt-2 text-sm text-gray-500 dark:text-gray-400">(Ex: SP12345)</span></label>
                        <input type="text" name="cpCrmv"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                            id="crmv" placeholder="UF + número (ex: SP12345)" maxlength="7" required />
                    </div>

                    <div class="mt-0">
                     <button type="submit"
                       class="justify-center text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                       Cadastrar
                     </button>
                   </div>
            </form>
        </div>
        </div>
<div id="visita" class="container mx-auto p-4 w-full hidden">
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

       <div class="mt-0">
         <button type="submit"
           class="justify-center text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
           Cadastrar
         </button>
       </div>
    </form>
</div>

<script>
    <!-- máscara telefone -->
    document.getElementById("telefone").addEventListener("input", function(e) {
      let valor = e.target.value.replace(/\D/g, '').slice(0, 11);

      if (valor.length >= 2 && valor.length <= 6) {
        valor = valor.replace(/^(\d{2})(\d+)/, '($1) $2');
      } else if (valor.length > 6) {
        valor = valor.replace(/^(\d{2})(\d{5})(\d{0,4})/, '($1) $2-$3');
      } else if (valor.length > 0) {
        valor = valor.replace(/^(\d{0,2})/, '($1');
      }

      e.target.value = valor;
    });

    <!-- máscara CRMV -->
    document.getElementById("crmv").addEventListener("input", function(e) {
      let valor = e.target.value.toUpperCase().replace(/[^A-Z0-9]/g, '');
      valor = valor.replace(/^([A-Z]{2})(\d{0,5}).*/, '$1$2');
      e.target.value = valor;
    });
</script>

<!-- Mudança de tela -->
<script>
    const normal = document.querySelector("#normal");
    const visita = document.querySelector("#visita");
    const btn = document.querySelector("#btn");
    const title = document.querySelector("#titulo");

    btn.addEventListener("click", () => {
        if (btn.innerText === 'Visita Veterinário') {
            btn.innerText = 'Cadastrar Funcionário';
            visita.classList.remove('hidden');
            normal.classList.add('hidden');
            if (title) title.innerText = 'Visita Veterinária';
        } else {
            btn.innerText = 'Visita Veterinário';
            normal.classList.remove('hidden');
            visita.classList.add('hidden');
            if (title) title.innerText = 'Cadastro de Veterinário';
        }
    });
</script>
