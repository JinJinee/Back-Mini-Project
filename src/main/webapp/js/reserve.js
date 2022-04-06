

$(document).ready(function() {
	$("#reserveFrm").submit(function() {
		if($("#custname").val() == '') {
			$("#nameChk").html("이름을 입력해 주세요.");
			$("#nameChk").css("font-size", "13px").css("color", "gray").css("left", "20px");
			$("#custname").parent().css("margin-bottom", "0px");
			$("#csutname").focus();
			return false;
		} 
		if($("#custtel").val() == '') {
			$("#custtel").focus();
			$("#telChk").html("연락처를 입력해 주세요.");
			$("#telChk").css("font-size", "13px").css("color", "gray").css("left", "20px");
			$("#custtel").parent().css("margin-bottom", "0px");
			return false;
		} 
		
		var reg = /^[0-9]{2,3}[-][0-9]{3,4}[-][0-9]{4}$/;
		if(!reg.test($("#custtel").val())){
			$("#custtel").focus();
			$("#telChk").html("010-0000-0000 형식으로 입력해 주세요.");
			$("#telChk").css("font-size", "13px").css("color", "gray").css("left", "20px");
			$("#custtel").parent().css("margin-bottom", "0px");
			return false;
		}
		
		return true;
		
	});
});