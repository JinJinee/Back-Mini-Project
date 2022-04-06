<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${url}/css/style-detail.css" type="text/css"/>
<script src="${url}/js/customerView.js"></script>
<div class="wrap">
	<div class="detailTitle">
		<img src="${url}/img/revise.png"/>
		<h1>Detail</h1>
	</div>
	<form method="post" action="${url}/admin/customerEditOk" id="custViewFrm">
		<div class="detailWrap">
			<ul>
				<li>
					<div>이름</div>
					<input type="text" name="custname" value="${vo.custname}" id="custname"/>
				</li>
		        <li>
		        	<div>연락처</div>
		        	<input type="text" name="custtel" value="${vo.custtel}" id="custtel"/>
		        </li>
		        <li>
		        	<div>이메일</div>
		        	<input type="text" name="custemail" value="${vo.custemail}"/>
		        </li>
		        <li>
		        	<div>주소</div>
		        	<input type="text" name="custaddr" value="${vo.custaddr}"/>
		        </li>
			</ul>
			<ul>
				<li id="detail">
					<div>세부사항</div>
					<textarea name="detail">${vo.detail}</textarea>
				</li>
		        <li>
		        	<div>상태</div>
		        	<input type="text" name="status" value="${vo.status}"/>
		        </li>
		        <li>
		        	<div>예약날짜</div>
		        	<input type="datetime-local" name="visitdate" id="visitdate">
		        </li>
			</ul>
		</div>
		<div class="detailBtn">
			<input type="submit" value="수정"/>
			<a href="${url}/admin/customerList"><input type="button" value="목록"/></a>
		</div>
		<input type="hidden" name="custno" value="${vo.custno}"/>
	</form>

</div>