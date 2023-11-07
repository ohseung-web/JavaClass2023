package classpart11;
import java.util.*;
public class ClassEx11 {
	Scanner scan = new Scanner(System.in);

	String name = "";

	String[] arAcc = {"1111", "2222", "3333", "", ""};
	String[] arPw  = {"1234", "2345", "3456", "", ""};
	int[] arMoney  = {87000, 34000, 17500, 0, 0};

	int count = 3;

	// 로그아웃(-1)
	int loginCheck = -1;			// 3333 로그인 중
//-------- 입력된 계좌 보여주기   
	public void showMember() {
		for(int i=0; i<count; i++) {
			System.out.println(arAcc[i] + " : " + arPw[i] + " : " + arMoney[i] + "원");
		}
	}
   //--------- 메뉴 보기
	public void showMenu() {
		System.out.print("# 로그인 상태 : ");
		if(loginCheck == -1){
			System.out.println("로그아웃");
		}else {
			System.out.println(arAcc[loginCheck] + "님, 로그인 중...");
		}

		System.out.println("=== " + name + " ===");
		System.out.println("1.회원가입");	
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.입금하기");
		System.out.println("6.이체하기");
		System.out.println("7.종료");
	}

	// ------- 존재하는 계좌번호 체크하기
	public int checkAcc(String myAcc) {

		int check = 1;
		for(int i=0; i<count; i++) {
			if(arAcc[i].equals(myAcc)) {
				check = -1;
			}
		}
		return check;
	}

	// --------------- 비밀번호 체크하기
	public int checkPw(int accCheck) {
		System.out.print("비밀번호를 입력하세요 : ");
		String myPw = scan.next();

		int pwCheck = -1;

		if(arPw[accCheck].equals(myPw)) {
			pwCheck = 1;
		}

		return pwCheck;
	}

	//-------  회원가입 탈퇴시 계좌번호 확인 
	public int checkAcc() {

		System.out.print("탈퇴할 계좌번호를 입력하세요 : ");
		String myAcc = scan.next();

		int accCheck = -1;
		for(int i=0; i<count; i++) {
			if(arAcc[i].equals(myAcc)) {
				accCheck = i;
			}
		}
		return accCheck;
	}
//-------------- 회원탈퇴시 회원의 존재유무
	public void delMember() {

		// 회원탈퇴 제약조건
		if(count == 0) {
			System.out.println("탈퇴할 회원정보가 없습니다.");
			return;
		}

		// 계좌번호 유효성 검사
		int accCheck = checkAcc();

		if(accCheck != -1) {
			// 비밀번호 유효성 검사
			int pwCheck = checkPw(accCheck);
			if(pwCheck == -1) {
				System.out.println("비밀번호를 잘 못 입력했습니다.");
			}else {
				for(int i=accCheck; i<count - 1; i++) {
					arAcc[i] = arAcc[i + 1];
					arPw[i] = arPw[i + 1];
					arMoney[i] = arMoney[i + 1];
				}
				count -= 1;
				System.out.println("탈퇴되었습니다.");
			}
		}else {
			System.out.println("없는 계좌번호 입니다.");
		}
	}
// --- 회원가입
	public void joinMember() {

		// 회원가입 회원 수는 5명까지만 허용
		if(count == 5) {
			System.out.println("더이상 가입할 수 없습니다.");
			return;
		}

		// 계좌번호 중복검사
		System.out.print("가입할 계좌번호를 입력하세요 : ");
		String myAcc = scan.next();
		int check = checkAcc(myAcc);

		if(check == -1) {
			System.out.println("계좌번호가 중복됩니다.");
		}else {
			System.out.print("비밀번호를 입력하세요 : ");
			String myPw = scan.next();

			arAcc[count] = myAcc;
			arPw[count] = myPw;
			arMoney[count] = 1000;

			count += 1;
			System.out.println("회원가입을 축하합니다.");
		}
	}
// ---  로그인
	public void login() {

		if(loginCheck != -1) {
			System.out.println("로그아웃 후 진행해주세요.");
			return;
		}
		System.out.print("계좌번호를 입력하세요 : ");
		String myId = scan.next();
		System.out.print("패스워드를 입력하세요 : ");
		String myPw = scan.next();

		// 계좌번호와 패스워드 유효성 검사
		for(int i=0; i<count; i++) {
			if(myId.equals(arAcc[i]) && myPw.equals(arPw[i])) {
				loginCheck = i;
			}
		}

		if(loginCheck == -1) {
			System.out.println("계좌번호와 패스워드를 확인해주세요.");
		}else {
			System.out.println("로그인 성공!");
		}	
	}
// --- 로그아웃 
	public void logOut() {
		if(loginCheck == -1) {
			System.out.println("로그인 후 진행해주세요.");
		}else {
			loginCheck = -1;
			System.out.println("로그아웃 되었습니다.");
		}		
	}
//  --- 입금
	public void income() {
		System.out.print("입금할 금액을 입력하세요 : ");
		int money = scan.nextInt();

		arMoney[loginCheck] += money;
		System.out.println("입금을 완료하였습니다.");		
	}
// --- 이체
	public void trans() {
		System.out.print("이체할 계좌번호를 입력하세요 : ");
		String transAcc = scan.next();

		// 이체 계좌번호 유효성 검사
		int check = -1;
		for (int i = 0; i < count; i++) {
			if (arAcc[i].equals(transAcc)) {
				check = i;
			}
		}

		if (check == -1) {
			System.out.println("계좌번호를 확인해주세요.");
		} else {
			System.out.print("이체할 금액을 입력하세요 : ");
			int transMoney = scan.nextInt();

			// 이체 금액 유효성 검사
			if (arMoney[loginCheck] >= transMoney) {
				arMoney[loginCheck] -= transMoney;
				arMoney[check] += transMoney;
				System.out.println("이체를 완료하였습니다.");
			} else {
				System.out.println("계좌잔액이 부족합니다.");
			}
		}

	}
// --- 프로그램 실행
	public void run() {

		while(true) {
			// 전체 회원정보 출력
			showMember();
			// 메뉴 출력
			showMenu();
			// 메뉴 선택
			System.out.print("메뉴를 선택해주세요 : ");
			int choice = scan.nextInt();
			// 회원가입
			if(choice == 1) { joinMember(); }
			// 회원탈퇴
			else if(choice == 2) { delMember();	}
			// 로그인
			else if(choice == 3) { login(); }
			// 로그아웃
			else if(choice == 4) { logOut(); }
			// 입금
			else if(choice == 5) { 
				if(loginCheck == -1) {
					System.out.println("로그인 후 사용하세요!!");
				}else {
					income();
				}
			}
			// 이체
			else if(choice == 6) {
				if(loginCheck == -1) {
					System.out.println("로그인 후 사용하세요!!");
				}else {
					trans(); 
				}
			}
			else if(choice == 7) { 
				System.out.println("종료");	
				break;
			} 
		}		
	}
}
