<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${url}/css/style-customerList.css" type="text/css"/>
<script src="${url}/js/custList.js"></script>
<div class="wrap">
	<div class="custListWrap">
		<div><input type="checkbox" id="allChk"/>전체선택</div>
		<div align="right" id="custTopBtn">
			<a href="${url}/admin/customerAdd">+추가</a>
			<button id="multiDel">선택삭제</button>
		</div>
		
		<form method="post" action="${url}/admin/multiDel" id="custListFrm">
			<ul class="custList">
				<li class="listTop">&nbsp;</li>
	            <li class="listTop">No.</li>
	            <li class="listTop">등록일</li>
	            <li class="listTop">이름</li>
	            <li class="listTop">연락처</li>
	            <li class="listTop">이메일</li>
	            <li class="listTop">주소</li>
	            <li class="listTop">세부사항</li>
	            <li class="listTop">상태</li>
	            <li class="listTop">예약날짜</li>
	            
	            <c:forEach var="vo" items="${list}">
		            <li><input type="checkbox" name="noList" value="${vo.custno}" class="chk"/></li>
		            <li>${vo.custno}</li>
		            <li>${vo.writedate}</li>
		            <li><a href="${url}/admin/customerView?custno=${vo.custno}">${vo.custname}</a></li>
		            <li>${vo.custtel}</li>
		            <li>${vo.custemail}</li>
		            <li>${vo.custaddr}</li>
		            <li class="wordcut">${vo.detail}</li>
		            <li>${vo.status}</li>
		            <li>${vo.visitdate}</li>
	            </c:forEach>
			</ul>
		</form>
		
		
		
		<div class="pagingWrap" align="center">
			<ul class="paging">
				<!-- 첫페이지 / 이전페이지 -->
				<c:if test="${pVO.pageNum == 1}">
					<li><<</li>
					<li><</li>
				</c:if>
				<c:if test="${pVO.pageNum > 1}">
					<li><a href="${url}/admin/customerList?pageNum=1<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>"><<</a></li>
					<li><a href="${url}/admin/customerList?pageNum=${pVO.pageNum-1}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>"><</a></li>
				</c:if>
				
				<!-- 페이지 번호 -->
				<c:forEach var="p" begin="${pVO.startPage}" end="${pVO.startPage + pVO.onePageCount-1}">
					<c:if test="${p<=pVO.totalPage}">
						<c:if test="${p == pVO.pageNum}">
							<li id="pageClick" style="background-color:rgb(77, 70, 55);">
						</c:if>
						<c:if test="${p != pVO.pageNum}">
							<li>
						</c:if>
						<a href="${url}/admin/customerList?pageNum=${p}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${p}</a></li>
					</c:if>
				</c:forEach>
				
				<!-- 다음페이지 / 마지막페이지 -->
				<c:if test="${pVO.pageNum < pVO.totalPage}">
					<li><a href="${url}/admin/customerList?pageNum=${pVO.pageNum+1}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">></a></li>
					<li><a href="${url}/admin/customerList?pageNum=${pVO.totalPage}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">>></a></li>
				</c:if>
				<c:if test="${pVO.pageNum == pVO.totalPage}">
					<li>></li>
					<li>>></li>
				</c:if>
			</ul>
		</div>
		<div class="searchWrap">
			<form method="get" action="${url}/admin/customerList" id="searchFrm">
				<select name="searchKey">
					<option value="custname">이름</option>
					<option value="custtel">연락처</option>
					<option value="custemail">이메일</option>
				</select>
				<input type="search" name="searchWord" placeholder=" " rel="search"/>
				<input type="submit" value="검색"/>
			</form>
		</div>
	</div>
</div>