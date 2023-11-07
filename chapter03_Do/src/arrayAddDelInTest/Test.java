package arrayAddDelInTest;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = {10,20,0,0,0};
		int cnt =2;

		boolean run = true;
		while(run) {
			// arr의 데이터 출력
			for(int i=0; i<cnt; i++) {
				System.out.print(arr[i]+" ");
			}
		
			//메뉴
			System.out.println();
			System.out.println("[1].삭제");
			System.out.println("[2].추가");
			System.out.println("[3].삽입");
			System.out.println("[0].종료");
			System.out.print("메뉴선택 :");
			int select = scan.nextInt();
			
			// arr의 데이터 삭제
			switch(select) {
			case 1:
				System.out.println("삭제할 값을 입력하세요");
				int data = scan.nextInt();

				int delindex = -1;// 삭제할 값이 존재하는지 여부 치트키
				for(int i=0; i<cnt; i++) {
					if(arr[i] == data) {
						delindex = i;	 // delindex = 1	   
					}
				}
				if(delindex == -1) {
					System.out.println("존재 하지 않는 값입니다.");
					break;
				}else {
					for(int i=delindex; i<cnt-1;i++) { 
						arr[i] = arr[i+1];
					}
				}
				cnt -= 1;
				break;
			case 2:
				if(cnt == 5) {
					System.out.println("더 이상 추가할 수 없습니다.");
					continue;
				}
				System.out.print("추가할 데이터 입력");
				int data1 = scan.nextInt();
				arr[cnt] = data1;
				cnt ++;
				break;
			case 3:
				if(cnt == 5) {
					System.out.println("더 이상 삽입할 수 없습니다.");
					break;
				}
				System.out.print("데이터를 삽입할 위치를 입력");
				int insertIndex = scan.nextInt();
				if(cnt< insertIndex || insertIndex < 0) {
					System.out.println("데이터 삽입 불가능");
					continue;
				}
				System.out.print("삽입할 데이터 입력");
				int data2  = scan.nextInt();
				for(int i=cnt; i > insertIndex; i--) {
					 arr[i] = arr[i-1];
				}
				arr[insertIndex] = data2;
				cnt ++;
				break;
			case 0:
				System.out.println("종료");
				run = false;
				break;
			}
		}

		scan.close();    
	}

}
