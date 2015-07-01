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
 * Servlet implementation class VoteForUser
 */
@WebServlet("/VoteForUser")
public class VoteForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteForUser() {
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
		String newVote = request.getParameter("rating");
		int voteNumber = Integer.parseInt(newVote);
		HttpSession session = request.getSession();
		Account current = (Account) session.getAttribute("account");
		Server serv = (Server) request.getServletContext().getAttribute("server");
		DataBase db = serv.getDB();
		String name = request.getParameter("userName");
		Account target = db.getAccountByName(name);
		target.setVotedBy(db.getAllVotes(target.getUserName()));
		if (!target.getVotedBy().contains(current.getUserName())) {
			target.addVote(current.getUserName(), voteNumber);
			db.voteForUser(current.getUserName(), name);
			db.updateRating(target);
		}
		response.sendRedirect("MemberPage?memberID=" + name);
	}

}
