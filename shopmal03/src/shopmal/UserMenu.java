package shopmal;

import java.util.*;

public class UserMenu extends User {

	Scanner scan = new Scanner(System.in);
	int cnt = id.length;
	
	public int userLog() {
		int log = super.log;
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
