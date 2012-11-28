package mysql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;

public class ConnectionPool {

	private Vector<Connection> pool;

	private String url;

	private String username;

	private String password;

	private String driverClassName;

	private int poolSize = 1;

	private static ConnectionPool instance = null;

	/**
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private ConnectionPool() throws InstantiationException,
			IllegalAccessException {
		init();
	}

	/**
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private void init() throws InstantiationException, IllegalAccessException {
		pool = new Vector<Connection>(poolSize);
		readConfig();
		addConnection();
	}

	public synchronized void release(Connection conn) {
		pool.add(conn);

	}

	public synchronized void closePool() {
		for (int i = 0; i < pool.size(); i++) {
			try {
				((Connection) pool.get(i)).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pool.remove(i);
		}
	}

	public static ConnectionPool getInstance() throws InstantiationException,
			IllegalAccessException {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	public synchronized Connection getConnection() {
		if (pool.size() > 0) {
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		} else {
			return null;
		}
	}

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private void addConnection() throws InstantiationException,
			IllegalAccessException {
		Connection conn = null;
		for (int i = 0; i < poolSize; i++) {

			try {

				Class.forName(driverClassName).newInstance();
				String url = this.url + "?user=" + this.username + "&password="
						+ this.password
						+ "&useUnicode=true&characterEncoding=GBK";
				conn = DriverManager.getConnection(url);

				pool.add(conn);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private void readConfig() {
		try {
			String path = System.getProperty("user.dir")
					+ "\\dbpool.properties";
			FileInputStream is = new FileInputStream(path);
			Properties props = new Properties();
			props.load(is);
			this.driverClassName = props.getProperty("driverClassName");
			this.username = props.getProperty("username");
			this.password = props.getProperty("password");
			this.url = props.getProperty("url");
			this.poolSize = Integer.parseInt(props.getProperty("poolSize"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}