package array;
import java.util.*;
public class ArrayExample9_Insert2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = {10,20,0,0,0};
		int cnt = 2;
		
		boolean run = true;
		while(run) {
			for(int i=0;i<cnt;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			System.out.println("[3].삽입");
			System.out.println("[0].종료");
			System.out.println("메뉴선택 :");
			int sel =scan.nextInt();
			
			switch(sel) {
			case 3:
				if(cnt == 5) {
					System.out.println("더 이상 삽입할 수 없습니다.");
					continue;
				}
				System.out.print("삽입할 위치 입력 :");
			    int index = scan.nextInt();
			    if(index<0 || index>cnt) {
			    	System.out.println("해당 위치는 삽입할 수없습니다.");
			    	continue;
			    }
			    System.out.print("삽입할 값을 입력 :");
			    int data = scan.nextInt();
				for(int i=cnt;i>index;i--) {
					arr[i] = arr[i-1];
				}
				arr[index] = data;
				cnt += 1;
				break;
			case 0:
				run = false;
				break;
			}
		}
	}

}
