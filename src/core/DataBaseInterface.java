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
	public List<Category> getAllCategory();
	public void changeStatus(String username,String value);
	public void deleteCategory(String catName);
	public int getTotalAccount();
	public List<Notification> getNotifications(String userName);
	void addNotification(String userName, Notification notification);
	void updateNotification(String userName, Notification notification);
	void voteForUser(String voter, String receiver);
	List<String> getAllVotes(String userName);
	void updateRating(Account user);
}
