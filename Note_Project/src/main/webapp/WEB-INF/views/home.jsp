<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인페이지입니당</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="common/top.jsp" flush="true"/>	
</body>
</html>




<%--
${nt.getIdx()}<br>
${nt.getUserId()}<br>
${nt.getTitle()}<br>
${nt.getDate()}<br>

${nt.getChapter().getIdx()}<br>
${nt.getChapter().getTitle()}<br>
${nt.getChapter().getTravelDate()}<br>
${nt.getPicture().getImg()} 
--%>