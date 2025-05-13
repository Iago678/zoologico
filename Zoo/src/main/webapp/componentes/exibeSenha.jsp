<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <label class="font-small text-gray-700">
        <input type="checkbox" onclick="tooglePassword()">
        Mostrar senha
</label>

<script>
    function tooglePassword(){
        const senha = document.getElementById("cpSenha");
        senha.type = senha.type === "password" ? "text" : "password";
    }
</script>