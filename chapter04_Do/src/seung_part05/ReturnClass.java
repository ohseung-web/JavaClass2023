package seung_part05;

import java.util.Scanner;

class ReturnEx{
	
	public void returnint() {
		int k=10;
		// System.out.println(k);
	}
	
	public String returnstr() {
		return "�ڹ�";
	}
}
class ReturnEx02{
	
	public int arr(int[] arr) {
		int cnt =0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] % 4 == 0) {
				cnt ++;
			}
		}
		return cnt;
	}
}

public class ReturnClass {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		ReturnEx re = new ReturnEx();
		System.out.println(re.returnstr()); // retrun�� ���� ��ȯ�� ���ִ�.
		re.returnint(); //void�Լ��� print�� �Ǵ� ������ ���� ��ȯ�� �� ����.
		
		int[] arr = {6,8,12,20,9,10};
		ReturnEx02 re02 = new ReturnEx02();
		System.out.println(re02.arr(arr));
		
		while(true){
			System.out.println("�޴�����");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.println("����");
				return;
			}else if(select ==2) {
				System.out.println("����2");
			}else if(select == 3) {
				System.out.println("����"); 	
				break;
			}
		}
	
	    
	}
}
