<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="review">
     <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>本棚</h2>
        <ul>
            <c:forEach var="book" items="${books}">
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${book.id}">
                        <c:out value="${book.id}" />
                    </a>
                    ：<c:out value="${book.title}"></c:out>
                </li>
            </c:forEach>
        </ul>

        <p><a href="${pageContext.request.contextPath}/new">新しい本を本棚に追加</a></p>
    </c:param>
</c:import>

<link rel="stylesheet" href="css/styles.css">
