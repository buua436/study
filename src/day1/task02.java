package day1;

import java.util.Random;
import java.util.Scanner;

public class task02 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("1. 登陆\r\n" + 
				"2. 注册\r\n" + 
				"3. 退出\r\n" + 
				"请选择:");;
		int x=sc.nextInt();
		if(x==1)
		{
			System.out.print("输入账户名:");
			sc.nextLine();
			String name=sc.nextLine();
			if(name.equals("admin"))
			{
				System.out.print("输入密码:");
				String passwd=sc.nextLine();
				if(passwd.equals("123456"))
				{
					Random rm=new Random();
					int check=1000+rm.nextInt(9000);
					System.out.print(check);
					System.out.print("\n输入验证码:");
					int check2=sc.nextInt();
					if(check2==check)
					{
						System.out.print("登录成功");
						System.out.print("\n主菜单\r\n" + 
								"1. 幸运抽奖\r\n" + 
								"2. 购物结算\r\n" + 
								"3. 退出系统\r\n" + 
								"请选择：");
						int choice=sc.nextInt();
						if(choice==1)
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
					}
				}
				
			}
		}
	}

}
