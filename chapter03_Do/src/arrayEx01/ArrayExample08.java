package arrayEx01;
import java.util.*;
public class ArrayExample08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[7];

		int cnt = 0; //좌석개수 변수
		boolean run = true;
		while(run) {
			for(int i=0; i<seat.length; i++) {
				if(seat[i] == 0) {
					System.out.print("[ ]");
				}else {
					System.out.print("[O]");
				}
			}
			System.out.println();
			System.out.println("=메가 영화관=");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			if(sel == 1) {
				System.out.print("좌석번호 선택[1~7] : ");
				int idx = scan.nextInt();
				idx -= 1; // 배열의 index번호가 0번부터 시작하기때문에 초기값을 0으로 만들어 주는 식

				if(seat[idx] == 0) {
					seat[idx] = 1;
					cnt += 1;
				}else {
					System.out.println("이미 예매가 완료된 자리입니다.");
				}
			}
			else if(sel == 2) {

				int total = cnt * 12000;
				System.out.println("매출액 = " +total + "원");

				run = false;
			}
		}

		scan.close();

	}
}
