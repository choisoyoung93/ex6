<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 경로에러 등등 -->
	<h1>ERROR</h1>
	<h3>${e}</h3>
	<a href="../">HOME</a>
	
	<p>1. 납품자명: <input type="search" placeholder="name"></p>
	<input type="number" min="10" max="100" step="10">
	<input type="range"  min="0" max="10" step="2">
	<select>
		<option></option>
		<option >dog1004</option>
		<option>catchicken</option>
		<option>milk</option>
	</select>
	
	<input list="productName" name="productName">
  		<datalist id="productName">
    	<option value="dog1004" label="도그1004">
    	<option value="catchicken" label="고양이치킨">
    	<option value="milk" label="우유">
  		</datalist><br>
</body>
</html>