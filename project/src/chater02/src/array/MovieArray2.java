package array;
import java.util.*;
public abstract class MovieArray2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		int[] seat = new int[7];

		int cnt = 0;

		boolean run = true;
		while(run) {

			for(int i=0; i<7; i++) {
				if(seat[i] == 0) {
					System.out.print("[ ]");
				}else if(seat[i]==2) {
					System.out.print("[X]");
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
				System.out.print("예매 인원을 입력하세요[1~7] :");
				int inwon = scan.nextInt();
				System.out.print("좌석번호 선택[1~7] : ");
				int idx = scan.nextInt();
				idx -= 1;

				if(inwon ==1) {
					if( idx % 2  != 0) {
						seat[idx] = 2;
						System.out.println("예매 불가능");
					}else if(seat[idx]==0) {
						seat[idx] =1;
						cnt += 1;
					}else {
						System.out.println("이미 예매가 완료된 자리입니다.");
					}
				}else if(inwon >= 2 && inwon <=7) {

					if(seat[idx]==0) {
						seat[idx]=1;
						for(int i=1;i<inwon;i++) {
							seat[idx+i]=1;
						}
						cnt += inwon;
					}else {
						System.out.println("이미 예매가 완료된 자리입니다.");
					}
				}
				else {
					//			------------ 예매인원수가 1이상인 경우 짝수 자리 리셋 코딩 -------
					if(idx % 2 != 0 && seat[idx] != 1) {
						seat[idx] = 0;
					}
					//		  ----------------------------------------------------------------------------			    
					if(seat[idx] == 0) {
						seat[idx] = 1;
						cnt += 1;
					}else {
						System.out.println("이미 예매가 완료된 자리입니다.");
					}
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
