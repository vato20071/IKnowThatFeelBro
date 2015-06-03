package core;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
	
	private int ID, coeffCount, status;
	private String userName, password, mail, facebook;
	private double coeffValue;
	private HashMap<String, ArrayList<String> > friendMap;
	private DataBase base;
	
	public Account() {
		friendMap = new HashMap<>();
	}
	
	public void addFriendShip(String category, String userName) {
		base.addFriendShip(this.userName, userName, category);
		ArrayList<String> friends = friendMap.get(category);
		if (!friends.contains(userName)) {
			friends.add(userName);
		}
		friendMap.put(category, friends);
	}
	
	public void setDataBase(DataBase base) {
		this.base = base;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getCoeffCount() {
		return coeffCount;
	}
	
	public void setCoeffCount(int coeffCount) {
		this.coeffCount = coeffCount;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getFacebook() {
		return facebook;
	}
	
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	public double getCoeffValue() {
		return coeffValue;
	}
	
	public void setCoeffValue(double coeffValue) {
		this.coeffValue = coeffValue;
	}
	
}
