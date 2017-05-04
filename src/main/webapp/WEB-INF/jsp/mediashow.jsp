<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>爬虫统计数据</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dist/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dist/bootstrap-table.css">

<script src="<%=request.getContextPath()%>/dist/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/dist/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/dist/bootstrap-table.js"></script>
<!-- put your locale files after bootstrap-table.js -->
<script
	src="<%=request.getContextPath()%>/dist/locale/bootstrap-table-zh-CN.js"></script>

	<style type="text/css">
		.panel{
			display:none;
			height:900;
		}
		.panel-body{
			height:850;
		}
		table{
			font-size:14px;
		}
	</style>
	
	<script type="text/javascript">
		$(function(){
			$("#list-group").click(function(event){
				if(event.target.nodeName=='LI'){
					var dataVal=$(event.target).attr("data-val");
					$(".panel[data-val]").css("display","none");
					$(".panel[data-val="+dataVal+"]").css("display","block");
				}
			});
		});
	</script>
 
</head>
<body>

	<div class="container-fluid" style="margin-top:10px;">
		<div class="col-md-2">
			<ul class="list-group" id="list-group">
				<li class="list-group-item active">爬虫统计数据</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-1">新闻源采集情况(${sessionScope.date})</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-2">新闻源子分类采集情况(${sessionScope.date})</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-3">文本源采集情况(${sessionScope.date})</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-4">图集源采集情况(${sessionScope.date})</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-5">视频源采集情况(${sessionScope.date})</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-6">快讯采集情况(${sessionScope.date})</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-7">新闻源未开启采集列表(${sessionScope.date})</li>
			</ul>
		</div>
		<div class="col-md-10">

			<div class="panel panel-primary" style="display:block;" data-val="list-1">
				<!-- Default panel contents -->
				<div class="panel-heading">新闻源采集情况(${sessionScope.date})</div>
				<div class="panel-body">
					<table id="media"></table>
				</div>
			</div>

			<div class="panel panel-primary" data-val="list-2">
				<!-- Default panel contents -->
				<div class="panel-heading">新闻源子分类采集情况(${sessionScope.date})</div>
				<div class="panel-body">
					<table id="mediacategory"></table>
				</div>
			</div>

			<div class="panel panel-primary" data-val="list-3">
				<!-- Default panel contents -->
				<div class="panel-heading">文本源采集情况(${sessionScope.date})</div>
				<div class="panel-body">
					<table id="mediaText"></table>
				</div>
			</div>

			<div class="panel panel-primary" data-val="list-4" >
				<!-- Default panel contents -->
				<div class="panel-heading">图集源采集情况(${sessionScope.date})</div>
				<div class="panel-body">
					<table id="mediaGallery"></table>
				</div>
			</div>

			<div class="panel panel-primary" data-val="list-5" >
				<!-- Default panel contents -->
				<div class="panel-heading">视频源采集情况(${sessionScope.date})</div>
				<div class="panel-body">
					<table id="mediaVideo"></table>
				</div>
			</div>
			
			<div class="panel panel-primary" data-val="list-6" >
				<!-- Default panel contents -->
				<div class="panel-heading">快讯采集情况(${sessionScope.date})</div>
				<div class="panel-body">
					<table id="mediaBreakingNews"></table>
				</div>
			</div>
			

			<div class="panel panel-primary" data-val="list-7" >
				<!-- Default panel contents -->
				<div class="panel-heading">新闻源未开启采集列表(${sessionScope.date})</div>
				<div class="panel-body">
					<table id="mediaopen"></table>
				</div>
			</div>

		</div>

	</div>
	

	<script type="text/javascript">
		$('#media').bootstrapTable({
			url : 'media',
			striped : true,
			columns : [ {
				field : 'id',
				title : '新闻源id',
				width : '100px'
			}, {
				field : 'total',
				title : '采集文章数',
				width : '100px'
			} ]
		});

		$('#mediacategory').bootstrapTable({
			url : 'mediacategory',
			striped : true, //是否显示行间隔色
			columns : [ {
				field : 'mediaId',
				title : '源id'
			}, {
				field : 'id',
				title : '源子分类id'
			}, {
				field : 'total',
				title : '采集文章数'
			} ]
		});
		
		$('#mediaText').bootstrapTable({
			url : 'media?type=text',
			striped : true, //是否显示行间隔色
			columns : [ {
				field : 'id',
				title : '源子分类id'
			}, {
				field : 'total',
				title : '采集文章数'
			} ]
		});
		
		$('#mediaGallery').bootstrapTable({
			url : 'media?type=gallery',
			striped : true, //是否显示行间隔色
			columns : [  {
				field : 'id',
				title : '源子分类id'
			}, {
				field : 'total',
				title : '采集文章数'
			} ]
		});
		
		$('#mediaVideo').bootstrapTable({
			url : 'media?type=video',
			striped : true, //是否显示行间隔色
			columns : [ {
				field : 'id',
				title : '源子分类id'
			}, {
				field : 'total',
				title : '采集文章数'
			} ]
		});
		
		$('#mediaBreakingNews').bootstrapTable({
			url : 'media?type=breakingnews',
			striped : true, //是否显示行间隔色
			columns : [ {
				field : 'id',
				title : '源子分类id'
			}, {
				field : 'total',
				title : '采集快讯数'
			} ]
		});
		

		$('#mediaopen').bootstrapTable({
			url : 'mediaopen',
			striped : true, //是否显示行间隔色
			columns : [ {
				field : 'id',
				title : '源id'
			}, {
				field : 'type',
				title : '源类型'
			} ]
		});
	</script>
</body>
</html>
