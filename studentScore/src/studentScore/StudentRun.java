package studentScore;
import java.util.*;
public class StudentRun {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Student>  list = new ArrayList<>();
		System.out.println("�л� �̸�,�а�,�й�,��������� �Է��ϼ��� :");

		// ArrayList �л����� ����
		for(int i=0; i<4;i++) {
			System.out.println(">>");
			String studentList = scan.next();
			StringTokenizer st = new StringTokenizer(studentList,",");
			String name = st.nextToken().trim();
			String department = st.nextToken().trim();
			String studentID = st.nextToken().trim();
			//  parseDouble : ���ڿ�����  double�� ��������  �Ľ��ϴ� �޼���
			double credit = Double.parseDouble(st.nextToken().trim());
			Student temp = new Student(name, department, studentID, credit);
			list.add(temp);
		}
		// ArrayList �л����� ���
		for(int i=0; i<list.size(); i++) {
			System.out.println("----------------------------");
			System.out.println("�̸� :"+ list.get(i).getName());
			System.out.println("�а� :"+ list.get(i).getDepartment());
			System.out.println("�й� :"+ list.get(i).getStudentID());
			System.out.println("������� :"+ list.get(i).getCredit());
			System.out.println("----------------------------");
		}
        // ArrayList �л����� �˻�
		while(true) {
			System.out.println("�л��̸� >>");
			String myname = scan.next();

			if(myname.equals("�׸�")) {
				break;
			}else {
				for(int i=0; i<list.size(); i++) {
					if(myname.equals(list.get(i).getName())) {
						System.out.println(list.get(i).getName()+","
								+list.get(i).getDepartment()+","
								+list.get(i).getStudentID()+","
								+list.get(i).getCredit());
					}
				}
			}
		}
	      scan.close();	
	}
}
