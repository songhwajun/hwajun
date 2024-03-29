<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div id="boardJsp">
<a href="/">뒤로가기</a>
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
		</c:forEach>
    </div>
</div>

<script type="text/javascript" src="/resource/jquery/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="/resource/cmm/com.js"></script>

<script type="text/javascript">
	documentReady("#boardJsp" , function(dom){
		
	
	});
</script>

