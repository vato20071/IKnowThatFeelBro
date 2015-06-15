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
		DataBase dt = new DataBase();
		String name = request.getParameter("reg_username");
		System.out.println(name);
		if (dt.getAccountByName(name) != null) {
			// TODO
		} else {
			String nick = request.getParameter("reg_nickname");
			String password = request.getParameter("reg_pass");
			MessageDigest m;
			String pass = "";
			try {
				m = MessageDigest.getInstance("SHA");
				pass = m.digest(password.getBytes()).toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			Account newOne = new Account();
			newOne.setUserName(name);
			newOne.setNickName(nick);
			newOne.setPassword(pass);
			dt.insertDataIntoAccount(newOne);
			request.getSession().setAttribute("account", newOne);
			response.sendRedirect("generic.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase dt = new DataBase();
		String name = request.getParameter("reg_username");
		if (dt.getAccountByName(name) != null) {
			// TODO
		} else {
			String nick = request.getParameter("reg_nickname");
			String password = request.getParameter("reg_pass");
			if (password == null) password = new String(name);
			MessageDigest m;
			String pass = "";
			try {
				m = MessageDigest.getInstance("SHA");
				pass = m.digest(password.getBytes()).toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			Account newOne = new Account();
			newOne.setUserName(name);
			newOne.setNickName(nick);
			newOne.setPassword(pass);
			dt.insertDataIntoAccount(newOne);
			request.getSession().setAttribute("account", newOne);
			response.sendRedirect("generic.jsp");
		}
	}

}
