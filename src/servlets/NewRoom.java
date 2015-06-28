package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.Account;
import core.Category;
import core.DataBase;
import core.Server;

/**
 * Servlet implementation class NewRoom
 */
@WebServlet("/NewRoom")
public class NewRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRoom() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Server serv = (Server)request.getServletContext().getAttribute("server");
        DataBase db = serv.getDB();
        HttpSession ses = request.getSession();
        String userName = (String) ses.getAttribute("accountID");
        Account acc = db.getAccountByName(userName);
        String catName = request.getParameter("category");
        Category cat = db.getCategoryByID(Integer.parseInt(catName));
        if(cat == null) response.sendRedirect("generic.jsp");
        HashMap<String, Category> categories = serv.getCategoryList();
        if(!categories.containsKey(catName)) {
        	categories.put(catName, cat);
        } else {
        	cat = categories.get(catName);
        }
        cat.addRoom();
        ses.setAttribute("account", acc);
        ses.setAttribute("category", cat);
        response.sendRedirect("roomList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
