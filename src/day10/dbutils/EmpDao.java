package day10.dbutils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import day10.bean.Emp;
import day10.datapool.DataPool;

public class EmpDao {
	//1.���һ����Ա��
		public int insertEmp(Emp emp)
		{
			QueryRunner runner = new QueryRunner(DataPool.dataSource);
			String sql="insert into emp values(?,?,?,?,?,?,?,?)";
			try {
				return runner.update(sql, emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		//2.�޸�Ա������
		public int updateSal(int empno,double money)
		{
			QueryRunner runner = new QueryRunner(DataPool.dataSource);
			String sql = "update emp set sal=sal+? where empno=?";
			try {
				return  runner.update(sql, money,empno);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		//3.����Ա�����ɾ��Ա��
		public int deleteByNo(int empNo)
		{
			QueryRunner runner = new QueryRunner(DataPool.dataSource);
			String sql = "delete from emp where empno=?";
			try {
				return runner.update(sql, empNo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;	
		}
		
		
		
		//4.��ѯ����Ա��
		public List<Emp> findAll()
		{
			QueryRunner runner = new QueryRunner(DataPool.dataSource);
			String sql = "select * from emp";
			try {
				return runner.query(sql, new BeanListHandler<Emp>(Emp.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		//5.����Ա���Ĺ��Ų�ѯ
		public Emp findByEmpNo(int empNo)
		{
			QueryRunner runner = new QueryRunner(DataPool.dataSource);
			String sql = "select * from emp where empno = ?";
			try {
				return runner.query(sql, new BeanHandler<Emp>(Emp.class),empNo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		//6.����Ա������ģ����ѯ
		public List<Emp> findByNameLike(String key)
		{
			QueryRunner runner = new QueryRunner(DataPool.dataSource);
			String sql = "select * from emp where ename like ?";
			try {
				return runner.query(sql, new BeanListHandler<Emp>(Emp.class),"%"+key+"%");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		
		//���ݲ������Ʋ�ѯԱ��
		public List<Emp> findByDeptName(String dname)
		{
			QueryRunner runner = new QueryRunner(DataPool.dataSource);
			String sql = "select * from emp where deptno=(select deptno from dept where dname=?)";
			try {
				return runner.query(sql, new BeanListHandler<Emp>(Emp.class),dname);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		//��ѯһ���ж���Ա����
		public int getAllCount()
		{
			QueryRunner runner = new QueryRunner(DataPool.dataSource);
			String sql="select count(*) from emp";
			try {
				Object result = runner.query(sql, new ScalarHandler());
				
				return Integer.parseInt(result.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
}
