<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${url}/js/reserve.js"></script>
<div class="wrap">
	<div class="reserveFormWrap">
		<h1>상담예약</h1>
		<form method="post" action="${url}/reserveOk" id="reserveFrm">
			<ul>
				<li>
					<input type="text" name="custname" id="custname" placeholder="*성함"/><br>
					<span id="nameChk"></span>
				</li>
				<li>
					<input type="text" name="custtel" id="custtel" placeholder="*연락처"/><br>
					<span id="telChk"></span>
				</li>
				<li><input type="text" name="custemail" id="custemail" placeholder="이메일" /></li>
				<li><input type="text" name="custaddr" id="custaddr" placeholder="주소" /></li>
				<li>*필수입력</li>
				<li><iframe src="/myapp/reserve/policy.html"> </iframe></li>
				<li><input type="checkbox" required /> 동의합니다.</li>
				<li><input type="submit" value="보내기" /></li>
			</ul>
		</form>
	</div>
</div>