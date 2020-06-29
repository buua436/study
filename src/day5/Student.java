package day5;

import java.util.Calendar;

public class Student {
	private int id;
	private String name;
	private String cls;
	private int age;
	private String phone;
	private Calendar date;
	
	public Student(int id, String name, String cls, int age, String phone, Calendar date) {
		super();
		this.id = id;
		this.name = name;
		this.cls = cls;
		this.age = age;
		this.phone = phone;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	@Override
	public String toString() {
		int year=date.get(Calendar.YEAR);
		int month=date.get(Calendar.MONTH);
		int day=date.get(Calendar.DAY_OF_MONTH);
		return "Student [id=" + id + ", name=" + name + ", cls=" + cls + ", age=" + age + ", phone=" + phone + ", date="
				+year+ "/"+month+"/" + day+"]";
	}
	
}
