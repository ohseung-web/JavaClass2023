package arrayEx01;
import java.util.*;
public class ArrayExample_Atm {

	public static void main(String[] args) {
		/*
		 * # ATM[3단계]
		 * 1. 가입
		 * . 계좌번호와 비밀번호를 입력받아 가입
		 * . 계좌번호 중복검사
		 * 2. 탈퇴
		 * . 계좌번호를 입력받아 탈퇴
		 */
	
       Scanner scan = new Scanner(System.in);
		
		int[] accs = {1001, 1002, 0, 0, 0};
		int[] pws  = {1111, 2222, 0, 0, 0};
		
		int cnt = 2;
		
		boolean run = true;
		while(run) {
			
			for(int i=0; i<cnt; i++) {
				System.out.println((i+1) + "." + accs[i] + ":" + pws[i]);
			}
			System.out.println();
			
			System.out.println("1.가입");
			System.out.println("2.탈퇴");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				if(cnt == 5) {
					System.out.println("더이상 가입할 수 없습니다.");
					continue;
				}
				
				System.out.print("[가입]계좌번호 입력 : ");
				int myAcc = scan.nextInt();
				
				int check = 1; // 중복계좌번호 체크키
				for(int i=0; i<cnt; i++) {
					if(accs[i] == myAcc) {
						check = -1; // 중복되었을 때
					}
				}
				
				if(check == -1) {
					System.out.println("계좌번호가 중복됩니다.");
				}else {
					System.out.print("[가입]비밀번호 입력 : ");
					int myPw = scan.nextInt();
					
					accs[cnt] = myAcc;
					pws[cnt] = myPw;
					cnt += 1;
				}
			}
			else if(sel == 2) {
				
				System.out.print("[탈퇴]계좌번호 입력 : ");
				int myAcc = scan.nextInt();
				
				int check = -1;// 해당계좌번호 존재유무 체크키;
				for(int i=0; i<cnt; i++) {
					if(accs[i] == myAcc) {
						check = i;
					}
				}
				
				if(check == -1) {
					System.out.println("해당계좌번호는 존재하지 않습니다.");
				}else {
					for(int i=check; i<cnt-1; i++) {
						accs[i] = accs[i + 1];
						pws[i] = pws[i + 1];
					}
					cnt -= 1;
				}
				
			}
			
		}
		scan.close();
	}

}
