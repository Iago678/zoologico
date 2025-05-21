<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Seção de Edição de Animal -->
<div id="edicao" class="max-w-md mx-auto">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center dark:text-white">
        Editar Animal
    </h2>

    <form class="max-w-md mx-auto space-y-6 gap-4" method="POST" action="web?ac=updateAnimal&id=${id}">
        <!-- Campo oculto com o ID do animal -->
        <input type="hidden" name="cpId" value="${requestScope.animal.id}" />

        <!-- Nome e Saúde -->
        <div class="flex gap-4">
            <div class="flex-1">
                <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Nome</label>
                <input type="text" name="cpNomeAnm" placeholder="Nome" required
                    value="${requestScope.animal.nome}"
                    class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white" />
            </div>

            <div class="flex-1">
                <label for="saude" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Estado de saúde</label>
                <select id="saude" name="cpSaude"
                    class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                    <c:forEach var="saude" items="${requestScope.saude}">
                        <option value="${saude}" ${saude == requestScope.animal.estadoSaude ? 'selected' : ''}>${saude}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Nome Científico -->
        <div>
            <label class="block text-sm font-medium text-gray-900 dark:text-white">Nome Científico</label>
            <input type="text" name="cpNomeCient" placeholder="Nome Cientifico" required
                value="${requestScope.animal.nomeCientifico}"
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" />
        </div>

        <!-- Espécie e Idade -->
        <div class="flex gap-8">
            <div class="flex-1">
                <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Espécie</label>
                <input type="text" name="cpEspecie" placeholder="Espécie" required
                    value="${requestScope.animal.especie}"
                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" />
            </div>

            <div class="flex-1">
                <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Idade</label>
                <input type="number" name="cpIdade" placeholder="Idade" required
                    value="${requestScope.animal.idade}"
                    class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" />
            </div>
        </div>

        <!-- Checkbox e Sexo -->
        <div class="flex gap-8 items-start">
            <div class="flex-1 flex items-center mt-6">
                <input id="default-checkbox" type="checkbox" name="cpExpo" value="true"
                    ${requestScope.animal.emExpo ? 'checked' : ''}
                    class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 rounded-sm focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600" />
                <label for="default-checkbox" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Em Exposição</label>
            </div>

            <div class="flex-1">
                <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Sexo do animal</label>
                <select name="cpSexo"
                    class="bg-gray-50 border border-gray-300 rounded-lg p-2.5 w-full focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                    <c:forEach var="sexo" items="${requestScope.sexo}">
                        <option value="${sexo}" <c:if test="${sexo == requestScope.animal.sexo}">selected</c:if>>${sexo}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Botão de Salvar -->
        <div class="mt-6">
            <button type="submit"
                class="text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">
                Salvar Alterações
            </button>
        </div>
    </form>
</div>