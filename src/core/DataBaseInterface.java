package core;

import java.util.List;

public interface DataBaseInterface {

	public void insertDataIntoAccount(Account user);
	public void insertDataIntoCategories(Category category);
	public void addFriendShip(String user1, String user2, String catName);
	public void updateAccount(Account user);
	
	public Account getAccountByID(int ID);
	public Account getAccountByName(String name);
	public Category getCategoryByID(int ID);
	public Category getCategoryByName(String name);
	public boolean getFriendShip(Account user1, Account user2);
	public List<String> getFriendsByCategory(String userName, String categoryName);
	public List<String> getCategoryList(String userName);
}
