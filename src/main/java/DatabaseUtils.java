import java.io.File;
import java.sql.*;

public final class DatabaseUtils
{

	public static final String usersURL = "jdbc:sqlite:users.db";
	public static final String bugsURL = "jdbc:sqlite:bugs.db";

	public static void init() throws SQLException
	{
		// Create users table
		connect(usersURL, "CREATE TABLE IF NOT EXISTS users(UserID INTEGER PRIMARY KEY, Username varchar(25)," +
				"Password varchar(25), IsAdmin BIT)");

		// Register default test account credentials
		registerAccount("Username", "Password", true);
	}

	// Connect to database and optionally execute chosen statement
	public static void connect(String databaseURL, String... sql) throws SQLException
	{
		File file = new File(databaseURL);

		try (Connection conn = DriverManager.getConnection(databaseURL))
		{
			Statement statement = conn.createStatement();

			if (!file.exists())
			{
				statement.executeUpdate(sql[0]);
			}
		}
	}

	// Register an account
	public static void registerAccount(String username, String password, boolean isAdmin) throws SQLException
	{
		connect(usersURL, "INSERT INTO users (Username,Password,IsAdmin) VALUES ('" + username + "'," +
				" '" + password + "', " + (isAdmin ? 1 : 0) + ")"); // Connect and convert java boolean input to sql BIT
	}

	// Check a value against a specified input
	public static boolean compareValue(String databaseURL, String columnLabel, String input) throws SQLException
	{
		try (Connection conn = DriverManager.getConnection(databaseURL))
		{
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE " + columnLabel + " = '" + input + "'");

			if (resultSet.next())
			{
				return true;
			}
		}

		return false;
	}
}
