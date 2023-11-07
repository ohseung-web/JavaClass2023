package megabox;

import java.util.Scanner;

public class Megabox extends MegaboxElements{
	Scanner scan = new Scanner(System.in);
	
	public void run() {
		while(run) {
			System.out.println("=메가 영화관=");
			System.out.println("1.좌석예매");
			System.out.println("2.예매취소");
			System.out.println("3.종료");
			System.out.print("메뉴 선택 : ");
			int menu = scan.nextInt();
			if(menu==1) {
				reserveSeat();
			}
			else if(menu==2) {
				cancelSeat();
			}
			else if(menu==3) {
				end();
			}
			else {
				System.out.println("유효하지 않은 메뉴입니다.");
			}
		}
	}
	
	public void reserveSeat() {
		convertReservedSeats();
		printScreen();
		System.out.print("인원 선택(1~8)(0.이전): ");
		personnel = scan.nextInt();
		if(personnel>0 && personnel<9) {
			if(personnel==1) { // 1명일 때
				oneBook();
			}
			else if(personnel % 2 == 1) { // 홀수일 때 (1명일 경우 제외)
				oddBook();
			}
			else { // 짝수일 때
				evenBook();
			}
			System.out.println("좌석선택이 완료되었습니다.");
			System.out.println();
		}
	}
	
	public void oneBook() {
		while(personnel!=0) {
			oneSetSeat();	
		}
	}
	
	public void oddBook() {
		while(personnel!=0) {
			if(personnel == 1) {
				oneSetSeat();
			}
			else {
				twoSetSeat();
			}	
		}
	}
	
	public void evenBook() {
		while(personnel!=0) {
			twoSetSeat();
		}
	}
	
	public void cancelSeat() {
		cancelReservedSeats();
		printScreen();
		System.out.println();
	}
	
	public void end() {
		System.out.println("총 매출액 = "+revenue);
		run = false;
	}
	
	public void inputSeat() { // 예매할 좌석 입력
		System.out.print("예매좌석1(A~I): ");
		reserveRow = scan.next();
		for(int i=0;i<row;i++) {
			if(rowAlphabet[i].equals(reserveRow)) {
				reserveSeat1 = i;
			}
		}
		System.out.print("예매좌석2(1~8): ");
		reserveSeat2 = scan.nextInt()-1;
	}
	
	public void oneSetSeat() { // 한 명이 앉을 좌석 선택하기
		disableEvenColumns();
		printScreen();
		inputSeat();
		if(screen[reserveSeat1][reserveSeat2] == 0) {
			screen[reserveSeat1][reserveSeat2] = 1;
			personnel -= 1;
			revenue += 12000;
		}
		else if(screen[reserveSeat1][reserveSeat2] == 1) {
			screen[reserveSeat1][reserveSeat2] = 0;
			if(reserveSeat2 % 2 == 0) {
				screen[reserveSeat1][reserveSeat2+1] = 0;
			}
			else {
				screen[reserveSeat1][reserveSeat2-1] = 0;
			}
			personnel += 2;
			revenue -= 24000;
		}
		else if(screen[reserveSeat1][reserveSeat2] == 2) {
			System.out.println("선택 불가능한 자리입니다.");
		}
		else {
			System.out.println("이미 예매된 자리입니다.");
		}
		initializeDisabledColumns();
	}
	
	public void twoSetSeat() { // 두 명이 앉을 좌석 선택하기
		printScreen();
		inputSeat();
		if(screen[reserveSeat1][reserveSeat2] == 0) {
			screen[reserveSeat1][reserveSeat2] = 1;
			if(reserveSeat2 % 2 == 0) {
				screen[reserveSeat1][reserveSeat2+1] = 1;
			}
			else {
				screen[reserveSeat1][reserveSeat2-1] = 1;
			}
			personnel -= 2;
			revenue += 24000;
		}
		else if(screen[reserveSeat1][reserveSeat2] == 1) {
			screen[reserveSeat1][reserveSeat2] = 0;
			if(reserveSeat2 % 2 == 0) {
				screen[reserveSeat1][reserveSeat2+1] = 0;
			}
			else {
				screen[reserveSeat1][reserveSeat2-1] = 0;
			}
			personnel += 2;
			revenue -= 24000;
		}
		else {
			System.out.println("이미 예매된 자리입니다.");
		}
	}
}
