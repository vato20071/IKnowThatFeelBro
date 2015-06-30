package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
	private int countActiveUsers;
	private List<DataBase> dataList;
	private HashMap<String, Category> categoryList;
	
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
	
	public DataBase getDB() {
		if (dataList.size() == 0) return new DataBase();
		return dataList.get(dataList.size()-1);
	}

	public synchronized void decActiveUsers() {
		this.countActiveUsers--;
		if(countActiveUsers % DataBase.MAX_CONNECTIONS == 0){
			dataList.remove(dataList.size()-1);
		}
	}
	
	public Server(){
		dataList = new ArrayList<DataBase>();
		categoryList = new HashMap<>();
		countActiveUsers = 0;
	}
	
	public synchronized void addNewUser(Account newUser){
		if (dataList.size() == 0) dataList.add(new DataBase());
		DataBase db = dataList.get(dataList.size()-1);
		db.insertDataIntoAccount(newUser);
	}
	
	public synchronized void addNewCategory(Category cat){
		if (dataList.size() == 0) dataList.add(new DataBase());
		DataBase db = dataList.get(dataList.size()-1);
		db.insertDataIntoCategories(cat);
	}
	
	public void addFriend(String acc1,String acc2,String catName){
		if (dataList.size() == 0) dataList.add(new DataBase());
		DataBase db = dataList.get(dataList.size()-1);
		db.addFriendShip(acc1, acc2, catName);
	}
	
	public List<String> getFriendsCat(String user,String catName){
		if (dataList.size() == 0) dataList.add(new DataBase());
		DataBase db = dataList.get(dataList.size()-1);
		List<String> friendList = db.getFriendsByCategory(user,catName);
		return friendList;
	}
	
	public HashMap<String, List<String>> getAllFriends(String user){
		if (dataList.size() == 0) dataList.add(new DataBase());
		DataBase db = dataList.get(dataList.size()-1);
		List<String> categoryList = db.getCategoryList(user);
		HashMap<String, List<String>> mp = new HashMap<String, List<String>>();
		for(int i=0; i< categoryList.size(); ++i){
			List<String> catFrList = getFriendsCat(user, categoryList.get(i));
			mp.put(categoryList.get(i), catFrList);
		}
		return mp;
	}
	
	public HashMap<String, Category> getCategoryList() {
		return categoryList;
	}

	public List<DataBase> getDataList() {
		return dataList;
	}
	
}
