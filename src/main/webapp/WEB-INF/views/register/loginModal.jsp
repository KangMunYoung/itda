<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 로그인 모달창... -->
<div class="loginModal" id="loginModal">
  <div class="modalOverlay"></div>
  <article class="loginForm">
    <div class="closeBtn">╳</div>
    <form method="post" action="/itda/loginOk">
      <h3>LOGIN</h3>
      <input type="text" class="login_userid" name="m_userid" placeholder="아이디" /><br />
      <input type="password" class="login_userpwd" name="m_userpwd" placeholder="비밀번호" /><br />
    <label class="autoLoginLabel">
      <input type="checkbox" name="autoLogin" id="autoLogin" class="autoLogin" />
      <span>로그인상태유지</span>
    </label>
      <input type="submit" value="로그인" />
    </form>
    <div class="loginBottumBtn">
      <a href="" class="joinBtn2">회원가입</a>
      <a href="" class="findId">ID&Password 찾기</a>
    </div>
  </article>
</div>
