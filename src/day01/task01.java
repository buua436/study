package day01;

import java.util.Scanner;

public class task01 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("输入菱形行数:");
		int x=sc.nextInt();
		while(x%2==0)
		{
			System.out.print("输入菱形行数:");
			x=sc.nextInt();
		}
		int i=0,j=0;
		for(i=0;i<x;i++)
		{
			for(j=0;j<x;j++)
				if(j>=(x/2-i)&&j<=(x/2+i)&&j>=(i-x/2)&&j<=(x+x/2-i-1))
					System.out.print('*');
				else
					System.out.print(' ');
			System.out.println();
		}
		System.out.println("---------------------------------------");
		for(i=0;i<x;i++)
		{
			for(j=0;j<x;j++)
				if(j==(x/2-i)||j==(x/2+i)||j==(i-x/2)||j==(x+x/2-i-1))
					System.out.print('*');
				else
					System.out.print(' ');
			System.out.println();
		}
	}
		

}
