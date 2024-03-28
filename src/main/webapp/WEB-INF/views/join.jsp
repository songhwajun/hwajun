<%@ page pageEncoding="UTF-8"%>
<div id="joinJsp">
	<a href="/">뒤로가기</a>
	<br>
	<div>
		<!-- name : 서버로 전송 할 때 변수이름의 역할 -->
	    <label>이메일 : </label><input type="text" id="memberEmail"> <button id="duplicateCheck" value="N">중복확인</button> 
	    <label id="duplicateCheckTrue" style="display:none;">이미 사용중인 ID입니다</label>
	    <label id="duplicateCheckFalse" style="display:none;">사용가능한 ID입니다</label> 
	    <br>
	    <label>비밀번호 : </label><input type="password" id="memberPassword"> <br>
    </div>
    <button id="join">회원가입</button>
</div>

<script type="text/javascript" src="/resource/jquery/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="/resource/cmm/com.js"></script>

<script type="text/javascript">
	documentReady("#joinJsp" , function(dom){
		//id 변경 시 id중복체크 N으로 변경
		$(dom).find("#memberEmail").on('change', function(){
			$(dom).find("#duplicateCheck").val("N");
			$(dom).find("#duplicateCheckFalse").hide();
			$(dom).find("#duplicateChecktrue").hide();
		});
		
		//id 중복확인
		$(dom).find("#duplicateCheck").on('click', function(){
			var id = $(dom).find("#memberEmail").val();
			var pw = $(dom).find("#memberPassword").val();
			var duplicateCheck = $(dom).find("#duplicateCheck").val();
			
			if(id == ""){
				alert("아이디를 입력해주세요");
				return;
			}
			
			
			var param = {};
			param.id = id;
			
			ajaxAction(param, "text", "/LoginController/duplicateCheck.act", function(result){
				console.log(result);	
				if(result == 0){
					//중복확인 정상
					$(dom).find("#duplicateCheck").val("Y");
					$(dom).find("#duplicateCheckFalse").show();
				}else{
					//중복확인 비정상
					$(dom).find("#duplicateCheck").val("N");
					$(dom).find("#duplicateCheckTrue").show();
				}
				
			});
			
		});
		
		
		//회원가입
		$(dom).find("#join").on('click', function(){
			var id = $(dom).find("#memberEmail").val();
			var pw = $(dom).find("#memberPassword").val();
			var duplicateCheck = $(dom).find("#duplicateCheck").val();
			
			if(id == "" || pw == ""){
				var type = "비밀번호를"
				if(id == "") {
					type = "이메일을"		
				}
				alert("" + type + " 입력해주세요");
				return;
			}			
			
			if(duplicateCheck == "N"){
				alert("이미 사용중인 ID로는 재 가입이 불가능 합니다.")
				return;
			}
			
			var param = {};
			param.id = id;
			param.password = pw;
			param.passwordErr = 0;
			
			console.log("ajax전송");
			ajaxAction(param, "text", "/LoginController/join.act", function(data){
				alert(data);
				document.location.href = document.location.href;
			});
		});
		
		
		
		
		
		
		
	
	});
</script>

