$(function(){
	$("#custAddFrm").submit(function(){
		if($("#custname").val() == '' || $("#custname").val() == null){
			alert("이름을 입력해주세요.");
			return false;
		}
		if($("#custtel").val() == '' || $("#custtel") == null){
			alert("연락처를 입력해주세요.");
			return false;
		}
		
		return true;
	});
});