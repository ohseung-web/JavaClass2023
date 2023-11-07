package classPart;

import java.util.Scanner;

public class ReturnClass {

	int num1 = 10;
	int num2 = 20;


	public void test02() {
		if(num1 >= num2) {
			System.out.println("크다");
		}
		return;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ReturnClass r = new ReturnClass();

		while(true) {
			System.out.println("메뉴출력");
			int sel = scan.nextInt();
			if(sel == 1) {
				r.test02();
			}else {
				System.out.println("종료");
				return;
			}
		}		
	}

}
