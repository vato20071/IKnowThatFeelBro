package core;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private List<Account> members;
	private List<Message> chat;
	private List<String> invitedUsers;
	private String roomName;
	private int roomID;
	
	public Room() {
		members = new ArrayList<>();
		chat = new ArrayList<>();
		invitedUsers = new ArrayList<>();
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

}