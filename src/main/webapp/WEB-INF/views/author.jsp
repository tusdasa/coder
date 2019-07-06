<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文章管理</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/fonts.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span><span class="icon-bar"></span> <span
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
				<div class="col-md-12 column">
					<div class="tabbable" id="tabs-914808">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#panel-001" data-toggle="tab">欢迎</a></li>
							<li><a href="#panel-003" data-toggle="tab">文章管理</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-001">
								<div class="col-md-12 column">
									<h2>${user.username}, 欢迎您。</h2>

								</div>
							</div>
							<div class="tab-pane" id="panel-003">
								<div class="col-md-8 column">
									<table class="table table-condensed table-striped">
										<thead>
											<tr>
												<th>ID</th>
												<th>标题</th>
												<th>分类</th>
												<th>时间</th>
												<th>作者</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${ articles }" var="article">
												<tr>
													<td>${article.aid}</td>
													<td><a href="rewrite?aid=${article.aid}"
														target="_blank">${article.title}</a></td>
													<td>${article.category.acname}</td>
													<td>${article.date}</td>
													<td>${article.author.username}</td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-md-4 column">
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="aid">删除</label> <input type="text"
													class="form-control" id="aid" placeholder="ID" />
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="delarticle">删除</button>
										</div>
									</div>
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="upaid">更改分类</label> <input type="text"
													class="form-control" id="upaid" placeholder="ID" /> <select
													class="form-control" id="upcategoryacid">
													<option></option>
													<c:forEach var="category" items="${ categorys }">
														<option value="${ category.acid }">${ category.acname }</option>
													</c:forEach>
												</select>
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="uparticlec">更改</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/admin.js"></script>
</body>

</html>