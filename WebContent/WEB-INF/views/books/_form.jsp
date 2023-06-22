<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="title">タイトル</label><br />
<input type="text" name="title" id="title" value="${book.title}" />
<br /><br />

<label for="author_book">著者名</label><br />
<input type="text" name="author" id="author_book" value="${book.author}" />
<br /><br />

<label for="company_book">出版社</label><br />
<input type="text" name="company" id="company_book" value="${book.company}" />
<br /><br />

<label for="readStatus">読書状況</label><br />
<select name="readStatus" id="readStatus">
  <option value="読みたい" ${book.readStatus eq 'wantToRead' ? 'selected' : ''}>読みたい</option>
  <option value="今読んでいる" ${book.readStatus eq 'currentlyReading' ? 'selected' : ''}>今読んでいる</option>
  <option value="読み終わった" ${book.readStatus eq 'finishedReading' ? 'selected' : ''}>読み終わった</option>
</select>
<br /><br />

<label for="review_book">レビュー</label><br />
<textarea name="review" rows="5" cols="50" id="review_book">${book.review}</textarea>
<br /><br />

<label for="rating">評価</label><br />
<div class="rating">
  <span class="star ${book.star >= 1 ? 'selected' : ''}"></span>
  <span class="star ${book.star >= 2 ? 'selected' : ''}"></span>
  <span class="star ${book.star >= 3 ? 'selected' : ''}"></span>
  <span class="star ${book.star >= 4 ? 'selected' : ''}"></span>
  <span class="star ${book.star >= 5 ? 'selected' : ''}"></span>
</div>
<input type="hidden" name="star" id="star" value="${book.star}" />
<br /><br />

<script>
  const stars = document.querySelectorAll('.star');
  const ratingInput = document.getElementById('star');

  stars.forEach((star, index) => {
    star.addEventListener('click', () => {
      // 評価の値を設定
      ratingInput.value = index + 1;

      // 選択された星までを黄色にする
      for (let i = 0; i < stars.length; i++) {
        if (i <= index) {
          stars[i].classList.add('selected');
        } else {
          stars[i].classList.remove('selected');
        }
      }
    });
  });
</script>

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">追加</button>