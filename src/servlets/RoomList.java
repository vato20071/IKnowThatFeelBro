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
            if(request.getSession().getAttribute("spectAccountID") != null){
            	ses.setAttribute("category", cat);
            	response.sendRedirect("spectRoomList.jsp");
            	return;
            } 	if (acc == null) {
            		response.sendRedirect("index.jsp");
            	} else {
            			acc.setFriendMap(db.getAllFriends(userName));
		            	ses.setAttribute("account", acc);
		            	ses.setAttribute("category", cat);
		            	response.sendRedirect("roomList.jsp");
            		}
        }
 
        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               
               
               
        }
 
}