package core;

public interface DataBaseInterface {

	public void insertDataIntoAccount(Account user);
	public void insertDataIntoCategories(Category category);
	public void insertDataIntoRooms(Room room);
	public void addFriendShip(Account user1, Account user2);
	
	public Account getAccountByID(int ID);
	public Account getAccountByName(String name);
	public Category getCategoryByID(int ID);
	public Room getRoomByID(int ID);
	public Category getFriendShip(Account user1, Account user2);
	
}
