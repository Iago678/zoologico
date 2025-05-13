<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${not empty msg}">
    <div class="p-4 mb-4 text-sm text-green-700 bg-green-100 rounded-lg">
        ${msg}
    </div>
</c:if>

<c:if test="${not empty err}">
    <div class="p-4 mb-4 text-sm text-red-700 bg-red-100 rounded-lg">
        ${err}
    </div>
</c:if>