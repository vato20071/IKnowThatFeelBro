package core;

public interface DataBaseInterface {

	public void insertDataIntoAccount(Account user);
	public void insertDataIntoCategories(Category category);
	public void addFriendShip(String user1, String user2, String catName);
	
	public Account getAccountByID(int ID);
	public Account getAccountByName(String name);
	public Category getCategoryByID(int ID);
	public Category getCategoryByName(String name);
	public boolean getFriendShip(Account user1, Account user2);
	
}
