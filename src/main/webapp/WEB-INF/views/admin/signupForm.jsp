<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${url}/js/signup.js"></script>
<div class="wrap">
	<div class="signupWrap">
		<h1>회원가입</h1>
		<form method="post" action="${url}/admin/signupOk" id="signupFrm" onsubmit="return formCheck()">
			<ul>
				<li>아이디</li>
				<li>
					<input type="text" name="empid" id="empid" maxlength=20/>
					<span id="chkId"></span>
					<input type="hidden" id="idChk" value="N"/>
				</li>
				<li>비밀번호</li>
				<li>
					<input type="password" name="emppwd" id="emppwd" maxlength=16/>
					<span id="chkPwd"></span>
					<input type="hidden" id="pwdChk" value="N"/>
				</li>
				<li>비밀번호 재확인</li>
				<li>
					<input type="password" name="emppwd2" id="emppwd2" maxlength=16/>
					<span id="chkPwd2"></span>
					<input type="hidden" id="pwdChk2" value="N"/>
				</li>
				<li>이메일 <span style="color:rgba(94, 94, 94, 0.73); font-size:12px;">(선택)</span></li>
				<li>
					<input type="text" name="email1" id="email1"/>
					@
					<input type="text" name="email2" id="email2" disabled/>
					<select name="emailSelect" id="emailSelect">
						<option value="">선택</option>
	                  	<option value="self">직접입력</option>
	                  	<option value="naver.com">naver.com</option>
	                  	<option value="gmail.com">gmail.com</option>
	                  	<option value="nate.com">nate.com</option>
	                  	<option value="daum.net">daum.net</option>
					</select>
				</li>
				<li>이름</li>
				<li>
					<input type="text" name="empname" id="empname"/>
					<span id="chkName"></span>
					<input type="hidden" id="nameChk" value="N"/>
				</li>
				<li>휴대전화</li>
				<li>
					<input type="text" name="tel" id="tel" placeholder="ex) 010-0000-0000">
					<input type="button" id="telBtn" value="인증번호 받기"/>
				</li>
				<li>
					<input type="text" name="secureNum" id="secureNum" placeholder=" 인증번호 입력" disabled>
					<span id="chkTel"></span>
					<input type="hidden" id="telChk" value="N"/>
				</li>
				<li style="margin-bottom: 0px; margin-top: 15px;">생년월일 <span style="color:rgba(94, 94, 94, 0.73); font-size:12px;">(선택)</span></li>
				<li>
					<input type="text" name="year" placeholder="년(4자)" id="year" maxlength="4">
					<select name="month" id="month">
		                <option value="">월</option>
		                <c:forEach var="i" begin="1" end="12">
		                	<option value="${i}">${i}</option>
		                </c:forEach>
	             	 </select>
	             	 <select name="day" id="day">
		                <option value="">일</option>
		                <c:forEach var="i" begin="1" end="31">
		                	<option value="${i}">${i}</option>
		                </c:forEach>
	             	 </select>
				</li>
				<li style="margin-bottom: 0px; margin-top: 15px;">성별 <span style="color:rgba(94, 94, 94, 0.73); font-size:12px;">(선택)</span></li>
				<li>
					<select name="gender" id="gender">
		                <option value="">선택</option>
		                <option value="여">여</option>
		                <option value="남">남</option>
		                <option value="선택안함">선택안함</option>
	              	</select>
				</li>
				<li><input type="submit" value="가입하기"/></li>
			</ul>
		</form>
	</div>
</div>