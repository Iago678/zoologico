<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2 class="text-xl font-semibold mb-4">Bem-vindo ao Zoologico</h2>

<%
    String mensagem = (String) request.getAttribute("mensagem");
    if (mensagem != null) {
%>
    <div class="bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded mb-4">
        <%= mensagem %>
    </div>
<%
    }
%>

<p class="text-gray-700 mb-4">
    Venha visitar a gente a ver nossos queridos animais!!!
</p>

<div class="grid md:grid-rows-3 gap-4 text-center">
    <div class="bg-blue-50 p-4 rounded-lg">
        <h3 class="font-medium text-blue-800 mb-2 ">Horários</h3>
        <p class="text-blue-600">Veja nossos horários de visita</p>
    </div>
    <div class="bg-green-50 p-4 rounded-lg">
        <h3 class="font-medium text-green-800 mb-2">Faça Login</h3>
        <p class="text-green-600">Descontos para membros</p>
    </div>
    <div class="bg-purple-50 p-4 rounded-lg">
        <h3 class="font-medium text-purple-800 mb-2">Recurso 3</h3>
        <p class="text-purple-600">Descrição do terceiro recurso.</p>
    </div>
</div>
