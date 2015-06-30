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
import core.Room;
import core.Server;

/**
 * Servlet implementation class LeaveRoom
 */
@WebServlet("/LeaveRoom")
public class LeaveRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Room room = (Room) session.getAttribute("room");
		Category cat = (Category) session.getAttribute("category");
		Account acc = (Account) session.getAttribute("account");
		session.removeAttribute("room");
		session.removeAttribute("category");
		if (session.getAttribute("spectAccountID") != null) {
			response.sendRedirect("RoomList?category=" + cat.getID());
			return;
		}
		room.removeMember(acc);
		session.setAttribute("accountID", acc.getUserName());
		response.sendRedirect("RoomList?category=" + cat.getID());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
