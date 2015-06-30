package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class Room {

	public static final int MAX_USERS_ALLOWED = 6;
	private List<Account> members;
	private List<Message> chat;
	private List<String> invitedUsers;
	private String roomName;
	private int roomID;
	private Map<Account,Integer> report;
	private boolean ques;
	private HttpSession currSpeaker;
	private HashMap<HttpSession, Integer> users;
	private List<Account> banList;

	
	public Room() {
		members = new ArrayList<>();
		chat = new ArrayList<>();
		invitedUsers = new ArrayList<>();
		report = new HashMap<Account, Integer>();
		users=new HashMap<HttpSession, Integer>();
		banList=new ArrayList<Account>();
		ques=false;

	}
	public HashMap<HttpSession, Integer> getUsers(){
		return users;
	}
	public void addUser(HttpSession newOne){
		if(!users.containsKey(newOne))
			users.put(newOne, 0);
	}
	public void addToBanList(Account curr){
		banList.add(curr);
	}
	public boolean isBanned(Account acc){
		return banList.contains(acc);
	}
	public void incrUser(HttpSession curr){
		if(users.containsKey(curr))
			users.put(curr, users.get(curr)+1);
		
	}
	public boolean questions(){
		return ques;
	}
	public void setQuestions(boolean status){
		ques=status;
	}
	public HttpSession getSpeaker(){
		return currSpeaker;
	}
	public void setSpeaker(HttpSession curr){
		currSpeaker=curr;
	}

	public int membersCount() {
		return members.size();
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomID() {
		return roomID;
	}
	
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
	public void addMember(Account name) {
		members.add(name);
		report.put(name, 0);
	}
	
	public void removeMember(Account name) {
		for (int i=0; i<members.size(); i++) {
			if (members.get(i).getUserName().equals(name.getUserName())) {
				members.remove(i);
			}
		}
	}
	
	public void addMessage(Message msg) {
		chat.add(msg);
	}

	public List<Message> getMessageList() {
		return chat;
	}
	
	public void addInvitedUser(String user) {
		invitedUsers.add(user);
	}
	
	public List<String> getInvitedList() {
		return invitedUsers;
	}
	
	public void removeInvitedUser(String user) {
		invitedUsers.remove(user);
	}
	public List<Account> getMemberList() {
		return members;
	}
	
	public Map<Account,Integer> getReportMap(){
		return report;
	}
	
	public void addReportToUser(Account acc){
		String accUserName = acc.getUserName();
		for(Account key : report.keySet()){
			if(key.getUserName().equals(accUserName)){
				int num = report.get(key);
				report.put(key, num+1);
				return;
			}
		}
	}

}