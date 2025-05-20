<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container mx-auto p-4">
    <!-- Botão de Toggle entre Cadastro e Delete -->
    <div class="mt-0 mb-6">
        <button type="button" id="btnToggle"
            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            Deletar Animal
        </button>
    </div>

    <!-- Seção de Cadastro de Animal (visível por padrão) -->
    <div id="cadastro">
        <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center dark:text-white">
            Cadastrar Animal
        </h2>

        <form class="max-w-md mx-auto space-y-6 gap-4" method="POST" action="web?ac=saveAnimal">
            <!-- Linha 1: Nome e Saúde -->
            <div class="flex gap-4">
                <div class="flex-1">
                    <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nome</label>
                    <input type="text" name="cpNomeAnm" placeholder="Nome" required
                        class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" />
                </div>

                <div class="flex-1">
                    <label for="saude" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Estado de saúde</label>
                    <select id="saude" name="cpSaude" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                        <c:forEach var="saude" items="${requestScope.saude}">
                            <option value="${saude}">${saude}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!-- Nome Científico -->
            <div>
                <label class="block text-sm font-medium text-gray-900 dark:text-white">Nome Científico</label>
                <input type="text" name="cpNomeCient"
                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                    placeholder="Nome Cientifico" required />
            </div>

            <!-- Linha 2: Espécie e Idade -->
            <div class="flex gap-8">
                <div class="flex-1">
                    <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Espécie</label>
                    <input type="text" name="cpEspecie"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                        placeholder="Espécie" required />
                </div>

                <div class="flex-1">
                    <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Idade</label>
                    <input type="number" name="cpIdade"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                        placeholder="Idade" required />
                </div>
            </div>

            <!-- Linha 3: Checkbox e Sexo -->
            <div class="flex gap-8 items-start">
                <div class="flex-1 flex items-center mt-6">
                    <input id="default-checkbox" type="checkbox" name="cpExpo" value="true"
                        class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 rounded-sm focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
                    <label for="default-checkbox" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Em Exposição</label>
                </div>


                <div class="flex-1">
                    <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Sexo do animal</label>
                    <select name="cpSexo" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                        <c:forEach var="sexo" items="${requestScope.sexo}">
                            <option value="${sexo}">${sexo}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!-- Botão de Cadastro -->
            <div class="mt-6">
                <button type="submit"
                    class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    Cadastrar
                </button>
            </div>
        </form>
    </div>

    <!-- Delete de Animal  -->
    <div id="delete" class="hidden max-w-md mx-auto">
        <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center dark:text-white">
            Deletar Animal
        </h2>

        <form method="POST" action="web?ac=delAnimal">
            <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Animais:</label>
            <select name="cpId" class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" required>
                <option value="">Selecione um Animal</option>
                <c:forEach var="anm" items="${requestScope.animais}">
                    <option value="${anm.id}">${anm.nome}</option>
                </c:forEach>
            </select>

            <div class="mt-6">
                <button type="submit"
                    class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    EXCLUIR
                </button>
            </div>
        </form>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const btnToggle = document.querySelector("#btnToggle");
        const divCadastro = document.querySelector("#cadastro");
        const divDelete = document.querySelector("#delete");

        btnToggle.addEventListener("click", () => {
            if (divCadastro.classList.contains('hidden')) {
                btnToggle.innerText = 'Deletar Animal';
                divCadastro.classList.remove('hidden');
                divDelete.classList.add('hidden');
            } else {
                btnToggle.innerText = 'Cadastrar Animal';
                divDelete.classList.remove('hidden');
                divCadastro.classList.add('hidden');
            }
        });
    });
</script>