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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dating.System.Database.Connect;
import Dating.User.Bean.*;;

/**
 * 2017/11/26
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/ListFriends")
public class ListFriends extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String search_name = " ";
	private String sex;
	private String year_from;
	private String year_to;
	private String city;
	private String user_name_login;
	private String user_type_login;

	private static Connection con;
	private static Statement st;

	private List<InfoUser> SearchUser(String search_name, String year_from, String year_to, String city)
			throws SQLException {
		List<InfoUser> listUser = new ArrayList<>();
		InfoUser infoUser = null;
		String sql = "SELECT user.full_name, info_user.birthday ,info_user.address, info_user.status "
				+ "FROM user JOIN info_user ON info_user.id_user = user.idUser WHERE user.full_name LIKE '%"
				+ search_name + "%' " + "OR info_user.address = '" + city + "' OR year(info_user.birthday) BETWEEN "
				+ year_from + " AND " + year_to;
		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			String full_name = rs.getString(1);
			Date birthday = rs.getDate(2);
			String address = rs.getString(3);
			String status = rs.getString(4);
			infoUser = new InfoUser(full_name, birthday, address, status);
			listUser.add(infoUser);
		}
		return listUser;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		search_name = req.getParameter("name");
		sex = req.getParameter("gender");
		year_from = req.getParameter("min_max");
		year_to = req.getParameter("min_old");
		city = req.getParameter("city");
		user_name_login = req.getParameter("user_name_login");
		user_type_login = req.getParameter("user_type_login");
		System.out.println(search_name + sex + year_from + year_to + city);
		List<InfoUser> listSearch = new ArrayList<>();
		try {
			con = Connect.getConnection();
			st = con.createStatement();
			listSearch = SearchUser(search_name, year_from, year_to, city);
			System.out.println("in sise : " + listSearch.size());
			req.setAttribute("size_result_search", listSearch.size());
			if (listSearch.size() != 0) {
				req.setAttribute("listSearch", listSearch);
			}
			req.setAttribute("result_search", "Tìm thấy : "+ listSearch.size()+ " kết quả.");
			req.setAttribute("user_name_login", user_name_login);
			req.setAttribute("user_type_login", user_type_login);
			req.getRequestDispatcher("./JSP/SearchUserOther.jsp").forward(req, resp);
			System.out.println("OK");
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}
}