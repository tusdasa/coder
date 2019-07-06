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
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span><span class="icon-bar"></span>
							<span class="icon-bar"></span>
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
				<div class="col-md-12 column">
					<div class="tabbable" id="tabs-914808">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#panel-001" data-toggle="tab">欢迎</a></li>
							<li><a href="#panel-002" data-toggle="tab">分类管理</a></li>
							<li><a href="#panel-003" data-toggle="tab">文章管理</a></li>
							<li><a href="#panel-004" data-toggle="tab">标签管理</a></li>
							<li><a href="#panel-005" data-toggle="tab">用户管理</a></li>
							<li><a href="#panel-006" data-toggle="tab">友链管理</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-001">
							<div class="col-md-12 column">
								<h2>
									${user.username}, 欢迎您。
								</h2>
							
							</div>
							</div>
							<div class="tab-pane" id="panel-002">
								<div class="col-md-8 column">
									<table class="table table-condensed table-striped">
										<thead>
											<tr>
												<th>ID</th>
												<th>分类</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="category" items="${ categorys }">
												<tr>
													<td>${ category.acid }</td>
													<td>${ category.acname }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-md-4 column">
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="newcategory">添加分类</label> 
												<input type="text" class="form-control" id="newcategory" placeholder="分类名" />
											</div>
											<button type="button" class="btn btn-block btn-primary btn-sm" id="addcategory">添加分类</button>
										</div>
									</div>
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="updatecategory">更改分类</label>
												 <input type="text" class="form-control" id="acid" placeholder="ID" /> 
												 <input type="text" class="form-control" id="newacname" placeholder="新分类名" />
											</div>
											<button type="button" class="btn btn-block btn-primary btn-sm" id="updatecategory">更改分类</button>
										</div>
									</div>
									<script type="text/javascript">
										
									</script>
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
													<td><a href="rewrite?aid=${article.aid}" target="_blank">${article.title}</a></td>
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
												<label for="aid">删除</label> <input
													type="text" class="form-control" id="aid"
													placeholder="ID" />
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="delarticle">删除</button>
										</div>
									</div>
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="upaid">更改分类</label> <input
													type="text" class="form-control" id="upaid"
													placeholder="ID" /> 
													<select class="form-control" id="upcategoryacid">
													<option></option>
													<c:forEach var="category" items="${ categorys }">	
													<option  value="${ category.acid }">${ category.acname }</option>
													</c:forEach>
												</select>
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="uparticlec">更改</button>
										</div>
									</div>
								</div>

							</div>
							<div class="tab-pane" id="panel-004">
									<div class="col-md-8 column">
									<table class="table table-condensed table-striped">
										<thead>
											<tr>
												<th>ID</th>
												<th>分类</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="tag" items="${ tags }">
												<tr>
													<td>${ tag.tid }</td>
													<td>${ tag.content }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-md-4 column">
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="newtag">添加便签</label> <input
													type="text" class="form-control" id="newtag"
													placeholder="新便签" />
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="addtag">添加</button>
										</div>
									</div>
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="tid">更改便签</label> <input
													type="text" class="form-control" id="tid"
													placeholder="ID" /> <input type="text"
													class="form-control" id="tcotent"
													placeholder="新分便签" />
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="updatetag">更改</button>
										</div>
									</div>

								</div>
							</div>
									<div class="tab-pane" id="panel-005">
									<div class="col-md-8 column">
									<table class="table table-condensed table-striped">
										<thead>
											<tr>
												<th>UID</th>
												<th>用户名</th>
												<th>邮件地址</th>
												<th>状态</th>
												<th>用户组</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="u" items="${ users }">
												<tr>
													<td>${ u.uid }</td>
													<td>${ u.username }</td>
													<td>${ u.email }</td>
													<c:if test="${ u.status eq 0 }">
														<td>禁用</td>
													</c:if>
													<c:if test="${ u.status eq 1 }">
														<td>正常</td>
													</c:if>
													
													<td>${ u.permission.pname }</td>

													
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-md-4 column">
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="uid">禁用</label> <input
													type="text" class="form-control" id="uid"
													placeholder="UID" />
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="disable">禁用</button>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="enable">启用</button>
										</div>
									</div>
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="upuid">更改权限</label> 
												<input type="text" class="form-control" id="upuid"
													placeholder="ID" /> 
												<select class="form-control" id="pid">
													<option></option>
													<c:forEach items="${ per }" var="p">
														<option value="${ p.pid }">${ p.pname }</option>
													</c:forEach>
												</select>
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="upper">更改</button>
										</div>
									</div>

								</div>
							</div>
								<div class="tab-pane" id="panel-006">
									<div class="col-md-8 column">
									<table class="table table-condensed table-striped">
										<thead>
											<tr>
												<th>ID</th>
												<th>标题</th>
												<th>地址</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="address" items="${ addresss }">
												<tr>
													<td>${ address.did }</td>
													<td>${ address.title }</td>
													<td>${ address.address }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-md-4 column">
										<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="newaddress">添加</label> 
												<input type="text" class="form-control" id="newaddress" placeholder="新地址" />
												<input type="text" class="form-control" id="newtitle" placeholder="描述" />
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="addaddress">添加</button>
										</div>
									</div>
									<div class="row-md-3 row">
										<div role="form">
											<div class="form-group">
												<label for="upuid">升级友链</label> 
												<input type="text" class="form-control" id="did" placeholder="ID" /> 
												<input type="text" class="form-control" id="uptitle" placeholder="描述" />
												<input type="text" class="form-control" id="upaddress" placeholder="地址" /> 
											</div>
											<button type="submit"
												class="btn btn-block btn-primary btn-sm" id="upadd">更改</button>
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