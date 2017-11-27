<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chào mừng bạn tới Website Dating.com</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/JS/css/style_log.css" />
</head>
<body background="${pageContext.request.contextPath}/Images/bg.jpg">
	<div class="profile">
	<form >
		<fieldset>
			<legend>
				<span class="number">2</span>Thêm thông tin về bạn
			</legend>
			<span class="city">
				<label for="city">Tỉnh/Thành Phố:</label> 
				<input type="text" id="city" name="city"> 
			</span>
			<span class="job">
				<label for="job">Công việc:</label> 
				<input type="text" id="job" name="job"> 
			</span>
			
			<span><label for="status" id = "status">Châm ngôn tình yêu</label></span>
			<input type="text" id="status" name="status"> 
			<label for="introduction">Đôi nét về bản thân</label>
			<textarea id="introdction" name="introduction"></textarea>
		</fieldset>

		
	</form>
	<div>
		<fieldset>
			<a href="Registration.jsp">
				<button class="back" type="submit"> Quay lại</button>
			</a>
			<a href="#">
				<button class="regis" type="submit">Đăng ký</button>
			</a>
		</fieldset>
	</div>
	</div>
</body>
</html>