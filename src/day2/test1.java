package day2;

public class test1 {
	public boolean isLeapYear(int year) {
		if(year%4==0&&year%100!=0||year%400==0) {
			return true;
		}
		return false;
	}
}
