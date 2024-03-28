<%@ page pageEncoding="UTF-8"%>

<div id="index">
	<button id="join">회원가입</button>
	<button id="login">로그인</button>
    
    <div>
	 	<div>
	 		<div>
	 			<h2> 게 시 판 </h2>
	 		</div>
 			<table>
 				<thead>
 					<tr>
 						<td>글번호</td>
 						<td>제목</td>
 						<td>작성자</td>
 						<td>등록일자</td>
 					</tr>
 				</thead>
 				<tbody>
 					<tr>
 						<td>1</td>
 						<td>타이틀1번</td>
 						<td>송화준</td>
 						<td>2024-03-28</td>
 					</tr>
 					<tr>
 						<td>2</td>
 						<td>타이틀2번</td>
 						<td>송화준</td>
 						<td>2024-03-28</td>
 					</tr>
 				</tbody>
 			</table>				
	 	</div>
	</div>
    
</div>
<script type="text/javascript" src="/resource/jquery/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="/resource/cmm/com.js"></script>
<script type="text/javascript">
	documentReady("#index" , function(dom){
		$(dom).find("#join").on('click', function(){
			console.log("회원가입");
			location.href = "/join";
		});
		
		$(dom).find("#login").on('click', function(){
			console.log("로그인");
			location.href = "/login";
		});
	
		$(dom).find("#login").on('click', function(){
			console.log("로그인");
			location.href = "/login";
		});
		
	});
</script>
