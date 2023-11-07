package classpart15;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] list = new Student[3]; 
		int cnt = 0;
		while(true) {
			for(int i=0;i<cnt;i++) {
				System.out.println("["+(i+1)+"]"+list[i].name+"학생>>>");
				if(list[i].subjects != null) {
					for(int j=0;j<list[i].subjects.length;j++) {
						System.out.println("["+(j+1)+"]"+list[i].subjects[j].name+"과목="+list[i].subjects[j].score+"점");
					}
				}
				System.out.println();
			}
			System.out.println("[1]학생 추가하기");
			System.out.println("[2]과목 추가하기");
			System.out.println("[3]성적 추가하기");
			System.out.println("[0]종료");
		    
			int choice = scan.nextInt();
			if(choice == 1) {
				System.out.println("이름입력 :");
				String name = scan.next();
				list[cnt] = new Student();
				list[cnt].name = name;
				cnt ++;
				
			}else if(choice == 2) {
				for(int i=0;i<cnt;i++) {
					System.out.println("["+(i+1)+"]"+list[i].name);
				}
				System.out.println("학생 선택 :");
				int sel = scan.nextInt();
				sel = sel -1; //index가 0부터 시작
				System.out.println("과목 입력 :");
				String subj = scan.next();
				
				if(list[sel].subjects == null) {
					list[sel].subjects = new Subject[1];
					list[sel].subjects[0] = new Subject();
					list[sel].subjects[0].name = subj;
				}else {
					int size = list[sel].subjects.length;
					Subject[] temp = list[sel].subjects;
					list[sel].subjects = new Subject[size+1];
					
					for(int i=0;i<size;i++) {
						list[sel].subjects[i] = temp[i];
					}
					
					list[sel].subjects[size] = new Subject();
					list[sel].subjects[size].name = subj;
					
					temp = null;
				}
				
			}else if(choice == 3) {
				for(int i=0;i<cnt;i++) {
					System.out.println("["+(i+1)+"]"+list[i].name);
				}
				System.out.println("학생 선택 :");
				int select = scan.nextInt();
				select = select -1;
				
				if(list[select].subjects != null) {
					for(int j=0;j<list[select].subjects.length;j++) {
						System.out.println("["+(j+1)+"]"+list[select].subjects[j].name);
					}
				}
				System.out.println("과목 선택 :");
				int num = scan.nextInt();
				num = num -1;
				System.out.println("성적 입력 :");
				int score = scan.nextInt();
				
				list[select].subjects[num].score = score;
			
			}else {
				System.out.println("프로그램 종료");
				break;
			}
					
		}
		scan.close();
//---------------------------------------------------------------		
	}

}
