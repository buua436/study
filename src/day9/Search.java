package day9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBCʵ�ֲ�ѯ
 * @author 86181
 *
 */
public class Search {
	
	//��ѯ����Ա��
	public void searchEmp()
	{	
		//1.��ȡ����
		Connection connection = D.getConnection();
	
		PreparedStatement ps = null;
		ResultSet rs  = null;
		try {
			//2.��дsql
			String sql = "select sal,deptno,empno as id,ename as name from emp";
			//3.��ȡԤ������
			ps = connection.prepareStatement(sql);
			//4.ע�����
			
			//5.ִ��sql,ִ��DQL��䣬��������executeQuery()����������һ��ResultSet�����
			rs = ps.executeQuery();
			
			//6.��������
			while(rs.next())
			{
				//ȡ���صĽ�����е�ÿһ��
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
