package day4;

import java.util.Scanner;

public class Camel {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] str = s.split("#");
		StringBuffer sbuff =new StringBuffer();
		sbuff.append(str[0].toLowerCase());
		int i=0;
		for(i=1;i<str.length;i++)
		{
			StringBuffer s2=new StringBuffer(str[i]);
			s2.setCharAt(0,Character.toUpperCase(s2.charAt(0)));
			sbuff.append(s2);
		}
		System.out.println(sbuff);
	}
}
