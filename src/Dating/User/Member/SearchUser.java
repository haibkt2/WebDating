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
@WebServlet("/SearchUserOther")
public class SearchUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String search_name=" ";
	private String sex;
	private String year_from ;
	private String year_to;
	private String city;
	private String status;
	private static Connection con;
	private static Statement st;

	private InfoUser LoadDbUser(String user_name) throws SQLException {
		InfoUser infoUser = null;
		String sql = "SELECT user.idUser,user.full_name,user.type, info_user.weight,info_user.height,info_user.birthday,info_user.sex,info_user.address,info_user.mail,info_user.job,info_user.status,info_user.introduction,info_user.on_off,info_user.religion FROM user JOIN info_user ON info_user.id_user = user.idUser WHERE user.full_name=\""
				+ user_name + "\"";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			String idUser = rs.getString(1);
			String full_name = rs.getString(2);
			String type = rs.getString(3);
			String weight = rs.getString(4);
			String height = rs.getString(5);
			Date birthday = rs.getDate(6);
			String sex = rs.getString(7);
			String address = rs.getString(8);
			String mail = rs.getString(9);
			String job = rs.getString(10);
			String status = rs.getString(11);
			String introdution = rs.getString(12);
			int on_off = rs.getInt(13);
			String religion = rs.getString(14);
			infoUser = new InfoUser(idUser, full_name, type, weight, height, birthday, sex, address, mail, job, status,
					introdution, on_off, religion);
		}

		return infoUser;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		search_name = req.getParameter("name");
		sex = req.getParameter("gender");
		year_from = req.getParameter("min_max");
		year_to = req.getParameter("min_old");
		city = req.getParameter("city");
		try {
			con = Connect.getConnection();
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			try {
				System.out.println("hihi");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}