<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	var m = '${message}';
	if(m != ''){
		alert(m);
	}
	$(function() {
		var board = '${board}';
		var kind = '${kind}';
		if(kind == ''){
			kind = "writer";
		}
		var search = '${search}';
		$("#kind").val(kind);
		$("#search").val(search)
		$(".page").click(function() {
			var curPage = $(this).attr("id");
			$("#curPage").val(curPage);
			frm.submit();
		});
	});
</script>
<style type="text/css">
	a{
		text-decoration: none;
		color: black;
	}
	span {
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1 align="center"> ${board} List </h1>
	
	<div>
		<form action="${board}List" name="frm">
			<select name="kind" id="kind">
				<option value="writer" selected="selected">WRITER</option>
				<option value="title">TITLE</option>
				<option value="contents">CONTENTS</option>
			</select>
			<input type="text" name="search" id="search">
			<input type="hidden" name="curPage" id="curPage" value="1">
			<input type="submit" value="SEARCH" class="btn btn-default">
		</form>
	</div>
	
	<table class="table table-striped">
      <thead>
      	<tr>
         <th width="50px">NUM</th><th style="text-align: center;">TITLE</th><th width="100px">WRITER</th><th width="100px">DATE</th><th width="50px">HIT</th>
         </tr>
       </thead>
       <tbody>
          <c:forEach items="${ boardList }" var="dto">
            <tr>
               <td>${ dto.num }</td>
               <td>
               		<c:catch>
               		<c:forEach begin="1" end="${dto.depth}" var="i">
               			&nbsp;&nbsp;
               			<c:if test="${i eq dto.depth}">└RE:</c:if>
               		</c:forEach>
               		
               		</c:catch>
               		<a href="${board}View?num=${ dto.num }" style="color: black; text-decoration: none;">${ dto.title }</a>
               	</td>
               <td>${ dto.writer }</td>
               <td>${ dto.reg_date }</td>
               <td>${ dto.hit }</td>
            </tr>
         </c:forEach>
      </tbody>
    </table>
    <div style="margin: 0 auto; float: left;">
    <ul class="pagination" >
    	<c:if test="${makePage.curBlock > 1}">
    		<li><span class="page" id="${makePage.startNum - 1}">Previous</span></li>
    		<%-- <li><a href="${board}List?curPage=${makePage.startNum - 1}&search=${search}&kind=${kind}">Previous</a></li> --%>
    	</c:if>
    	<c:forEach begin="${makePage.startNum}" end="${makePage.lastNum}" var="i">
    		<li><span class="page" id="${i}">${i}</span></li>
			<%-- <li><a href="${board}List?curPage=${i}&search=${search}&kind=${kind}">${i}</a></li> --%>
		</c:forEach>
		<c:if test="${makePage.curBlock < makePage.totalBlock}">
			<li><span class="page" id="${makePage.lastNum + 1}">Next</span></li>
			<%-- <li><a href="${board}List?curPage=${makePage.lastNum + 1}&search=${search}&kind=${kind}">Next</a></li> --%>
		</c:if>
	</ul>
	</div>
	
	<a href="${board}Write" class="btn btn-default" style="float: right;">Write</a>
	
	<br><br><br><br><br>
	<div>
		<p>curPage : ${curPage} </p>
		<p>search : ${search} </p>
		<p>kind : ${kind} </p>
	</div>
</body>
</html>