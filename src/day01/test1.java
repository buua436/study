package day01;
//蔡少豪Z09418101
import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("输入学生人数:");
		int x=sc.nextInt();
		int i=0;
		int count=0;
		int score=0;
		for(i=0;i<x;i++)
		{
			System.out.print("输入第"+(i+1)+"个学生成绩:");
			score=sc.nextInt();
			if(score>=85)count++;
		}
		double pro=count*1.0/x;
		if(pro>=0.8)
			System.out.print("班级成绩优秀");
		else if(pro>=0.6)
			System.out.print("班级成绩良好");
		else if(pro>=0.4)
			System.out.print("班级成绩一般");
		else if(pro<0.2)
			System.out.print("班级成绩较差");
		
	}
}
