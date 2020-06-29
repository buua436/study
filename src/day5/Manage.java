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
		t.add(new Teacher(1, "����", "123456", "1@t.com", "12345678910"));
		
		Calendar date1 = Calendar.getInstance();
		date1.set(2018, 9, 1);
		s.add(new Student(1, "����", "���", 20, "12345678912", date1));
		s.add(new Student(2, "����", "���", 20, "12345678913", date1));
	}
	public void mainMenu()
	{
		System.out.println("��ѡ��:1.��¼      2.ע��     3.�˳�");
		int x=sc.nextInt();
		sc.nextLine();
		if(x==1)
			login();
		else if(x==2)
			register();
		else if(x==3)
			System.out.println("���˳�����");
		else 
			mainMenu();
		
	}
	private void login()
	{
		System.out.println("����:");
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
			System.out.println("����:");
			String passwd=sc.nextLine();
			if(passwd.equals(t1.getPasswd()))
			{
				int check=rm.nextInt(9000)+1000;
				System.out.println("��֤����"+check);
				System.out.println("������֤��:");
				int checkcode=sc.nextInt();
				sc.nextLine();
				if(check==checkcode)
				{
					System.out.println("��¼�ɹ�");
					menu1();
				}
				else 
				{
					System.out.println("��֤�����");
					mainMenu();
				}
			}
			else
			{
				System.out.println("�������");
				mainMenu();
			}
		}
		else 
		{
			System.out.println("û�д˽�ʦ");
			mainMenu();
		}
		
	}
	private void register()
	{
		System.out.println("����:");
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
			System.out.println("�����ظ�");
			mainMenu();
		}
		else
		{
			System.out.println("����:");
			String passwd=sc.nextLine();
			System.out.println("ȷ������:");
			String repasswd=sc.nextLine();
			if (repasswd.equals(passwd))
			{
				System.out.println("����:");
				String name =sc.nextLine();
				System.out.println("����:");
				String email =sc.nextLine();
				System.out.println("�绰:");
				String phone =sc.nextLine();
				int check=rm.nextInt(9000)+1000;
				System.out.println("��֤����"+check);
				System.out.println("������֤��:");
				int checkcode=sc.nextInt();
				sc.nextLine();
				if(check==checkcode)
				{
					t.add(new Teacher(x, name, passwd, email, phone));
					System.out.println("ע��ɹ�");
					mainMenu();
				}
				else
				{
					System.out.println("��֤�����");
					mainMenu();
				}
			}
			else
			{
				System.out.println("���벻һ��");
				mainMenu();
			}	
		}
	}
	private void menu1() 
	{
		System.out.println("��ѡ��:1.��ѯѧ����Ϣ     2.ɾ��ѧԱ��Ϣ     3.�˳�");
		int x=sc.nextInt();
		sc.nextLine();
		if(x==1)
			selectmenu();
		else if(x==2)
			delete();
		else if(x==3)
		{
			System.out.println("�˳���¼");
			mainMenu();
		}
		else 
			menu1();
	}
	private void selectmenu()
	{
		System.out.println("��ѡ��:1.����ѧ�Ų�ѯ     2.��������ģ����ѯ     3.��ѯ����     4.�˳�");
		int x=sc.nextInt();
		sc.nextLine();
		if(x==1)
		{
			System.out.println("����ѧ��:");
			int id=sc.nextInt();
			sc.nextLine();
			select(id);
		}
		else if(x==2)
		{
			System.out.println("��������:");
			String name=sc.nextLine();
			select(name);
		}
		else if(x==3)
			select();
		else if(x==4)
		{
			System.out.println("�˳���ѯ");
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
			System.out.println("û�д�ѧ��");
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
			System.out.println("û�д�ѧ��");
		selectmenu();
	}
	private void delete()
	{
		System.out.println("ѧ��:");
		int id=sc.nextInt();
		sc.nextLine();
		int i=0,flag=0;
		for(i=0;i<s.size();i++) 
			if(s.get(i).getId()==id)
			{
				s.remove(i);
				flag=1;
				System.out.println("ɾ���ɹ�");
				break;
			}
		if(flag==0)
			System.out.println("û�д�ѧ��");
		menu1();
	}
	public static void main(String[] args) {
		new Manage().mainMenu();
	}
	
}
