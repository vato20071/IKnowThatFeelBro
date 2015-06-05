package core;

public class JustTest {

	private DataBase base = new DataBase();
	
	public static void main(String[] args) {
		JustTest test = new JustTest();
		test.checkAccountAdd();
		test.addAccount2();
		test.addCategory();
		test.addFriend();
	}
	
	private void checkAccountAdd() {
		Account acc = new Account();
		acc.setUserName("Vato");
		acc.setPassword("password");
		acc.setMail(null);
		acc.setFacebook("Vato Tabatadze");
		acc.setCoeffValue(0);
		acc.setCoeffCount(0);
		acc.setStatus(0);
		base.insertDataIntoAccount(acc);
	}
	
	private void addAccount2() {
		Account acc = new Account();
		acc.setUserName("Vato2");
		acc.setPassword("password2");
		acc.setMail(null);
		acc.setFacebook("Vato Var Tabatadze");
		acc.setCoeffValue(0);
		acc.setCoeffCount(0);
		acc.setStatus(1);
		base.insertDataIntoAccount(acc);
	}
	
	private void addCategory() {
		Category cat = new Category();
		cat.setName("Alcoholic");
		base.insertDataIntoCategories(cat);
	}
	
	private void addFriend() {
		base.addFriendShip("Vato", "Vato2", "Alcoholic");
	}
}
