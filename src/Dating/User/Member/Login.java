/**
 * 
 */
package Dating.User.Member;

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
import javax.servlet.http.HttpSession;

import Dating.System.Database.Connect;

/**
 * 2017/11/26
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String full_name;
	private String password;
	private String type;
	private boolean Login(String name, String pass) throws ClassNotFoundException, SQLException {
		boolean check_login = true;
		Connection con = Connect.getConnection();
		String sql = "SELECT user.full_name,user.type FROM user WHERE full_name = \""+name+"\" && password = \""+pass+"\" ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(!rs.next()){
			check_login = false;
		}
		else type= rs.getString(2);
		return check_login;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		full_name = req.getParameter("name");
		byte[] bytes = full_name.getBytes(StandardCharsets.ISO_8859_1);
		full_name = new String(bytes, StandardCharsets.UTF_8);
		password = req.getParameter("password");
		req.setAttribute("mess", " ");
		req.setAttribute("type", " ");
		try {
			if (Login(full_name, password)) {
				if(type.equals("admin")){
					req.setAttribute("type", "Phân quyền");
				}
				req.setAttribute("user_name", full_name);
				req.getRequestDispatcher("./JSP/Home.jsp").forward(req, resp);
				session.invalidate();
			}
			else {
				req.setAttribute("mess", "Tên đăng nhập hoặc mật khẩu không đúng");
				req.getRequestDispatcher("./JSP/LoginRegistration.jsp").forward(req, resp);
				session.invalidate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
