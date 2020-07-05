package day9.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Daoutil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection  getConnection(){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?&useSSL=false&serverTimezone=UTC","root","123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(connection);
		return connection;
	}
	public static void closeAll(Connection conn,Statement st, ResultSet rs)
	{
		try {
			if(conn !=null)
				conn.close();
			if(st!=null)
				st.close();
			if(rs!=null)
				rs.close();
		}catch (Exception e) {
		}
	}
}
