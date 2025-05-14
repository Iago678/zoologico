<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="flex items-start mb-5">
    <div class="flex items-center h-5">
      <input type="checkbox" value="" class="w-4 h-4 border border-gray-300 rounded-sm bg-gray-50 focus:ring-3 focus:ring-blue-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:focus:ring-offset-gray-800" onclick="tooglePassword()" />
    </div>
    <label class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Mostrar Senha</label>
  </div>
  
<script>
    function tooglePassword(){
        const senha = document.getElementById("cpSenha");
        senha.type = senha.type === "password" ? "text" : "password";
    }
</script>