package day1;

import java.util.Random;
import java.util.Scanner;

public class task02 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("1. ��½\r\n" + 
				"2. ע��\r\n" + 
				"3. �˳�\r\n" + 
				"��ѡ��:");;
		int x=sc.nextInt();
		if(x==1)
		{
			System.out.print("�����˻���:");
			sc.nextLine();
			String name=sc.nextLine();
			if(name.equals("admin"))
			{
				System.out.print("��������:");
				String passwd=sc.nextLine();
				if(passwd.equals("123456"))
				{
					Random rm=new Random();
					int check=1000+rm.nextInt(9000);
					System.out.print(check);
					System.out.print("\n������֤��:");
					int check2=sc.nextInt();
					if(check2==check)
					{
						System.out.print("��¼�ɹ�");
						System.out.print("\n���˵�\r\n" + 
								"1. ���˳齱\r\n" + 
								"2. �������\r\n" + 
								"3. �˳�ϵͳ\r\n" + 
								"��ѡ��");
						int choice=sc.nextInt();
						if(choice==1)
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
					}
				}
				
			}
		}
	}

}
