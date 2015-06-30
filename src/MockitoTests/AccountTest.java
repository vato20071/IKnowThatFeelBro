package MockitoTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.gson.Gson;

import core.Account;
import core.DataBase;

public class AccountTest {

	@Mock
	private Account acc;
	
	@Mock
	private DataBase base;
	
	@Mock
	private List<String> friends;
	
	@Mock
	private HashMap<String, List<String> > friendMap;
	
	private String nuca = "nuca";
	private String vato = "vato";
	private String cat = "cat";
	
	@Before
	public void initMocks() {
		acc = mock(Account.class);	
		base = mock(DataBase.class);
		friends = new ArrayList<>();
		friendMap = new HashMap<>();
		friendMap.put(cat, friends);
	}
	
	@Test
	public void testContainsFriend() {
		when(acc.containsFriend(nuca)).thenReturn(true);
		boolean res = acc.containsFriend(nuca);
		assertTrue(res);
	}
	
	@Test	
	public void testAddFriendShipFriendIsFirst() {//String category, String userName
		
		base.addFriendShip(nuca, vato, cat);
		friends = friendMap.get(cat);
		
		if (!friends.contains(vato)) { //we know there isn't nuca, so this 'if' is used
			friends.add(vato);
			assertTrue(friends.contains(vato));
		}
		
		friendMap.put(cat, friends);
		assertTrue(friends.equals(friendMap.get(cat)));
	}
	
	@Test	
	public void testAddFriendShipFriendIsNotFirst() {
		
		base.addFriendShip(nuca, vato, cat);
		friends = friendMap.get(cat);
		friends.add(vato);
		
		friendMap.put(cat, friends);
		assertTrue(friends.equals(friendMap.get(cat)));
	}
	
}
