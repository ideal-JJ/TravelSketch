<%@page import="com.dto.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/main.css" rel='stylesheet' type='text/css' />

<script type="text/javascript">

   $(document).ready(function() {
       
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
<!-- <link href="css/main.css" rel="stylesheet"> -->
<!-- 
<div class="card border-primary mb-3" style="max-width: 20rem;">
  <div class="card-header">Header</div>
  <div class="card-body">
    <h4 class="card-title">Primary card title</h4>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>
 -->
 
<div class="content">
	<div class="wrap">
		
		<!-- 
		note.getNtIdx(), 
		note.getUuId(), 
		note.getUserName(),
		note.getuPhoto(),
		note.getNtTitle(),
		note.getNtDate(),
		note.getChIdx(),
		note.getChTitle(),
		note.getChTravelDate(),
		note.getPctImgs()
	 -->
		
		<div id="main" role="main"  style="max-width: 20rem;">
			<img src="images/ddd.jpg">
			<ul id="tiles" >
			
			<c:set var="isBuild" value="${0}" />
			<c:set var="increase" value="${0}" />
			<c:set var="beforeIdx" value="${0}" />
			<c:set var="lastNote" value="${noteList}" />
			<c:forEach var="note" items="${noteList}">
				<c:choose>
					<c:when test="${beforeIdx != note.getNtIdx()}">
							
						<c:set var="increase" value="${0}" />
						<c:choose>
							<c:when test="${isBuild == 1}">
								<c:set var="isBuild" value="${0}" />
													</div>
								        		</div>
								        		<hr>
								        		<div >
													<img class="noteUserPic" src="images/${lastNote.getuPhoto()}">
													 좋아요<span>${lastNote.getLkCnt()}</span> 댓글<span>${lastNote.getRpyCnt()}</span>
													<div >
														<span >traveler</span>
														<span >${lastNote.getUserName()}</span>	
													</div>
												</div>
								        	</div>
								        	</a>
								        </li>
							</c:when>		
						</c:choose>
						
						
						<c:set var="beforeIdx" value="${note.getNtIdx()}" />
							<li>
								<a href="chapterList/noteIdx/${note.getNtIdx()}">
					        	<img class="notePic" src="images/${fn:split(note.getPctImgs(),'/')[0]}" width="318">
					        	<div >
					        		<span>${note.getNtTitle()}</span>
					        		<fmt:formatDate value="${note.getChTravelDate()}" pattern="yyyy-MM-dd" var="myDate"/>
									<p>${myDate}에 다녀옴</p>
				        		</div>
					        	<div >
					        		<div >
					        			<div >
					        				<c:set var="lastNote" value="${note}" />
					        				<c:set var="isBuild" value="${1}" />
					        				<c:set var="increase" value="${increase + 1}" />
					        				<span>${increase}</span><span>${note.getChTitle()}</span><br/>
					</c:when>
					<c:otherwise>
											<c:set var="increase" value="${increase + 1}" />
					        				<span>${increase}</span><span>${note.getChTitle()}</span><br/>
				    </c:otherwise>
				</c:choose>
			</c:forEach>
										</div>
					        		</div>
					        		<hr>
					        		<div >
										<img class="noteUserPic" src="images/${lastNote.getuPhoto()}">
										좋아요<span>${lastNote.getLkCnt()}</span> 댓글<span>${lastNote.getRpyCnt()}</span>
										<div >
											<span >traveler</span>
											<span >${lastNote.getUserName()}</span>	
										</div>
									</div>
					        	</div>
					        	</a>
					        </li>
						</ul>
		</div>
		
	</div>
</div>