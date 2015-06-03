package core;

import java.util.ArrayList;

public class Room {

	private ArrayList<String> members;
	private ArrayList<Message> chat;
	private ArrayList<String> invitedUsers;
	private String roomName;
	private int roomID;
	
	public Room() {
		members = new ArrayList<>();
		chat = new ArrayList<>();
		invitedUsers = new ArrayList<>();
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
	
	public void addMember(String name) {
		members.add(name);
	}
	
	public void removeMember(String name) {
		members.remove(name);
	}
	
	public void addMessage(Message msg) {
		chat.add(msg);
	}
	
	public ArrayList<Message> getMessageList() {
		return chat;
	}
	
	public void addInvitedUser(String user) {
		invitedUsers.add(user);
	}
	
	public ArrayList<String> getInvitedList() {
		return invitedUsers;
	}
	
	public void removeInvitedUser(String user) {
		invitedUsers.remove(user);
	}
	
}