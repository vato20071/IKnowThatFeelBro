package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
	private int countActiveUsers;
	private List<DataBase> dataList;
	
	public int getCountActiveUsers() {
		return countActiveUsers;
	}

	public synchronized void incActiveUsers() {
		this.countActiveUsers++;
		DataBase db;
		if(countActiveUsers % DataBase.MAX_CONNECTIONS == 1){
			db = new DataBase();
			dataList.add(db);
		}
	}

	public synchronized void decActiveUsers() {
		this.countActiveUsers--;
		if(countActiveUsers % DataBase.MAX_CONNECTIONS == 0){
			dataList.remove(dataList.size()-1);
		}
	}
	
	public Server(){
		dataList = new ArrayList<DataBase>();
		countActiveUsers = 0;
	}
	
	public synchronized void addNewUser(Account newUser){
		DataBase db = dataList.get(dataList.size()-1);
		db.insertDataIntoAccount(newUser);
	}
	
	public synchronized void addNewCategory(Category cat){
		DataBase db = dataList.get(dataList.size()-1);
		db.insertDataIntoCategories(cat);
	}
	
	public void addFriend(String acc1,String acc2,String catName){
		DataBase db = dataList.get(dataList.size()-1);
		db.addFriendShip(acc1, acc2, catName);
	}
	
	public List<String> getFriendsCat(String user,String catName){
		DataBase db = dataList.get(dataList.size()-1);
		List<String> friendList = db.getFriendsByCategory(user,catName);
		return friendList;
	}
	
	public HashMap<String, List<String>> getAllFriends(String user){
		DataBase db = dataList.get(dataList.size()-1);
		List<String> categoryList = db.getCategoryList(user);
		HashMap<String, List<String>> mp = new HashMap<String, List<String>>();
		for(int i=0; i< categoryList.size(); ++i){
			List<String> catFrList = getFriendsCat(user, categoryList.get(i));
			mp.put(categoryList.get(i), catFrList);
		}
		return mp;
	}
	
	
}
