package leejunhun;

import java.util.*;

// TODO UserManager Full inspection 통과

public class UserManager {
	Scanner scn = new Scanner(System.in);
	private ArrayList<User> userList = new ArrayList<>();
	
	public UserManager() {
		//String id, String pw, String name, String tel, String email, int adminlevel
		userList.add(new Administrator ("eriot", "qwer!", "이준훈", "010-0000-1234", "admin@shop.com", 5));
		//String id, String pw, String acctype, String name, String tel, String email, String primaryaddr
		userList.add(new User("test","a","테스트계정","test","000-0000-0000","test@test.com","null"));
	}
	
	// 일반유저 : String id, String pw, String acctype, String name, String tel, String email, String primaryaddr


	// 회원가입
	public int Join()	{
		System.out.println("***** MEGAMART 가입을 환영합니다 *****");
		System.out.print("가입할 ID를 입력하세요 : ");
		String usrInputId = scn.next();
		System.out.print("사용할 비밀번호를 입력하세요 : ");
		String usrInputPw = scn.next();
		
		for(User u : userList)	{
			if(u.getId().equals(usrInputId)) {
				
				return 403;
			}
		}
		System.out.println("\n\n 이제 기초정보 입력을 시작합니다.\n");
		System.out.print("개인회원이신가요? 사업자이신가요? [1] 개인회원 [2] 사업자 : ");
		int select = scn.nextInt();
		//scn.nextLine();
		
		//scn.nextLine();
		String acctype = (select == 1) ? "개인회원" : (select == 2) ? "사업자" : null;
		
		System.out.print("사용자님 이름은 무엇인가요? : ");
		String usrInputName = scn.next();
		System.out.print("사용자님 전화번호를 알려주세요 : ");
		String usrInputTel = scn.next();
		System.out.print("사용자님 이메일 주소를 알려주세요 : ");
		String usrInputEmail = scn.next();
		System.out.print("기초 배송지를 설정할까요? (y/n) : ");
		String selector = scn.next();
		String primaryaddr = null;
		
		if(selector.equals("y")) {
			System.out.print("기초 배송지를 입력해주세요 (띄어쓰기 사용금지, 엔터입력시 입력종료) : ");
			
			primaryaddr = scn.next();	// next는 쉼표뒤 띄어쓰기에서 에서 짤림, 
		}
		// next도 개행문자를 안가져옴, nextInt()도 개행문자를 안가져옴
		// 일반유저 : String id, String pw, String acctype, String name, String tel, String email, String primaryaddr
		System.out.println("정보 입력이 끝났습니다. 회원가입중입니다.");
		userList.add(new User (usrInputId, usrInputPw, acctype, usrInputName, usrInputTel, usrInputEmail, primaryaddr));
		
		return 200;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}


	// 회원탈퇴
	public int secede(User currentUser)	{
		if(currentUser == null)	{
			return 404;
		}else if(currentUser.getClass().equals(Administrator.class)) {
			return 403;
		}else {
			System.out.print("계정의 비밀번호를 한번 더 확인할게요 : ");
			String usrInPw = scn.next();
			if(currentUser.getPw().equals(usrInPw)) {
				currentUser.setValidate(0);
				
				return 200;
			}else {
				
				return 4041;
			}

		}
	}

	// 회원 로그인
	public User Login()	{
		System.out.print("계정 ID를 입력해주세요 : ");
		String usrInputId = scn.next();
		System.out.print("계정 PW를 입력해주세요 : ");
		String usrInputPw = scn.next();
		
		User verifying = null;
		for(User u : userList)	{
			if(u.getId().equals(usrInputId) && u.getPw().equals(usrInputPw)) {
				verifying = u;
			}
		}

		if(verifying==null) {
			return null;
		}else if(verifying.getValidate() != 1)	{
			System.out.print("계정 접근이 금지되었거나 삭제된 계정입니다. 관리자에게 문의하세요");
			return null;
		}else {
			return verifying;
		}
	}
	
	public User Logout(User currentUser)	{
		return null;
	}
	
}


