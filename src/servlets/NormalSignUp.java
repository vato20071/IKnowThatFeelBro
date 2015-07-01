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
 * Servlet implementation class NormalSignUp
 */
@WebServlet("/NormalSignUp")
public class NormalSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NormalSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		chooseAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		chooseAction(request, response);
	}

	private void chooseAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Server serv = (Server) request.getSession().getServletContext().getAttribute("server");
		String name = request.getParameter("reg_username");
		DataBase db = serv.getDB();
		if (db.getAccountByName(name) != null) {
			System.out.println("Account already registered, please choose the other one");
			response.sendRedirect("usernameExists.jsp");
		} else {
			String nick = request.getParameter("reg_nickname");
			String password = request.getParameter("reg_pass");
			if (password == null) password = new String(name);
			MessageDigest m;
			String pass = "";
			try {
				m = MessageDigest.getInstance("SHA");
				pass = DataBase.hexToString(m.digest(password.getBytes()));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			Account newOne = new Account();
			newOne.setUserName(name);
			newOne.setNickName(nick);
			newOne.setPassword(pass);
			serv.addNewUser(newOne);
			request.getSession().setAttribute("accountID", name);
			response.sendRedirect("generic.jsp");
		}
	}

}
