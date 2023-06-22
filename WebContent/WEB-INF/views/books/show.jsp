<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
    <c:param name="review">
	   <c:choose>
            <c:when test="${book != null}">
        <h2>${book.title} の詳細ページ</h2>

	        <p>タイトル：<c:out value="${book.title}" /></p>
	        <p>著者名：<c:out value="${book.author}" /></p>
	        <p>出版社：<c:out value="${book.company}" /></p>
	        <p>読書状況：<c:out value="${book.readStatus}" /></p>
	        <p>レビュー：<c:out value="${book.review}" /></p>
	        <p>評価：<c:out value="${book.star}" /></p>


        <p><a href="${pageContext.request.contextPath}/ReadBookServlet">本棚に戻る</a></p>

        <p><a href="${pageContext.request.contextPath}/edit?id=${book.id}">この本について想いを馳せる</a></p>
	        </c:when>
            <c:otherwise>
                <h2>お探しの本は見つかりませんでした。</h2>
            </c:otherwise>
       </c:choose>
    </c:param>
</c:import>