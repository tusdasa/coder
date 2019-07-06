<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coder专栏</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/fonts.css">
<link rel="stylesheet" type="text/css" href="css/article.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/default.min.css">
<script type="text/javascript" src="js/highlight.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

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
						<form class="navbar-form navbar-left" role="search" action="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="关键字" name="key"/>
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
			<div class="col-md-12 column">
				<div style="width: 1200px; height: 100px;"></div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
						<div class="row clearfix">
							<div style="height: 10px;"></div>
						</div>
					<div class="row clearfix" id="title">
						<h3 style="text-indent: 2em;"> <a href="?aid=${ article.aid }">${ article.title }</a> </h3>
					</div>
					<hr>
					<div class="row clearfix">
						<blockquote>
							<p>
								<small>作者:<cite>${article.author.username }</cite></small>
							</p>
							<p>
								<small>时间:<cite><fmt:formatDate value="${ article.date }" pattern="yyyy-MM-dd" /></cite></small>
							</p>
							<p>
								<small>分类:<cite>${article.category.acname }</cite></small>
							</p>
							<c:if test="${ functions:length(article.tags) ne 0 }">
								<c:forEach items="${ article.tags }" var="tag">
									<span class="label label-info"> <a href="tags?tags=${ tag.tid }">${ tag.content }</a></span>
								</c:forEach>
							</c:if>
						</blockquote>
					</div>
					<div class="row clearfix" id="text">${article.content }</div>
				
			</div>
		</div>
		<div class="row clearfix">
		<div class="col-md-12 column">
			<div style="width: 1200px;height: 50px;"></div>
		</div>
		<c:if test="${ functions:length(article.comments) ne 0 }">
			<c:forEach items="${ article.comments }" var="comment">
				<div class="col-md-12 column">
					<blockquote>
						<p>
								<small>用户:<cite>${comment.user.username }</cite></small>
						</p>
						<p>
								<small>时间:<cite><fmt:formatDate value="${ comment.created }" pattern="yyyy-MM-dd" /></cite></small>
						</p>
						<p>${comment.comment}</p>
					</blockquote>
			</div>
			</c:forEach>
		</c:if>
		<div class="col-md-12 column">
			<form role="form" action="comment" method="post" onsubmit="return check()">
				<input type="hidden" value="${ aid }" name="aid" id="aid">
				<div class="form-group">
					 <label for="comment">评论</label>
					 <textarea id="comment" class="form-control" name="comment"></textarea>
				</div>
				<button type="submit" class="btn btn-default">提交</button>
			</form>
		</div>
	</div>
	<jsp:useBean id="now" class="java.util.Date" scope="page"/>
			<div class="col-md-12 column"><p>©<fmt:formatDate value="${now}" pattern="yyyy" /> Coder专栏</p></div>
	</div>
	<script type="text/javascript">
		function check() {
			
			if($("#aid").val()!="" && $("#comment").val()!=""){
				return true;
			}else{
				return false;
			}
		}
	</script>
	<script type="text/javascript">hljs.initHighlightingOnLoad();</script>
</body>
</html>