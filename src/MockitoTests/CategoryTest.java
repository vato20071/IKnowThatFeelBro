package MockitoTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import core.Category;
import core.Room;

public class CategoryTest {
	
	private Category cat;
	private Room room;
	private List<Room> roomList;
	
	private int size = 8;

	@Before
	public void init() {
		cat = new Category();
		roomList = cat.getRoomList();
	}
	
	@Test
	public void testCategoryConstractor() {		
		assertTrue(cat.getRoomList().size() == size);
	}
	
	@Test
	public void testAddRoom() {
		size = roomList.size();
		int addition = 10;
		for (int i = 0; i < addition; i++) {
			cat.addRoom();
		}
		assertTrue(cat.getRoomList().size() == size + addition);
	}
		
	@Test
	public void testRemoveRoom() {
		size = roomList.size();
		for (int i = 0; i < size; i++) {
			cat.removeRoom(roomList.get(0));			
		}
		assertTrue(cat.getRoomList().isEmpty());
	}

}
