package mega_Movie;

import java.util.Scanner;

public class Menu {
	Scanner scan = new Scanner(System.in);
	MemberInfo member = new MemberInfo();
	MovieDAO mdao = new MovieDAO();
	String menuLogIn = "[1]�α���\n[2]ȸ������\n[3]��ȭ���\n[4]�˻�\n[0]����";
	String menuLogOut = "[1]�α׾ƿ�\n[2]��ȭ���\n[3]�˻�\n[4]����������\n[5]ȸ��Ż��\n[0]����";
	String menuManager = "[1]������Ȳ\n[2]ȸ�����\n[3]����Ʈ�̿���Ȳ\n[4]��ȭ���\n[5]����";

	// �޴���� �޼���
	public void run() {
		while(true) {
			member.samplePrint();
			System.out.println();
			System.out.println("--- �ް� �ڽ� ---");
			if(member.log == -1) {
				System.out.println(menuLogIn);
			}else if(member.log == 0) {
				System.out.println(menuManager);
				System.out.print("������ �޴� ���� : ");
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
					System.out.println("������ �޴��� �����մϴ�.");
					continue;
				}

			}else {
				System.out.println(menuLogOut);
				System.out.print("�޴� ���� : ");
				int select = scan.nextInt();
			    if(select == 1) {
			    	String logId = member.memberList.get(member.log).getId();
					System.out.println(logId+"�� �α׾ƿ�");
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
					System.out.println("����");
					break;
				}
			}

			System.out.print("�޴� ���� : ");
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
					System.out.println("�̹� �����ϴ� Id�Դϴ�.");
					member.memberJoin();
					memberCheck=500;
					break;
				}
				if(memberCheck == 500) {
					System.out.println("ȸ�����Կ� �����ϼ̽��ϴ�.!!");
					System.out.println("1,000p�� �����Ǿ����ϴ�!");
				}
			}else if(select == 3) {
				mdao.movieList();
				continue;
			}else if(select == 4) {
				mdao.movieSearch();
				continue;
			}else if(select ==0) {
				System.out.println("����");
				break;
			}
		}
	}

}

