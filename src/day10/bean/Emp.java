package day10.bean;

import java.util.Date;

public class Emp {
		private int empno;
		private String ename;
		private String job;
		private Integer mgr;
		private Date hiredate;
		private double sal;
		private Double comm;
		private int deptno;
		public int getEmpno() {
			return empno;
		}
		public void setEmpno(int empno) {
			this.empno = empno;
		}
		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public Integer getMgr() {
			return mgr;
		}
		public void setMgr(Integer mgr) {
			this.mgr = mgr;
		}
		public Date getHiredate() {
			return hiredate;
		}
		public void setHiredate(Date hiredate) {
			this.hiredate = hiredate;
		}
		public double getSal() {
			return sal;
		}
		public void setSal(double sal) {
			this.sal = sal;
		}
		public Double getComm() {
			return comm;
		}
		public void setComm(Double comm) {
			this.comm = comm;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
		public Emp(int empno, String ename, String job, Integer mgr, Date hiredate, double sal, Double comm, int deptno) {
			super();
			this.empno = empno;
			this.ename = ename;
			this.job = job;
			this.mgr = mgr;
			this.hiredate = hiredate;
			this.sal = sal;
			this.comm = comm;
			this.deptno = deptno;
		}
		public Emp(int empno, String ename, double sal, int deptno) {
			super();
			this.empno = empno;
			this.ename = ename;
			this.sal = sal;
			this.deptno = deptno;
		}
		public Emp() {}
}
