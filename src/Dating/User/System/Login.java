/**
 * 
 */
package Dating.User.System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
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
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String full_name;
	private String password;
	public static String mess="";

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
		full_name = req.getParameter("name");
		password = req.getParameter("password");
		System.out.println(full_name + " " + password);
		try {
			if (Login(full_name, password)) {
				req.getRequestDispatcher("./JSP/test.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("mess", mess);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
