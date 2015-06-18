package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Account;
import core.DataBase;
import core.Server;

/**
 * Servlet implementation class SaveData
 */
@WebServlet("/SaveData")
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Server serv = (Server) request.getServletContext().getAttribute("server");
		DataBase db = serv.getDB();
		Account current = (Account) request.getSession().getAttribute("account");
		String nickname = checkString(request.getParameter("nickname"));
		String mail = checkString(request.getParameter("mail"));
		String fb = checkString(request.getParameter("facebook"));
		String gplus = checkString(request.getParameter("gplus"));
		current.setNickName(nickname);
		current.setMail(mail);
		current.setFacebook(fb);
		current.setGplus(gplus);
		db.updateAccount(current);
		request.getSession().removeAttribute("account");
		request.getSession().setAttribute("accountID", current.getUserName());
		response.sendRedirect("Settings");
	}

	private String checkString(String parameter) {
		if (!parameter.equals("Not Specified")) return parameter;
		return "";
	}

}
