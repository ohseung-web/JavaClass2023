package chapter7;

public class Student {
	private String name, major, sNumber;
	private double grade;
	public Student(String name, String major, String sNumber, double grade) {
		this.name = name;
		this.major = major;
		this.sNumber = sNumber;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public String getsNumber() {
		return sNumber;
	}
	public double getGrade() {
		return grade;
	}
}

