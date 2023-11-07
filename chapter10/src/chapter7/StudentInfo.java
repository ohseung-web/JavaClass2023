package chapter7;
import java.util.*;

public class StudentInfo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> info = new ArrayList<>();
				
		System.out.println("�л� �̸�, �а�, �й�, ���� ����� �Է��ϼ���.");
		for(int i = 0; i < 4; i++) {
			System.out.print(">> ");
			String text = sc.nextLine();
			StringTokenizer st = new StringTokenizer(text, ",");
			String name = st.nextToken().trim();
			String major = st.nextToken().trim();
			String sNumber = st.nextToken().trim();
			double grade = Double.parseDouble(st.nextToken().trim());
			
			Student s = new Student(name, major, sNumber, grade);
			info.add(s);
		}
		
		for(int i=0; i< info.size(); i++) {
			System.out.println("---------------------------");
			System.out.println("�̸�:" + info.get(i).getName());
			System.out.println("�а�:" + info.get(i).getMajor());
			System.out.println("�й�:" + info.get(i).getsNumber());
			System.out.println("�������:" + info.get(i).getGrade());
			System.out.println("---------------------------");
		}
		
		/*
		Iterator<Student> it = info.iterator();
		while (it.hasNext()) {
			Student student = it.next();
			System.out.println("---------------------------");
			System.out.println("�̸�:" + student.getName());
			System.out.println("�а�:" + student.getMajor());
			System.out.println("�й�:" + student.getsNumber());
			System.out.println("�������:" + student.getGrade());
			System.out.println("---------------------------");
		}	
		*/
		while(true) {
			System.out.print("�л� �̸� >> ");
			String name = sc.nextLine();
			if(name.equals("�׸�")) break;
			
			for(int i = 0; i < info.size(); i++) {
				Student s = info.get(i);
				if(s.getName().equals(name)) {
					System.out.print(s.getName() + ", ");
					System.out.print(s.getMajor() + ", ");
					System.out.print(s.getsNumber() + ", ");
					System.out.println(s.getGrade());
					break;
				}
			}
		}
		sc.close();
	}

}
