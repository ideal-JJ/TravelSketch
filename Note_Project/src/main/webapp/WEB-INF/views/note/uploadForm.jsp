<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form name="fileForm" action="requestupload2" method="post" enctype="multipart/form-data">
        <input multiple="multiple" type="file" name="file" />
        <input type="text" name="src" />
        <input type="submit" value="전송" />
    </form>    
    
	<!-- <form action="noteUpload" method="post" enctype="multipart/form-data">
		텍스트<input type="text" name="theText"><br>
		텍스트<input type="file" name="theFile"><br>
		<input type="submit" value="전송">
	</form> -->

</body>
</html>