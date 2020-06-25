package day2;

import java.util.Random;
import java.util.Scanner;

public class Menu {
	private Scanner sc=new Scanner(System.in);
	private Account account=new Account();
	private Random rm=new Random();
	public void start()
	{
		System.out.print("1. 登陆\r\n" + 
				"2. 注册\r\n" + 
				"3. 退出\r\n" + 
				"请选择:");;
		int x=sc.nextInt();
		if(x==1) {
			login();
		}
		else if(x==2)
			register();
		else if(x==3)
			;
		else
		{
			System.out.print("选择有误，请重新选择\n");
			start();
		}
	}
	private void register()
	{
		sc.nextLine();
		System.out.print("输入账户名:");
		String name=sc.nextLine();
		System.out.print("输入密码:");
		String passwd=sc.nextLine();
		System.out.print("再次输入密码:");
		String repasswd=sc.nextLine();
		int check=rm.nextInt(9000)+1000;
		System.out.println("验证码是"+check);
		System.out.println("输入验证码:");
		int checkcode=sc.nextInt();
		sc.nextLine();
		if(repasswd.equals(passwd))
		{
			if(check==checkcode)
			{
				account.setName(name);
				account.setPasswd(passwd);
				System.out.println("注册成功");
				start();
			}
			else
			{
				System.out.println("验证码输入错误");
				System.out.println("注册失败");
				start();
			}
		}
		else
		{
			System.out.println("两次密码输入不一致,注册失败");
			start();
		}
		
	}
	private void login()
	{
		{
			int count=2;
			sc.nextLine();
			while(true)
			{
				System.out.print("输入账户名:");
				String name=sc.nextLine();
				System.out.print("输入密码:");
				String passwd=sc.nextLine();
				
				if(name.equals(account.getName())&&passwd.equals(account.getPasswd()))
				{
					System.out.println("输入正确，进入系统");
					mainMenu();
					break;
				}else if(count!=0)
				{
					System.out.println("用户名或密码输入错误，请重新输入");
					System.out.println("还有"+count+"次");
					count--;
				}
				else
				{
					System.out.println("用户名或密码输入错误，账号已冻结，请联系管理员");
					break;
				}
			}
		}
	}
	private void mainMenu()
	{
		;
	}
	private void draw()
	{
		System.out.print("输入四位数账号:");
		int account=sc.nextInt();
		if(account<=9999&&account>=1000)
		{
			int reward=rm.nextInt(10);
			System.out.print("抽奖号码是"+reward);
			System.out.println();
			if((account/100)%10==reward)
				System.out.print("恭喜你,中奖了");
			else
				System.out.print("抽奖失败");
		}
	}
	public static void main(String[] args) 
	{
		new Menu().start();
	}
}
