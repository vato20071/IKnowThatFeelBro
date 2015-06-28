package core;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private int ID;
	private String name;
	private List<Room> roomList;
	
	public Category() {
		roomList = new ArrayList<>();
		for (int i=0; i<8; i++) {
			addRoom();
		}
	}
	
	public void addRoom() {
		Room room = new Room();
		room.setRoomID(roomList.size() + 1);
		room.setRoomName("Room " + room.getRoomID());
		roomList.add(room);
	}
	
	public void removeRoom(Room room) {
		roomList.remove(room);
	}
	
	public List<Room> getRoomList() {
		return roomList;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
}
