package day10.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import day10.bean.Dept;
import day10.bean.Emp;
import day10.datapool.DataPool;

public class DeptDao {
	public List<Dept> findAll()
	{
		QueryRunner runner = new QueryRunner(DataPool.dataSource);
		String sql = " select * from dept";
		try {
			return runner.query(sql, new BeanListHandler<Dept>(Dept.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//1.根据地点查询部门信息
	public List<Dept> findBy(String loc)
	{
		QueryRunner runner = new QueryRunner(DataPool.dataSource);
		String sql = " select * from dept where loc = ?";
		try {
			return runner.query(sql, new BeanListHandler<Dept>(Dept.class),loc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//2.修改部门的名称（根据部门编号修改）
	public int updateDname(int deptno,String dname)
	{
		QueryRunner runner = new QueryRunner(DataPool.dataSource);
		String sql = "update emp set dname=? where deptno=?";
		try {
			return  runner.update(sql, dname,deptno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//3.根据id删除部门信息（考虑：该部门下的员工一并删除）
	public int deleteByDeptNo(int deptno)
	{
		QueryRunner runner = new QueryRunner(DataPool.dataSource);
		String sql = "delete from dept where deptno=?";
		try {
			return runner.update(sql, deptno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}
	
	//*4.返回从事给定工作的员工的信息，包括部门名称。
	public List<Map<String, Object>> findByJob(String job)
	{
		QueryRunner runner = new QueryRunner(DataPool.dataSource);
		String sql = " select emp.*,dname from emp,dept where dept.deptno=emp.deptno and job = ?";
		try {
			return runner.query(sql, new MapListHandler(),job);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
