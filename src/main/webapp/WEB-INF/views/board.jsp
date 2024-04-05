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
<div id="boardJsp">
	<div>
		<c:forEach var="item" items="${boardList}">
	    	<div>
	    		<label>제목 :</label>
	    		<span>${item.title}</span>
	    	</div>
	    	<div>
	    		<label>내용 :</label>
	    		<span>${item.content}</span>
	    	</div>
	    	<div style="display:none;">
	    		<input type="hidden" id="boardNum" value="${item.boardNum}"/>
	    		<input type="hidden" id="userNo" value="${item.userNo}"/>
	    		<input type="hidden" id="userName" value="${item.userName}"/>
	    		<input type="hidden" id="title" value="${item.title}"/>
	    		<input type="hidden" id="content" value="${item.content}"/>
	    	</div>
		</c:forEach>
    </div>
    <span class="left;">
    	<input type="button" id="modify" value="글수정" style="margin-top: 50px;">
		<input type="button" id="back" value="글목록" style="margin-top: 50px;">
	</span>
</div>

<script type="text/javascript" src="/resource/jquery/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="/resource/cmm/com.js"></script>

<script type="text/javascript">
	documentReady("#boardJsp" , function(dom){
		
		//글 목록(뒤로가기)
		$(dom).find("#back").on('click', function(){
			location.href = "/";
		});
	
		//글 수정
		$(dom).find("#modify").on('click', function(){
			var test = "${boardList}" || "";
			
			var param = {};
			param.boardNum = $(dom).find("#boardNum").val();
			param.userNo = $(dom).find("#userNo").val();
			param.userName = $(dom).find("#userName").val();
			param.title = $(dom).find("#title").val();
			param.content = $(dom).find("#content").val();
			
			console.log(param);
		});
	});
</script>

