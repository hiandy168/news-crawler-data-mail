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
	<table id="table"></table>
	<script type="text/javascript">
		$('#table').bootstrapTable({
			url : 'data1.json',
			columns : [ {
				field : 'id',
				title : 'Item ID'
			}, {
				field : 'name',
				title : 'Item Name'
			}, {
				field : 'price',
				title : 'Item Price'
			}, ]
		});
	</script>
</body>
</html>
