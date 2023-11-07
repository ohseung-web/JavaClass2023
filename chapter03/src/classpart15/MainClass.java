package classpart15;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] list = new Student[3]; 
		int cnt = 0;
		while(true) {
			for(int i=0;i<cnt;i++) {
				System.out.println("["+(i+1)+"]"+list[i].name+"�л�>>>");
				if(list[i].subjects != null) {
					for(int j=0;j<list[i].subjects.length;j++) {
						System.out.println("["+(j+1)+"]"+list[i].subjects[j].name+"����="+list[i].subjects[j].score+"��");
					}
				}
				System.out.println();
			}
			System.out.println("[1]�л� �߰��ϱ�");
			System.out.println("[2]���� �߰��ϱ�");
			System.out.println("[3]���� �߰��ϱ�");
			System.out.println("[0]����");
		    
			int choice = scan.nextInt();
			if(choice == 1) {
				System.out.println("�̸��Է� :");
				String name = scan.next();
				list[cnt] = new Student();
				list[cnt].name = name;
				cnt ++;
				
			}else if(choice == 2) {
				for(int i=0;i<cnt;i++) {
					System.out.println("["+(i+1)+"]"+list[i].name);
				}
				System.out.println("�л� ���� :");
				int sel = scan.nextInt();
				sel = sel -1; //index�� 0���� ����
				System.out.println("���� �Է� :");
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
				System.out.println("�л� ���� :");
				int select = scan.nextInt();
				select = select -1;
				
				if(list[select].subjects != null) {
					for(int j=0;j<list[select].subjects.length;j++) {
						System.out.println("["+(j+1)+"]"+list[select].subjects[j].name);
					}
				}
				System.out.println("���� ���� :");
				int num = scan.nextInt();
				num = num -1;
				System.out.println("���� �Է� :");
				int score = scan.nextInt();
				
				list[select].subjects[num].score = score;
			
			}else {
				System.out.println("���α׷� ����");
				break;
			}
					
		}
		scan.close();
//---------------------------------------------------------------		
	}

}
