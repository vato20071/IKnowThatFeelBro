package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class RoomManager {
	private Room curr;
	public RoomManager(Room room){
		curr=room;
	}
	
	private void getSpeaker(){
		Random r = new Random();
		HashMap<HttpSession,Integer> users=curr.getUsers();
		
		
		int min=10000;
		Set<HttpSession> set = users.keySet();
		Iterator<HttpSession> iterator = set.iterator();
		ArrayList<HttpSession> speakers=new ArrayList<HttpSession>();
		
		while (iterator.hasNext()) {
			HttpSession user=iterator.next();
			if(!curr.getMemberList().contains((Account)user.getAttribute("account")))
				continue;
			int num = users.get(user);
			if(min==num){
				speakers.add(user);
			}
			 if(min>num){
				min=num;
				speakers = new ArrayList<HttpSession>();
				speakers.add(user);
			}
		}
			 if(speakers.size()>1){
				 int pos=r.nextInt(speakers.size());
				 curr.setSpeaker(speakers.get(pos));
			 }else
				 curr.setSpeaker(speakers.get(0));
		
		
		
		
	}
	public void start() throws InterruptedException{
		while(true){
			if(curr.questions()==false && curr.membersCount()!=0){
				getSpeaker();
			}
			for(int i=0; i<120; i++){
			Thread.sleep(1000);
			if(curr.getSpeaker()==null){
				if(curr.membersCount()==0)
					break;
				getSpeaker();
				i=0;
			}
			}
			if(curr.membersCount()!=0){
				curr.setQuestions(true);
				curr.setSpeaker(null);
			}
			Thread.sleep(12000);
			curr.setQuestions(false);
		}
	}
}
