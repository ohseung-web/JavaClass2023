package studentScore;

public class Student {
      
	private String name; // �̸�
	private String department; // �а�
	private Integer studentID; // �й�
	private double credit; // ����
	
	public Student() {}
	public Student(String name, String department, Integer studentID, double credit) {
		 this.name = name;
		 this.department = department;
		 this.studentID = studentID;
		 this.credit = credit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
}
