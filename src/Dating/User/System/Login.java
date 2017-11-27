/**
 * 
 */
package Dating.User.System;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dating.System.Database.Connect;

/**
 * 2017/11/26
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String full_name;
	private String password;
	public static String mess="";
	@Override
    public void init(FilterConfig filterConfig)
            throws ServletException {

    }
	private boolean Login(String name, String pass) throws ClassNotFoundException, SQLException {
		boolean check_login = true;
		Connection con = Connect.getConnection();
		String sql = "SELECT info_user.full_name FROM info_user WHERE full_name = \""+name+"\" && password = \""+pass+"\" ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(!rs.next()){
			check_login = false;
			mess="Tên đăng nhập hoặc mật khẩu không đúng";
		}
		return check_login;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		full_name = req.getParameter("name");
		byte[] bytes = full_name.getBytes(StandardCharsets.ISO_8859_1);
		full_name = new String(bytes, StandardCharsets.UTF_8);
		password = req.getParameter("password");
		System.out.println(full_name + " " + password);
		try {
			if (Login(full_name, password)) {
				req.getRequestDispatcher("./JSP/test.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("mess", mess);
				System.out.println(mess);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //Set character encoding as UTF-8
        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, response);
    }
	@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html; charset=UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
