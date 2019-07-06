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

								</ul>
								</li>
						</ul>
					</div>
				</nav>
				<div class="carousel slide" id="carousel-564216">

					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="images/background.png" />
							<div class="carousel-caption">
								<h2>吾生也有涯，而知也无涯</h2>
								<p style="margin-left: 1em; font-size: 18px;">拓展您的知识视野
									enjoy! :)</p>
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
			<div class="col-md-2 column"></div>
			<div class="col-md-8 column">

			<h2>鸣谢</h2>
			<p>
				Coder的创建离不开以下开源软件
			</p>
		<table class="table table-condensed table-striped">
										<tbody>
											
												<tr>
													<td>Spring</td>
													<td><a href="https://spring.io" target="_blank">https://spring.io </a></td>
												</tr>
												<tr>
													<td>Hibernate</td>
													<td><a href="http://hibernate.org" target="_blank">http://hibernate.org</a></td>
												</tr>
												<tr>
													<td>MySQL</td>
													<td><a href="https://www.mysql.com" target="_blank">https://www.mysql.com</a></td>
												</tr>
												<tr>
													<td>gson库</td>
													<td><a href="http://www.gson.org" target="_blank">http://www.gson.org</a></td>
												</tr>
												<tr>
													<td>eclipse</td>
													<td><a href="https://www.eclipse.org" target="_blank">https://www.eclipse.org</a></td>
												</tr>
												<tr>
													<td>Bootstrap</td>
													<td><a href="https://getbootstrap.com" target="_blank">https://getbootstrap.com</a></td>
												</tr>
												<tr>
													<td>wangEditor</td>
													<td><a href="http://www.wangeditor.com" target="_blank">http://www.wangeditor.com</a></td>
												</tr>
												<tr>
													<td>Apache Commons</td>
													<td><a href="http://commons.apache.org" target="_blank">http://commons.apache.org</a></td>
												</tr>
												<tr>
													<td>EhCache</td>
													<td><a href="https://www.ehcache.org" target="_blank">https://www.ehcache.org</a></td>
												</tr>
												<tr>
													<td>Apache Tomcat</td>
													<td><a href="http://tomcat.apache.org" target="_blank">http://tomcat.apache.org</a></td>
												</tr>
										</tbody>
									</table>
			<p>还有许多自由软件</p>

			</div>
			<div class="col-md-2 column"></div>
		</div>
		<div class="row clearfix">
			<jsp:useBean id="now" class="java.util.Date" scope="page"/>
			<div class="col-md-12 column"><p>©<fmt:formatDate value="${now}" pattern="yyyy" /> Coder专栏</p></div>
		</div>
	</div>
</body>
</html>