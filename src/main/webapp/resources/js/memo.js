/**
 * 
 */
function memoView(num) {
	$.get("memoView/"+num, function(data) {
		alert(data.writer);
	});
}

function memoWrite(writer, contents) {
	$.ajax({
		url: "memoWrite",
		type: "POST",
		data: {
			writer: writer,
			contents: contents
		},
		success: function(data) {
			alert(data.trim());
			$("#writer").val("");
			$("#contents").val("");
			getList(1, "", "");
		}
	});
}
	
function getList(curPage, kind, search) {
	$.ajax({
		url: "getMemoList/" + curPage + "/" + kind + "/" + search,
		type: "GET",
		success: function(data) {
			var result = "<table>";
			$(data).each(function(){
				result = result + "<tr>";
				result = result + "<td>" + this.num + "</td>";
				result = result + "<td>" + this.contents + "</td>";
				result = result + "<td>" + this.writer + "</td>";
				result = result + "<td>" + this.reg_date + "</td>";
				result = result + "</tr>";
			});
			result = result + "</table>";
			$("#result").html(result);
		}
	});
	/* $.get("URL?name=value", function(data){});
	$.post("URL", {name = value, name2 = value2}, function(){});
	$.ajax({
		url: "",
		type: "",
		data: {},
		success: function() {		
		}
	});
	$("#result").load */
}