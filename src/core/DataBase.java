package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataBase implements DataBaseInterface{

	BasicDataSource ds = new BasicDataSource();
	
	public DataBase() {
		ds = new BasicDataSource();
		initConnection(ds);
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
				+ "(user_name, password, mail, fb, coeff_value, coeff_numb, status) " 
				+ "values (?, ?, ?, ?, ?, ?, ?)")) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getMail());
			stmt.setString(4, user.getFacebook());
			stmt.setDouble(5, user.getCoeffValue());
			stmt.setInt(6, user.getCoeffCount());
			stmt.setString(7, user.getStatus()+"");
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
				acc.setMail(set.getString("mail"));
				acc.setFacebook(set.getString("fb"));
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
	
}
