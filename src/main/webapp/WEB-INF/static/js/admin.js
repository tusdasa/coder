//添加分类
$("#addcategory").click(function(){
	var url="/api/add";
	var date = new Object();
	if($("#newcategory").val()!=""){
		date.action="category";
		date.value=$("#newcategory").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});
//升级分类
$("#updatecategory").click(function(){
	var url="/api/update";
	var date = new Object();
	if($("#acid").val()!="" && $("#newacname").val()!=""){
		date.action="uc";
		//主键
		date.value=$("#newacname").val();
		//新值
		date.id=$("#acid").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});

$("#delarticle").click(function(){
	var url="/api/del";
	var date = new Object();
	if($("#aid").val()!=""){
		date.action="darticle";
		date.value=$("#aid").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});

$("#uparticlec").click(function(){
	var url="/api/update";
	var date = new Object();
	if($("#upcategoryacid").val()!="" && $("#upaid").val()!=""){
		date.action="ua";
		date.id=$("#upaid").val();
		date.value=$("#upcategoryacid").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});



$("#addtag").click(function(){
	var url="/api/add";
	var date = new Object();
	if($("#newtag").val()!=""){
		date.action="tag";
		date.value=$("#newtag").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});




$("#updatetag").click(function(){
	var url="/api/update";
	var date = new Object();
	if($("#tid").val()!="" && $("#tcotent").val()!=""){
		date.action="ut";
		date.id=$("#tid").val();
		date.value=$("#tcotent").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});



$("#disable").click(function(){
	var url="/api/user";
	var date = new Object();
	if($("#uid").val()!=""){
		date.action="disable";
		date.value=$("#uid").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});


$("#enable").click(function(){
	var url="/api/user";
	var date = new Object();
	if($("#uid").val()!=""){
		date.action="enable";
		date.value=$("#uid").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});



$("#upper").click(function(){
	var url="/api/update";
	var date = new Object();
	if($("#upuid").val()!="" && $("#pid").val()!=""){
		date.action="uu";
		date.value=$("#pid").val();
		date.id=$("#upuid").val();
		if(sendDateByGet(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});



$("#addaddress").click(function(){
	var url="/api/addAddress";
	var date = new Object();
	if($("#newaddress").val()!="" && $("#newtitle").val()!=""){
		date.address=$("#newaddress").val();
		date.title=$("#newtitle").val();
		if(sendJsonByPost(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});


$("#upadd").click(function(){
	var url="/api/upAddress";
	var date = new Object();
	if($("#uptitle").val()!="" && $("#upaddress").val()!="" && $("#did").val()!=""){
		date.did=$("#did").val();
		date.address=$("#upaddress").val();
		date.title=$("#uptitle").val();
		if(sendJsonByPost(url, date)){
			alert("成功");
		}else{
			alert("失败");
		}
		
	}else{
		alert("请填写");
	}
});

