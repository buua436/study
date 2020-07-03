package day9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC实现查询
 * @author 86181
 *
 */
public class Search {
	
	//查询所有员工
	public void searchEmp()
	{	
		//1.获取连接
		Connection connection = D.getConnection();
	
		PreparedStatement ps = null;
		ResultSet rs  = null;
		try {
			//2.编写sql
			String sql = "select sal,deptno,empno as id,ename as name from emp";
			//3.获取预处理器
			ps = connection.prepareStatement(sql);
			//4.注入参数
			
			//5.执行sql,执行DQL语句，则必须调用executeQuery()方法。返回一个ResultSet结果集
			rs = ps.executeQuery();
			
			//6.处理结果集
			while(rs.next())
			{
				//取返回的结果集中的每一列
				int id = rs.getInt(3);
				String name = rs.getString(4);
				double sal = rs.getDouble(1);
				int deptno = rs.getInt(2);
				
				System.out.println("id="+id+";name="+name+";sal=" + sal+";detp="+deptno);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			D.closeAll(connection, ps, rs);
		}
		
		
		
	}
	public static void main(String[] args) {
		Search demo04 = new Search();
		demo04.searchEmp();
	}
}
