package day01;
//���ٺ�Z09418101
import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("����ѧ������:");
		int x=sc.nextInt();
		int i=0;
		int count=0;
		int score=0;
		for(i=0;i<x;i++)
		{
			System.out.print("�����"+(i+1)+"��ѧ���ɼ�:");
			score=sc.nextInt();
			if(score>=85)count++;
		}
		double pro=count*1.0/x;
		if(pro>=0.8)
			System.out.print("�༶�ɼ�����");
		else if(pro>=0.6)
			System.out.print("�༶�ɼ�����");
		else if(pro>=0.4)
			System.out.print("�༶�ɼ�һ��");
		else if(pro<0.2)
			System.out.print("�༶�ɼ��ϲ�");
		
	}
}
