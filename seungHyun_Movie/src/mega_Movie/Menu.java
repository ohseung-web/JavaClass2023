package mega_Movie;

import java.util.Scanner;

public class Menu {
	Scanner scan = new Scanner(System.in);
	MemberInfo member = new MemberInfo();
	MovieDAO mdao = new MovieDAO();
	String menuLogIn = "[1]로그인\n[2]회원가입\n[3]영화목록\n[4]검색\n[0]종료";
	String menuLogOut = "[1]로그아웃\n[2]영화목록\n[3]검색\n[4]마이페이지\n[5]회원탈퇴\n[0]종료";
	String menuManager = "[1]예매현황\n[2]회원목록\n[3]포인트이용현황\n[4]영화목록\n[5]이전";

	// 메뉴출력 메서드
	public void run() {
		while(true) {
			member.samplePrint();
			System.out.println();
			System.out.println("--- 메가 박스 ---");
			if(member.log == -1) {
				System.out.println(menuLogIn);
			}else if(member.log == 0) {
				System.out.println(menuManager);
				System.out.print("관리자 메뉴 선택 : ");
				int select = scan.nextInt();
				if(select ==1) {
				}else if(select == 2) {
					member.memberPrint();
					continue;
				}else if(select == 3) {
				}else if(select ==4) {
					mdao.movieList();
					continue;
				}else if(select ==5) {
					member.log = -1;
					System.out.println("관리자 메뉴를 종료합니다.");
					continue;
				}

			}else {
				System.out.println(menuLogOut);
				System.out.print("메뉴 선택 : ");
				int select = scan.nextInt();
			    if(select == 1) {
			    	String logId = member.memberList.get(member.log).getId();
					System.out.println(logId+"님 로그아웃");
					member.log = -1;
					continue;
			    }else if(select == 2) {
					mdao.movieList();
					continue;
				}else if(select == 3) {
					mdao.movieSearch();
					continue;
				}else if(select ==4) {
					member.myPage();
					continue;
				}else if(select == 5) {
					member.memberRemove();
					continue;
				}else if(select ==0) {
					System.out.println("종료");
					break;
				}
			}

			System.out.print("메뉴 선택 : ");
			int select = scan.nextInt();
			if(select ==1) {
				member.logIn();
			 }else if(select ==2) {
				int memberCheck = member.memberJoin();
				switch(memberCheck){
				case 405:
					member.memberJoin();
					memberCheck = 500;
					break;
				case 403:
					System.out.println("이미 존재하는 Id입니다.");
					member.memberJoin();
					memberCheck=500;
					break;
				}
				if(memberCheck == 500) {
					System.out.println("회원가입에 성공하셨습니다.!!");
					System.out.println("1,000p가 적립되었습니다!");
				}
			}else if(select == 3) {
				mdao.movieList();
				continue;
			}else if(select == 4) {
				mdao.movieSearch();
				continue;
			}else if(select ==0) {
				System.out.println("종료");
				break;
			}
		}
	}

}

