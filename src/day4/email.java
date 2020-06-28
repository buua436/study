package day4;

import java.util.Scanner;

public class email {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println(s.matches("^[A-Za-z]\\w+@\\w+(\\.[A-Za-z]+)+$"));
	}
}
