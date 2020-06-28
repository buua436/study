package day4;

public class string {
	public void indexof(String a,String b)
	{
		int x=a.indexOf(b);
		while(x!=-1)
		{
			System.out.println(x);
			x=a.indexOf(b,x+1);
		}
	}
	public static void main(String[] args) {
		new string().indexof("adfabdfadhfadfahdfadfhadhfadf","fa");
	}
}
