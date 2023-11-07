package studentScore;
import java.util.*;
public class StudentRun {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Student>  list = new ArrayList<>();
		System.out.println("학생 이름,학과,학번,학점평균을 입력하세요 :");

		// ArrayList 학생정보 저장
		for(int i=0; i<4;i++) {
			System.out.println(">>");
			String studentList = scan.next();
			StringTokenizer st = new StringTokenizer(studentList,",");
			String name = st.nextToken().trim();
			String department = st.nextToken().trim();
			String studentID = st.nextToken().trim();
			//  parseDouble : 문자열에서  double의 형식으로  파싱하는 메서드
			double credit = Double.parseDouble(st.nextToken().trim());
			Student temp = new Student(name, department, studentID, credit);
			list.add(temp);
		}
		// ArrayList 학생정보 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println("----------------------------");
			System.out.println("이름 :"+ list.get(i).getName());
			System.out.println("학과 :"+ list.get(i).getDepartment());
			System.out.println("학번 :"+ list.get(i).getStudentID());
			System.out.println("학점평균 :"+ list.get(i).getCredit());
			System.out.println("----------------------------");
		}
        // ArrayList 학생정보 검색
		while(true) {
			System.out.println("학생이름 >>");
			String myname = scan.next();

			if(myname.equals("그만")) {
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
