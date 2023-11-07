package arraylist01;
import java.util.*;

public class Student {
	private int studentID;
	private String studentName;
	private ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		
		//subjectList = new ArrayList<Subject>();
	}
	
	public void addSubject(String name, int score) {
		Subject subject = new Subject();
		subject.setName(name);
		subject.setScorepoint(score);
		
		subjectList.add(subject);
	}
	
	public void Showinfo() {
		int tot = 0;
		for(Subject subject : subjectList) {
			tot += subject.getScorepoint();
			System.out.println("�л�"+studentName+"���� "+subject.getName()+"������ ������"
					+subject.getScorepoint()+"�� �Դϴ�.");
		}
		System.out.println("�л�"+studentName+"���� ������"+tot+"�Դϴ�.");
	}
}
