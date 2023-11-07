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
			System.out.println("학생"+studentName+"님의 "+subject.getName()+"과목의 성적은"
					+subject.getScorepoint()+"점 입니다.");
		}
		System.out.println("학생"+studentName+"님의 총점은"+tot+"입니다.");
	}
}
