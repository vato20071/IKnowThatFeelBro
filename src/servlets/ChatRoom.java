package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.Account;
import core.Category;
import core.DataBase;
import core.Room;
import core.Server;

/**
 * Servlet implementation class ChatRoom
 */
@WebServlet("/ChatRoom")
public class ChatRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Server serv = (Server) request.getServletContext().getAttribute("server");
		DataBase db = serv.getDB();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("accountID");
        Account acc = db.getAccountByName(userName);
        String catName = request.getParameter("category");
        Category cat = db.getCategoryByID(Integer.parseInt(catName));
        if (cat == null) {
        	response.sendRedirect("generic.jsp");
        	return;
        }
        cat = serv.getCategoryList().get("" + cat.getID());
        if (cat == null) {
        	response.sendRedirect("generic.jsp");
        	return;
        }
        String roomName = request.getParameter("roomID");
        Room current = cat.getRoomList().get(Integer.parseInt(roomName)-1);
        if(userName != null)
        	current.addMember(acc);
        session.setAttribute("category", cat);
        session.setAttribute("account", acc);
        session.setAttribute("room", current);
        response.sendRedirect("chatRoom.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
