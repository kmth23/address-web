package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class DBManager {

	public static Connection getConnection() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/address", "address", "address");
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static List<User> findList(String id) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		List<User> list = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM address where UserID like ?";
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				list.add(new User(rs.getString("UserID"), rs.getString("Name")));
			}
		} finally {
			ps.close();
			con.close();
        }
		return list;
	}
}
