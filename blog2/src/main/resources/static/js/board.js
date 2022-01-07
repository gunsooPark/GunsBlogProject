let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	},
	
	save:function(){
		//alert("board의 save함수 호출 ")
		let data = {
			title : $("#title").val(),
			content : $("#content").val()
		};
		
		$.ajax({
			type:"post",
			url : "/api/board",
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		}).done(function(resp){
			alert("글쓰기가 완료되었습니다. ");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	}//end save
	
	
}//end index


index.init();