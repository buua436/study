package day4;

import java.util.Scanner;

public class secret {
	public StringBuffer  sec(StringBuffer s)
	{
		int l=s.length();
		int i=0;
		for(i=0;i<l;i++)
		{
			s.setCharAt(i, (char)(s.charAt(i)+10));
		}
		char c=s.charAt(0);
		for(i=0;i<l-1;i++)
			s.setCharAt(i,s.charAt(i+1));
		s.setCharAt(l-1,c);
		return s;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuffer s1=new StringBuffer(sc.nextLine());
		System.out.println(new secret().sec(s1));
	}

}
