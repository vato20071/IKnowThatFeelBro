package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Account {
	
	private int ID, coeffCount, status;
	private String userName, password, mail, facebook, nickName, gplus;
	private double coeffValue;
	private HashMap<String, List<String> > friendMap;
	private DataBase base;
	
	public Account() {
		friendMap = new HashMap<>();
		mail = "";
		facebook = "";
		gplus = "";
	}
	public boolean containsFriend(String name){
		Set<String> set = friendMap.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			List<String> friendList = friendMap.get(iterator.next());
			if(friendList.contains(name))
				return true;
		}
		return false;
	}
	public String getGplus() {
		return gplus;
	}

	public void setGplus(String gplus) {
		this.gplus = gplus;
	}

	public HashMap<String, List<String>> getFriendMap() {
		return friendMap;
	}

	public void setFriendMap(HashMap<String, List<String>> friendMap) {
		this.friendMap = friendMap;
	}
	
	public void addFriendShip(String category, String userName) {
		base.addFriendShip(this.userName, userName, category);
		List<String> friends = friendMap.get(category);
		if (!friends.contains(userName)) {
			friends.add(userName);
		}
		friendMap.put(category, friends);
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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
