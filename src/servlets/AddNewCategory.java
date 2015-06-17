package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Category;
import core.DataBase;
import core.Server;

/**
 * Servlet implementation class AddNewCategory
 */
@WebServlet("/AddNewCategory")
public class AddNewCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catName = request.getParameter("catName");
		Server serv = (Server) request.getSession().getServletContext().getAttribute("server");
		DataBase db = serv.getDB();
		Category cat = db.getCategoryByName(catName);
		int amount = db.getTotalAccount();
		int online = serv.getCountActiveUsers();
		if(cat != null){
			request.getSession().setAttribute("catName", catName);
			response.sendRedirect("duplicateCategory.jsp");
			return;
		} else{
			Category newCat = new Category();
			newCat.setName(catName);
			db.insertDataIntoCategories(newCat);
			request.getSession().setAttribute("catName", catName);
			request.getSession().setAttribute("amount", amount);
			request.getSession().setAttribute("online", online);
			response.sendRedirect("successCat.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
