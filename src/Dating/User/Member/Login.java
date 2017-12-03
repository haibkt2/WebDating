/**
 * 
 */
package Dating.User.Member;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
import Dating.User.Bean.*;;

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
	private String type;
	private String id_user;
	private int on = 1;
	private static Connection con;
	private static Statement st;
	private String action_to_home;

	private boolean Login(String name, String pass) throws SQLException {
		boolean check_login = true;
		String sql = "SELECT user.idUser,user.type FROM user WHERE full_name = \"" + name + "\" && password = \"" + pass
				+ "\" ";
		ResultSet rs = st.executeQuery(sql);
		if (!rs.next()) {
			check_login = false;
		} else {
			id_user = rs.getString(1);
			type = rs.getString(2);

		}
		return check_login;
	}

	public void ChangeOnOff(String id_user, int on_off) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE info_user SET on_off = " + on_off + " WHERE id_user =\"" + id_user + "\" ";
		Connection con = Connect.getConnection();
		Statement st = con.createStatement();
		st.executeUpdate(sql);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		action_to_home = req.getParameter("action_to_home");
		if (!action_to_home.equals("Login")) {
			String name_logged = req.getParameter("user_name_login");
			String id_logged = req.getParameter("user_id_login");
			String type_logged = req.getParameter("user_type_login");
			System.out.println("hi");
			req.getRequestDispatcher("./JSP/Home.jsp?user_name_login=" + name_logged + "&&user_id_login=" + id_logged
					+ "&&user_type_login=" + type_logged).forward(req, resp);
		} else {
			try {
				con = Connect.getConnection();
				st = con.createStatement();
				full_name = req.getParameter("name");
				password = req.getParameter("password");
				System.err.println(action_to_home);
				if (Login(full_name, password)) {
					ChangeOnOff(id_user, on);
					System.out.println(1);
					System.out.println(2);
					req.setAttribute("action_user", "UserLogin");
					req.getRequestDispatcher("./JSP/Home.jsp?user_name_login=" + full_name + "&&user_id_login="
							+ id_user + "&&user_type_login=" + type).forward(req, resp);
				} else {
					req.setAttribute("mess", "Tên đăng nhập hoặc mật khẩu không đúng");
					req.getRequestDispatcher("./JSP/LoginRegistration.jsp").forward(req, resp);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}