package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.Account;
import core.Room;

/**
 * Servlet implementation class reportServlet
 */
@WebServlet("/reportServlet")
public class reportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportServlet() {
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
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("daendzra");
		Room room = (Room) request.getSession().getAttribute("room");
		Account acc = (Account) request.getSession().getAttribute("account");
		List<Account> list = room.getMemberList();
		for(int i=0; i< list.size(); i++){
			String[] tmp = request.getParameterValues(list.get(i).getUserName());
			if(tmp != null){
				room.addReportToUser(list.get(i), acc);
				System.out.println("report added to " + list.get(i).getNickName());
			}
		}
		Map<Account,Integer> mp = room.getReportMap();
		int critical = list.size()/2+1;
		System.out.println("critical: " + critical);
		for(Account key : mp.keySet()){
			if(mp.get(key) >= critical){
				room.addToBanList(key);
				findAndKillSession(key, room);
			}
		}
		response.sendRedirect("chatRoom.jsp");
	}
	
	private void findAndKillSession(Account acc,Room room){
		System.out.println("daerxa");
		Map<HttpSession,Integer> mp = room.getUsers();
		for(HttpSession ses : mp.keySet()){
			Account tmp = (Account)ses.getAttribute("account");
			if(tmp.getUserName().equals(acc.getUserName())){
				System.out.println("egaa");
				room.removeMember(acc);
				ses.invalidate();
			}
		}
	}
	
}
