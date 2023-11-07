package graduate;

public class Student {

	protected String name;  // �̸�
	protected String course; // �Ҽ��а�
	protected int grade; // �г�
	protected int credit; // �̼�������
	
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
		return "�̸� : " + name
				+ "\n�Ҽ��а� : " + course
				+ "\n�г� : " + grade
				+ "\n�̼������� : " + credit;
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
