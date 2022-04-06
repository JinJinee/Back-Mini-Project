<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${url}/css/calendar.css" type="text/css"/>
<script>
$(function(){
	$(".calList").each(function(){
		for(var i=1; i<=31; i++){
			if(($(this).children("#custDay").text() == i) && ($(this).children("#custMonth").text() == $(".month").text()) && ($(this).children("#custYear").text() == $(".year").text())){
				$('#' + i).children("div").text($(this).children("#time-name").text());
				$('#' + i).children("div").css("background","#FFC2B1");
			}
		}
	})
});
</script>
<div class="wrap">
	<div class='calendar'>
		<div class="header">
			<div class="month-year">
				<div class="month"></div>
				<div class="year"></div>
			</div>
			<div class="nav">
				<button class="nav-btn go-prev" onclick="preMonth()">&lt;</button>
				<button class="nav-btn go-today" onclick="goToday()">Today</button>
				<button class="nav-btn go-next" onclick="nextMonth()">&gt;</button> 
			</div>
		</div>
		<div class="mainCalender">
			<div class="days">
				<div class="day">일</div>
				<div class="day">월</div>
				<div class="day">화</div>
				<div class="day">수</div>
				<div class="day">목</div>
				<div class="day">금</div>
				<div class="day">토</div>
			</div>
			<div class="dates"></div>
		</div>
	</div>
	<script src="${url}/js/calendar.js"></script>
	<div class="calendarAdd">
		<a href="${url}/admin/customerAdd"><input type="button" value="+"/>&nbsp;일정추가</a>
	</div>
	<c:forEach var="a" items="${calList}">
		<div class="calList" style="display:none;">
			<span id="custYear">${a.year}</span>
			<span id="custMonth">${a.month}</span>
			<span id="custDay">${a.day}</span>
			<span id="time-name">${a.time} ${a.custname}</span>
		</div>
	</c:forEach>
</div>
