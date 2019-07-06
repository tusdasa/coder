<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>登录</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="css/fonts.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					登录 
				</h1>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div style="width: 1200px;height: 100px;"></div>
	</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
		</div>
		<div class="col-md-3 column">
			<c:if test="${ info ne null }">
				<div class="alert alert-dismissable alert-warning" id="info">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					<strong style="text-align: center;">${ info }</strong>
				</div>
			</c:if>
			<form role="form" action="login" method="post" onsubmit="return check();">
						<div class="form-group">
							 <label for="text">电子邮件/手机号/用户名</label>
							 <input type="text" class="form-control" id="text" name="text" />
						</div>
						<div class="form-group">
							 <label for="password">密码</label>
							 <input type="password" class="form-control" id="password" name="password" />
						</div>
						<div class="form-group">
							 <label for="password">验证码</label>
							 <div class="row clearfix">
							 	<div class="col-md-4 column">
							 		<input type="text" class="form-control" id="code" name="code" />
								</div>
								<div class="col-md-4 column">
									<img alt="code" src="code">
								</div>
							 </div>
						</div>
						<button type="submit" class="btn btn-block btn-sm btn-primary">登录</button>
					</form>
		</div>
		<div class="col-md-5 column">
		</div>
	</div>
	<script type="text/javascript">
	function check(){
		if($("#text").val()!="" && $("#password").val()!="" && $("#code").val()!=null){
			return true;
		}else{
			return false;
		}
	}
	</script>
</div>
</body>
</html>