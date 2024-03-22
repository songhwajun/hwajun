<%@ page pageEncoding="UTF-8"%>
<div id="joinJsp">
	<a href="/">뒤로가기</a>
	<br>
	<div>
		<!-- name : 서버로 전송 할 때 변수이름의 역할 -->
	    <label>이메일 : </label><input type="text" id="memberEmail"> <br>
	    <label>비밀번호 : </label><input type="password" id="memberPassword"> <br>
    </div>
    <button id="join">회원가입</button>
</div>

<script type="text/javascript" src="/resource/jquery/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="/resource/cmm/com.js"></script>

<script type="text/javascript">
	documentReady("#joinJsp" , function(dom){
		//1. 빈값
		//2. id중복
		
		//회원가입
		$(dom).find("#join").on('click', function(){
			var id = $(dom).find("#memberEmail").val();
			var pw = $(dom).find("#memberPassword").val();
			
			if(id == "" || pw == ""){
				var type = "비밀번호를"
				if(id == "") {
					type = "이메일을"	
				}
				alert("" + type + " 입력해주세요");
				return;
			}			
			
			var param = {
					"id" : id,
					"pw" : pw
			};
			ajaxAction(param, "/test", function(data){
				console.log(data);
			});
		});
	
	});
</script>

