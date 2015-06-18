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
 * Servlet implementation class FriendSearch
 */
@WebServlet("/FriendSearch")
public class FriendSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Server serv = (Server) request.getSession().getServletContext().getAttribute("server");
		DataBase db = serv.getDB();
		Account cur = db.getAccountByName((String) request.getSession().getAttribute("accountID"));
		String name = request.getParameter("search");
		if(cur.containsFriend(name))
			response.sendRedirect("friend.jsp");
		else
			response.sendRedirect("generic.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
