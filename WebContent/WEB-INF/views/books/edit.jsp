<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="review">
      <c:choose>
            <c:when test="${book != null}">
        <h2>${book.title} について振り返る</h2>

        <form method="POST" action="${pageContext.request.contextPath}/update">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/ReadBookServlet">書斎に戻る</a></p>

        <p><a href="#" onclick="confirmDestroy();">この本をBOOKOFFに売る</a></p>
        <form method="POST" action="${pageContext.request.contextPath}/destroy">
            <input type="hidden" name="_token" value="${_token}" />
        </form>
        <script>
        function confirmDestroy() {
            if(confirm("本当に売ってよろしいですか？")) {
                document.forms[1].submit();
            }
        }
        </script>
        </c:when>
            <c:otherwise>
                <h2>お探しの本は見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
    </c:param>
</c:import>