package day9;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class D {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//非常耗时的
	}
	//打开连接
	public static Connection  getConnection(){
		
		//2.通过驱动管理器DriverManager获取连接对象
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?&useSSL=false&serverTimezone=UTC","root","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(connection);
		return connection;
	}
	
	
	//关闭连接
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
			// TODO: handle exception
		}
	}
	
}