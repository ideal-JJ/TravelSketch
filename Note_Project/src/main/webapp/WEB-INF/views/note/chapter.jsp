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
						$('#likePic').prepend("<li id='picid" + uid + "'><img src='images/" + data + "'></li>");
						
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
       
   	   $("#allCheck").on("click", function() {
   		     var result = this.checked;
   		     $(".check").each(function(idx,data){
   		    	 this.checked = result;
   		     });
   	   });
   	   
   	   //삭제 버튼 이벤트
   	   $(".delBtn").on("click",function(){
   		   var num = $(this).attr("data-delBtn");
   		   //console.log(num);
   		   //location.href="goodsCartDel?num="+num;
   		   
   		   var xxx = $(this);	// delBtn 임
	   		$.ajax({
	   		   url:'loginCheck/goodsCartDel',
	   		   type:"get",
	   		   dataType:'text',
	   		   data:{
	   			  num:num
	   		   },
	   		   success:function(data,status,xhr){
	   				if (data == 'success') {
	   					console.log(">>> " + xxx.parents());
	   					xxx.parents().filter("tr").remove();	// 공부하자 ㅠㅠ
	   				}
	   		   },
	   		   error:function(xhr,status,error){
	   			   console.log(error);
	   		   }
	   	   });
   	   });
   	 //수정 버튼 이벤트
   	   $(".updateBtn").on("click",function(){
   		 var num = $(this).attr("data-num");
   		 var gAmount = $("#cart_gAmount"+num).val();
   		 var gPrice =  $(this).attr("data-price");
   		 console.log(num,gPrice);
   		 $.ajax({
  		   url:'loginCheck/goodsCartUpdate',
  		   type:"get",
  		   dataType:'text',
  		   data:{
  			  num:num,
  			  gAmount:gAmount
  		   },
  		   success:function(data,status,xhr){
  			 if(data=='success'){
  				 var total =
    				   Number.parseInt(gAmount) * Number.parseInt(gPrice);
    			   $("#sum"+num).text(total);
    			   
    			   // 장바구니 총 합을 구한다
    			 var totalSum = 0;
    			 $(".sum").each(function(idx,ele) {
    				 totalSum += Number.parseInt($(ele).text());
    			 })
  			 }
  		   },
  		   error:function(xhr,status,error){
  			   console.log(error);
  		   }
  	   });
   		 
   		 
   		 
   	   });
   	 
   	 //전체 삭제
   	 //삭제 버튼 이벤트
   	   $("#delAllCart").on("click",function(event){
   
   		  $("form").attr("action","loginCheck/goodsCartAllDel");
   	      $("form").submit(); // trigger
   		 
   	   });
   	 //주문 버튼 이벤트
   	   $(".orderBtn").on("click",function(){
   		   var num = $(this).attr("data-orderBtn");
   		   //console.log(num);
   		   location.href="loginCheck/goodsOrderConfirm?num="+num;
   	   });
   	 
   	//전체주문 버튼 이벤트
   	   $("#orderAll").on("click",function(event){
   
   		  $("form").attr("action","loginCheck/goodsOrderAllConfirm");
   	      $("form").submit(); // trigger
   		 
   	   });
   	});
</script> 


<!-- 
private int chIdx;
private int chIncrease;
private String chTitle;
private String chContent;
private String chMapInfo;
private Date chTravelDate;
private String chImgs; 
-->
 
<div class="content">
	<div class="wrap">
		
		<div id="main" role="main" class="card border-primary mb-3" style="max-width: 80rem;">
			<c:forEach var="chapter" items="${chapterList}">
				<ul>
					<li>
						<div class="card border-primary mb-3" style="max-width: 80rem;" value="${chapter.chIdx}"><p>${chapter.chTitle}</p></div>
						<p>${chapter.chContent}</p>
						
						<c:set var="chPic" value="${fn:split(chapter.getChImgs(),'/')}" />
						<%-- 갯수 : ${fn:length(chPic)} --%>
						<c:choose>
						    <c:when test="${fn:length(chPic) == 1}">
						        <img src="images/${fn:split(chapter.getChImgs(),'/')[0]}" width="540" height="540">
						    </c:when>
						    <c:when test="${fn:length(chPic) == 2}">
						    	<ul class="ul_pic">
						    		<li><img src="images/${fn:split(chapter.getChImgs(),'/')[0]}" width="540" height="270"></li>
						    		<li><img src="images/${fn:split(chapter.getChImgs(),'/')[1]}" width="540" height="270"></li>
						    	</ul>
						    </c:when>
						    <c:when test="${fn:length(chPic) == 3}">
						    	<img src="images/${fn:split(chapter.getChImgs(),'/')[0]}" width="540" height="360">
						        <ul class="ul_pic">
						    		<li><img src="images/${fn:split(chapter.getChImgs(),'/')[1]}" width="270" height="180"></li>
						    		<li><img src="images/${fn:split(chapter.getChImgs(),'/')[2]}" width="270" height="180"></li>
						    	</ul>
						    </c:when>
						    <c:otherwise>
						    	<img src="images/${fn:split(chapter.getChImgs(),'/')[0]}" width="540" height="360">
						        <ul class="ul_pic">
						    		<li><img src="images/${fn:split(chapter.getChImgs(),'/')[1]}" width="180" height="180"></li>
						    		<li><img src="images/${fn:split(chapter.getChImgs(),'/')[2]}" width="180" height="180"></li>
						    		<li><img src="images/${fn:split(chapter.getChImgs(),'/')[3]}" width="180" height="180"></li>
						    	</ul>
							</c:otherwise>
						</c:choose>
						
						<%-- <c:forEach var="pic" items="${chPic}" varStatus="g">
							
							${g.last}-${pic}   , 
						</c:forEach>  --%>
						
						<fmt:formatDate value="${chapter.chTravelDate}" pattern="yyyy-MM-dd" var="myDate"/>
						<p>${myDate}</p>
					</li>
				</ul>
			</c:forEach>
			<div>
				<p><button id="likebtn" data-likebtn="${noteIdx}">좋아요 : <span class="likeCnt">${likeList.size()}</span></button></p>
				<p><button>댓글 : ${replyList.size()}</button></p>
			</div>
			<div>
				<p>이 여행기를 좋아하는 사람들 (<span class="likeCnt2">${likeList.size()}</span>)</p>
				<ul id="likePic" data-uid="${uuid}">
					<c:forEach var="like" items="${likeList}" varStatus="g">
						<li id="picid${like.getUuid()}">
							<img src="images/${like.getuPhoto()}">
					    </li>
					</c:forEach>
				</ul>
			</div>			
		</div>
		
	</div>
</div>