package day2;

import java.util.Scanner;

public class Atm {
	private double money=200000;
	private Scanner sc=new Scanner(System.in);
	public void start(Card c) {
		int count=3;
		while(count!=0)
		{
			System.out.println("请输入密码:");
			String passwd=sc.nextLine();
			if(passwd.equals(c.getPasswd()))
			{
				System.out.println("密码正确");
				mainMenu(c);
				break;
			}
			else
			{
				count--;
				System.out.println("密码输入错误，还有"+count+"次机会。");
			}
		}
		if(count==0)
		{
			System.out.println("账号已被冻结。");
		}
	}
	private void mainMenu(Card c)
	{
		System.out.print("1.查看余额\r\n" + 
				"2.取款\r\n" + 
				"3.存款\r\n" + 
				"4.退出取卡\r\n" + 
				"请选择:");
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
			System.out.println("请重新选择");
			mainMenu(c);
		}
	}
	private void draw(Card c) {
		System.out.println("请取款:");
		int x=sc.nextInt();
		double y=0;
		if(c.getType().equals("工商银行"))
			y=x;
		else
			y=x*1.03;
		if(x%50!=0&&x>2000)
		{
			System.out.println("取款失败");
			mainMenu(c);
		}
		else if(y>c.getMoney())
		{
			System.out.println("余额不足");
			mainMenu(c);
		}
		else
		{
			this.money-=x;
			c.setMoney(c.getMoney()-y);
			System.out.println("取款成功");
			System.out.println("取款"+x+"元");
			System.out.println("现有余额"+c.getMoney()+"元");
			mainMenu(c);
		}
	}
	private void deposit(Card c)
	{
		if(money>=500000)
		{
			System.out.println("无法继续存款");
			mainMenu(c);
		}
		else
		{
			System.out.println("请存款:");
			int x=sc.nextInt();
			if(x%50!=0)
			{
				System.out.println("存款失败");
				mainMenu(c);
			}
			else
			{
				this.money+=x;
				c.setMoney(c.getMoney()+x);
				System.out.println("存款成功");
				System.out.println("存款"+x+"元");
				System.out.println("现有余额"+c.getMoney()+"元");
				mainMenu(c);
			}
		}
		
	}
	private void query(Card c) 
	{
		System.out.println("卡内余额:"+c.getMoney()+"元");
		mainMenu(c);
	}
	private void exit() 
	{
		System.out.println("已退卡，请取卡");
	}
	public static void main(String[] args) {
		Card c=new Card("11", "123456", 100000, "工商银行");
		new Atm().start(c);
	}
}
