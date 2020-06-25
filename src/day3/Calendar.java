package day3;

import java.util.Scanner;

public class Calendar {
	public int year;
	public int moon;
	public Calendar(int year, int moon) {
		super();
		this.year = year;
		this.moon = moon;
	}
	public int day()
	{
		int i=0,sum=0;
		for(i=1900;i<year;i++)
		{
			if(isleap(i))
				sum+=366;
			else
				sum+=365;
		}
		for(i=1;i<moon;i++)
		{
			if(i==4||i==6||i==9||i==11)
				sum+=30;
			else if(isleap(year)&&i==2)
				sum+=29;
			else if(i==2)
				sum+=28;
			else sum+=31;
		}
		return sum%7;
	}
	public void print()
	{
		System.out.println("一\t二\t三\t四\t五\t六\t日");
		int i=0;
		int count=0;
		int day;
		if(i==4||i==6||i==9||i==11)
			day=30;
		else if(isleap(year)&&i==2)
			day=29;
		else if(i==2)
			day=28;
		else day=31;
		for(count=0;count<day();count++)
			System.out.print(" \t");
		count=day()+1;
		for(i=1;i<=day;i++)
		{
			if(count%7==0)
				System.out.print(i+"\n");
			else
				System.out.print(i+"\t");
			count++;
		}
		
	}
	public boolean isleap(int year)
	{
		if(year%4==0&&year%100!=0||year%400==0)return true;
		else return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入年份:");
		int year=sc.nextInt();
		System.out.print("请输入月份:");
		int moon=sc.nextInt();
		new Calendar(year, moon).print();		
	}
}
