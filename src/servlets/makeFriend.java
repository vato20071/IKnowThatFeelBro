package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import core.Account;
import core.Category;
import core.DataBase;
import core.Room;
import core.Server;

/**
 * Servlet implementation class makeFriend
 */
@WebServlet("/makeFriend")
public class makeFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makeFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account acc = (Account) request.getSession().getAttribute("account");
		String userName = request.getParameter("fruser");
		if(!userName.equals(acc.getUserName())){
			Category catName = (Category) request.getSession().getAttribute("category");
			Server serv = (Server) request.getSession().getServletContext().getAttribute("server");
			DataBase db = serv.getDB();
			acc.setDataBase(db);
			if(acc.getFriendMap().get("catName") == null){
				List<String> list = new ArrayList<String>();
				HashMap<String, List<String> > tmp = acc.getFriendMap();
				tmp.put(catName.getName(), list);
				acc.setFriendMap(tmp);
			} 
			if(!acc.containsFriend(userName))
				acc.addFriendShip(catName.getName(),userName);
		}
		response.sendRedirect("chatRoom.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
}
