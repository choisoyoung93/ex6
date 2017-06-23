<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var i = 0;
		var name = 0;
		$("#add").click(function() {	
			if(i>=5){
				alert("그만");
			}else{
				i++;
				name++;
				$("#file").append('<p class="'+i+'"><input type="file" name="f'+name+'"><span class="del" data-n="'+i+'">X</span></p>');			
			}
		});
		$("#file").on("click", ".del", function() {
			var num = $(this).attr("data-n");
			$("."+num).remove();
			i--;
		});
	});
</script>
</head>
<body>
	<h2>단일 파일 업로드</h2>
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<p>NAME: <input type="text" name="name"></p>
		<p><input type="file" name="f1"></p>
		<button>UPLOAD</button>
	</form>
	<hr>
	<h2>다중 파일 업로드 - 이름이 다를 때</h2>
	<form action="multiFileUpload" method="post" enctype="multipart/form-data">
		<p>NAME: <input type="text" name="name"></p>
		<p><input type="file" name="f1"></p>
		<p><input type="file" name="f2"></p>
		<button>UPLOAD</button>
	</form>
	<hr>
	<h2>다중 파일 업로드 - 이름이 같을 때</h2>
	<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
		<p>NAME: <input type="text" name="name"></p>
		<p><input type="file" name="f1"></p>
		<p><input type="file" name="f1"></p>
		<button>UPLOAD</button>
	</form>
	<hr>
	<h2>다중 파일 업로드 - 이름이 같고 갯수를 모를때</h2>
	<form action="upload" method="post" enctype="multipart/form-data">
		<p>NAME: <input type="text" name="name"><input type="button" id="add" value="FILE ADD"></p>
		<div id="file">
			
		</div>
		<button>UPLOAD</button>
	</form>
</body>
</html>