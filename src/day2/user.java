package day2;

public class user {
	public void printshape(int x)
	{
		if(x%2!=0) {
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
	public static void main(String[] args) {
		new user().printshape(7);
	}
}
