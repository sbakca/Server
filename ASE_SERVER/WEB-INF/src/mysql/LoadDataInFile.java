package mysql;

import java.sql.Connection;
import java.sql.SQLException;

public class LoadDataInFile {
	public static void LoadData(String path) throws SQLException, InstantiationException, IllegalAccessException {

		Connection conn = ConnectionPool.getInstance().getConnection();
		if (conn != null) {
			java.sql.Statement stmt = conn.createStatement();
			stmt.executeUpdate("LOCK TABLES location WRITE");
			stmt.executeUpdate("Load Data InFile '"
					+ path
					+ "' Into Table `location` FIELDS Terminated By ',' LINES Terminated By ';'"
					+ " (user_name,longtitude,latitude,log_time)");
			stmt.executeUpdate("UNLOCK TABLES");
			stmt.close();
			ConnectionPool.getInstance().release(conn);
		}
	}
}