package MulitArrrayEx;

import java.util.Scanner;

public class Megabox {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[][] seat = new int[9][8];
		boolean run = true;
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		int chekAlph = -1;
		int chekAlph2 = -1;
		int total = 0;
		int inwon =0;
		int cnt = 0;
		int chekSeat = -1;
		int chekindex1 = -1;
		int chekindex2= -1;
		
		while(run) {

			// screen 화면구성
			System.out.println("---------- SCREEN -----------");
			for(int i=0; i<seat.length; i++) {
				System.out.print(alphabet[i]+" ");
				for(int j=0; j<seat[i].length; j++) {
					if(seat[i][j]==1) {
						System.out.print("[○]");    	
					}else if(seat[i][j]==2) {
						System.out.print("[X]");
					}else if(seat[i][j]==3) {
						System.out.print("[■]");
						seat[i][j] = 0; //초기화
					}else {
						System.out.print("[  ]");
					}
				}
				System.out.println();
			}
			System.out.println("--------------------------------");
            System.out.println("○ : 예매 ,  X : 예매완료, ■ : 선택불가  ");
			System.out.println("= Mega Movie =");
			System.out.println("[1]좌석예매");
			System.out.println("[2]예매취소");
			System.out.println("[0]종료");
			System.out.print("메뉴선택 :");
			int select = scan.nextInt();
			System.out.println();

			switch(select) {
			case 1:  // 좌석예매
				
				System.out.print("인원 선택(1~8)(0.이전) ");
				inwon = scan.nextInt();
				if(inwon == 0) {
					continue;
				}
				if( inwon >= 1 && inwon <= 8) {
					System.out.print("예매좌석1(A~I) :");
					String seatName = scan.next();

					// 좌석 A~I 까지 체크
					for(int i=0; i<alphabet.length; i++) { 
						if(alphabet[i].equals(seatName)) {
							chekAlph = i;
						}
					}
					System.out.print("예매좌석2(1~8) :");
					int seatNum2 = scan.nextInt();


					if(chekAlph == -1) {
						System.out.println("존재 하지 않는 좌석입니다.");
					}else {
						if( seatNum2 >=1 && seatNum2 <=8) {
							if(inwon == 1) { // 예매인원 1명인 경우
								// 짝수좌석 선택 못하게 하기 -------------------------------------------------------
								for(int i=0; i<seat.length; i++) { 
									for(int j=0; j<seat[i].length; j++) { 
										if((j+1)%2==0 && seat[i][j]!=2 && seat[i][j]!=1) {
											// 선택한 좌석이 : 짝수좌석 / 예매 완료 / 예매함 일때
											seat[i][j]=3; // 짝수좌석 예매불과로 출력! 
											//	앞에 예매한 좌석과 짝수좌석이 연달아 있을때 그 짝수좌석은 예매 가능하게 하는 코드
											if( j != seat[0].length-1) {
												if(seat[i][j-1]==1 || seat[i][j+1]==1) {
													seat[i][j]=0;
												}
											} else {
												if(seat[i][j-1]==1) {
													seat[i][j]=0;
												}
											}
										}
									}
								}
								if(seatNum2 % 2 == 0) {
									System.out.println("선택 불가능한 좌석");
								}else {
									seat[chekAlph][seatNum2-1] = 1;
									cnt ++;
								}
								//-----------------------------------------------------------------------------------------------------
							}else if(inwon == 2) {
								for(int i=0; i<seat.length-1; i++) {
									if( seat[chekAlph][i] == 1 || seat[chekAlph][i] == 3) {
										chekSeat = i;
									}
								}
								if(chekSeat != -1) {
									System.out.println("선택 불가능한 좌석");
								}
								else {
									seat[chekAlph][seatNum2-1] = 1;
									seat[chekAlph][seatNum2] = 1;
									cnt += inwon;
								}
                       //-----------------------------------------------------------------------------------------
							}else if(inwon == 3) {
								for(int i=0; i<seat.length-1; i++) {
									if( seat[chekAlph][i] == 1 || seat[chekAlph][i] == 3) {
										chekSeat = i;
									}
								}
								if(chekSeat != -1) {
									System.out.println("선택 불가능한 좌석");
								}
								else {
									seat[chekAlph][seatNum2-1] = 1;
									seat[chekAlph][seatNum2] = 1;
									cnt += inwon;
								}
							}
						}
					}
				}else {
					System.out.println("선택 할 수 없는 인원입니다.");
				}
				break;
				
			case 2: // 좌석예매 취소
				System.out.println("취소할 좌석 번호를 입력해 주세요 ");
				System.out.print("예매좌석1(A~I) :");
				String cancelName = scan.next();
				
				// 좌석 A~I 까지 체크
				for(int i=0; i<alphabet.length; i++) { 
					if(alphabet[i].equals(cancelName)) {
						chekAlph2= i;
					}
				}
				System.out.print("예매좌석2(1~8) :");
				int cancelNum = scan.nextInt();
				
				if( seat[chekAlph2][cancelNum-1] == 0) {
					System.out.println("취소 할 수 없는 좌석입니다.");
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+1] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					seat[chekAlph2][cancelNum+1] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+2] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					seat[chekAlph2][cancelNum+1] = 0;
					seat[chekAlph2][cancelNum+2] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+3] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					seat[chekAlph2][cancelNum+1] = 0;
					seat[chekAlph2][cancelNum+2] = 0;
					seat[chekAlph2][cancelNum+3] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+4] == 1 ){
					seat[chekAlph2][cancelNum-1] = 0;
					seat[chekAlph2][cancelNum] = 0;
					seat[chekAlph2][cancelNum+1] = 0;
					seat[chekAlph2][cancelNum+2] = 0;
					seat[chekAlph2][cancelNum+3] = 0;
					seat[chekAlph2][cancelNum+4] = 0;
					cnt = cnt - inwon;
				}else if( seat[chekAlph2][cancelNum-1] == 1 && seat[chekAlph2][cancelNum+5] == 1 ){
						seat[chekAlph2][cancelNum-1] = 0;
						seat[chekAlph2][cancelNum] = 0;
						seat[chekAlph2][cancelNum+1] = 0;
						seat[chekAlph2][cancelNum+2] = 0;
						seat[chekAlph2][cancelNum+3] = 0;
						seat[chekAlph2][cancelNum+4] = 0;
						seat[chekAlph2][cancelNum+5] = 0;
						cnt = cnt - inwon;
					}else {
					seat[chekAlph2][cancelNum-1] = 0;
					cnt --;
				}
				break;
				
			case 0: // 종료 후 영화비 출력
				total += (cnt * 12000);
				System.out.print("총 매출액 :");
				System.out.println(total);
				run = false;

			}
		}
		
//-----------------------------------------------------------------------------------------------------------------------		
	}
}
