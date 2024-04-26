<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>

    <style>
h2 { font-weight: border; }
.hr1 { border: 0;
height: 2px;
background:  #d3d3d3;}
    .grey { 
     color: #727272;}
     #strong { font-weight: 900;}

            table {
            width: 100%;
            border-top: 1px solid #d3d3d3;
            border-collapse: collapse;
            }
            th { background-color: #d3d3d3 ; 
            border-top: 3px solid #727272;
            }
            th, td {
            border-bottom: 1px solid #d3d3d3;
            padding: 10px;
            }

  .greylist {
  width: 50px;
  height: 30px;
  font-weight: 900;
  color: white;
  text-align: center;
  background: grey;
  border: solid 2px white;
  border-radius: 5px;
  }
  .gradient {
  width: 80px;
  height: 30px;
  font-weight: 900;
  color: white;
  text-align: center;
  background: linear-gradient( to bottom, grey, black );
  border: solid 2px white;
  border-radius: 5px;
  }	

            .left {text-align: left;}
            .right {  float: right;}
            .center { text-align: center;}

a {color:black;
text-decoration-line : none;}
    </style>
</head>
<div id="writeJsp">
	<h2> 게시판 글 작성 </h2>
	<hr class ="hr1" noshade> 
	<br>
	
	<div class="panel-body">
			<!-- 
			<div class="form-group">
				<label>작성자</label> 
                	<input class="form-control" name="writer" value="${name}" readonly>
			</div>
			 -->
			<div class="form-group">
				<label>제목</label> 
                <input class="form-control" id="title" name="title">
			</div>
			<br>
			<div class="form-group">
				<label>내용</label>
					<textarea class="form-control" id="content" rows="3" name="content"></textarea>
			</div>	
			<input type="button" id="back" class="btn btn-default" value="뒤로가기" style="margin-top: 50px;">
			<input type="button" id="submit" class="btn btn-default" value="등록" style=	"margin-top: 50px;">
	</div>	
</div>

<script type="text/javascript" src="/resource/jquery/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="/resource/cmm/com.js"></script>

<script type="text/javascript">
	documentReady("#writeJsp" , function(dom){
		
		//글 목록(뒤로가기)
		$(dom).find("#back").on('click', function(){
			location.href = "/";
		});
		
		
		//글 작성
		$(dom).find("#submit").on('click', function(){
			console.log("테스트진행중")
			var param = {};
			
			param.userNo = "1";
			param.title = $(dom).find("#title").val(); 
			param.content = $(dom).find("#content").val();
			param.userName = "송화준";
			
			ajaxAction(param, "text", "/BoardController/write.act", function(data){
				alert(data);
				document.location.href = "/";
			});
			
		});
	});
</script>

