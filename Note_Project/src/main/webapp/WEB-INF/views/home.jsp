<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	home이야~
	${nt.getIdx()}<br>
	${nt.getUserId()}<br>
	${nt.getTitle()}<br>
	${nt.getDate()}<br>
	
	${nt.getChapter().getIdx()}<br>
	${nt.getChapter().getTitle()}<br>
	${nt.getChapter().getTravelDate()}<br>
	${nt.getPicture().getImg()}
</body>
</html>