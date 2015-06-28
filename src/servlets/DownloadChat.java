package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Account;
import core.Message;
import core.Room;

/**
 * Servlet implementation class DownloadChat
 */
@WebServlet("/DownloadChat")
public class DownloadChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadChat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("APPLICATION/OCTET-STREAM");   
		Room room = (Room) request.getSession().getAttribute("room");
		response.setHeader("Content-Disposition","attachment; filename=\"" + room.getRoomName() + " Chat.txt" + "\"");  
		OutputStream out = response.getOutputStream();
		List<Message> chat = room.getMessageList();
		byte[] buffer = new byte[4096];
		for (int i=0; i<chat.size(); i++) {
			buffer = (chat.get(i).toString()+"\n").getBytes();
			out.write(buffer);
		}
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
