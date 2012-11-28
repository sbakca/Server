package mysql;

import java.sql.*;
import java.util.ArrayList;
import model.Comment;
import model.Shop;

public class Procedure {

	public int Login(String username, String userpassword)
			throws InstantiationException, IllegalAccessException {
		Connection conn = ConnectionPool.getInstance().getConnection();
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall("{call login(?,?,?)}");
			cs.setString(1, username);
			cs.setString(2, userpassword);
			cs.registerOutParameter(3, Types.BOOLEAN);
			cs.execute();
			return cs.getInt(3);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					ConnectionPool.getInstance().release(conn);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return 0;

	}

	public boolean InsertLocation(String username, double longtitude,
			double latitude, String time) throws InstantiationException,
			IllegalAccessException {
		Connection conn = ConnectionPool.getInstance().getConnection();
		CallableStatement cs = null;

		try {
			cs = conn.prepareCall("{call android.insertlog(?,?,?,?,?)}");
			cs.setString(1, username);
			cs.setDouble(2, longtitude);
			cs.setDouble(3, latitude);
			cs.setString(4, time);
			cs.registerOutParameter(5, Types.BOOLEAN);
			cs.execute();
			return cs.getBoolean(5);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					ConnectionPool.getInstance().release(conn);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	public void InsertComment(String username, String shop_key, String content)
			throws InstantiationException, IllegalAccessException {
		Connection conn = ConnectionPool.getInstance().getConnection();
		CallableStatement cs = null;

		try {
			cs = conn.prepareCall("{call android.insertcomments(?,?,?)}");
			cs.setString(1, username);
			cs.setString(2, shop_key);
			cs.setString(3, content);
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					ConnectionPool.getInstance().release(conn);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public ArrayList<Comment> getComments(String shop_key) {
		ArrayList<Comment> list = null;
		Comment ms = null;
		ResultSet rs = null;
		Statement cs = null;
		list = new ArrayList<Comment>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getInstance().getConnection();
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cs = conn.createStatement();
			rs = cs.executeQuery("select * from android.comments where shop_key='"
					+ shop_key
					+ "' order by com_id desc");
			while (rs.next()) {
				ms = new Comment();
				ms.setComentId(rs.getInt("com_id"));
				ms.setContent(rs.getString("content"));
				ms.setDislike(rs.getInt("ndislike"));
				ms.setNlike(rs.getInt("nlike"));
				ms.setUsername(rs.getString("user_name"));
				list.add(ms);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					ConnectionPool.getInstance().release(conn);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return list;
	}

	public void LikeComment(int com_id)
	{
		Connection conn=null;
		try {
			conn = ConnectionPool.getInstance().getConnection();
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CallableStatement cs = null;

		try {
			cs = conn.prepareCall("{call android.likecomment(?)}");
			cs.setInt(1, com_id);
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					ConnectionPool.getInstance().release(conn);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	
	public void InsertCheckIn(String username, String shop_name)
			throws InstantiationException, IllegalAccessException {
		Connection conn = ConnectionPool.getInstance().getConnection();
		CallableStatement cs = null;

		try {
			cs = conn.prepareCall("{call android.checkin(?,?)}");
			cs.setString(1, username);
			cs.setString(2, shop_name);
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					ConnectionPool.getInstance().release(conn);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public ArrayList<Shop> getUserHistoryLocation(String username) {
		ArrayList<Shop> list = null;
		Shop ms = null;
		ResultSet rs = null;
		Statement cs = null;
		list = new ArrayList<Shop>();
		Connection conn = null;
		try {
			conn = ConnectionPool.getInstance().getConnection();
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cs = conn.createStatement();
			rs = cs.executeQuery("select * from android.userhistory where user_name='"
					+ username
					+ "' order by history_id desc");
			while (rs.next()) {
				ms = new Shop();
				ms.setName(rs.getString("shop_name"));
				list.add(ms);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					ConnectionPool.getInstance().release(conn);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return list;
	}
	
	public void DislikeComment(int com_id)
	{
		Connection conn=null;
		try {
			conn = ConnectionPool.getInstance().getConnection();
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CallableStatement cs = null;

		try {
			cs = conn.prepareCall("{call android.dislikecomment(?)}");
			cs.setInt(1, com_id);
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (conn != null) {
					ConnectionPool.getInstance().release(conn);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
//	public static void main(String[] args) throws InstantiationException,
//			IllegalAccessException {
//		Procedure p = new Procedure();
////		p.InsertComment("user1", "1122334", "432524523");
////		p.InsertComment("user1", "1122334", "432524523");
////		p.InsertComment("user1", "1122334", "432524523");
//		//p.LikeComment(2);
////		p.InsertCheckIn("user1", "ShopA");
////		p.InsertCheckIn("user1", "Shopb");
////		p.InsertCheckIn("user1", "Shopc");
////		p.InsertCheckIn("user1", "Shopd");
//		p.getUserHistoryLocation("user1");
//	}
}