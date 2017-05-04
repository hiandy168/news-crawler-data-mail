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
				<li class="list-group-item active">爬虫分类统计数据</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-1">统计十天内新闻源采集情况(${sessionScope.date})</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-2">统计十天内每小时采集情况(不含快讯)</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-3">新闻源分类采集情况(${sessionScope.date})</li>
				<li class="list-group-item" style="cursor:pointer" data-val="list-4">新闻源分类及子分类采集情况(${sessionScope.date})</li>
			</ul>
		</div>
			<div class="col-md-10">
				<div class="panel panel-primary" style="display:block;" data-val="list-1" >
					<!-- Default panel contents -->
					<div class="panel-heading">统计十天内新闻源采集情况(${sessionScope.date})</div>
					<div class="panel-body">
						<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
						<div id="main" style="width: 100%;height:600px;"></div>
					</div>
				</div>

				<div class="panel panel-primary" style="display: none;" data-val="list-2" >
					<!-- Default panel contents -->
					<div class="panel-heading">统计十天内每小时采集情况(不含快讯数据)</div>
					<div class="panel-body" style="height:500px;">
						<table id="main_perhour"
							style="table-layout: fixed;font-size:12px;"></table>
					</div>
				</div>

				<div class="panel panel-primary" style="display: none;height:900;" data-val="list-3" >
					<!-- Default panel contents -->
					<div class="panel-heading">新闻源分类采集情况(${sessionScope.date})</div>
					<div class="panel-body" style="height:850;" >
						<table id="category" style="font-size:14px;"></table>
					</div>
				</div>

				<div class="panel panel-primary" style="display: none;height:900;" data-val="list-4" >
					<!-- Default panel contents -->
					<div class="panel-heading">新闻源分类及子分类采集情况(${sessionScope.date})</div>
					<div class="panel-body" style="height:850;">
						<table id="subcategory" style="font-size:14px;"></table>
					</div>
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
		        data:['文本源采集量','图集源采集量','视频源采集量','快讯采集量']
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
			        },{
			            // 根据名字对应到相应的系列
			            name: '快讯数',
			             type:'bar',
			            data: data.breakingnewsData
			        }]
			    });
			}
		});
	
		$('#main_perhour').bootstrapTable({
			url : 'perHourStat',
			striped : true,
			columns : [ {
				field : 'date',
				title : '日期',
				width:100
			}, {
				field : 'f0t1',
				title : '0点到1点',
				width:90
			}, {
				field : 'f1t2',
				title : '1点到2点',
				width:90
			}, {
				field : 'f2t3',
				title : '2点到3点',
				width:90
			}, {
				field : 'f3t4',
				title : '3点到4点',
				width:90
			}, {
				field : 'f4t5',
				title : '4点到5点',
				width:90
			}, {
				field : 'f5t6',
				title : '5点到6点',
				width:90
			}, {
				field : 'f6t7',
				title : '6点到7点',
				width:90
			}, {
				field : 'f7t8',
				title : '7点到8点',
				width:90
			}, {
				field : 'f8t9',
				title : '8点到9点',
				width:90
			}, {
				field : 'f9t10',
				title : '9点到10点',
				width:90
			}, {
				field : 'f10t11',
				title : '10点到11点',
				width:90
			}, {
				field : 'f11t12',
				title : '11点到12点',
				width:90
			}, {
				field : 'f12t13',
				title : '12点到13点',
				width:90
			}, {
				field : 'f13t14',
				title : '13点到14点',
				width:90
			}, {
				field : 'f14t15',
				title : '14点到15点',
				width:90
			}, {
				field : 'f15t16',
				title : '15点到16点',
				width:90
			}, {
				field : 'f16t17',
				title : '16点到17点',
				width:90
			}, {
				field : 'f17t18',
				title : '17点到18点',
				width:90
			}, {
				field : 'f18t19',
				title : '18点到19点',
				width:90
			}, {
				field : 'f19t20',
				title : '19点到20点',
				width:90
			}, {
				field : 'f20t21',
				title : '20点到21点',
				width:90
			}, {
				field : 'f21t22',
				title : '21点到22点',
				width:90
			}, {
				field : 'f22t23',
				title : '22点到23点',
				width:90
			}, {
				field : 'f23t0',
				title : '23点到0点',
				width:90
			}, {
				field : 'total',
				title : '采集文章数',
				width:90
			}, ]
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
