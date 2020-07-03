package day9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.cj.*;

public class TestJdbc {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		Scanner sc=new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?&useSSL=false&serverTimezone=UTC","root","123456");
			System.out.println(connection);
			String sql1 = "insert into emp values(?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql1);
			int empno,mgr,deptno;
			double sal,comm;
			String ename,job,hiredate;
			empno=sc.nextInt();
			sc.nextLine();
			ename=sc.nextLine();
			job=sc.nextLine();
			mgr=sc.nextInt();
			sc.nextLine();
			hiredate=sc.nextLine();
			sal=sc.nextDouble();
			sc.nextLine();
			comm=sc.nextDouble();
			sc.nextLine();
			deptno=sc.nextInt();
			sc.nextLine();
			ps.setInt(1,empno);
			ps.setString(2,ename);
			ps.setString(3,job);
			ps.setInt(4,mgr);
			ps.setString(5,hiredate);
			ps.setDouble(6, sal);
			ps.setDouble(7, comm);
			ps.setInt(8,deptno);
			int count = ps.executeUpdate();
			System.out.println("影响的行数： " + count);
			String sql2 = "update  emp set ename=? where empno=?";
			ps = connection.prepareStatement(sql2);
			ps.setString(1,ename);
			ps.setInt(2,empno);
			count = ps.executeUpdate();
			System.out.println("影响的行数： " + count);
			String sql3 = "delete from emp where empno=?";
			ps = connection.prepareStatement(sql3);
			ps.setInt(1,empno);
			count = ps.executeUpdate();
			System.out.println("影响的行数： " + count);
			
		}catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
				{
					connection.close();	
				}
				
				if(ps !=null )
					ps.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
}
