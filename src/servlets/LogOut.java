package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NormalLogIn
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		try {  
			session.invalidate(); 
			response.sendRedirect("index.jsp");
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		
		try {  
			session.invalidate(); 
			response.sendRedirect("index.html");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
