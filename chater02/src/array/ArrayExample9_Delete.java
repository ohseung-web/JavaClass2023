package array;
import java.util.*;
public class ArrayExample9_Delete {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = {10,20,30,40,50};
		int cnt = 5;
		
		boolean run = true;
		while(run) {
			for(int i=0;i<cnt; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			System.out.println("[2].����");
			System.out.print("�޴����� :");
			int sel = scan.nextInt();
			
			switch(sel) {
			case 2:
				  System.out.println("������ �� �Է� :");
				  int data = scan.nextInt();
				  
				  int delindex = -1;
				  for(int i=0;i<cnt;i++) {
					  if(arr[i] == data) {
						  delindex = i;
					  }
				  }
				  if(delindex == -1) {
					  System.out.println("�Է��� ���� �������� �ʽ��ϴ�.");
					  break;
				  }else {
					  for(int i=delindex;i<cnt-1;i++) {
						  arr[i] = arr[i+1];
					  }
				  }
				  cnt -= 1;
				break;
			}
		}
		scan.close();
	}

}
