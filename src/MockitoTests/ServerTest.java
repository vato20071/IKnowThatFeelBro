package MockitoTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import core.Account;
import core.Category;
import core.DataBase;
import core.Server;

public class ServerTest {
	
	private Server serv;
	
	private int countActiveUsers;
	private List<DataBase> dataList;
	private HashMap<String, Category> categoryList;
	
	private int addition = 10;
	
	@Before
	public void init() {
		serv = new Server();
		countActiveUsers = serv.getCountActiveUsers();
		dataList = serv.getDataList();
		categoryList = serv.getCategoryList();
	}

	@Test
	public void testServerConstructor() {
		assertTrue(categoryList != null);
		assertTrue(countActiveUsers == 0);
	}

	@Test
	public void testGetIncAndDecActiveUsers() {
		int origin = serv.getCountActiveUsers();
		
		for(int i = 0; i < 2 * addition; i++) {
			serv.incActiveUsers();
		}
		assertTrue(serv.getCountActiveUsers() == origin + 2 * addition);
		
		origin += 2 * addition;
		
		for(int i = 0; i < addition; i++) {
			serv.decActiveUsers();
		}
		assertTrue(serv.getCountActiveUsers() == origin - addition);
	}
	
	
	@Test
	public synchronized void testAddNewUser() {
		int dtSize = serv.getDB().getTotalAccount();
		core.Account newUser = new core.Account();
		serv.addNewUser(newUser);
		assertTrue(dtSize != -1);		
	}
	
	@Test
	public void testAddNewCategory() {
		List<Category> allCats = serv.getDB().getAllCategory();
		int allCatsSize = allCats.size();
		Category cat = new Category();
		serv.addNewCategory(cat);
		assertTrue(allCats.size() != -1);
	}
	
	
	
}
