$(function(){
	// 검색
	$("#searchFrm").submit(function(){
		if($("#searchWord").val() == ''){
			alert("검색어를 입력해 주세요.");
			return false;
		}
	});
	
	// 리스트 체크
	$("#allChk").click(function(){
		$(".chk").prop('checked', this.checked);
	});
	
	$("#multiDel").click(function(){
		var cnt = 0;
		
		$(".chk").each(function(i, obj){
			if(obj.checked){
				cnt++;
			}
		});
		
		if(confirm("삭제하겠습니까?")){
			$("#custListFrm").submit();
		}
			
		if(cnt <= 0){
			alert("목록을 선택해 주세요.");
			return false;
		}
	});
	
});
