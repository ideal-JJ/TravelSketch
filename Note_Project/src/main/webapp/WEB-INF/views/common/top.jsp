<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" href="https://bootswatch.com/4/minty/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/modal.css">
<script type="text/javascript" src="js/modal.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		var myModal = new Example.Modal({
			id : "modal_login" // 모달창 아이디 지정
		});

		$("#login").on("click", function() {
			//$("form").attr("action","loginCheck/goodsCart");
			myModal.show();
		});

		// 모달 창 안에 있는 확인
		$("#confirm_button").click(function() {
			myModal.hide(); // 모달창 감추기
		});
		
		$("#MyPage").on("click", function() {
			$("form").attr("action","loginCheck/myPage");
		});
		
		$("#logout").on("click", function() {
			$("form").attr("action","loginCheck/logout");
		});

	});
</script>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#">여행스케치</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor01" aria-controls="navbarColor01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Home<span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#">Features</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>
		</ul>
		<c:if test="${empty login}">
			<button id="login" class="btn btn-danger">로그인</button>&nbsp;
			<button id="join" class="btn btn-secondary">회원가입</button>
		</c:if>
		<c:if test="${!empty login}">
			${login.name}님!&nbsp;
			<button id="MyPage" class="btn btn-info">MyPage</button>&nbsp;
			<button id="logout" class="btn btn-danger">로그아웃</button>
		</c:if>
	</div>
</nav>

<!-- 로그인 모달창 -->
<div class="modal" id="modal_login">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">로그인</h5>
			</div>
			<form:form action="login" modelAttribute="loginx">
				<div class="modal-body">
					<div class="form-group">
					    <label for="userid">아이디</label>
					    <input type="text" class="form-control" name="userid" id="userid" aria-describedby="emailHelp" placeholder="아이디를 입력하세요">
					    <form:errors path="userid"/><br>
				    </div>
				    <div class="form-group">
						<label for="passwd">비밀번호</label>
						<input type="password" class="form-control" name="passwd" id="passwd" placeholder="비밀번호를 입력하세요">
						<form:errors path="passwd"/><br>
				    </div>
					<%-- 아이디<input type="text" name="userid" id="userid">
					<form:errors path="userid"/><br>
					비밀번호<input type="text" name="passwd" id="passwd">
					<form:errors path="passwd"/><br>
					<input type="submit" value="로그인">
					<input type='button' id="idSearch" value="아아디 찾기"> --%>
				</div>
				<div class="modal-footer">
					<input type="submit" id="confirm_button" class="btn btn-primary" value="로그인"/>
					<button type="button" id="js_close" class="btn btn-secondary" data-dismiss="modal">닫기</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
<!-- <div id="modal_login">
    <h3>Test Modal</h3>
    <p>이 창은 모달창입니다.</p>
    <button id="confirm_button">확인</button>
    <button id="js_close">닫기</button>
</div> -->