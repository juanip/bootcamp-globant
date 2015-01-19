package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

	private static Connection connection;
	private static final String db = "my-db";
	private static final String user = "root";
	private static final String pass = "64586458";

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/" + db, user, pass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return connection;
		} else {
			return connection;
		}
	}

	public int getCount() {
		Connection conn = getConnection();
		int count = 0;

		try {
			Statement statement = conn.createStatement();

			String sql = "SELECT count FROM data";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				count = rs.getInt("count");
			}

			statement.close();

			if (count == 0) {
				statement = conn.createStatement();
				sql = "INSERT INTO data (count) VALUES (1)";
				statement.executeUpdate(sql);

				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public void setCount(int count) {
		Connection conn = getConnection();

		try {
			PreparedStatement statement;

			String sql = "UPDATE data SET count = ?";

			statement = conn.prepareStatement(sql);

			statement.setInt(1, count);

			statement.executeUpdate();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
