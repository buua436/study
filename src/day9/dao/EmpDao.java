package day9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import day9.bean.Emp;

public class EmpDao {
	// 1.添加一个新员工
	public int insertEmp(Emp emp) {
		Connection con = Daoutil.getConnection();
		PreparedStatement ps = null;
		int count = 0;
		String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			ps = con.prepareStatement(sql);
			ps.setInt(1, emp.getEmpno());
			ps.setString(2,emp.getEname());
			ps.setString(3,emp.getJob());
			ps.setInt(4,emp.getMgr());
			ps.setString(5,format.format(emp.getHiredate()));
			ps.setDouble(6,emp.getSal());
			ps.setDouble(7, emp.getComm());
			ps.setInt(8,emp.getDeptno());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Daoutil.closeAll(con, ps, null);
		}
		return count;
	}
	// 2.修改员工工资
	public int updateSal(int id,double sal) {
		Connection con = Daoutil.getConnection();
		PreparedStatement ps = null;
		int count = 0;
		String sql = "update  emp set sal=? where empno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, sal);
			ps.setInt(2, id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Daoutil.closeAll(con, ps, null);
		}
		return count;
	}
	// 3.根据员工编号删除员工
	public int removeByEmpNo(int id) {
		Connection con = Daoutil.getConnection();
		PreparedStatement ps = null;
		int count = 0;
		String sql = "delete from emp where empno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Daoutil.closeAll(con, ps, null);
		}
		return count;
	}

	// 4.查询所有员工
	public List<Emp> findAllEmp() {
		Connection con = Daoutil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Emp> list = new ArrayList<>();
		String sql = "select * from emp)";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				Date date = rs.getDate(5);
				double sal = rs.getDouble(6);
				double comm = rs.getDouble(7);
				int deptno = rs.getInt(8);

				Emp emp = new Emp(empno, ename, job, mgr, date, sal, comm, deptno);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Daoutil.closeAll(con, ps, rs);
		}
		return list;
	}

	// 根据部门名称查询员工
	public List<Emp> findByDeptName(String dname) {
		Connection con = Daoutil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Emp> list = new ArrayList<>();
		try {
			String sql = "select * from emp where deptno=(select deptno from dept where dname=?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dname);
			rs = ps.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				Date date = rs.getDate(5);
				double sal = rs.getDouble(6);
				double comm = rs.getDouble(7);
				int deptno = rs.getInt(8);

				Emp emp = new Emp(empno, ename, job, mgr, date, sal, comm, deptno);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Daoutil.closeAll(con, ps, rs);
		}
		return list;
	}

	// 5.根据员工的工号查询
	public List<Emp> findByEmpNo(int id) {
		Connection con = Daoutil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Emp> list = new ArrayList<>();
		try {
			String sql = "select * from emp where empno=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				Date date = rs.getDate(5);
				double sal = rs.getDouble(6);
				double comm = rs.getDouble(7);
				int deptno = rs.getInt(8);
				Emp emp = new Emp(empno, ename, job, mgr, date, sal, comm, deptno);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Daoutil.closeAll(con, ps, rs);
		}
		return list;
	}

	// 6.根据员工姓名模糊查询
	public List<Emp> findByEname(String empname) {
		Connection con = Daoutil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Emp> list = new ArrayList<>();
		try {
			String sql = "select * from emp where ename like ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, empname);
			rs = ps.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				Date date = rs.getDate(5);
				double sal = rs.getDouble(6);
				double comm = rs.getDouble(7);
				int deptno = rs.getInt(8);

				Emp emp = new Emp(empno, ename, job, mgr, date, sal, comm, deptno);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Daoutil.closeAll(con, ps, rs);
		}
		return list;
	}
}
