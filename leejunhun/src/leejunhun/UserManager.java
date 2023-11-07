package leejunhun;

import java.util.*;

// TODO UserManager Full inspection ���

public class UserManager {
	Scanner scn = new Scanner(System.in);
	private ArrayList<User> userList = new ArrayList<>();
	
	public UserManager() {
		//String id, String pw, String name, String tel, String email, int adminlevel
		userList.add(new Administrator ("eriot", "qwer!", "������", "010-0000-1234", "admin@shop.com", 5));
		//String id, String pw, String acctype, String name, String tel, String email, String primaryaddr
		userList.add(new User("test","a","�׽�Ʈ����","test","000-0000-0000","test@test.com","null"));
	}
	
	// �Ϲ����� : String id, String pw, String acctype, String name, String tel, String email, String primaryaddr


	// ȸ������
	public int Join()	{
		System.out.println("***** MEGAMART ������ ȯ���մϴ� *****");
		System.out.print("������ ID�� �Է��ϼ��� : ");
		String usrInputId = scn.next();
		System.out.print("����� ��й�ȣ�� �Է��ϼ��� : ");
		String usrInputPw = scn.next();
		
		for(User u : userList)	{
			if(u.getId().equals(usrInputId)) {
				
				return 403;
			}
		}
		System.out.println("\n\n ���� �������� �Է��� �����մϴ�.\n");
		System.out.print("����ȸ���̽Ű���? ������̽Ű���? [1] ����ȸ�� [2] ����� : ");
		int select = scn.nextInt();
		//scn.nextLine();
		
		//scn.nextLine();
		String acctype = (select == 1) ? "����ȸ��" : (select == 2) ? "�����" : null;
		
		System.out.print("����ڴ� �̸��� �����ΰ���? : ");
		String usrInputName = scn.next();
		System.out.print("����ڴ� ��ȭ��ȣ�� �˷��ּ��� : ");
		String usrInputTel = scn.next();
		System.out.print("����ڴ� �̸��� �ּҸ� �˷��ּ��� : ");
		String usrInputEmail = scn.next();
		System.out.print("���� ������� �����ұ��? (y/n) : ");
		String selector = scn.next();
		String primaryaddr = null;
		
		if(selector.equals("y")) {
			System.out.print("���� ������� �Է����ּ��� (���� ������, �����Է½� �Է�����) : ");
			
			primaryaddr = scn.next();	// next�� ��ǥ�� ���⿡�� ���� ©��, 
		}
		// next�� ���๮�ڸ� �Ȱ�����, nextInt()�� ���๮�ڸ� �Ȱ�����
		// �Ϲ����� : String id, String pw, String acctype, String name, String tel, String email, String primaryaddr
		System.out.println("���� �Է��� �������ϴ�. ȸ���������Դϴ�.");
		userList.add(new User (usrInputId, usrInputPw, acctype, usrInputName, usrInputTel, usrInputEmail, primaryaddr));
		
		return 200;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}


	// ȸ��Ż��
	public int secede(User currentUser)	{
		if(currentUser == null)	{
			return 404;
		}else if(currentUser.getClass().equals(Administrator.class)) {
			return 403;
		}else {
			System.out.print("������ ��й�ȣ�� �ѹ� �� Ȯ���ҰԿ� : ");
			String usrInPw = scn.next();
			if(currentUser.getPw().equals(usrInPw)) {
				currentUser.setValidate(0);
				
				return 200;
			}else {
				
				return 4041;
			}

		}
	}

	// ȸ�� �α���
	public User Login()	{
		System.out.print("���� ID�� �Է����ּ��� : ");
		String usrInputId = scn.next();
		System.out.print("���� PW�� �Է����ּ��� : ");
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
			System.out.print("���� ������ �����Ǿ��ų� ������ �����Դϴ�. �����ڿ��� �����ϼ���");
			return null;
		}else {
			return verifying;
		}
	}
	
	public User Logout(User currentUser)	{
		return null;
	}
	
}


