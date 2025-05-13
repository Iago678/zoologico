<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container mx-auto flex justify-between items-center">
    <h1 class="text-2xl font-bold"><a href="/">Zoologico</a></h1>
    <nav>
        <ul class="flex space-x-6">
            <li><a href="/" class="hover:underline">Home</a></li>

            <!-- logado como cliente -->
            <c:if test="${sessionScope.estaLogado != null && sessionScope.estaLogado.equals('1') && sessionScope.user.tipo == 'CLIENTE'}">
                <li><a href="web?ac=logout" class="hover:underline">Logout</a></li>
            </c:if>

             <c:if test="${sessionScope.estaLogado == null || sessionScope.estaLogado.equals('0')}">
                <li><a href="web?ac=login" class="hover:underline">Login</a></li>
                <li><a href="web?ac=cadastro" class="hover:underline">Cadastrar</a></li>
            </c:if>
        </ul>
    </nav>
</div>
