<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
<script>

</script>
  <div class="TopContent">
    <div class="TopSubContent">
    	<div>신고 게시판</div>
    </div>
  </div>
  <div class="MainContent">
       <div style=" width:100%; margin-top:50px; overflow:auto;">
          <ul class="sirenTitle">
          	<li>no</li>
            <li>카테고리</li>
            <li>제목</li>
            <li>글쓴이</li>
            <li>신고수</li>
            <li>등록일</li>
            <li>&nbsp;</li>
          </ul>
          <ul id="BoardView">
            <c:forEach items="${list}" var="call">
              <li>${call.board_seq}</li>
              <li>${call.board_content}</li>
              <li> ${call.board_subject}</li>
              <li>${call.m_nickname}</li>
              <li>${call.board_call}</li>
              <li>${call.board_writedate}</li>
              <li class="BoardBlack" name="${call.board_seq}">관리</li>
          	</c:forEach>
          </ul>
    </div>
    <div class="AdminBoardButtonBox">
      <ul class="AdminBoardListButton">
        <li><a href="#"><</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">6</a></li>
        <li><a href="#">></a></li>
      </ul>
    </div>
  </div>
  

 <!-- 모달창... -->
  <div class="CallBoardModalTest">
    <div class="modalOverlay"></div>
    <article class="BoardModal">
    <div id="update"></div>

    </article> 
  </div>
