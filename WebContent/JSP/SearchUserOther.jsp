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
<div id="container">
		<%
		int size_result_search = (int)request.getAttribute("size_result_search");
		String result_search = (String)request.getAttribute("result_search");
		String user_name_login = (String)request.getAttribute("user_name_login");
		String user_id_login = (String)request.getParameter("user_id_login");
		System.out.print("user_name_login " +user_name_login);
		String user_type_login = (String)request.getAttribute("user_type_login");
		System.out.print("user_type_login " +user_type_login);
		%>
		<div id="header" style="background: url('${pageContext.request.contextPath}/images/divider.jpg')">
    		<div id="login_box">
      			<a href="LogOut?idUser=">Log Out</a> 
      		</div>
  		</div>
	 	<div id="menu" style="background: url('${pageContext.request.contextPath}/images/menu_bg.jpg')">
    		<ul>
      			<li><a href="Login?user_name_login=<%=user_name_login+"&&user_id_login="+user_id_login+"&&user_type_login="+user_type_login+"&&action_to_home=back_home"%>" class="current">Trang Chủ</a></li>
      			<li><a href="ViewInfoUser?user_name_login=<%=user_name_login +"&&user_id_login=" + user_id_login+"&&user_type_login="+user_type_login+"&&view_info_me=true"%>"><%=user_name_login%></a></li>
      			<li><a href="#">Cuộc trò chuyện</a></li>
      			<li><a href="#">Đọc tin</a></li>
      			<li><a href="#">Bạn bè</a></li>
      			<li><a href="#">Về chúng tôi</a></li>
      			<li><a href="#"><% if(user_type_login.equals("admin"))%><%="Phân Quyền"%><%; %></a></li>
    		</ul>
  	</div>
  	<div id="content">
    <div id="content_left">
      <div class="content_left_section_01">
        <div class="welcome_title" style="background: url('./images/welcome_title.jpg') no-repeat;"></div>
    	   <p> <strong><%=result_search %></strong> </p>
      </div>
      <div class="cleaner_with_divider">&nbsp;</div>
      <div class="content_left_section_02">
         <% if(size_result_search!=0){
			List<InfoUser> infoUser = (List) request.getAttribute("listSearch");
		System.out.print("ok");%>
      <div class="latest_profile_title">Kết quả tìm được .</div>
			<%for(InfoUser info : infoUser ){%> 
        <div class="latest_profile_box"> <img src="${pageContext.request.contextPath}/images/avatar_man.jpg" alt="" />
          <div class="name"><%=info.getFull_name() %></div>
          Ngày sinh : <%=info.getBirthday() %><br />
          Địa chỉ   : <%=info.getAddress() %><br />
          Châm ngôn tình yêu   : <%=info.getStatus() %><br />
          <div class="readmore"><a href="ViewInfoUser?user_name_login=<%=user_name_login +"&&user_id_login=" + user_id_login+"&&user_type_login="+user_type_login+"&&view_info_me=false"+"&&search_user_name="+info.getFull_name()%>">Details &raquo;</a></div>
        </div>
        <div class="cleaner_with_width">&nbsp;</div>
        <span></span> 
        <% }
		}%></div>
      <!-- end of section 2 -->
    </div>

    <!-- end of content left -->
    <div id="content_right">
      <div id="templatmeo_quick_search">
        <h1>Tìm Kiếm Thành Viên</h1>
        <div class="form_container">
	  <form action="SearchUserOther?user_name_login=<%=user_name_login%>&&user_type_login=<%=user_type_login%>" method="post">
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
                <select class="gender" name="gender">
                  <option value="N">  ---Tất Cả---  </option>
				  <option value="Nữ">Nữ</option>
				  <option value="Nam">Nam</option>
                </select>
              </div>
            </div>
            <div class="search_row">
              <div class="search_column_1">
                <label>Năm sinh từ</label>
              </div>
              <div class="search_column_2" >	
              	<select class="gender" title="year" name="min_Max">
										<option value="2017">2017</option>
										<option value="2016">2016</option>
										<option value="2015">2015</option>
										<option value="2014">2014</option>
										<option value="2013">2013</option>
										<option value="2012">2012</option>
										<option value="2011">2011</option>
										<option value="2010">2010</option>
										<option value="2009">2009</option>
										<option value="2008">2008</option>
										<option value="2007">2007</option>
										<option value="2006">2006</option>
										<option value="2005">2005</option>
										<option value="2004">2004</option>
										<option value="2003">2003</option>
										<option value="2002">2002</option>
										<option value="2001">2001</option>
										<option value="2000">2000</option>
										<option value="1999">1999</option>
										<option value="1998">1998</option>
										<option value="1997">1997</option>
										<option value="1996">1996</option>
										<option value="1995">1995</option>
										<option value="1994">1994</option>
										<option value="1993">1993</option>
										<option value="1992">1992</option>
										<option value="1991">1991</option>
										<option value="1990" selected="1">1990</option>
										<option value="1989">1989</option>
										<option value="1988">1988</option>
										<option value="1987">1987</option>
										<option value="1986">1986</option>
										<option value="1985">1985</option>
										<option value="1984">1984</option>
										<option value="1983">1983</option>
										<option value="1982">1982</option>
										<option value="1981">1981</option>
										<option value="1980">1980</option>
										<option value="1979">1979</option>
										<option value="1978">1978</option>
										<option value="1977">1977</option>
										<option value="1976">1976</option>
										<option value="1975">1975</option>
										<option value="1974">1974</option>
										<option value="1973">1973</option>
										<option value="1972">1972</option>
										<option value="1971">1971</option>
										<option value="1970">1970</option>
										<option value="1969">1969</option>
										<option value="1968">1968</option>
										<option value="1967">1967</option>
										<option value="1966">1966</option>
										<option value="1965">1965</option>
										<option value="1964">1964</option>
										<option value="1963">1963</option>
										<option value="1962">1962</option>
										<option value="1961">1961</option>
										<option value="1960">1960</option>
										<option value="1959">1959</option>
										<option value="1958">1958</option>
										<option value="1957">1957</option>
										<option value="1956">1956</option>
										<option value="1955">1955</option>
										<option value="1954">1954</option>
										<option value="1953">1953</option>
										<option value="1952">1952</option>
										<option value="1951">1951</option>
										<option value="1950">1950</option>
										<option value="1949">1949</option>
										<option value="1948">1948</option>
										<option value="1947">1947</option>
										<option value="1946">1946</option>
										<option value="1945">1945</option>
										<option value="1944">1944</option>
										<option value="1943">1943</option>
										<option value="1942">1942</option>
										<option value="1941">1941</option>
										<option value="1940">1940</option>
										<option value="1939">1939</option>
										<option value="1938">1938</option>
										<option value="1937">1937</option>
										<option value="1936">1936</option>
										<option value="1935">1935</option>
										<option value="1934">1934</option>
										<option value="1933">1933</option>
										<option value="1932">1932</option>
										<option value="1931">1931</option>
										<option value="1930">1930</option>
										<option value="1929">1929</option>
										<option value="1928">1928</option>
										<option value="1927">1927</option>
										<option value="1926">1926</option>
										<option value="1925">1925</option>
										<option value="1924">1924</option>
										<option value="1923">1923</option>
										<option value="1922">1922</option>
										<option value="1921">1921</option>
										<option value="1920">1920</option>
										<option value="1919">1919</option>
										<option value="1918">1918</option>
										<option value="1917">1917</option>
										<option value="1916">1916</option>
										<option value="1915">1915</option>
										<option value="1914">1914</option>
										<option value="1913">1913</option>
										<option value="1912">1912</option>
										<option value="1911">1911</option>
										<option value="1910">1910</option>
										<option value="1909">1909</option>
										<option value="1908">1908</option>
										<option value="1907">1907</option>
										<option value="1906">1906</option>
										<option value="1905">1905</option></select>			
                <label class="seeking">Tới</label>
                <select class="gender" title="year" name="min_old">
										<option value="2017">2017</option>
										<option value="2016">2016</option>
										<option value="2015">2015</option>
										<option value="2014">2014</option>
										<option value="2013">2013</option>
										<option value="2012">2012</option>
										<option value="2011">2011</option>
										<option value="2010" selected="1">2010</option>
										<option value="2009">2009</option>
										<option value="2008">2008</option>
										<option value="2007">2007</option>
										<option value="2006">2006</option>
										<option value="2005">2005</option>
										<option value="2004">2004</option>
										<option value="2003">2003</option>
										<option value="2002">2002</option>
										<option value="2001">2001</option>
										<option value="2000">2000</option>
										<option value="1999">1999</option>
										<option value="1998">1998</option>
										<option value="1997">1997</option>
										<option value="1996">1996</option>
										<option value="1995">1995</option>
										<option value="1994">1994</option>
										<option value="1993">1993</option>
										<option value="1992">1992</option>
										<option value="1991">1991</option>
										<option value="1990">1990</option>
										<option value="1989">1989</option>
										<option value="1988">1988</option>
										<option value="1987">1987</option>
										<option value="1986">1986</option>
										<option value="1985">1985</option>
										<option value="1984">1984</option>
										<option value="1983">1983</option>
										<option value="1982">1982</option>
										<option value="1981">1981</option>
										<option value="1980">1980</option>
										<option value="1979">1979</option>
										<option value="1978">1978</option>
										<option value="1977">1977</option>
										<option value="1976">1976</option>
										<option value="1975">1975</option>
										<option value="1974">1974</option>
										<option value="1973">1973</option>
										<option value="1972">1972</option>
										<option value="1971">1971</option>
										<option value="1970">1970</option>
										<option value="1969">1969</option>
										<option value="1968">1968</option>
										<option value="1967">1967</option>
										<option value="1966">1966</option>
										<option value="1965">1965</option>
										<option value="1964">1964</option>
										<option value="1963">1963</option>
										<option value="1962">1962</option>
										<option value="1961">1961</option>
										<option value="1960">1960</option>
										<option value="1959">1959</option>
										<option value="1958">1958</option>
										<option value="1957">1957</option>
										<option value="1956">1956</option>
										<option value="1955">1955</option>
										<option value="1954">1954</option>
										<option value="1953">1953</option>
										<option value="1952">1952</option>
										<option value="1951">1951</option>
										<option value="1950">1950</option>
										<option value="1949">1949</option>
										<option value="1948">1948</option>
										<option value="1947">1947</option>
										<option value="1946">1946</option>
										<option value="1945">1945</option>
										<option value="1944">1944</option>
										<option value="1943">1943</option>
										<option value="1942">1942</option>
										<option value="1941">1941</option>
										<option value="1940">1940</option>
										<option value="1939">1939</option>
										<option value="1938">1938</option>
										<option value="1937">1937</option>
										<option value="1936">1936</option>
										<option value="1935">1935</option>
										<option value="1934">1934</option>
										<option value="1933">1933</option>
										<option value="1932">1932</option>
										<option value="1931">1931</option>
										<option value="1930">1930</option>
										<option value="1929">1929</option>
										<option value="1928">1928</option>
										<option value="1927">1927</option>
										<option value="1926">1926</option>
										<option value="1925">1925</option>
										<option value="1924">1924</option>
										<option value="1923">1923</option>
										<option value="1922">1922</option>
										<option value="1921">1921</option>
										<option value="1920">1920</option>
										<option value="1919">1919</option>
										<option value="1918">1918</option>
										<option value="1917">1917</option>
										<option value="1916">1916</option>
										<option value="1915">1915</option>
										<option value="1914">1914</option>
										<option value="1913">1913</option>
										<option value="1912">1912</option>
										<option value="1911">1911</option>
										<option value="1910">1910</option>
										<option value="1909">1909</option>
										<option value="1908">1908</option>
										<option value="1907">1907</option>
										<option value="1906">1906</option>
										<option value="1905">1905</option></select>		
				<label class="seeking"></label>
              </div>
            </div>
            <div class="search_row">
              <div class="search_column_1">
                <label>Tỉnh/Thành Phố</label>
              </div>
              <div class="search_column_2">
                <select class="dob" name="city">
                <option value="0">--Tất cả---</option>
				 <option value="Đà Nẵng">Đà Nẵng</option>
				  <option value="Đà Nẵng">Quảng Bình</option>
				  <option value="Đà Nẵng">Hà Nội</option>
				  <option>Huế</option>
				  <option>Quảng Nam</option>
				  <option>Cần Thơ</option>
				  <option>TP Hồ Chí Minh</option>
				  <option>Hà Tĩnh</option>
				  <option>Hải Phòng</option>
				  <option>Quảng Quảng</option>
				  <option>Cà Mau</option>
				  <option>Cần Thơ</option>
                </select>
                
              </div>
            </div>

            <div class="search_row last">
              <div class="search_column_1">&nbsp;</div>
              <div class="search_column_2">
                <input type="submit" class="search_btn" value = "Tìm Kiếm" />
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