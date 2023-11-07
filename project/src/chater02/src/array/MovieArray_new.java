package array;
import java.util.*;
public abstract class MovieArray_new {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		/*
		[매가박스 영화예매]
		1. 사용자로부터 좌석번호(index)를 입력받아 예매한다.
		2. 예매인원은 1~8 사이의 인원만 입력받아 예매한다.
		      단, 1~8 사이의 인원이 아니면 예외처리 한다.
		      ex) 인원을 확인하세요.
		3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
		4. 한 좌석당 예매가격 12,000원
		5. 프로그램 종료 후 해당 영화 총 매출액 출력
		6. 예매인원이 1명일 경우 
		      짝수 좌석은 예매불가 [!]
		7. 이미 예매가 된 좌석인 경우 [X]
		8. 비 예매 좌석은 [ ]
		9. 예매한 좌석 [O]    
		10. 예매인원이 2명 이상인 경우
		 */

		int[] seat = new int[10];
		int cnt = 0;
		int seatcnt = 0 ; //좌석이[o]인 인원수ㄴ
		boolean run = true;
		while(run) {

			System.out.println(); 
			System.out.println("=메가 영화관=");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			System.out.println("3.취소");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if(sel == 1) {
				System.out.print("예매 인원을 입력하세요[1~8] :");
				int inwon = scan.nextInt();

				if(inwon>=1 && inwon<=8) {		
					//	------------- 예매인원이 1명일때 짝수 좌석은 !를 출력하는 코딩 --------------------------------				
					if(inwon ==1) {
						for(int i=0; i<10; i++) {
							if(i % 2 != 0) {
								seat[i] = 3;
							}
						}
						for(int i=0; i<10; i++) {
							if(seat[i] == 0) {
								System.out.print("[ ]"); //예매가능
							}else if(seat[i]==2) {     // 예매완료
								System.out.print("[X]");
							}else if(seat[i]==3) {
								System.out.print("[!]");  //예매불가능
							}else {
								System.out.print("[O]"); // 예매선택
							}
						}
						System.out.println();

						//	-------------- 짝수 자리 선택시 예매불가능 홀수 자리 선택시 예매완료 코딩---------------
						System.out.print("좌석번호 선택[1~10] : ");
						int idx = scan.nextInt();
						idx -= 1;     // index번호가 0부터 시작하기 때문에   
						if(idx % 2 != 0 ) {
							System.out.println("예매불가능");
						}else {
							seat[idx] = 1;
							System.out.println("예매완료");
							cnt += 1;
						}
						for(int i=0; i<10; i++) {
							if(seat[i] == 0) {
								System.out.print("[ ]"); //예매가능
							}else if(seat[i]==2) {     // 예매완료
								System.out.print("[X]");
							}else if(seat[i]==3) {
								System.out.print("[!]");  //예매불가능
							}else {
								System.out.print("[O]"); // 예매선택
							}
						}
					}
					// -----------------------------------------------------------------------------------------
					if(inwon>=2 && inwon<=8) {  // 2명이상 8이하 선택했을 경우
						for(int i=0; i<10; i++) {
							if(seat[i] == 0) {
								System.out.print("[ ]"); //예매가능
							}else if(seat[i]==2) {     // 예매완료
								System.out.print("[X]");
							}else if(seat[i]==3) {
								System.out.print("[!]");  //예매불가능
							}else {
								System.out.print("[O]"); // 예매선택
							}
						}
						System.out.println();
						System.out.println();
						if(inwon % 2 == 0) { // 인원수가 짝수 홀수일때 선택하는 좌석수가 달라지기때문
							for(int k=0;k<(inwon/2);k++) {
								if(seat[k] == 1) {
									seatcnt = seatcnt + 2;
								}
								if(inwon != seatcnt) {
									System.out.print("예매좌석: ");
									int idx1 = scan.nextInt();
									idx1 -= 1;     // index번호가 0부터 시작하기 때문에
									seat[idx1+1] = 1; 
									seat[idx1] = 1;
									cnt += 2;
									
									for(int i=0; i<10; i++) {
										if(seat[i] == 0) {
											System.out.print("[ ]"); //예매가능
										}else if(seat[i]==2) {     // 예매완료
											System.out.print("[X]");
										}else if(seat[i]==3) {
											System.out.print("[!]");  //예매불가능
										}else {
											System.out.print("[O]"); // 예매선택
										}
									}
									System.out.println();
								}
							}
							
						}else {
							for(int k=0;k<(inwon/2)+1;k++) {
								if(seat[k] == 1) {
									seatcnt = seatcnt + 2;
								}
								System.out.println("좌석선택인원 :"+seatcnt);
								if(inwon != seatcnt) {
									System.out.print("예매좌석: ");
									int idx1 = scan.nextInt();
									idx1 -= 1;     // index번호가 0부터 시작하기 때문에
									
									if(seatcnt == inwon-1) {
										seat[idx1] = 1;
										cnt += 1;
									}else {
										seat[idx1+1] = 1; 
										seat[idx1] = 1;
										cnt += 2;
									}
									
									
									for(int i=0; i<10; i++) {
										if(seat[i] == 0) {
											System.out.print("[ ]"); //예매가능
										}else if(seat[i]==2) {     // 예매완료
											System.out.print("[X]");
										}else if(seat[i]==3) {
											System.out.print("[!]");  //예매불가능
										}else {
											System.out.print("[O]"); // 예매선택
										}
									}
									System.out.println();
								}
							}
						}
						
						

						/*		if(idx1==9) { //좌석10은 선택 불가. 						
							System.out.println("예매불가능한 좌석");
						} else {
//	------------------- 홀수좌석 선택 코딩 ------------------------------------------------						
							if(idx1 % 2 != 0) { 
								if(seat[idx1+1]==2 || seat[idx1]==2) { 
									System.out.println("예매불가능한 좌석");
									continue;
								}
//	------------ 선택한 좌석과 다음 좌석 예매 완료 코딩 -------------------------------							
								seat[idx1+1] = 1; 
								seat[idx1] = 1; 
								System.out.println("예매완료");
								cnt= cnt+2;
								seatcnt = seatcnt +2;
// -----------------------짝수 좌석 선택 코딩 --------------------------------------------								
							} else if(idx1 % 2 ==0) { //선택한 좌석 짝수
								if(seat[idx1+1]==2 || seat[idx1]==2) {
									System.out.println("예매불가능");
									continue;
								}
								seat[idx1+1] = 1; 
								seat[idx1] = 1; 
								//System.out.println("예매완료");
								//cnt= cnt+2;

							}
						}*/
					}	
						
						// ---------------------------- 리셋  [!]인 자리를 [ ], [O]예매된 자리를 [X]로 -----------------  
						for(int i=0; i<seat.length; i++) {
							if(seat[i]==3) { 
								seat[i]=0; 
							} else if(seat[i]==1) { 
								seat[i]=2; 
							}
						}	 

						// -------------------- 예매인원이 1~8 사이가 아닌경우 예외처리 코딩 ----------------------
					}else {
						System.out.println("예매인원을 확인하세요~");
					}
					//-------------------- 프로그램 종료 후 매출액 계산 코딩 ----------------------------------------
				}
				else if(sel == 2) {
					int total = cnt * 12000;
					System.out.println("매출액 : " +total + "원");
					run = false;
					//------------------- 예매좌석 취소 코딩 -------------------------------				
				}else if(sel == 3) {
					System.out.print("취소할 좌석선택 :");
					int index1 = scan.nextInt();
					index1 -= 1;
					seat[index1] = 0;
					if(seat[index1+1] == 0) {
						seat[index1-1] = 0; 
					}
					seat[index1+1] = 0; 
					cnt -= 2;

					for(int i=0; i<10; i++) {

						if(seat[i] == 0) {
							System.out.print("[ ]"); //예매가능
						}else if(seat[i]==2) {     // 예매완료
							System.out.print("[X]");
						}else if(seat[i]==3) {
							System.out.print("[!]");  //예매불가능
						}else {
							System.out.print("[O]"); // 예매선택
						}
					}
					System.out.println();
					System.out.println("예매취소완료");
				}
			}
			//-----------------------------------------------------------------------------------------------
			scan.close();

		}
	}
