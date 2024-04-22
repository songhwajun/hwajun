<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h2> 게시판 </h2>
	<hr class ="hr1" noshade> 
	<br>
	<div>
		<c:forEach var="item" items="${boardList}">
	    	<div>
	    		<label>제목 :</label>
	    		<input class="form-control" id="new_title" name="title" value="${item.title}" disabled />
	    	</div>
	    	<br>	
	    	<div>
	    		<label>내용 :</label>
	    		<textarea class="form-control" id="new_content" rows="3" name="content" disabled>${item.content}</textarea>
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
    <span class="left;" id="type1">
    	<input type="button" id="back" value="뒤로가기" style="margin-top: 50px;">
    	<input type="button" id="modify" value="글 수정" style="margin-top: 50px;">
    	<input type="button" id="delete" value="글 삭제" style="margin-top: 50px;">
	</span>
	
	<span class="left;" id="type2" style="display:none;">
    	<input type="button" id="modify_finish" value="수정완료" style="margin-top: 50px;">
    	<input type="button" id="modify_cancle" value="취소" style="margin-top: 50px;">
	</span>
	
</div>

<script type="text/javascript" src="/resource/jquery/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="/resource/cmm/com.js"></script>

<script type="text/javascript">
	documentReady("#boardJsp" , function(dom){
		
		var beforeText = "";
		
		//글 목록(뒤로가기)
		$(dom).find("#back").on('click', function(){
			location.href = "/";
		});
	
		//글 수정
		$(dom).find("#modify").on('click', function(){
			$(dom).find("#type2").show();
			$(dom).find("#type1").hide();
			
			$(dom).find("#new_title").attr('disabled', false);
			$(dom).find("#new_content").attr('disabled', false);
		});
		
		//수정취소
		$(dom).find("#modify_cancle").on('click', function(){
			$(dom).find("#type1").show();
			$(dom).find("#type2").hide();
			
			console.log('test');
			$(dom).find("#new_title").attr('disabled', true);
			$(dom).find("#new_content").attr('disabled', true);
			
			
			var beforeTitle = $(dom).find("#title").val();
			var beforeContent = $(dom).find("#content").val();
			
			$(dom).find("#new_title").val(beforeTitle);
			$(dom).find("#new_content").val(beforeContent);
			
		})
		
		//글 수정완료
		$(dom).find("#modify_finish").on('click', function(){
			var test = "${boardList}" || "";
			
			var param = {};
			param.boardNum = $(dom).find("#boardNum").val();
			param.userNo = $(dom).find("#userNo").val();
			param.userName = $(dom).find("#userName").val();
			param.title = $(dom).find("#new_title").val();
			param.content = $(dom).find("#new_content").val();
			
			ajaxAction(param, "text", "/BoardController/modify.act", function(data){
				//alert(data);
				
				var url = "/boardDetail?num=" + param.boardNum;
			   window.location.href = url;
			    
			});
		})
		
		//글 삭제
		$(dom).find("#delete").on('click', function(){
			var delConfirm = confirm('정말 삭제하시겠습니까?');
			if (delConfirm) {
				
				var param = {};
				param.boardNum = $(dom).find("#boardNum").val();
				
				ajaxAction(param, "text", "/BoardController/delete.act", function(data){
					alert(data);
					document.location.href = "/";
				});
			}
			
		});
		
	});
</script>

