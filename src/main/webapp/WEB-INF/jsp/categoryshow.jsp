<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>爬虫分类统计数据</title>

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
 <script src="<%=request.getContextPath()%>/dist/echarts.common.min.js"></script>
</head>

<body>
	
	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">统计十天内新闻源采集情况(${sessionScope.date})</div>
			<div class="panel-body">
				 <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    			<div id="main" style="width: 1100px;height:500px;"></div>
			</div>
		</div>
	</div>
	
	
	
	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">新闻源分类采集情况(${sessionScope.date})</div>
			<div class="panel-body">
				<table id="category"></table>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">新闻源分类及子分类采集情况(${sessionScope.date})</div>
			<div class="panel-body">
				<table id="subcategory"></table>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
		var myChart = echarts.init(document.getElementById('main'));
		// 显示标题，图例和空的坐标轴
		myChart.setOption({
		    title: {
		        text: '统计十天内新闻源采集情况'
		    },
		      toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true}
		        }
		    },
		    tooltip: {
		    	trigger: 'axis'
		    },
		    legend: {
		        data:['文本源采集量','图集源采集量','视频源采集量']
		    },
		    calculable : true,
		    xAxis: {
		        data: []
		    },
		    yAxis: {},
		    series: [{
		        name: '采集数据量',
		        type: 'bar',
		        data: []
		    }]
		});
		
		myChart.showLoading();
		// 异步加载数据
		$.ajax({
			dataType: "json",
			url: "article",
			success: function(data){
				myChart.hideLoading();
			    // 填入数据
			    myChart.setOption({
			        xAxis: {
			        	type : 'category',
			            data: data.date
			        },
			        yAxis : [
				        {
				            type : 'value'
				        }
				    ],
			        series: [{
			            // 根据名字对应到相应的系列
			            name: '文本文章数',
			             type:'bar',
			            data: data.textData
			        },{
			            // 根据名字对应到相应的系列
			            name: '图集文章数',
			             type:'bar',
			            data: data.galleryData
			        },{
			            // 根据名字对应到相应的系列
			            name: '视频文章数',
			             type:'bar',
			            data: data.videoData
			        }]
			    });
			}
		});
	
	
		$('#category').bootstrapTable({
			url : 'category',
			striped : true,
			columns : [ {
				field : 'id',
				title : '分类id'
			}, {
				field : 'note',
				title : '分类名称'
			}, {
				field : 'total',
				title : '采集文章数'
			}, ]
		});
		
		$('#subcategory').bootstrapTable({
			url : 'subcategory',
			striped : true,
			columns : [ {
				field : 'categoryId',
				title : '分类id'
			}, {
				field : 'id',
				title : '子分类id'
			},{
				field : 'name',
				title : '子分类名称'
			}, {
				field : 'total',
				title : '采集文章数'
			}, ]
		});
	</script>
</body>
</html>
