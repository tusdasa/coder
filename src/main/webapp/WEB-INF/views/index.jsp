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
<link rel="stylesheet" type="text/css" href="css/article.css">
<link rel="stylesheet" type="text/css" href="css/fonts.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/default.min.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/highlight.min.js"></script>
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
						<li>
							 <a href="about">关于</a>
						</li>
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
										<c:if test="${ user.permission.publish and not user.permission.admin }">
											<li><a href="author">文章管理</a></li>
										</c:if>
									</c:if>
									<c:if test="${ user ne null }">
										<li><a href="logout">注销</a></li>
									</c:if>

								</ul>
								</li>
						</ul>
					</div>
				</nav>
				<div class="carousel slide" id="carousel-564216">

					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="images/background.jpg" />
							<div class="carousel-caption">
								<h1>Coder专栏</h1>
								<p style="margin-left: 1em; font-size: 14px;">为更纯粹的求知</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div style="width: 1200px; height: 100px;"></div>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-10 column">
			<c:if test="${ functions:length(articles) eq 0 }">
				<h1 align="center">还没有人发表文章</h1>
			</c:if>
				<c:if test="${ functions:length(articles) ne 0 }">
				
				<c:forEach items="${ articles }" var="article"
					varStatus="userStatus">
					<c:if test="${userStatus.index eq 0}">
						<div class="row clearfix">
							<div style="height: 10px;"></div>
						</div>
					</c:if>
					<c:if test="${userStatus.index ne 0}">
						<div class="row clearfix">
							<div style="height: 50px;"></div>
						</div>
					</c:if>
					<div class="row clearfix" id="title">
						<h3 style="text-indent: 2em;"> <a href="article?aid=${ article.aid }">${ article.title }</a> </h3>
					</div>
					<hr>
					<div class="row clearfix">
						<blockquote>
							<p>
								<small>作者:<cite>${article.author.username }</cite></small>
							</p>
							<p>
								<small>时间:<cite><fmt:formatDate
											value="${ article.date }" pattern="yyyy-MM-dd" /></cite></small>
							</p>
							<p>
								<small>分类:<cite>${article.category.acname }</cite></small>
							</p>
							<c:if test="${ article.tags ne null}">
								<c:forEach items="${ article.tags }" var="tag">
									<span class="label label-info"> <a href="tags?tags=${ tag.tid }">${ tag.content }</a></span>
								</c:forEach>
							</c:if>
						</blockquote>
					</div>
					<div class="row clearfix" id="text">${article.content }</div>
				</c:forEach>
				
				
				</c:if>
			</div>
			<div class="col-md-2 column">
				<div class="row clearfix">
					<h4>分类</h4>
				<hr>
				<ul>
					<c:forEach items="${ categorys }" var="category">
						<li>
							<p>
								<a href="category?ac=${ category.acid }">${ category.acname }</a>
							</p>
						</li>
					</c:forEach>
				</ul>
				<hr>
				</div>
				<div class="row clearfix">
					<div style="height: 60px;width: 60px;"></div>
				</div>
				<div class="row clearfix">
						<h4>友情链接</h4>
				<hr>
				<ul>
					<c:forEach items="${ addresss }" var="address">
						<li>
							<p>
								<a href="${ address.address }">${ address.title }</a>
							</p>
						</li>
					</c:forEach>
				</ul>
				<hr>
				</div>
			</div>
		</div>
		<div class="row clearfix">
		<c:if test="${ page ne null }">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<ul class="pagination pagination-sm">
								<c:forEach step="1" begin="0" end="${ page-1 }" var="i">
									<li><a href="?page=${i}">${i+1}</a></li>
								</c:forEach>
						</ul>
					</div>
					<div class="col-md-4 column"></div>
				</div>
			</div>
			</c:if>
			<jsp:useBean id="now" class="java.util.Date" scope="page"/>
			<div class="col-md-12 column"><p>©<fmt:formatDate value="${now}" pattern="yyyy" />Coder专栏</p></div>
		</div>
		<script type="text/javascript"></script>
	</div>
	<script type="text/javascript">hljs.initHighlightingOnLoad();</script>
</body>
</html>