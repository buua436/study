package day5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Manage {
	private Scanner sc=new Scanner(System.in);
	private Random rm=new Random();
	ArrayList<Teacher> t=new ArrayList<Teacher>();
	ArrayList<Student> s=new ArrayList<Student>();
	{
		t.add(new Teacher(1, "张三", "123456", "1@t.com", "12345678910"));
		
		Calendar date1 = Calendar.getInstance();
		date1.set(2018, 9, 1);
		s.add(new Student(1, "王五", "软件", 20, "12345678912", date1));
		s.add(new Student(2, "赵六", "软件", 20, "12345678913", date1));
	}
	public void mainMenu()
	{
		System.out.println("请选择:1.登录      2.注册     3.退出");
		int x=sc.nextInt();
		sc.nextLine();
		if(x==1)
			login();
		else if(x==2)
			register();
		else if(x==3)
			System.out.println("已退出程序");
		else 
			mainMenu();
		
	}
	private void login()
	{
		System.out.println("工号:");
		int x=sc.nextInt();
		sc.nextLine();
		int i=0,flag=0;
		Teacher t1=null;
		for(i=0;i<t.size();i++)
			if(t.get(i).getId()==x)
			{
				t1=t.get(i);
				flag=1;
				break;
			}
		if(flag==1)
		{
			System.out.println("密码:");
			String passwd=sc.nextLine();
			if(passwd.equals(t1.getPasswd()))
			{
				int check=rm.nextInt(9000)+1000;
				System.out.println("验证码是"+check);
				System.out.println("输入验证码:");
				int checkcode=sc.nextInt();
				sc.nextLine();
				if(check==checkcode)
				{
					System.out.println("登录成功");
					menu1();
				}
				else 
				{
					System.out.println("验证码错误");
					mainMenu();
				}
			}
			else
			{
				System.out.println("密码错误");
				mainMenu();
			}
		}
		else 
		{
			System.out.println("没有此教师");
			mainMenu();
		}
		
	}
	private void register()
	{
		System.out.println("工号:");
		int x=sc.nextInt();
		sc.nextLine();
		int i=0,flag=0;
		for(i=0;i<t.size();i++)
			if(t.get(i).getId()==x)
			{
				flag=1;
				break;
			}
		if(flag==1)
		{
			System.out.println("工号重复");
			mainMenu();
		}
		else
		{
			System.out.println("密码:");
			String passwd=sc.nextLine();
			System.out.println("确认密码:");
			String repasswd=sc.nextLine();
			if (repasswd.equals(passwd))
			{
				System.out.println("姓名:");
				String name =sc.nextLine();
				System.out.println("邮箱:");
				String email =sc.nextLine();
				System.out.println("电话:");
				String phone =sc.nextLine();
				int check=rm.nextInt(9000)+1000;
				System.out.println("验证码是"+check);
				System.out.println("输入验证码:");
				int checkcode=sc.nextInt();
				sc.nextLine();
				if(check==checkcode)
				{
					t.add(new Teacher(x, name, passwd, email, phone));
					System.out.println("注册成功");
					mainMenu();
				}
				else
				{
					System.out.println("验证码错误");
					mainMenu();
				}
			}
			else
			{
				System.out.println("密码不一致");
				mainMenu();
			}	
		}
	}
	private void menu1() 
	{
		System.out.println("请选择:1.查询学生信息     2.删除学员信息     3.退出");
		int x=sc.nextInt();
		sc.nextLine();
		if(x==1)
			selectmenu();
		else if(x==2)
			delete();
		else if(x==3)
		{
			System.out.println("退出登录");
			mainMenu();
		}
		else 
			menu1();
	}
	private void selectmenu()
	{
		System.out.println("请选择:1.根据学号查询     2.根据姓名模糊查询     3.查询所有     4.退出");
		int x=sc.nextInt();
		sc.nextLine();
		if(x==1)
		{
			System.out.println("输入学号:");
			int id=sc.nextInt();
			sc.nextLine();
			select(id);
		}
		else if(x==2)
		{
			System.out.println("输入姓名:");
			String name=sc.nextLine();
			select(name);
		}
		else if(x==3)
			select();
		else if(x==4)
		{
			System.out.println("退出查询");
			menu1();;
		}
		else 
			selectmenu();
	}
	private void select() 
	{
		int i=0;
		for(i=0;i<s.size();i++)
		{
			System.out.println(s.get(i));
		}
		selectmenu();
	}
	private void select(int id) 
	{
		int i=0,flag=0;
		for(i=0;i<s.size();i++) 
			if(s.get(i).getId()==id)
			{
				System.out.println(s.get(i));
				flag=1;
			}
		if(flag==0)
			System.out.println("没有此学生");
		selectmenu();
	}
	private void select(String name) 
	{
		int i=0,flag=0;
		for(i=0;i<s.size();i++) 
			if(s.get(i).getName().contains(name))
			{
				System.out.println(s.get(i));
				flag=1;
			}
		if(flag==0)
			System.out.println("没有此学生");
		selectmenu();
	}
	private void delete()
	{
		System.out.println("学号:");
		int id=sc.nextInt();
		sc.nextLine();
		int i=0,flag=0;
		for(i=0;i<s.size();i++) 
			if(s.get(i).getId()==id)
			{
				s.remove(i);
				flag=1;
				System.out.println("删除成功");
				break;
			}
		if(flag==0)
			System.out.println("没有此学生");
		menu1();
	}
	public static void main(String[] args) {
		new Manage().mainMenu();
	}
	
}
