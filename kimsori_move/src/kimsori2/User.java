package kimsori2;

import java.util.*;

public class User {
	Scanner scan = new Scanner(System.in);
	String[] id = {"qwer","javaking","abcd","kjb","ckr"};
	String[] pw = {"1111","2222","3333","5555","6666"};
	int cnt = id.length;

	public int userLog() {
		int log = Shopping.log;
		System.out.print("ID�Է�: ");
		String myId = scan.next();
		System.out.print("PW�Է�: ");
		String myPw = scan.next();
			
		for(int i=0; i<cnt; i++) {
			if(myId.equals(id[i]) && myPw.equals(pw[i])) {
				log = i; 
			} 
		}
			
		if(log<0) {
			System.out.println("���̵�� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
		} else {
			System.out.printf("[%s]��, ȯ���մϴ�.\n", id[log]);
		}
		return log;
	}
	
	
}
