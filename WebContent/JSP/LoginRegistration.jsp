<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Chào mừng bạn tới Website Dating.com</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/JS/css/style_log.css" />
</head>
<body background="${pageContext.request.contextPath}/Images/bg.jpg">
	<div class="login">
	<form method="post" action="Login">
		<fieldset>
		<h1>Đăng nhập</h1>
			<label for="name">Tên Đăng Nhập:</label> 
			<input type="text" id="name" name="name"> 
			<label for="password">Mật khẩu:</label> 
			<input type="password" id="password" name="password"> 
		<button class="sm_login" type="submit">Đăng Nhập</button>
				</fieldset>
	</form>
	<div>
		<fieldset>
			<label for="name">Chưa phải là thành viên ?? </label> 
			<a href="${pageContext.request.contextPath}/JSP	/Registration.jsp">
				<button class="sm_regis">Đăng ký</button>
			</a>
			
	</fieldset>
	</div>
	
	</div>
</body>
</html>