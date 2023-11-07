package kimsori2;

import java.util.*;

public class User {
	Scanner scan = new Scanner(System.in);
	String[] id = {"qwer","javaking","abcd","kjb","ckr"};
	String[] pw = {"1111","2222","3333","5555","6666"};
	int cnt = id.length;

	public int userLog() {
		int log = Shopping.log;
		System.out.print("ID입력: ");
		String myId = scan.next();
		System.out.print("PW입력: ");
		String myPw = scan.next();
			
		for(int i=0; i<cnt; i++) {
			if(myId.equals(id[i]) && myPw.equals(pw[i])) {
				log = i; 
			} 
		}
			
		if(log<0) {
			System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
		} else {
			System.out.printf("[%s]님, 환영합니다.\n", id[log]);
		}
		return log;
	}
	
	
}
