<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2 class="text-xl font-semibold mb-4 text-gray-800 dark:text-gray-100">Bem-vindo ao Zoologico</h2>

<%
    String mensagem = (String) request.getAttribute("mensagem");
    if (mensagem != null) {
%>
    <div class="bg-green-100 dark:bg-green-900 border border-green-400 dark:border-green-700 text-green-700 dark:text-green-100 px-4 py-3 rounded mb-4 transition-colors duration-300">
        <%= mensagem %>
    </div>
<%
    }
%>

<p class="text-gray-700 dark:text-gray-300 mb-4">
    Venha visitar a gente a ver nossos queridos animais!!!
</p>

<div class="grid md:grid-rows-3 gap-4 text-center">
    <a href="web?ac=cadastro">
    <div class="bg-blue-50 dark:bg-blue-900 p-4 rounded-lg transition-colors duration-300 hover:bg-blue-100 dark:hover:bg-blue-800">
        <h3 class="font-medium text-blue-800 dark:text-blue-100 mb-2">Horários</h3>
        <p class="text-blue-600 dark:text-blue-300">Veja nossos horários de visita</p>
    </div>
    </a>
    <a href="web?ac=login">
    <div class="bg-green-50 dark:bg-green-900 p-4 rounded-lg transition-colors duration-300 hover:bg-green-100 dark:hover:bg-green-800">
        <h3 class="font-medium text-green-800 dark:text-green-100 mb-2">Faça Login</h3>
        <p class="text-green-600 dark:text-green-300">Descontos para membros</p>
    </div>
    </a>
    <div class="bg-purple-50 dark:bg-purple-900 p-4 rounded-lg transition-colors duration-300 hover:bg-purple-100 dark:hover:bg-purple-800">
        <h3 class="font-medium text-purple-800 dark:text-purple-100 mb-2">Recurso 3</h3>
        <p class="text-purple-600 dark:text-purple-300">Descrição do terceiro recurso.</p>
    </div>
</div>