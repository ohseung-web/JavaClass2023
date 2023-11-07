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

	//ȸ������ �޼���
	public int memberJoin() {
		String myid ="";
		System.out.print("Id :");
		String inputid = scan.next();

		// id ���ڼ� ���� üũ
		if(inputid.length()>=1 && inputid.length()<=6) {
			myid = inputid;
		}else {
			System.out.println("id�� 1~6������ �ۼ����� �մϴ�.");
			return 405;	
		}

		// ����ȸ���� Id�� ������ 403���� ����üũ
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
	
	//���� ����Ʈ
    public void samplePrint() {
    	System.out.println("-------------");
    	for(MemberDTO mt : memberList) {
    		System.out.println(mt.getId()+","+mt.getPw());
    	}
    	System.out.println();
    }
	
	// ��ü ȸ������ ��¸޼���
	public void memberPrint() {
		int num=1;
		System.out.println("---------------------------- [��üȸ�� ����] ---------------------");
		System.out.println("    ID\t\tPW\tPhoneNumber\tEmail     \tPoint");
		System.out.println("---------------------------------------------------------------");
		for(MemberDTO m : memberList) {
			System.out.println("["+(num++)+"] "+m.getId() + "\t"+ m.getPw()+"\t"
		                        +m.getPhone()+"\t"+m.getEmail()+"\t"+dmf.format(m.getPoint()));
		}
		System.out.println("---------------------------------------------------------------");
	}

	//ȸ������ �߰� �޼���
	public void addMember(MemberDTO md) {
		memberList.add(md);
	}

    // �α��� �޼���
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
				System.out.println(memberList.get(log).getId()+"���� ������ �Դϴ�.");
			}else {
				System.out.println(memberList.get(log).getId()+"�� �α��� ����!!");
			}	
		}else {
			System.out.println("Id�� PWȮ���ϰ� �ٽ� �α��� ���ּ���");
		}

		return log;	
	}

    //ȸ��Ż�� �޼���
	public void memberRemove() {
		if(log != -1) {
			 memberList.remove(log);
			 System.out.println("Ż�� �Ǽ̽��ϴ�.!!");
		     log = -1;
		}else {System.out.println("�α��� ���ּ���~");}
	}
	
	//����������
	public void myPage() {
		
	}
}
