package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.Account;
import core.DataBase;
import core.Notification;
import core.Server;

/**
 * Servlet implementation class Invite
 */
@WebServlet("/Invite")
public class Invite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Invite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses= request.getSession();
		Account curr=(Account)ses.getAttribute("account");
		Server serv = (Server)request.getServletContext().getAttribute("server");
        DataBase db = serv.getDB();
		
		
		String userName=request.getParameter("friendname");
		String category=request.getParameter("category");
		String number=request.getParameter("number");
		Account friend=db.getAccountByName(userName);
		System.out.println(userName);
		Notification newOne = new Notification();
		newOne.setMessage(curr.getNickName()+" invited you to category : "+category +" room number "+number);
		newOne.setType(1);
		friend.addNotification(curr.getNickName()+" invited you to category : "+category +" room number "+number);
		db.addNotification(userName, newOne);
		response.sendRedirect("chatRoom.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
