package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Messages;
import Model.User;
import Repository.UserManagement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManagement usermanagement;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		usermanagement = new UserManagement();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = usermanagement.getUser(username, password);
		if ((username.equals("admin")) && (password.equals("admin")))
			response.sendRedirect("Admin");
		else if (u == null) {
			Messages message = new Messages(1, "username or password wrong !");
			request.setAttribute("message", message);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			response.sendRedirect("profil.jsp");
		}

	}

}
