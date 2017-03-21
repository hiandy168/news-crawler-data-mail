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

</head>

<body>
	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">新闻源采集情况(${sessionScope.date})</div>
			<div class="panel-body">
				<table id="media"></table>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">新闻源采集情况(${sessionScope.date})</div>
			<div class="panel-body">
				<table id="mediacategory"></table>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">文本源采集情况(${sessionScope.date})</div>
			<div class="panel-body">
				<table id="mediaText"></table>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">图集源采集情况(${sessionScope.date})</div>
			<div class="panel-body">
				<table id="mediaGallery"></table>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">视频源采集情况(${sessionScope.date})</div>
			<div class="panel-body">
				<table id="mediaVideo"></table>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">新闻源未开启采集列表(${sessionScope.date})</div>
			<div class="panel-body">
				<table id="mediaopen"></table>
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
