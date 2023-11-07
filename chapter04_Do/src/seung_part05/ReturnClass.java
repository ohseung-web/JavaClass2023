package seung_part05;

import java.util.Scanner;

class ReturnEx{
	
	public void returnint() {
		int k=10;
		// System.out.println(k);
	}
	
	public String returnstr() {
		return "자바";
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
		System.out.println(re.returnstr()); // retrun은 값을 반환할 수있다.
		re.returnint(); //void함수는 print문 또는 변수로 값을 반환할 수 없다.
		
		int[] arr = {6,8,12,20,9,10};
		ReturnEx02 re02 = new ReturnEx02();
		System.out.println(re02.arr(arr));
		
		while(true){
			System.out.println("메뉴선택");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.println("연습");
				return;
			}else if(select ==2) {
				System.out.println("연습2");
			}else if(select == 3) {
				System.out.println("종료"); 	
				break;
			}
		}
	
	    
	}
}
