<%@page import="com.dto.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/main.css" rel='stylesheet' type='text/css' />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
	#admin {
	    margin-top : 50px;
	    margin-left : 50px;
	}
	#chart {
		margin-top : 100px;
	    margin-left : 100px;
	}
	svg {
	    border: 1px solid;
	}
	g {
		margin : 10px;
		padding : 10px;
	}
	.bar {
	    _fill: skyblue;
	}
	.bar:hover {
	    fill: blue;
	}
	/* .text {
	    fill: white;
	    font-weight:bold;
	} */
	.grid line {
	  stroke: lightgrey;
	  stroke-opacity: 0.7;
	  shape-rendering: crispEdges;
	}
	.toolTip {
	    position: absolute;
	    border: 0 none;
	    border-radius: 4px 4px 4px 4px;
	    background-color: white;
	    padding: 5px;
	    text-align: center;
	    font-size: 11px;
	}
</style>

<div id="admin">
	<img src="url/admin_512dp.png">
</div>
<div id="chart" style="display:none;">
	<h1>국내 여행지 통계</h1>
	<svg width="800" height="400" ></svg>
</div>
<script src="https://d3js.org/d3.v4.min.js"></script>
<script>
	var dataset = [];
	
	function clickChart() {
		console.log('click chart');
		
		$.ajax({
			type : 'post',
			url : 'chart',
			processData : false,
			contentType : false,
			success : function(data,status,xhr) {
				dataset = data;
				
				$('#admin').css('display', 'none');
				$('#chart').css('display', 'block');
				
				viewChart();
			},
			error : function(error) {
				console.log(error);
				console.log(error.status);
			}
		});
	}
	
	function viewChart() {
		/* var dataset2 = [{x:'A', y:9 }, {x:'B', y:19}, {x:'C', y:29}, {x:'D', y:49}, 
		               {x:'E', y:29}, {x:'F', y:19}, {x:'G', y:9 }]; */
		
		var svg = d3.select("svg");
		var width  = parseInt(svg.style("width"), 10) - 30;
		var height = parseInt(svg.style("height"), 10) - 20;
		var svgG = svg.append("g")
		    .attr("transform", "translate(30, 0)");
		          
		var xScale = d3.scaleBand()
		    .domain(dataset.map(function(d) { return d.x;} ))
		    .range([0, width]).padding(0.2);
		var yScale = d3.scaleLinear()
		    .domain([0, d3.max(dataset, function(d){ return d.y; })])
		    .range([height, 10]);
		var scale = d3.scaleOrdinal()
		    .range(["red", "red", "red", "red", "red", "red", "red", "red", "red", "red"]);
		    
		svgG.append("g")            
		    .attr("class", "grid")
		    .attr("transform", "translate(0," + height + ")")
		    .call(d3.axisBottom(xScale)
		        .tickSize(-height)
		    );
		    
		svgG.append("g")
		    .attr("class", "grid")
		    .call(d3.axisLeft(yScale)
		        .ticks(5)
		        .tickSize(-width)
		    );
		    
		var barG = svgG.append("g");
		    
		barG.selectAll("rect")
		    .data(dataset)
		    .enter().append("rect")
		        .attr("class", "bar")
		        .attr("height", function(d, i) {return height - yScale(d.y)})
		        .attr("width", xScale.bandwidth())
		        .attr("x", function(d, i) {return xScale(d.x)})
		        .attr("y", function(d, i) {return yScale(d.y)})
				.attr("fill",   function(d) { return scale(d.x); })
		        .on("mouseover", function() { tooltip.style("display", null); })
		        .on("mouseout",  function() { tooltip.style("display", "none"); })
		        .on("mousemove", function(d) {
		            tooltip.style("left", (d3.event.pageX+10)+"px");
		            tooltip.style("top",  (d3.event.pageY-10)+"px");
		            tooltip.html(d.y);
		        });        
		    
		barG.selectAll("text")
		    .data(dataset)
		    .enter().append("text")
		    .text(function(d) {return d.y})
		        .attr("class", "text")
		        .attr("x", function(d, i) {return xScale(d.x)+xScale.bandwidth()/2})
		        .style("text-anchor", "middle")
		        .attr("y", function(d, i) {
		        	if (d.y == 0) {
		        		return yScale(d.y) - 10;
		        	}
		        	return yScale(d.y) + 30;
		        })
		        .attr("fill", function(d, i) {
		        	if (d.y == 0) {
		        		return "black";
		        	}
		        	return "white";
		        });
		
		var tooltip = d3.select("body").append("div").attr("class", "toolTip").style("display", "none");
	}
</script>