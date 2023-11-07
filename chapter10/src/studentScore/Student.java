package studentScore;

public class Student {
      
	private String name; // 이름
	private String department; // 학과
	private Integer studentID; // 학번
	private double credit; // 평점
	
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
