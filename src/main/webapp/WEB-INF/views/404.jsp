<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/article.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/fonts.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>404</title>
</head>
<body>
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
		<div class="col-md-12 column">
			<h1 align="center">404</h1>
		</div>

	</div>
</body>
</html>