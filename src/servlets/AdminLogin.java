package servlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Account;
import core.DataBase;
import core.Server;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int ADMIN_NUM = 1;
	private static final int TOKEN = 121314;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Server serv = (Server) request.getSession().getServletContext().getAttribute("server");
		String name = request.getParameter("username");
		DataBase db = serv.getDB();
		Account acc = db.getAccountByName(name); 
		int amount = db.getTotalAccount();
		int online = serv.getCountActiveUsers();
		if (acc != null && db.getAccountByName(name).getStatus() == ADMIN_NUM) {
			String offeredPassword = request.getParameter("password");
			MessageDigest m;
			try {
				m = MessageDigest.getInstance("SHA");
				offeredPassword = DataBase.hexToString(m.digest(offeredPassword
						.getBytes()));
				String realPassword = acc.getPassword();
				try {
					if (offeredPassword.equals(realPassword)) {
						request.getSession().setAttribute("adminLet", TOKEN);
						request.getSession().setAttribute("amount", amount);
						request.getSession().setAttribute("online", online);
						request.getSession().setAttribute("alreadyLogged",
								"universal");
						response.sendRedirect("adminLoggedIn.jsp");
					} else {
						response.sendRedirect("adminLogError.jsp");
					}
				} catch (Exception ex) {

				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("adminLogError.jsp");
		} 
	}

}
