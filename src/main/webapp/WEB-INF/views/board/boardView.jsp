<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	var m = '${message}';
	if(m != ''){
		alert(m);
	}
</script>
</head>
<body>
	<h1> ${board} View Page </h1>
	<table class="table">
		<thead>
		<tr>
			<th width="50px">NUM</th><th style="text-align: center;">TITLE</th><th width="100px">WRITER</th><th width="100px">DATE</th><th width="50px">HIT</th>
		</tr>
		</thead>
		<tr>
			<td>${boardDTO.num}</td><td>${boardDTO.title}</td><td>${boardDTO.writer}</td><td>${boardDTO.reg_date}</td><td>${boardDTO.hit}</td>
		</tr>
		<tr>
			<td colspan="5">${boardDTO.contents}</td>
		</tr>
	</table>
	<a href="${board}List" class="btn btn-default">LIST</a>
	<a href="${board}Reply?num=${boardDTO.num}" class="btn btn-default">REPLY</a>
	<a href="${board}Update?num=${boardDTO.num}" class="btn btn-default">MOD</a>
	<a href="${board}Delete?num=${boardDTO.num}" class="btn btn-default">DEL</a>
</body>
</html>