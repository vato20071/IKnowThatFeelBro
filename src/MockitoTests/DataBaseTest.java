package MockitoTests;

import static org.junit.Assert.*;

import org.mockito.Mockito.*;

import java.sql.Connection;

import org.junit.Test;

import core.Account;
import core.Category;
import core.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseTest {
	
	private DataBase db;
	//private BasicDataSource ds;

	@Test
	public void testDataBaseConstructor() {
		db = new DataBase();
		assertTrue(db != null);
	}
	
}
