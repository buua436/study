package day2;

import java.util.Random;
import java.util.Scanner;

public class Menu {
	private Scanner sc=new Scanner(System.in);
	private Account account=new Account();
	private Random rm=new Random();
	public void start()
	{
		System.out.print("1. ��½\r\n" + 
				"2. ע��\r\n" + 
				"3. �˳�\r\n" + 
				"��ѡ��:");;
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
			System.out.print("ѡ������������ѡ��\n");
			start();
		}
	}
	private void register()
	{
		sc.nextLine();
		System.out.print("�����˻���:");
		String name=sc.nextLine();
		System.out.print("��������:");
		String passwd=sc.nextLine();
		System.out.print("�ٴ���������:");
		String repasswd=sc.nextLine();
		int check=rm.nextInt(9000)+1000;
		System.out.println("��֤����"+check);
		System.out.println("������֤��:");
		int checkcode=sc.nextInt();
		sc.nextLine();
		if(repasswd.equals(passwd))
		{
			if(check==checkcode)
			{
				account.setName(name);
				account.setPasswd(passwd);
				System.out.println("ע��ɹ�");
				start();
			}
			else
			{
				System.out.println("��֤���������");
				System.out.println("ע��ʧ��");
				start();
			}
		}
		else
		{
			System.out.println("�����������벻һ��,ע��ʧ��");
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
				System.out.print("�����˻���:");
				String name=sc.nextLine();
				System.out.print("��������:");
				String passwd=sc.nextLine();
				
				if(name.equals(account.getName())&&passwd.equals(account.getPasswd()))
				{
					System.out.println("������ȷ������ϵͳ");
					mainMenu();
					break;
				}else if(count!=0)
				{
					System.out.println("�û��������������������������");
					System.out.println("����"+count+"��");
					count--;
				}
				else
				{
					System.out.println("�û�����������������˺��Ѷ��ᣬ����ϵ����Ա");
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
		System.out.print("������λ���˺�:");
		int account=sc.nextInt();
		if(account<=9999&&account>=1000)
		{
			int reward=rm.nextInt(10);
			System.out.print("�齱������"+reward);
			System.out.println();
			if((account/100)%10==reward)
				System.out.print("��ϲ��,�н���");
			else
				System.out.print("�齱ʧ��");
		}
	}
	public static void main(String[] args) 
	{
		new Menu().start();
	}
}
