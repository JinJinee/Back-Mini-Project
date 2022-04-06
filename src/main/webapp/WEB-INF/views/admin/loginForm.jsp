<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/myapp/js/signup.js"></script>
<div class="wrap">
	<div class="loginWrap">
		<img src="${url}/img/login-man.png"/>
		<h2>관리자</h2>
		<form method="post" action="${url}/admin/loginOk" id="loginFrm">
			<ul>
				<li>
					<div><img src="${url}/img/id-icon.png"/></div><input type="text" name="empid" id="empid" placeholder="아이디"/>
				</li>
				<li>
					<div><img src="${url}/img/key.png"/></div><input type="password" name="emppwd" id="emppwd" placeholder="비밀번호"/>
				</li>
				<li><input type="checkbox"/> 자동로그인</li>
				<li id="logChk">
					<input type="hidden" id="logIdChk" value="N"/>
					<input type="hidden" id="logPwdChk" value="N"/>
				</li>
				<li><input type="submit" value="로그인" id="logsubmit"/></li>
				<li><a href="#">아이디</a> / <a href="#">비밀번호</a> 찾기</li>
				<li><a href="${url}/admin/signupForm">회원가입</a></li>
			</ul>
		</form>
	</div>
</div>