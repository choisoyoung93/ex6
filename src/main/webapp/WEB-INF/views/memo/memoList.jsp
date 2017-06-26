<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<script type="text/javascript">
	$(function() {
		getList(1, "%", "%");
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			memoWrite(writer, contents);
		});
		$("#btnView").click(function() {
			memoView(2);
		});
	});
	
	
</script>
</head>
<body>
	<h1>MEMO PAGE</h1>
	<div>
		<form action="">
			<p>WRITER: <input type="text" id="writer"></p>
			<p>CONTENTS: <textarea rows="" cols="" id="contents"></textarea>
			<input type="button" value="BUTTON" id="btn"> 
		</form>
	</div>
	<div id="result"></div>
	<div id="btnView">VIEW</div>
</body>
</html>