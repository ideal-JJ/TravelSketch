<%@page import="com.dto.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">

   $(document).ready(function() {
	   
	   $("#likebtn").on("click", function() {
		   var num = $(this).attr("data-likebtn");
		   var uid = $('#likePic').attr('data-uid');
		   
		   $.ajax({
				url:'chapterAddLike',
				type:"get",
				dataType:'text',
				data:{
					noteIdx:num
				},
				success:function(data,status,xhr){
					var cnt = parseInt($('.likeCnt').text());
					var rst = 0;
					if (data == 'hasCount') {
						// 좋아요 카운트가 있어서 데이터를 삭제한다
						var picid = $("#picid" + uid);
						picid.remove();
						
						rst = cnt - 1;
						
						$('.likeCnt').text(cnt - 1);
						$('.likeCnt2').text(cnt - 1);
					} else {
						// 카운트가 없기에 insert 한다
						$('#likePic').prepend("<li id='picid" + uid + "' class='likefloat'><img src='url/" + data + "' style='width:32px; height:32px'></li>");
						
						rst = cnt + 1;
						$('.likeCnt').text(cnt + 1);
						$('.likeCnt2').text(cnt + 1);
					}
			   },
			   error:function(xhr,status,error){
				   console.log(error);
			   }
		   });
	   });
       
   	});
</script> 


<div class="content">
	<div class="wrap">
		
		<div id="main" role="main" class="card border-primary mb-3 mt20" style="max-width: 80rem;">
			<c:forEach var="chapter" items="${chapterList}">
				<ul class="chapterUl">
					<li>
						<div class="card border-primary mb-3" style="max-width: 80rem;" value="${chapter.chIdx}">
							<p class="chapterHeader">${chapter.chTitle}</p>
						</div>
						<div class="ml10">
							<p>${chapter.chContent}</p> 
							<c:set var="chPic" value="${fn:split(chapter.getChImgs(),'|')}" />
							
							<c:choose>
							    <c:when test="${fn:length(chPic) == 1}">
							        <img src="url/${fn:split(chapter.getChImgs(),'|')[0]}" width="540" height="540">
							    </c:when>
							    <c:when test="${fn:length(chPic) == 2}">
							    	<ul class="ul_pic">
							    		<li><img src="url/${fn:split(chapter.getChImgs(),'|')[0]}" width="540" height="270"></li>
							    		<li><img src="url/${fn:split(chapter.getChImgs(),'|')[1]}" width="540" height="270"></li>
							    	</ul>
							    </c:when>
							    <c:when test="${fn:length(chPic) == 3}">
							    	<img src="url/${fn:split(chapter.getChImgs(),'|')[0]}" width="540" height="360">
							        <ul class="ul_pic">
							    		<li><img src="url/${fn:split(chapter.getChImgs(),'|')[1]}" width="270" height="180"></li>
							    		<li><img src="url/${fn:split(chapter.getChImgs(),'|')[2]}" width="270" height="180"></li>
							    	</ul>
							    </c:when>
							    <c:otherwise>
							    	<img src="url/${fn:split(chapter.getChImgs(),'|')[0]}" width="540" height="360">
							        <ul class="ul_pic">
							    		<li><img src="url/${fn:split(chapter.getChImgs(),'|')[1]}" width="180" height="180"></li>
							    		<li><img src="url/${fn:split(chapter.getChImgs(),'|')[2]}" width="180" height="180"></li>
							    		<li><img src="url/${fn:split(chapter.getChImgs(),'|')[3]}" width="180" height="180"></li>
							    	</ul>
								</c:otherwise>
							</c:choose>
							
							<fmt:formatDate value="${chapter.chTravelDate}" pattern="yyyy-MM-dd" var="myDate"/>
							<p class="pp">${myDate}</p>
						</div>
					</li>
				</ul>
			</c:forEach>
			<div id="btnWarp">
				<p><a id="likebtn" data-likebtn="${noteIdx}">좋아요 : <span class="likeCnt">${likeList.size()}</span></a></p>
				<p><a>댓글 : ${replyList.size()}</a></p>
			</div>
			<div>
				<p>이 여행기를 좋아하는 사람들 (<span class="likeCnt2">${likeList.size()}</span>)</p>
				<ul id="likePic" data-uid="${uuid}">
					<c:forEach var="like" items="${likeList}" varStatus="g">
						<li id="picid${like.getUuid()}" class="likefloat">
							<img src="url/${like.getuPhoto()}" style="width:32px; height:32px">
					    </li>
					</c:forEach>
				</ul>
			</div>			
		</div>
		
	</div>
</div>