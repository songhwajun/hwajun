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
<div id="index">
    <h2> 게시판 </h2>
	<hr class ="hr1" noshade> 
	<!-- 
	<form>
		<span> ▷ 총 3개의 게시물이 있습니다. </span>
		<span class="right"> 
            <span class="grey" id="strong">SELECT</span>
		    <select>
			    <option value="제목"  name="제목" >제목</option>
			    <option value="글쓴이" name="글쓴이">글쓴이</option>
		    </select>
		<input type="text"> <input type="button" name="검색" class="gradient" value="검색" >
		</span>
	</form>
	 -->
	<br>
	<table id="boardTable">
	    <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>글쓴이</th>
	        <th>일시</th>
	    </tr>
	    <c:forEach var="item" items="${boardList}">
		    <tr class="boardDetail">
		        <td class="center" id="boardNum">${item.boardNum}</td>
		        <td class="left" id="title">
			        <span>${item.title}</span>
			        <input type="hidden" id="content" value="${item.content}"/>
		        </td>
		        <td class="center" id="userName">${item.userName}</td>
		        <td class="center" id="registDate">${item.registDate}</td>
		    </tr>
	    </c:forEach>
	</table>
	<br>
	<!-- 
	<div class="center" >
	    <a href  = "https://www.naver.com/">◀ 이전</a> 
	    <a href  = "https://www.naver.com/">1</a>  
	    <a href  = "https://www.naver.com/">다음 ▶</a>
	</div>
	 -->
	<span class="right";>
		<button id="join">회원가입</button>
		<button id="login">로그인</button>
		<input type="button" value="글쓰기"  class="gradient";>
	</span>
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
	
		//게시글 상세페이지
		$(document).on("click", "#boardTable tr", function () {
			var tr = $(this);
			var boardNum = tr.find("td:eq(0)").text();
			
			var url = "/boardDetail?num=" + boardNum;
		    window.location.href = url;
		});
	
	});
</script>
