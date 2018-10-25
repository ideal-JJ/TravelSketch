<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
	#map {
		width:500px;
		height: 30%;
	}
	/* Optional: Makes the sample page fill the window. */
	html, body {
		height: 100%;
		margin: 0;
		padding: 0;
	}
	
	#description {
		font-family: Roboto;
		font-size: 15px;
		font-weight: 300;
	}
	
	#infowindow-content .title {
		font-weight: bold;
	}
	
	#infowindow-content {
		display: none;
	}
	
	#map #infowindow-content {
		display: inline;
	}
	
	.pac-card {
		margin: 10px 10px 0 0;
		border-radius: 2px 0 0 2px;
		box-sizing: border-box;
		-moz-box-sizing: border-box;
		outline: none;
		box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
		background-color: #fff;
		font-family: Roboto;
	}
	
	#pac-container {
		padding-bottom: 12px;
		margin-right: 12px;
	}
	
	.pac-controls {
		display: inline-block;
		padding: 5px 11px;
	}
	
	.pac-controls label {
		font-family: Roboto;
		font-size: 13px;
		font-weight: 300;
	}
	
	#pac-input {
		background-color: #fff;
		font-family: Roboto;
		font-size: 15px;
		font-weight: 300;
		margin-left: 12px;
		padding: 0 11px 0 13px;
		text-overflow: ellipsis;
		width: 400px;
	}
	
	#pac-input:focus {
		border-color: #4d90fe;
	}
	
	#title {
		color: #fff;
		background-color: #4d90fe;
		font-size: 25px;
		font-weight: 500;
		padding: 6px 12px;
	}
	
	ul{list-style:none;margin:0px;padding:0px; overflow: hidden; margin-bottom:20px;}
	.imgLi {
		float:left;
		margin-right:5px;
	}
	
	.pm10 {
		margin-top:10px;
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	
	

	$(document).ready(function() {
		
		$('#cancleChapter').on('click', function() {
			//console.log('cnt >>>>> ', cnt);
			location.href="noteUpload";
		});
		
		$('#saveNote').on('click', function() {
			$('form').attr('action', 'saveNote');
			$('form').submit();
		});
		
   	});
</script> 

<body>
	<c:choose>
	    <c:when test="${uploadPage eq 'note'}">
	    	<p class="pm10">여행후기 제목을 입력해 주세요</p>
	        <form name="fileForm" action="nextChapter">
		        <input type="text" name="noteTitle">
		        <input type="submit" value="다음" />
		    </form>    
	    </c:when>
	    <c:otherwise>
	    	<p class="pm10">여행 상세 후기 정보를 입력해주세요</p>
	    	<div id="addChapterArea"></div>
	    	
	    	<!-- 구글맵 -->
	    	<div class="pac-card" id="pac-card">
				<div>
					<div id="title">Autocomplete search</div>
					<div id="type-selector" class="pac-controls">
						<input type="radio" name="type" id="changetype-all" checked="checked"> 
						<label for="changetype-all">All</label>
						<input type="radio" name="type" id="changetype-establishment">
						<label for="changetype-establishment">Establishments</label> 
						<input type="radio" name="type" id="changetype-address"> 
						<label for="changetype-address">Addresses</label> 
						<input type="radio" name="type" id="changetype-geocode"> 
						<label for="changetype-geocode">Geocodes</label>
					</div>
					<div id="strict-bounds-selector" class="pac-controls">
						<input type="checkbox" id="use-strict-bounds" value=""> 
						<label for="use-strict-bounds">Strict Bounds</label>
					</div>
				</div>
				<div id="pac-container">
					<input id="pac-input" type="text" placeholder="Enter a location">
				</div>
			</div>
			<div id="map"></div>
			<div id="infowindow-content">
				<img src="" width="16" height="16" id="place-icon"> 
				<span id="place-name" class="title"></span><br> 
				<span id="place-address"></span>
			</div>
			<!-- 구글맵 end-->
			 
			<p class="pm10">여행후기 제목 : ${noteTitle}</p>
			<form id="fileForm" action="addChapter" method="post" enctype="multipart/form-data">
				<input type="hidden" id="${noteTitle}" name="noteTitle"/>
				<input type="hidden" id="increase" name="increase"/>
				위치명 : <input type="text" id="chtitle" name="chtitle" readonly="readonly"/><br/>
				주소 : <input type="text" id="mapInfo" name="mapInfo" readonly="readonly"/><br/>
				내용 : <textarea id="content" name="content" ></textarea><br/>
				파일선택 <br/>
				<input type="file" id="fileUp" name="fileUp" /><br /> 
				<input type="file" id="fileUp2" name="fileUp2" /><br /> 
				<input type="file" id="fileUp3" name="fileUp3" /><br /> 
				<input type="file" id="fileUp4" name="fileUp4" /><br /> 
				<input type="file" id="fileUp5" name="fileUp5" /><br /> 
				다녀온날짜 : <input type="text" id="travelDate" name="travelDate"/><br/>
				<input type="button" value="상세후기추가" onClick="fileSubmit();">
				<input type="button" id="cancleChapter" value="후기취소">
				<input type="button" id="saveNote" value="후기저장">
			</form>
		     
	    </c:otherwise>
	</c:choose>
	
	<!-- 구글맵 script -->
	<script>
		function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : -33.8688,
					lng : 151.2195
				},
				zoom : 13
			});
			var card = document.getElementById('pac-card');
			var input = document.getElementById('pac-input');
			var types = document.getElementById('type-selector');
			var strictBounds = document.getElementById('strict-bounds-selector');

			map.controls[google.maps.ControlPosition.TOP_RIGHT].push(card);

			var autocomplete = new google.maps.places.Autocomplete(input);

			autocomplete.bindTo('bounds', map);

			autocomplete.setFields([ 'address_components', 'geometry', 'icon', 'name' ]);

			var infowindow = new google.maps.InfoWindow();
			var infowindowContent = document.getElementById('infowindow-content');
			infowindow.setContent(infowindowContent);
			var marker = new google.maps.Marker({
				map : map,
				anchorPoint : new google.maps.Point(0, -29)
			});

			autocomplete
					.addListener(
							'place_changed',
							function() {
								infowindow.close();
								marker.setVisible(false);
								var place = autocomplete.getPlace();
								if (!place.geometry) {
									window.alert("No details available for input: '" + place.name + "'");
									return;
								}

								// If the place has a geometry, then present it on a map.
								if (place.geometry.viewport) {
									map.fitBounds(place.geometry.viewport);
								} else {
									map.setCenter(place.geometry.location);
									map.setZoom(17); // Why 17? Because it looks good.
								}
								marker.setPosition(place.geometry.location);
								marker.setVisible(true);

								var address = '';
								if (place.address_components) {
									address = [
											(place.address_components[0] && place.address_components[0].short_name || ''),
											(place.address_components[1] && place.address_components[1].short_name || ''),
											(place.address_components[2] && place.address_components[2].short_name || '') ]
											.join(' ');
								}								
								

								infowindowContent.children['place-icon'].src = place.icon;
								infowindowContent.children['place-name'].textContent = place.name;
								infowindowContent.children['place-address'].textContent = address;
								infowindow.open(map, marker);
								
								//console.log('place : ', place);
								
								place.address_components.reverse();
								
								var reverseName = '';
								for (var addr of place.address_components) {
								    //console.log('> ' , addr.long_name);
								    reverseName += addr.long_name + ' ';
								}
								
								document.getElementById('chtitle').value = place.name;
								document.getElementById('mapInfo').value = reverseName;
							});

			function setupClickListener(id, types) {
				var radioButton = document.getElementById(id);
				radioButton.addEventListener('click', function() {
					autocomplete.setTypes(types);
				});
			}

			setupClickListener('changetype-all', []);
			setupClickListener('changetype-address', [ 'address' ]);
			setupClickListener('changetype-establishment', [ 'establishment' ]);
			setupClickListener('changetype-geocode', [ 'geocode' ]);

			document.getElementById('use-strict-bounds').addEventListener('click', function() {
						console.log('Checkbox clicked! New state=' + this.checked);
						autocomplete.setOptions({
							strictBounds : this.checked
						});
					});
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDNsY19MlfwjeDdK9EQXqPhcF4G0ihjK9M&libraries=places&callback=initMap"
		async defer>
	</script>
	<!-- 구글맵 script end -->

	<script>
		var cnt = 0;
		
		function fileSubmit() {
			cnt++;
			//console.log('cnt : ' , cnt);
			
			document.getElementById('increase').value = cnt;
			
			var formData = new FormData($("#fileForm")[0]);
			
			$.ajax({
				type : 'post',
				url : 'addChapter',
				data : formData,
				processData : false,
				contentType : false,
				success : function(data,status,xhr) {
					
					var tempPic = '';
					var picList = data.chImgs.split('|');
					
					for(var pic of picList) {
						tempPic += "<li class='imgLi'><img src = upload/" + pic + " height='100'></li>"; 
					}
					
					var temp = "<div>" 
							+ "<p>" + data.chTitle + ' - ' + data.chContent + "</p>"
							+ "<ul>"
							+ tempPic
							+ "</ul>"
							+ "</div>";
					
					$('#addChapterArea').append( temp );
				},
				error : function(error) {
					alert("파일 업로드에 실패하였습니다.");
					console.log(error);
					console.log(error.status);
				}
			});
		}
	</script>
</body>

