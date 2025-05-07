<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container mx-auto flex justify-between items-center">
    <h1 class="text-2xl font-bold"><a href="/">Zoologico</a></h1>
    <nav>
        <ul class="flex space-x-6">
            <li><a href="/" class="hover:underline">Home</a></li>
            <%
                if (session.getAttribute("username") != null) {
            %>
                <li><a href="logout.jsp" class="hover:underline">Logout</a></li>
            <%
                } else {
            %>
                <li><a href="/login" class="hover:underline">Login</a></li>
            <%
                }
            %>
        </ul>
    </nav>
</div>
