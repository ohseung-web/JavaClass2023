package mega_Movie;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {
	Scanner scan = new Scanner(System.in);
	DecimalFormat dmf = new DecimalFormat("#,##0");
	ArrayList<MemberDTO> memberList = new ArrayList<>();
	MemberDTO mdto = new MemberDTO();
	static int log = -1;

	public MemberInfo() {
		memberList.add(new MemberDTO("Admin","12345","010-8888-1234","901011","k@naver.com",0));
		memberList.add(new MemberDTO("kjb10","33333","010-7777-1234","881011","g@naver.com",0));
	}

	//회원가입 메서드
	public int memberJoin() {
		String myid ="";
		System.out.print("Id :");
		String inputid = scan.next();

		// id 글자수 제한 체크
		if(inputid.length()>=1 && inputid.length()<=6) {
			myid = inputid;
		}else {
			System.out.println("id는 1~6까지만 작성가능 합니다.");
			return 405;	
		}

		// 기존회원의 Id와 같으면 403으로 오류체크
		for(MemberDTO m : memberList) {
			if(m.getId().equals(inputid)) {
				return 403;	
			}
		}
		System.out.print("pw :");
		String mypw = scan.next();
		System.out.print("phone :");
		String myphone = scan.next();
		System.out.print("birDate :");
		String mybirdate = scan.next();
		System.out.print("email :");
		String myemail = scan.next();

		addMember(new MemberDTO(myid,mypw,myphone,mybirdate,myemail,mdto.getPoint()));
		return 500;
	}
	
	//샘플 프린트
    public void samplePrint() {
    	System.out.println("-------------");
    	for(MemberDTO mt : memberList) {
    		System.out.println(mt.getId()+","+mt.getPw());
    	}
    	System.out.println();
    }
	
	// 전체 회원정보 출력메서드
	public void memberPrint() {
		int num=1;
		System.out.println("---------------------------- [전체회원 정보] ---------------------");
		System.out.println("    ID\t\tPW\tPhoneNumber\tEmail     \tPoint");
		System.out.println("---------------------------------------------------------------");
		for(MemberDTO m : memberList) {
			System.out.println("["+(num++)+"] "+m.getId() + "\t"+ m.getPw()+"\t"
		                        +m.getPhone()+"\t"+m.getEmail()+"\t"+dmf.format(m.getPoint()));
		}
		System.out.println("---------------------------------------------------------------");
	}

	//회원가입 추가 메서드
	public void addMember(MemberDTO md) {
		memberList.add(md);
	}

    // 로그인 메서드
	public int logIn() {
		System.out.print("ID :");
		String inpuid = scan.next();
		System.out.print("PW :");
		String inpupw = scan.next();

		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getId().equals(inpuid) 
				&& memberList.get(i).getPw().equals(inpupw)) {
				log = i;
			}
		}

		if(log != -1) {
			if(log == 0) {
				System.out.println(memberList.get(log).getId()+"님은 관리자 입니다.");
			}else {
				System.out.println(memberList.get(log).getId()+"님 로그인 성공!!");
			}	
		}else {
			System.out.println("Id와 PW확인하고 다시 로그인 해주세요");
		}

		return log;	
	}

    //회원탈퇴 메서드
	public void memberRemove() {
		if(log != -1) {
			 memberList.remove(log);
			 System.out.println("탈퇴 되셨습니다.!!");
		     log = -1;
		}else {System.out.println("로그인 해주세요~");}
	}
	
	//마이페이지
	public void myPage() {
		
	}
}
