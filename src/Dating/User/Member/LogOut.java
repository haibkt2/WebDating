/**
 * 
 */
package Dating.User.Member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2017/11/26
 * 
 * @author HaiRBk
 *
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int off = 0;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idUser =  req.getParameter("idUser");
		System.out.println("name is " + idUser);
		try {
			Login logout = new Login();
			logout.ChangeOnOff(idUser,off);
			req.getRequestDispatcher("./JSP/LoginRegistration.jsp").forward(req, resp);
		} catch (SQLException e) {
			System.out.println("Change on_off err");
		} catch (ClassNotFoundException e) {
			System.out.println("Change on_off err");
			e.printStackTrace();
		}
	}
}
