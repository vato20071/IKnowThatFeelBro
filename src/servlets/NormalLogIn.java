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
 * Servlet implementation class NormalLogIn
 */
@WebServlet("/NormalLogIn")

public class NormalLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NormalLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		Server serv = (Server)request.getServletContext().getAttribute("server");
		DataBase db = serv.getDB();
		String name = request.getParameter("log_user");
		Account acc = db.getAccountByName(name);
		if(acc != null) {
			acc.setFriendMap(db.getAllFriends(name));
			String offeredPassword = request.getParameter("log_pass");
			String realPasswordHash = acc.getPassword();
			MessageDigest m;
			String offeredPasswordHash = "";
			try {
				m = MessageDigest.getInstance("SHA");
				offeredPasswordHash = DataBase.hexToString(m.digest(offeredPassword.getBytes()));
				if(offeredPasswordHash.equals(realPasswordHash)) {
					request.getSession().setAttribute("accountID", acc.getUserName());
					response.sendRedirect("generic.jsp");					
				} else {
					response.sendRedirect("incorrectInfo.jsp");
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
		} else {
			response.sendRedirect("incorrectInfo.jsp");
		}
	}
}
