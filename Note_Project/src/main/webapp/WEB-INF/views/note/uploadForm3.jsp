<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
$(function() {
  $('button[type=submit]').click(function(e) {
    e.preventDefault();
    //Disable submit button
    $(this).prop('disabled',true);
    
    var form = document.forms[0];
    var formData = new FormData(form);
    	
    // Ajax call for file uploaling
    var ajaxReq = $.ajax({
      url : 'fileUpload',
      type : 'POST',
      data : formData,
      cache : false,
      contentType : false,
      processData : false,
      xhr: function(){
        //Get XmlHttpRequest object
         var xhr = $.ajaxSettings.xhr() ;
        
        //Set onprogress event handler 
         xhr.upload.onprogress = function(event){
          	var perc = Math.round((event.loaded / event.total) * 100);
          	$('#progressBar').text(perc + '%');
          	$('#progressBar').css('width',perc + '%');
         };
         return xhr ;
    	},
    	beforeSend: function( xhr ) {
    		//Reset alert message and progress bar
    		$('#alertMsg').text('');
    		$('#progressBar').text('');
    		$('#progressBar').css('width','0%');
              }
    });
  
    // Called on success of file upload
    ajaxReq.done(function(msg) {
      $('#alertMsg').text(msg);
      $('input[type=file]').val('');
      $('button[type=submit]').prop('disabled',false);
    });
    
    // Called on failure of file upload
    ajaxReq.fail(function(jqXHR) {
      $('#alertMsg').text(jqXHR.responseText+'('+jqXHR.status+
      		' - '+jqXHR.statusText+')');
      $('button[type=submit]').prop('disabled',false);
    });
  });
});
</script>
</head>


<c:choose>
    <c:when test="${uploadPage eq 'note'}">
    	<p>여행후기 제목을 입력해 주세요</p><br/>
        <form name="fileForm" action="noteTitleUpload">
	        <input type="text" name="noteTitle">
	        <input type="submit" value="다음" />
	    </form>    
    </c:when>
    <c:otherwise>
    	<div id="insert"></div>
    	<p>여행 상세 후기 정보를 입력해주세요</p>
    	<p>여행후기 제목 : ${noteTitle}</p>
    	
    	<form action="fileUpload" method="post" enctype="multipart/form-data">
    		<input type="hidden" name="noteTitle" value="${noteTitle}"/>
        	<input type="hidden" name="uuid" value="${uuid}"/>
        	위치 : <input type="text" id="title" name="title"/><br/>
			위치정보 : <input type="text" id="mapInfo" name="mapInfo"/><br/>
			내용 : <textarea id="content" name="content" ></textarea><br/>
			다녀온날짜 : <input type="text" id="travelDate" name="travelDate"/><br/>
		      <div class="form-group">
		        <label>Select File</label> 
		        <input class="form-control" type="file" name="files" multiple>
		      </div>
		      <div class="form-group">
		        <button class="btn btn-primary" type="submit">Upload</button>
		      </div>
	    </form>
	    <br />
	
	    <!-- Bootstrap Progress bar -->
	    <div class="progress">
	      <div id="progressBar" class="progress-bar progress-bar-success" role="progressbar"
	        aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">0%</div>
	    </div>
	
	    <!-- Alert -->
	    <div id="alertMsg" style="color: red;font-size: 18px;"></div>
	    
        
    </c:otherwise>
</c:choose>
