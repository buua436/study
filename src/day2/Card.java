package day2;

public class Card {
	private String no;
	private String passwd="123456";
	private double money=100000;
	private String type="工商银行";
	public Card(String no, String passwd, double money, String type) {
		super();
		this.no = no;
		this.passwd = passwd;
		this.money = money;
		this.type = type;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
