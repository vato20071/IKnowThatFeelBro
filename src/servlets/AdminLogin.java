package servlets;

import java.io.IOException;
import java.security.MessageDigest;

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
		System.out.print(name+" ");
		DataBase db = serv.getDB();
		Account acc = db.getAccountByName(name); 
		if (acc != null && db.getAccountByName(name).getStatus() == ADMIN_NUM) {
			String offeredPassword = request.getParameter("password");
			String realPassword = acc.getPassword();
			try {
				if(offeredPassword.equals(realPassword)) {
					serv.incActiveUsers();
					response.sendRedirect("adminLoggedIn.jsp");
				} else {
					response.sendRedirect("adminLogError.jsp");
				}
			} catch(Exception ex){
				
			}
		} 
	}

}
