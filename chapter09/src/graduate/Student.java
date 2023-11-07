package graduate;

public class Student {

	protected String name;  // 이름
	protected String course; // 소속학과
	protected int grade; // 학년
	protected int credit; // 이수학점수
	
	public Student() {}
	public  Student(String name, String course, int grade, int credit)
	{
		this.name = name;
		this.course =course;
		this.grade = grade;
		this.credit = credit;
	}

	@Override
	public String toString()
	{
		return "이름 : " + name
				+ "\n소속학과 : " + course
				+ "\n학년 : " + grade
				+ "\n이수학점수 : " + credit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
