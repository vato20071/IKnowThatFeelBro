package core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint(value="/ChatServer", configurator = ServerConfigurator.class)
public class ChatServer {
	static Map<String, Map<String, Session> > map = new HashMap<>();
	static Map<String, HttpSession> configs = new HashMap<>(); 
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) throws IOException {
		HttpSession ses = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		Room room = (Room) ses.getAttribute("room");
		Account acc = (Account) ses.getAttribute("account");
		Category cat = (Category) ses.getAttribute("category");
		String uniqueName = cat.getName() + room.getRoomName();
		Map<String, Session> roomMap = map.get(uniqueName);
		if (roomMap == null) {
			roomMap = new HashMap<>();
		}
		configs.put(session.getId(), ses);
		if (roomMap.containsKey(ses.getId())) {
			roomMap.put(ses.getId(), session);
			if (ses.getAttribute("spectAccountID") == null) {
				if (room.getMemberList().contains(acc))
					room.removeMember(acc);	
				room.addMember(acc);
			}
			return;
		}
		roomMap.put(ses.getId(), session);
		map.put(uniqueName, roomMap);
		if (ses.getAttribute("spectAccountID") == null) {
			room.addMember(acc);
			Map<String, String> textMap = new HashMap<String, String>();
			textMap.put("name", acc.getNickName());
			textMap.put("type", "system");
			Message mess = new Message();
			mess.setAuthor("System");
			mess.setMessage(acc.getNickName() + " joined.");
			room.addMessage(mess);
			String json = new Gson().toJson(textMap);
			SendMessages(uniqueName, json);
		}
		
	}
	
	private void SendMessages(String uniqueName, String message) throws IOException {
		HashMap<String, Session> thisMap = (HashMap<String, Session>) map.get(uniqueName);
		Iterator<String> it = thisMap.keySet().iterator();
		while (it.hasNext()) {
			Session session = thisMap.get(it.next());
			session.getBasicRemote().sendText(message);
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		HttpSession ses = configs.get(session.getId());
		try {
			ses.getCreationTime();
		} catch(IllegalStateException ex) {
			return;
		}
		Room room = (Room) ses.getAttribute("room");
		Account acc = (Account) ses.getAttribute("account");
//		if(room.getSpeaker().equals(ses))
//			room.setSpeaker(null);

		Category cat = (Category) ses.getAttribute("category");
		if (cat == null || room == null) {
			return;
		}
		String uniqueName = cat.getName() + room.getRoomName();
		HashMap<String, Session> thisMap = (HashMap<String, Session>) map.get(uniqueName);
		thisMap.remove(session.getId());
		if (ses.getAttribute("spectAccountID") == null) {
			room.removeMember(acc);
		}
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		HttpSession ses = (HttpSession) configs.get(session.getId());
		Room room = (Room) ses.getAttribute("room");
		Account acc = (Account) ses.getAttribute("account");
		Category cat = (Category) ses.getAttribute("category");
		if(!room.isBanned(acc)){
			String uniqueName = cat.getName() + room.getRoomName();
			Map<String, String> textMap = new HashMap<String, String>();
			textMap.put("name", acc.getNickName());
			textMap.put("message", message);
			Message mess = new Message();
			mess.setAuthor(acc.getNickName());
			mess.setMessage(message);
			room.addMessage(mess);
			String json = new Gson().toJson(textMap);
			SendMessages(uniqueName, json);
		}
	}
}
