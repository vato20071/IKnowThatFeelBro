package core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mysql.fabric.xmlrpc.base.Array;

public class DataBase implements DataBaseInterface{

	public static final int MAX_CONNECTIONS = 50;
	private static final int MAX_WAIT_TIME = 60000;
	BasicDataSource ds = new BasicDataSource();

	public DataBase() {
		ds = new BasicDataSource();
		initConnection(ds);
	}

	public static String hexToString(byte[] bytes) {
		StringBuffer buff = new StringBuffer();
		for (int i=0; i<bytes.length; i++) {
			int val = bytes[i];
			val = val & 0xff;  // remove higher bits, sign
			if (val<16) buff.append('0'); // leading 0
			buff.append(Integer.toString(val, 16));
		}
		return buff.toString();
	}
	/**
	 * Initializes BasicDataSource ds 
	 * @param ds
	 */
	private void initConnection(BasicDataSource ds) {
		ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/iknowthatfeelbro?characterEncoding=UTF8");
        ds.setUsername("root");
        ds.setPassword("vatodato");
        ds.setMaxTotal(MAX_CONNECTIONS);
        ds.setMaxConnLifetimeMillis(MAX_WAIT_TIME);
	}
	
	@Override
	public void insertDataIntoAccount(Account user) {
		try (Connection conn = ds.getConnection()) {
			addAccount(conn, user);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception occured when inserting new Account");
		}
	}

	private void addAccount(Connection conn, Account user) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement("insert into account "
				+ "(user_name, password, nickname, mail, fb, gplus, coeff_value, coeff_numb, status) " 
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getNickName());
			stmt.setString(4, user.getMail());
			stmt.setString(5, user.getFacebook());
			stmt.setString(6, user.getGplus());
			stmt.setDouble(7, user.getCoeffValue());
			stmt.setInt(8, user.getCoeffCount());
			stmt.setString(9, user.getStatus()+"");
			stmt.execute();
		} 
	}

	@Override
	public void insertDataIntoCategories(Category category) {
		try (Connection conn = ds.getConnection()) {
			addCategory(conn, category);
		} catch (SQLException e) {
			System.out.println("Exception occured when inserting new Category");
		}
	}

	private void addCategory(Connection conn, Category category) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement("insert into category " 
				+ "(name)" 
				+ "values (?)")) {
			stmt.setString(1, category.getName());
			stmt.executeUpdate();
		}
	}

	@Override
	public void addFriendShip(String user1Name, String user2Name, String catName) {
		Account user1 = getAccountByName(user1Name);
		Account user2 = getAccountByName(user2Name);
		Category category = getCategoryByName(catName);
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("insert into friendship " 
					+ "(user1_ID, user2_ID, cat_ID) " 
					+ "values (?, ?, ?)")) {
				stmt.setInt(1, user1.getID());
				stmt.setInt(2, user2.getID());
				stmt.setInt(3, category.getID());
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Exception occured when inserting new FriendShip");
		}
	}

	@Override
	public Account getAccountByID(int ID) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select * from account where ID = ?")) {
				stmt.setInt(1, ID);
				Account acc = getUser(stmt);
				return acc;
			}
		} catch (SQLException e) {
			System.out.println("Exception occured when obtaining Account from database by ID");
		}
		return null;
	}

	private Account getUser(PreparedStatement stmt) throws SQLException {
		try (ResultSet set = stmt.executeQuery()) {
			if (set.next()) {
				Account acc = new Account();
				acc.setID(set.getInt("ID"));
				acc.setUserName(set.getString("user_name"));
				acc.setPassword(set.getString("password"));
				acc.setNickName(set.getString("nickname"));
				acc.setMail(set.getString("mail"));
				acc.setFacebook(set.getString("fb"));
				acc.setGplus(set.getString("gplus"));
				acc.setCoeffValue(set.getDouble("coeff_value"));
				acc.setCoeffCount(set.getInt("coeff_numb"));
				acc.setStatus(set.getInt("status"));
				return acc;
			}
		}
		return null;
	}

	@Override
	public Account getAccountByName(String name) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select * from account where user_name = ?")) {
				stmt.setString(1, name);
				Account acc = getUser(stmt);
				return acc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception occured when obtaining Account from database by Name");
		}
		return null;
	}

	@Override
	public Category getCategoryByID(int ID) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select * from category where ID = ?")) {
				stmt.setInt(1, ID);
				Category cat = getCategory(stmt);
				return cat;
			}
		} catch (SQLException e) {
			System.out.println("Exception occured when obtaining Category from database by ID");
		}
		return null;
	}
	
	public List<Category> getAllCategory(){
		List<Category> categories= new ArrayList<Category>();
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select * from category")) {
				try (ResultSet set = stmt.executeQuery()) {
				while(set.next()){
				Category cat = new Category();
				cat.setID(set.getInt("ID"));
				cat.setName(set.getString("name"));
				categories.add(cat);
				}				
			}
				return categories;
			}
		} catch (SQLException e) {
			System.out.println("Exception occured when obtaining Category from database by ID");
		}
		return null;
	}
	
	private Category getCategory(PreparedStatement stmt) throws SQLException {
		try (ResultSet set = stmt.executeQuery()) {
			Category cat = new Category();
			if (set.next()) {
				cat.setID(set.getInt("ID"));
				cat.setName(set.getString("name"));
				return cat;
			}
		}
		return null;
	}

	@Override
	public Category getCategoryByName(String name) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select * from category where name = ?")) {
				stmt.setString(1, name);
				Category cat = getCategory(stmt);
				return cat;
			}
		} catch (SQLException e) {
			System.out.println("Exception occured when obtaining Category from database by Name");
		}
		return null;
	}

	@Override
	public boolean getFriendShip(Account user1, Account user2)  {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select * from category where user1_ID = ? and user2_ID = ?")) {
				stmt.setInt(1, user1.getID());
				stmt.setInt(2, user2.getID());
				try (ResultSet set = stmt.executeQuery()) {
					if (set.next()) {
						return true;
					}
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception occured when obtaining friendship status from database");
		}
		return false;
	}

	@Override
	public List<String> getFriendsByCategory(String userName, String categoryName) {
		Account user = getAccountByName(userName);
		Category cat = getCategoryByName(categoryName);
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select user2_ID from friendship where user1_ID = ? and cat_ID = ?")) {
				stmt.setInt(1, user.getID());
				stmt.setInt(2, cat.getID());
				List<String> list = new ArrayList<>();
				try (ResultSet set = stmt.executeQuery()) {
					while (set.next()) {
						list.add(getAccountByID(set.getInt("user2_ID")).getUserName());
					}
				}
				return list;
			}
		} catch (SQLException e) {
			System.out.println("Exception occured when obtaining friend list with category");
		}
		return null;
	}
	
	@Override
	public List<String> getCategoryList(String userName) {
		Account user = getAccountByName(userName);
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select cat_ID from friendship where user1_ID = ?")) {
				stmt.setInt(1, user.getID());
				List<String> list = new ArrayList<>();
				try (ResultSet set = stmt.executeQuery()) {
					while (set.next()) {
						list.add(getCategoryByID(set.getInt("cat_ID")).getName());
					}
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String, List<String> > getAllFriends(String userName) {
		List<String> categories = getCategoryList(userName);
		HashMap<String, List<String> > friendMap = new HashMap<>();
		for (int i=0; i<categories.size(); i++) {
			String category = categories.get(i);
			List<String> friends = getFriendsByCategory(userName, category);
			friendMap.put(category, friends);
		}
		return friendMap;
	}

	@Override
	public void updateAccount(Account user) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("update account set nickname = ?, mail = ?, fb = ?, gplus = ? "
					+ "where user_name = ?")) {
				stmt.setString(1, user.getNickName());
				stmt.setString(2, user.getMail());
				stmt.setString(3, user.getFacebook());
				stmt.setString(4, user.getGplus());
				stmt.setString(5, user.getUserName());
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateRating(Account user) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("update account set coeff_value = ?, coeff_numb = ? "
					+ "where user_name = ?")) {
				stmt.setDouble(1, user.getCoeffValue());
				stmt.setInt(2, user.getCoeffCount());
				stmt.setString(3, user.getUserName());
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeStatus(String username,String value) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("update account set status = ? "
					+ "where user_name = ?")) {
				stmt.setString(1, value);
				stmt.setString(2, username);
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteCategory(String catName) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM category WHERE name = ? ")) {
				stmt.setString(1, catName);
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getTotalAccount() {
		int result = 0;
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) as amount FROM account")) {
				stmt.execute();
				try (ResultSet set = stmt.executeQuery()) {
					while (set.next()) {
						result = set.getInt("amount");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Notification> getNotifications(String userName) {
		List<Notification> notifications = new ArrayList<>();
		Account acc = getAccountByName(userName);
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("SELECT type, message, date, seen FROM notifications where user_ID = ?")) {
				stmt.setInt(1, acc.getID());
				try (ResultSet set = stmt.executeQuery()) {
					while (set.next()) {
						Notification note = new Notification();
						note.setType(set.getInt("type"));
						note.setMessage(set.getString("message"));
						note.setDate(set.getDate("date"));
						note.setSeen(set.getBoolean("seen"));
						notifications.add(note);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notifications;
	}
	
	@Override
	public void addNotification(String userName, Notification notification) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO notifications"
					+ "(user_ID, type, date, message, seen) values"
					+ "(?, ?, ?, ?, ?)")) {
				Account acc = getAccountByName(userName);
				stmt.setInt(1, acc.getID());
				stmt.setInt(2, notification.getType());
				Date dt = new Date(notification.getMillis());
				stmt.setDate(3, dt);
				stmt.setString(4, notification.getMessage());
				stmt.setBoolean(5, notification.isSeen());
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateNotification(String userName, Notification notification) {
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("Update notifications set seen = true where user_ID = ? and message = ?")) {
				Account acc = getAccountByName(userName);
				stmt.setInt(1, acc.getID());
				stmt.setString(2, notification.getMessage());
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void voteForUser(String voterName, String receiverName) {
		Account voter = getAccountByName(voterName);
		Account receiver = getAccountByName(receiverName);
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("Insert into votes(user_ID1, user_ID2) values"
					+ "(?, ?)")) {
				stmt.setInt(1, voter.getID());
				stmt.setInt(2, receiver.getID());
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<String> getAllVotes(String userName) {
		Account receiver = getAccountByName(userName);
		try (Connection conn = ds.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("Select user_ID1 from votes where user_ID2 = ?")) {
				stmt.setInt(1, receiver.getID());
				List<String> users = new ArrayList<>();
				try (ResultSet set = stmt.executeQuery()) {
					while (set.next()) {
						int id = set.getInt("user_ID1");
						Account acc = getAccountByID(id);
						users.add(acc.getUserName());
					}
				}
				return users;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
