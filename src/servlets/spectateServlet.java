package servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import core.Account;
import core.DataBase;
import core.Server;

/**
 * Servlet implementation class spectateServlet
 */
@WebServlet("/spectateServlet")
public class spectateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public spectateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random r = new Random();
		String spectId;
		spectId = r.nextInt((int)Math.pow(2,31))+"";
		request.getSession().setAttribute("spectAccountID", spectId);
		request.getSession().setAttribute("name", "Guest Spectator");
		response.sendRedirect("spectCategories.jsp");
	}
}
