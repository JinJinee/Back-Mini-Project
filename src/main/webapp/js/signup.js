function formCheck() {
	// 아이디 유효성검사
	// 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능
	var reg = /^[a-zA-Z0-9_-]{5,20}$/;
	var empid = document.getElementById("empid");
	if (empid.value == "") {
		alert("아이디를 입력하세요.");
		empid.focus();
		return false;
	}
	if (!reg.test(empid.value)) {
		alert("아이디를 잘못 입력하였습니다. \n5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
		empid.focus();
		return false;
	}

	// 비밀번호 유효성검사
	// 8~16자 영문 대 소문자, 숫자, 특수문자를 사용 가능
	reg = /^[a-zA-Z0-9_!^@*]{8,16}$/;
	var emppwd = document.getElementById("emppwd");

	if (emppwd.value == '') {
		alert("비밀번호를 입력하세요.");
		emppwd.focus();
		return false;
	}
	if (!reg.test(emppwd.value)) {
		alert("비밀번호를 잘못 입력하였습니다. \n8~16자 영문 대 소문자, 숫자, 특수문자(_,!,^,@,*)만 사용 가능합니다.");
		emppwd.focus();
		return false;
	}

	// 비밀번호 재확인 유효성검사
	var emppwd2 = document.getElementById("emppwd2");
	if (emppwd2.value == '') {
		alert("비밀번호를 재확인해주세요.");
		emppwd2.focus();
		return false;
	}
	if (emppwd2.value != emppwd2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		emppwd2.focus();
		return false;
	}

	// 이름
	reg = /^[가-힣a-z]{2,7}$/;
	var empname = document.getElementById("empname");
	if (empname.value == "") {
		alert("이름을 입력하세요.");
		empname.focus();
		return false;
	}
	if (!reg.test(empname.value)) {
		alert("이름을 잘못 입력하였습니다. \n이름은 2~7글자 이내여야합니다.");
		empname.focus();
		return false;
	}

	// 전화번호 유효성검사
	reg = /^[0-9]{2,3}[-][0-9]{3,4}[-][0-9]{4}$/;
	var tel = document.getElementById("tel");

	if (tel.value == '') {
		alert("전화번호를 입력하세요.");
		tel.focus();
		return false;
	}
	if (!reg.test(tel.value)) {
		alert("전화번호를 잘못 입력했습니다.");
		tel.focus();
		return false;
	}
	return true;
} // formCheck


$(function() {
	// 아이디 중복검사
	$("#empid").focusout(function() {
		var reg = /^[a-zA-Z0-9_]{5,20}$/;
		var empid = $("#empid").val();
		if (reg.test(empid)) {
			var url = "/myapp/admin/signupIdCheck";
			$.ajax({
				url: url,
				data: "empid=" + empid,
				type: "POST",
				success: function(result) {
					if (result > 0) { // 사용불가(중복된 아이디가 있다.)
						$("#chkId").html("이미 사용중인 아이디입니다.");
						$("#idChk").val("N");
						$("#chkId").css("color", "red").css("font-size", "13px");
					} else { // 사용가능
						$("#chkId").html("사용가능한 아이디입니다.");
						$("#idChk").val("Y");
						$("#chkId").css("color", "blue").css("font-size", "13px");
					}
				}
			});
		} else if (empid == '') { // 사용불가
			$("#chkId").html("필수 정보입니다.");
			$("#idChk").val("N");
			$("#chkId").css("color", "red").css("font-size", "13px");
		} else {
			$("#chkId").html("5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
			$("#idChk").val("N");
			$("#chkId").css("color", "red").css("font-size", "13px");
		}
	}); //아이디 중복검사
	
	// 비밀번호 검사
	$("#emppwd").focusout(function(){
		reg = /^[a-zA-Z0-9_!^@*]{8,16}$/;
		var emppwd = $("#emppwd").val();
		if(reg.test(emppwd)){
			$("#chkPwd").html('');
			$("#pwdChk").val("Y");
		}else if(emppwd == ''){
			$("#chkPwd").html("필수 정보입니다.");
			$("#pwdChk").val("N");
			$("#chkPwd").css("color", "red").css("font-size", "13px");
		}else {
			$("#chkPwd").html("8~16자 영문 대 소문자, 숫자, 특수문자(_,!,^,@,*)를 사용하세요.");
			$("#pwdChk").val("N");
			$("#chkPwd").css("color", "red").css("font-size", "13px");
		}
	}); // 비밀번호 검사
	
	// 비밀번호 재검사
	$("#emppwd2").focusout(function(){
		var emppwd2 = $("#emppwd2").val();
		if(emppwd2 != '' && emppwd2 == $("#emppwd").val()){
			$("#chkPwd2").html('');
			$("#pwdChk2").val("Y");
		} else if(emppwd2 == ''){
			$("#chkPwd2").html("필수 정보입니다.");
			$("#pwdChk2").val("N");
			$("#chkPwd2").css("color", "red").css("font-size", "13px");
		}else {
			$("#chkPwd2").html("비밀번호가 일치하지 않습니다.");
			$("#pwdChk2").val("N");
			$("#chkPwd2").css("color", "red").css("font-size", "13px");
		}
	}); // 비밀번호 재검사
	
	// 이름 검사
	$("#empname").focusout(function(){
		reg = /^[가-힣a-z]{2,7}$/;
		var empname = $("#empname").val();
		if(reg.test(empname)){
			$("#chkName").html('');
			$("#nameChk").val("Y");
		}else if(empname == ''){
			$("#chkName").html("필수 정보입니다.");
			$("#nameChk").val("N");
			$("#chkName").css("color", "red").css("font-size", "13px");
		}else{
			$("#chkName").html("영문 대 소문자, 한글을 사용해 2~7글자 이내로 입력해주세요.");
			$("#nameChk").val("N");
			$("#chkName").css("color", "red").css("font-size", "13px");		
		}
	}); // 이름 검사
	
	
	// 전화번호 검사
	$("#tel").focusout(function(){
		reg = /^[0-9]{2,3}[-][0-9]{3,4}[-][0-9]{4}$/;
		var tel = $("#tel").val();
		if(reg.test(tel)){
			$("#chkTel").html('');
			$("#telChk").val("Y");
		} else if(tel == ''){
			$("#chkTel").html("필수 정보입니다.");
			$("#telChk").val("N");
			$("#chkTel").css("color", "red").css("font-size", "13px");
		}else{
			$("#chkTe;").html("");
			$("#telChk").val("N");
			$("#chkTel").css("color", "red").css("font-size", "13px");		
		}
	}); // 전화번호 검사
	
	
	// 인증번호 받기 누르면 입력창 활성화
	$("#telBtn").click(function(){
		$("#secureNum").attr("disabled", false);
		$("#secureNum").focus();
	})
	
	$("#emailSelect").on("change", function(){
		$("#email2").attr("disabled", false);
		if($(this).val() == "self"){
			$("#email2").val("");
		}else{
			$("#email2").val($(this).val());
		}
		
	})
	
	
	// 로그인
	$(document).ready(function(){
		$("#loginFrm").submit(function(){
		if($("#empid").val() == ''){
			$("#logChk").html("아이디를 입력해 주세요.");
			$("#logIdChk").val("N");
			$("#logChk").css("color", "red").css("font-size", "13px").css("text-align", "left");
			return false;
		}
		if($("#emppwd").val() == ''){
			$("#logChk").html("비밀번호를 입력해 주세요.");
			$("#logPwdChk").val("N");
			$("#logChk").css("color", "red").css("font-size", "13px").css("text-align", "left");
			return false;
		}
		return true;
		});
	});
	
	
	$("#telBtn").click(function(){
		alert("인증번호를 전송했습니다.");
	})
	
});

