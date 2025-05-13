<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<h2 class="text-3xl font-bold text-blue-600 mb-6 p-1 text-center">
    Cadastro
</h2>

<div class="container mx-auto p-4">
    <form class="max-w-md mx-auto space-y-4" method="POST" action="web?ac=saveCliente">
        <div class="space-y-2">
                    <label for="nome" class="block text-sm font-medium text-gray-700" >Nome</label>
                    <input type="text" required name="cpNome" class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
        </div>
        <div class="space-y-2">
                    <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
                    <input type="email" required name="cpEmail" class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
        </div>
        <div class="space-y-2">
            <label for="login" class="block text-sm font-medium text-gray-700">Login</label>
            <input type="text" required name="cpLogin" class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
        </div>

        <div class="space-y-2">
            <label for="senha" class="block text-sm font-medium text-gray-700">Senha</label>
            <input type="password" required name="cpSenha" class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            <jsp:include page="../componentes/exibeSenha.jsp" />
        </div>

        <button type="submit" class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
            Cadastrar
        </button>
    </form>
</div>





