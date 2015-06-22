package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import core.Account;
import core.Category;
import core.DataBase;
import core.Server;

/**
 * Servlet implementation class RoomList
 */
@WebServlet("/RoomList")
public class RoomList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Server serv = (Server)request.getServletContext().getAttribute("server");
		DataBase db = serv.getDB();
		HttpSession ses = request.getSession();
		String userName = (String) ses.getAttribute("accountID");
		Account acc = db.getAccountByName(userName);
		String catName = request.getParameter("category");
		Category cat = db.getCategoryByName(catName);
		HashMap<String, Category> categories = serv.getCategoryList();
		
		if(!categories.containsKey(catName)) {
			if(cat == null) response.sendRedirect("generic.jsp");
			categories.put(catName, cat);
		} 
		
		ses.setAttribute("account", acc);
		ses.setAttribute("category", cat);
		response.sendRedirect("roomList.jsp");
		
	}

}
