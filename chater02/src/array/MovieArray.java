package array;
import java.util.*;
public abstract class MovieArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[7]; // 영화관 좌석수 배열선언문
		int cnt = 0; // 예매인원수 세는 변수
		
		boolean run = true; //무한루프 초기값
		while(run) {
			for(int i=0;i<seat.length;i++) {
				if(seat[i]==0) {  // 예매좌석은 1로 비예매좌석은 0으로 좌석 초기값설정 조건
					System.out.print("[ ]");
				}else {
					System.out.print("[O]");
				}
			}
			System.out.println();
			System.out.println("=== 메가영화관 ===");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			System.out.print("메뉴 선택 :");
			int menu = scan.nextInt();
			switch(menu) {
			case 1 :
				System.out.print("좌석번호 선택[1~7] : ");
				int seatnumber = scan.nextInt();
				seatnumber -= 1 ; // seatnumber = seatnumber-1과 같은 의미로 좌석번호는 1번부터 시작하지만 배열은 0번부터 시작하기때문에 
				if(seat[seatnumber]==0) {
					seat[seatnumber] = 1; // 예매된 자리에 1을 입력해준다.
					cnt += 1;
				}else {
					System.out.println("이미 예매가 완료된 자리입니다.");
				}
				break;
			case 2 :
				System.out.println("매출액 :"+cnt*12000);
				run = false;
				break;
			}
		}
	}

}
