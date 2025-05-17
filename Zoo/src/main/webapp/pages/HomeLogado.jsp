<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.estaLogado != null && sessionScope.estaLogado.equals('1') && sessionScope.user.tipo == 'VISITANTE'}">
<h1 class="text-gray-900 dark:text-gray-300"> ${requestScope.msg} 
    Bem vindo ${sessionScope.user.nome} !!!
</h1>

</c:if>

<c:if test="${sessionScope.estaLogado != null && sessionScope.estaLogado.equals('1') && sessionScope.user.tipo == 'FUNCIONARIO'}">
    <h1 class="text-gray-900 dark:text-gray-300"> ${requestScope.msg}
        Bem-vindo colaborador ${sessionScope.user.nome} !!!
    </h1>
</c:if>
<c:if test="${sessionScope.estaLogado != null && sessionScope.estaLogado.equals('1') && sessionScope.user.tipo == 'ADMIN'}">
    <h1 class="text-gray-900 dark:text-gray-300"> ${requestScope.msg}
            Bem-vindo Admin ${sessionScope.user.nome} !!!
        </h1>
</c:if>





