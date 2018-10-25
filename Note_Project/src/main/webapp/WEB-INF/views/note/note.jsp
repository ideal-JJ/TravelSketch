<%@page import="com.dto.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/main.css" rel='stylesheet' type='text/css' />

<script type="text/javascript">

   $(document).ready(function() {r
   	   $("#allCheck").on("click", function() {
   		     var result = this.checked;
   		     $(".check").each(function(idx,data){
   		    	 this.checked = result;
   		     });
   	   });
   	   
</script> 
 
<div class="content">
	<div class="wrap">
		<div id="imgWrap">
			<img src="url/seyahat.png">
		</div>
		<div id="main" role="main">
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
													<img class="noteUserPic" src="url/${lastNote.getuPhoto()}">
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
					        	<img class="notePic" src="url/${fn:split(note.getPctImgs(),'|')[0]}" width="318">
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
										<img class="noteUserPic" src="url/${lastNote.getuPhoto()}">
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