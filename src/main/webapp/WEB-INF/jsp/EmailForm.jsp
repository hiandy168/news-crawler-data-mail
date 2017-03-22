<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email with Spring MVC</title>
<script src="<%=request.getContextPath()%>/dist/jquery.min.js"></script>
 <script src="<%=request.getContextPath()%>/dist/jquery.xpath.js"></script>
 <script src="<%=request.getContextPath()%>/dist/jquery.ellocate.js"></script>
 <style type="text/css">
 	.add_border{
 		border:1px solid blue;
 	}
 </style>

</head>
<body>
	<center>
		<h1>Sending e-mail with Spring MVC</h1>
		<form method="post" action="sendEmail">
			<table border="0" width="80%">
				<tr>
					<td>To:</td>
					<td><input type="text" name="recipient" size="65" />
					</td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><input type="text" name="subject" size="65" />
					</td>
				</tr>
				<tr>
					<td>Message:</td>
					<td><textarea cols="50" rows="10" name="message"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Send E-mail" /></td>
				</tr>
			</table>
		</form>
	</center>
	<script type="text/javascript">
		$(document).ready(function() {
			$(document).mouseover(function(e) {
				$(e.target).toggleClass("add_border");
			}).mouseout(function(e){
				$(e.target).toggleClass("add_border");
			}).click(function(e){
				console.log($(e.target).ellocate());
			});
		});
	</script>
</body>
</html>