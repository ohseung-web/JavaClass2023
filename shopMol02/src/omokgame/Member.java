package omokgame;

import java.util.ArrayList;
import java.util.Scanner;



public class Member extends Best{

	ArrayList<Best> list = new ArrayList<>();
	
	Scanner scan =new Scanner(System.in);
	public void MemberAdd() {
		System.out.println("※회원가입※");
		System.out.println("【이름를 입력하세요】");
		String Myname = scan.next();
		System.out.println("【ID를 입력하세요】");
		String Myid = scan.next();
		System.out.println("【PW를 입력하세요】");
		String Mypw = scan.next();
		
		
		for(int i = 0;i<list.size();i++) {
			if(Myid.equals(list.get(i).getID())) {
				System.out.println("▼▼▼▼▼▼▼▼▼▼▼▼");
				System.out.println("이미 존재하는 ID 입니다.");
				System.out.println("▲▲▲▲▲▲▲▲▲▲▲▲");
				return;
			}
		}
		
		list.add(new Best(Myname,Myid,Mypw));
	      System.out.println("▼▼▼▼▼▼▼");
	      System.out.println("회원가입 완료");
	      System.out.println("▲▲▲▲▲▲▲");
		
	      
	
	}
	public void MemberSub() {
		System.out.println("▼▼▼▼▼▼▼▼▼▼");
		System.out.println("회원 탈퇴 되셨습니다");
		 System.out.println("▲▲▲▲▲▲▲▲▲▲");
		list.remove(log);
	
	}
	
	
}