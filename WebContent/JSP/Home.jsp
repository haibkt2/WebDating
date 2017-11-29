<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Dating.User.Bean.InfoUser" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/JS/css/style_page.css" rel="stylesheet" />
<title>Chào mừng bạn đã tới với Website Dating.com</title>
</head>
<body>
		<%
				InfoUser infoUser = (InfoUser) request.getAttribute("infoUser");	
		%>
<div id="container">
		
		<div id="header" style="background: url('${pageContext.request.contextPath}/images/divider.jpg')">
    		<div id="login_box">
      			<a href="LogOut?idUser=<%=infoUser.getId_user()%>">Log Out</a> 
      		</div>
  		</div>
	 	<div id="menu" style="background: url('${pageContext.request.contextPath}/images/menu_bg.jpg')">
    		<ul>
      			<li><a href="#" class="current">Trang Chủ</a></li>
      			<li><a href="#"><%=infoUser.getFull_name()%></a></li>
      			<li><a href="#">Cuộc trò chuyện</a></li>
      			<li><a href="#">Đọc tin</a></li>
      			<li><a href="#">Bạn bè</a></li>
      			<li><a href="#">Về chúng tôi</a></li>
      			<li><a href="#"><% if(infoUser.getType().equals("admin"))%><%="Phân Quyền"%><%; %></a></li>
    		</ul>
  	</div>
  	<div id="content">
    <div id="content_left">
      <div class="content_left_section_01">
        <div class="welcome_title" style="background: url('./images/welcome_title.jpg') no-repeat;"></div>
        <p> The <strong>Dating Agency</strong> web template is provided by TemplateMo.com. You may download, edit and use this template layout for your websites. Credit goes to Photovaco.com for photos used in this template. </p>
        <p> Nulla et nunc commodo ante ornare imperdiet. Donec nunc neque, pulvinar a, vestibulum eget, luctus id, orci. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque elementum enim a augue. Donec in nisi. </p>
      </div>
      <div class="cleaner_with_divider">&nbsp;</div>
      <div class="content_left_section_02">
        <div class="latest_profile_title">Có thể bạn biết ??</div>
        <div class="latest_profile_box"> <img src="${pageContext.request.contextPath}/images/avatar_man.jpg" alt="" />
          <div class="name">Donec a purus vel</div>
          Age: 18<br />
          Mauris pede nisl, placerat nec, lobortis vitae.<br />
          <div class="readmore"><a href="#">Details &raquo;</a></div>
        </div>
        <div class="cleaner_with_width">&nbsp;</div>
        <div class="latest_profile_box"> <img src="${pageContext.request.contextPath}/images/avatar_woman.jpg" alt="" />
          <div class="name">Sed pellentesque</div>
          Age: 24<br />
          Suspendisse ac magna quis est eleifend dictum.<br />
          <div class="readmore"><a href="#">Details &raquo;</a></div>
        </div>
        <div class="cleaner_with_height">&nbsp;</div>
        <div class="latest_profile_box"> <img src="${pageContext.request.contextPath}/images/avatar_man.jpg" alt="" />
          <div class="name">Sed justo dolor</div>
          Age: 22<br />
          Morbi nec magna pulvinar mi scelerisque posuere.<br />
          <div class="readmore"><a href="#">Details &raquo;</a></div>
        </div>
        <div class="cleaner_with_width">&nbsp;</div>
        <div class="latest_profile_box"> <img src="${pageContext.request.contextPath}/images/avatar_woman.jpg" alt="" />
          <div class="name">Quisque ut odio</div>
          Age: 20<br />
          Fusce non lacus et lorem ornare interdum.<br />
          <div class="readmore"><a href="#">Details &raquo;</a></div>
        </div>
        <div class="cleaner">&nbsp;</div>
        <span></span> </div>
      <!-- end of section 2 -->
    </div>
    <!-- end of content left -->
    <div id="content_right">
      <div id="templatmeo_quick_search">
        <h1>Tìm Kiếm Thành Viên</h1>
        <div class="form_container">
	  <form action="#" method="get">
            <fieldset>
			<div class="search_row">
              <div class="search_column_1">
                <label>Tên</label>
              </div>
              <div class="search_column_2">
               <input class="name" type="text" name="name" value="" />
              </div>
            </div>
            <div class="search_row">
              <div class="search_column_1">
                <label>Giới Tính</label>
              </div>
              <div class="search_column_2">
                <select class="gender">
                  <option>  ---Tất Cả---  </option>
				  <option>Nữ</option>
				  <option>Nam</option>
                </select>
              </div>
            </div>
            <div class="search_row">
              <div class="search_column_1">
                <label>Độ tuổi từ</label>
              </div>
              <div class="search_column_2" >				
                 <input class="gender" type="text" name="min_old" value="" />
                <label class="seeking">Tới</label>
                <input class="gender" type="text" name="max_old" value="" />
				<label class="seeking">Tuổi</label>
              </div>
            </div>
            <div class="search_row">
              <div class="search_column_1">
                <label>Tỉnh/Thành Phố</label>
              </div>
              <div class="search_column_2">
                <select class="dob">
				 <option value ="0">  ---Tất Cả---  </option>
                  <option>Đà Nẵng</option>
				  <option>Quảng Bình</option>
				  <option>Hà Nội</option>
				  <option>Huế</option>
				  <option>Quảng Nam</option>
				  <option>Cần Thơ</option>
                </select>
                
              </div>
            </div>

            <div class="search_row last">
              <div class="search_column_1">&nbsp;</div>
              <div class="search_column_2">
                <input type="button" class="search_btn" value = "Tìm Kiếm" />
              </div>
            </div>
            </fieldset>
          </form>
		  
		  </div>
        <div class="cleaner">&nbsp;</div>
        <span></span> </div>
      <!-- end of quick search -->
      <div class="content_right_section">
        <h1>Bài viết mới nhất</h1>
        <img src="./images/image_01.jpg" alt="" />
        <h2>Vestibulum auctor odio eget</h2>
        <p>Quisque dictum pharetra neque. Aliquam pretium porta odio. Fusce quis diam sit amet tortor luctus pellentesque. </p>
        <a href="#" class="readmore">Read more &raquo;</a> </div>
    </div>
    <!-- end of content right -->
    <div class="cleaner_with_height">&nbsp;</div>
  </div>
  <!-- end of content -->
  <div id="footer">
    </div>
  <!-- end of footer -->
	</div>
</body>
</html>