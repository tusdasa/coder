<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/fonts.css">
<link rel="stylesheet" type="text/css" href="css/article.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/wangEditor.min.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/">Coder专栏</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav"></ul>
						<form class="navbar-form navbar-left" role="search"
							action="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="关键字"
									name="key" />
							</div>
							<button type="submit" class="btn btn-default">搜索</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Option<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<c:if test="${ user eq null }">
										<li><a href="login">登录</a></li>
										<li><a href="regist">注册</a></li>
									</c:if>
									<c:if test="${ user ne null }">
										<li><a>${ user.username }</a></li>
									</c:if>
									<c:if test="${ user ne null }">
										<c:if test="${ user.permission.admin }">
											<li><a href="admin">管理中心</a></li>
										</c:if>
										<c:if test="${ user.permission.publish }">
											<li><a href="write">创作</a></li>
										</c:if>
									</c:if>
									<c:if test="${ user ne null }">
										<li><a href="logout">注销</a></li>
									</c:if>
								</ul></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<div class="row clearfix">
			<div class="form-horizontal" role="form">
				<div class="form-group">
					<div class="col-sm-12">
						<label for="name">标题:</label> <input type="text" id="title"
							class="form-control" id="inputEmail3" placeholder="标题"
							name="title" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<label for="name">分类:</label> <select class="form-control"
							id="category">
							<c:forEach var="category" items="${ categorys }">
								<c:if test="${category.acid eq 1 }">
									<option selected="selected" value="${ category.acid }">${ category.acname }</option>
								</c:if>
								<c:if test="${category.acid ne 1 }">
									<option selected="selected" value="${ category.acid }">${ category.acname }</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<a id="modal-589481" href="#modal-container-589481" role="button"
					class="btn" data-toggle="modal">添加标签</a>
				<div class="modal fade" id="modal-container-589481" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" style="z-index:99;">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">添加标签</h4>
							</div>
							<div class="modal-body">
								<!-- 添加标签 -->
								<c:forEach items="${ tags }" var="tag">
									<div class="checkbox">
										<label><input type="checkbox" name="tag" value="${ tag.tid }" />${ tag.content }</label>
									</div>
								</c:forEach>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="row clearfix">

			<div class="col-md-12 column" style="z-index:1;">
				<div>
					<div class="col-md-12 column" id="edit" style="height: 400px;"></div>
				</div>
			</div>

		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="col-md-4 column">
					<div style="width: 100px; height: 90px;"></div>
				</div>
				<div class="col-md-4 column">
					<button type="button" id="sumit"
						class="btn btn-default btn-block center-block">保存</button>
				</div>
				<div class="col-md-4 column"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var E = window.wangEditor
		var editor = new E('#edit')

		editor.customConfig.uploadImgServer = 'upimg';
		editor.customConfig.uploadFileName = 'upload';

		editor.customConfig.uploadImgHooks = {
			fail : function(xhr, editor, result) {
				alert("上传失败");
			},
			error : function(xhr, editor) {
				alert("上传失败");
			},
			timeout : function(xhr, editor) {
				alert("上传失败");
			},
			customInsert : function(insertImg, result, editor) {

				var url = "images/" + result.url;
				insertImg(url);
			}
		};

		editor.create()
		$("#sumit").click(function() {
			var article = new Object();
			var category = new Object();
			
			
			 var tags = new Array();
	         var ob = $("input:checked[name='tag']");
	         for(var i =0 ;i <ob.length;i++){
	               var tag = new Object();
	               tag.tid=ob[i].value;
	               tags.push(tag);
	            }
			article.title = $("#title").val();
			category.acid = $("#category").val();
			article.category = category;
			article.content = editor.txt.html();
			article.tags=tags;
			if (editor.txt.text() == "") {
				alert("正文空");
				return;
			}
			if (article.title == "") {
				alert("标题为空");
				return;
			}
			$.ajax({
				url : "write",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(article),
				success : function(result) {
					if (result.state == 200) {
						alert("成功");
					}
					if (result.state == 500) {
						alert("失败");
					}
				}
			});

		});
	</script>
</body>
</html>