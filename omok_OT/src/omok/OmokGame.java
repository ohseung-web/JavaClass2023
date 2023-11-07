package omok;
import java.util.*;
public class OmokGame extends OmokPan{
	Scanner scan = new Scanner(System.in);
	int playerchk = -1;
	int p1x;
	int p1y;
	int p2x;
	int p2y;

	// 오목 메뉴 선택  실행 메서드------------- --------------------------- 
	public void run() {
		while(true) {
			System.out.println("[1]GamePlay");
			System.out.println("[2]End");
			System.out.println("메뉴선택");
			int select = scan.nextInt();

			if(select ==1) {
				System.out.println("player1: 흑돌, player2: 백돌 ");
				omokpan();
				while(true) {
					gammer();
				}
			}else {
				System.out.println("종료");
				break;
			}
		}
	}

	// 오목 두기 메서드------------------------------------------
	public void gammer() {

		while(true) {
			// player1 ------------------------------------------------------------
			System.out.println("===========================");
			System.out.println("player1님 오목을 놓을 X, Y좌표를 입력하세요(1~13)");
			System.out.println("===========================");
			p1x = scan.nextInt();
			p1y = scan.nextInt();
			if(p1x>=1 && p1x<=13) {
				p1x = p1x;
			}
			if(p1y>=1 && p1y<=13) {
				p1y =p1y;
			}
			omok[p1x][p1y-1]=2;

			for(int i =0;i<omok.length;i++) {
				if(i == 0) {
					for(int j=1;j<omok.length;j++) {
						if(j>=1 && j<=5) {
							System.out.print("[ "+j+"]");
						}else {
							System.out.print("["+j+"]");
						}
					}
				}else {
					// j가 13인 14번째 열은 오목을 두지 않고 행번호 1~13 출력
					for(int j=0;j<omok.length;j++) {
						if(j==13) {
							System.out.print("["+i+"]");
						}else {
							if(omok[i][j]==2) {
								System.out.print("[●]");
							}else if(omok[i][j]==3) {
								System.out.print("[○]");
							}else {
								System.out.print("[   ]");
							}
						}
					}
				}
				System.out.println();
			}
			player1Win();
			System.out.println("p2:"+playerchk);

			// player 2 -----------------------------------------------------------------------
			System.out.println("===========================");
			System.out.println("player2님 오목을 놓을 X,Y좌표를 입력하세요(1~13)");
			System.out.println("===========================");
			p2x = scan.nextInt();
			p2y = scan.nextInt();
			if(p2x>=1 && p2x<=13) {
				p2x = p2x;
			}
			if(p2y>=1 && p2y<=13) {
				p2y =p2y;
			}
			omok[p2x][p2y-1]=3;

			for(int i =0;i<omok.length;i++) {
				if(i == 0) {
					for(int j=1;j<omok.length;j++) {
						if(j>=1 && j<=5) {
							System.out.print("[ "+j+"]");
						}else {
							System.out.print("["+j+"]");
						}
					}
				}else {
					// j가 13인 14번째 열은 오목을 두지 않고 행번호 1~13 출력
					for(int j=0;j<omok.length;j++) {
						if(j==13) {
							System.out.print("["+i+"]");
						}else {
							if(omok[i][j]==2) {
								System.out.print("[●]");
							}else if(omok[i][j]==3) {
								System.out.print("[○]");
							}else {
								System.out.print("[   ]");
							}
						}
					}
				}
				System.out.println();
			}
			player2Win();
			System.out.println("p2"+playerchk);
			if(playerchk == -1) {
				System.out.println("==============");
				System.out.println("player1의 승리!");
				System.out.println("===============");
				break;
			}else if(playerchk == 1) {
				System.out.println("==============");
				System.out.println("player2의 승리!");
				System.out.println("===============");
				break;
			}else {
				break;
			}
			
		}
	}

	// player1 승리 메서드 -----------------------------------------------------------------------------------------------------------
	public void player1Win() {
		// 세로로 승리 (→)
		for(int i =1;i<omok.length-5;i++) {
			for(int j =0;j<omok.length-1;j++) {
				if(omok[i][j] == 2 && omok[i+1][j] == 2 
					&& omok[i+2][j] == 2 && omok[i+3][j] == 2 
					&& omok[i+4][j] == 2 ) {
					playerchk = -1;
					break;
				}
			}
		}
		// 가로로 승리(↓)
		for(int i =1;i<omok.length;i++) {
			for(int j =0;j<omok.length-5;j++) {
				if(omok[i][j] == 2 && omok[i][j+1] == 2 
					&& omok[i][j+2] == 2 && omok[i][j+3] == 2 
					&& omok[i][j+4] == 2 ) {
					playerchk = -1;
					break;
				}
			}
		}
		// 대각선 승리(↘)
		for(int i =1;i<omok.length-4;i++) {
			for(int j =0;j<omok.length-4;j++) {
				if(omok[i][j] == 2 && omok[i+1][j+1] == 2 
					&& omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2 
					&& omok[i+4][j+4] == 2 ) {
					playerchk = -1;
					break;
				}
			}
		}
		// 반대 대각선 승리(↗)
		for(int i =1;i<omok.length-4;i++) {
			for(int j =omok.length-1;j>=3;j--) {
				if(omok[i][j] == 2 && omok[i+1][j-1] == 2 
					&& omok[i+2][j-2] == 2 && omok[i+3][j-3] == 2 
					&& omok[i+4][j-4] == 2 ) {
					playerchk = -1;
					break;
				}
			}
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------	
	public void player2Win() {
		// 세로로 승리 (→)
		for(int i =1;i<omok.length-5;i++) {
			for(int j =0;j<omok.length-1;j++) {
				if(omok[i][j] == 3 && omok[i+1][j] == 3 
					&& omok[i+2][j] == 3 && omok[i+3][j] == 3 
					&& omok[i+4][j] == 3 ) {
					playerchk = 1;
					break;
				}
			}
		}
		// 가로로 승리(↓)
		for(int i =1;i<omok.length;i++) {
			for(int j =0;j<omok.length-5;j++) {
				if(omok[i][j] == 3 && omok[i][j+1] ==3 
					&& omok[i][j+2] == 3 && omok[i][j+3] == 3 
					&& omok[i][j+4] == 3 ) {
					playerchk = 1;
					break;
				}
			}
		}
		// 대각선 승리(↘)
		for(int i =1;i<omok.length-4;i++) {
			for(int j =0;j<omok.length-4;j++) {
				if(omok[i][j] == 3 && omok[i+1][j+1] == 3 
					&& omok[i+2][j+2] == 3 && omok[i+3][j+3] == 3 
					&& omok[i+4][j+4] == 3 ) {
					playerchk = 1;
					break;
				}
			}
		}
		// 반대 대각선 승리(↗)
		for(int i =1;i<omok.length-4;i++) {
			for(int j =omok.length-1;j>=3;j--) {
				if(omok[i][j] == 3 && omok[i+1][j-1] == 3 
					&& omok[i+2][j-2] == 3 && omok[i+3][j-3] == 3 
					&& omok[i+4][j-4] == 3 ) {
					playerchk = 1;
					break;
				}
			}
		}
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------		
}