package MockitoTests;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import core.Account;
import core.Message;
import core.Room;

public class RoomTest {
	
	private Room room;
	
	private List<Account> members;
	private List<Message> chat;
	private List<String> invitedUsers;
	
	private int addition = 10;

	@Before
	public void init() {
		room = new Room();
		members = room.getMemberList();
		chat = room.getMessageList();
		invitedUsers = room.getInvitedList();
	}
	
	@Test
	public void testRoomConstructor() {		
		assertTrue(members != null);
		assertTrue(chat != null);
		assertTrue(invitedUsers != null);
	}
	
	@Test
	public void testAddRemoveMemberAndMembersCount() {
		assertTrue(room.membersCount() == 0);
		
		for (int i = 0; i < addition; i++) {
			Account acc = new Account();
			acc.setUserName("nuca" + i);
			room.addMember(acc);
		}
		
		assertTrue(room.membersCount() == addition);
		
		for (int i = 0; i < addition/2; i++) {
			Account acc = new Account();
			acc.setUserName("nuca" + i);
			room.removeMember(acc);
		}
		
		assertTrue(room.membersCount() == addition - addition/2);
	}
	
	@Test
	public void testAddMessage() {
		chat = room.getMessageList();
		assertTrue(chat.size() == 0);
		
		for (int i = 0; i < addition; i++) {
			Message nuc = mock(Message.class);
			room.addMessage(nuc);
		}
		
		assertTrue(chat.size() == addition);
	}
	
	@Test
	public void testAddAndRemoveInvitedUser() {
		invitedUsers = room.getInvitedList();
		assertTrue(invitedUsers.size() == 0);
		
		for (int i = 0; i < addition; i++) {
			String nuca = "nuuca" + i;
			room.addInvitedUser(nuca);
		}
		
		assertTrue(invitedUsers.size() == addition);
		
		for (int i = 0; i < addition; i++) {
			String nuca = "nuuca" + i;
			room.removeInvitedUser(nuca);
		}
		
		assertTrue(invitedUsers.isEmpty());
	}

	
}
