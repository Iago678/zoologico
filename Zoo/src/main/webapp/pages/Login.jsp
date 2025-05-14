<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">
Login
</h2>

<div class="container mx-auto p-4">
    <form class="max-w-md mx-auto space-y-4" action="web?ac=valLog" method="POST">
      <div class="mb-5">
        <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Seu Login</label>
        <input type="text" name="cpLogin" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Login" required />
      </div>
      <div class="mb-5">
        <label  class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Senha</label>
        <input type="password" name="cpSenha" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder = "Senha" required />
      </div>
      <div class="flex items-start mb-5">
        <jsp:include page="../componentes/exibeSenha.jsp" />
      </div>
    
    <div class="pb-3">
      <p class="mt-2 text-sm text-gray-500 dark:text-gray-400">Não possuí cadastro?<a href="web?ac=cadastro" class="font-medium text-blue-600 hover:underline dark:text-blue-500">Faça seu cadastro aqui!</a></p>
    </div>
      <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Logar</button>
    </form>
</div>




