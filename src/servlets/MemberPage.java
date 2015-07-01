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
import core.Server;

/**
 * Servlet implementation class MemberPage
 */
@WebServlet("/MemberPage")
public class MemberPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPage() {
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
		String memberID = request.getParameter("memberID");
		Account member = db.getAccountByName(memberID);
		member.setVotedBy(db.getAllVotes(member.getUserName()));
		session.setAttribute("member", member);
		response.sendRedirect("memberPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
