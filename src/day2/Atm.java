package day2;

import java.util.Scanner;

public class Atm {
	private double money=200000;
	private Scanner sc=new Scanner(System.in);
	public void start(Card c) {
		int count=3;
		while(count!=0)
		{
			System.out.println("����������:");
			String passwd=sc.nextLine();
			if(passwd.equals(c.getPasswd()))
			{
				System.out.println("������ȷ");
				mainMenu(c);
				break;
			}
			else
			{
				count--;
				System.out.println("����������󣬻���"+count+"�λ��ᡣ");
			}
		}
		if(count==0)
		{
			System.out.println("�˺��ѱ����ᡣ");
		}
	}
	private void mainMenu(Card c)
	{
		System.out.print("1.�鿴���\r\n" + 
				"2.ȡ��\r\n" + 
				"3.���\r\n" + 
				"4.�˳�ȡ��\r\n" + 
				"��ѡ��:");
		int x=sc.nextInt();
		if(x==1)
			query(c);
		else if(x==2)
			draw(c);
		else if(x==3)
			deposit(c);
		else if(x==4)
			exit();
		else
		{
			System.out.println("������ѡ��");
			mainMenu(c);
		}
	}
	private void draw(Card c) {
		System.out.println("��ȡ��:");
		int x=sc.nextInt();
		double y=0;
		if(c.getType().equals("��������"))
			y=x;
		else
			y=x*1.03;
		if(x%50!=0&&x>2000)
		{
			System.out.println("ȡ��ʧ��");
			mainMenu(c);
		}
		else if(y>c.getMoney())
		{
			System.out.println("����");
			mainMenu(c);
		}
		else
		{
			this.money-=x;
			c.setMoney(c.getMoney()-y);
			System.out.println("ȡ��ɹ�");
			System.out.println("ȡ��"+x+"Ԫ");
			System.out.println("�������"+c.getMoney()+"Ԫ");
			mainMenu(c);
		}
	}
	private void deposit(Card c)
	{
		if(money>=500000)
		{
			System.out.println("�޷��������");
			mainMenu(c);
		}
		else
		{
			System.out.println("����:");
			int x=sc.nextInt();
			if(x%50!=0)
			{
				System.out.println("���ʧ��");
				mainMenu(c);
			}
			else
			{
				this.money+=x;
				c.setMoney(c.getMoney()+x);
				System.out.println("���ɹ�");
				System.out.println("���"+x+"Ԫ");
				System.out.println("�������"+c.getMoney()+"Ԫ");
				mainMenu(c);
			}
		}
		
	}
	private void query(Card c) 
	{
		System.out.println("�������:"+c.getMoney()+"Ԫ");
		mainMenu(c);
	}
	private void exit() 
	{
		System.out.println("���˿�����ȡ��");
	}
	public static void main(String[] args) {
		Card c=new Card("11", "123456", 100000, "��������");
		new Atm().start(c);
	}
}
