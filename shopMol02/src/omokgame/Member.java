package omokgame;

import java.util.ArrayList;
import java.util.Scanner;



public class Member extends Best{

	ArrayList<Best> list = new ArrayList<>();
	
	Scanner scan =new Scanner(System.in);
	public void MemberAdd() {
		System.out.println("��ȸ�����ԡ�");
		System.out.println("���̸��� �Է��ϼ��䡽");
		String Myname = scan.next();
		System.out.println("��ID�� �Է��ϼ��䡽");
		String Myid = scan.next();
		System.out.println("��PW�� �Է��ϼ��䡽");
		String Mypw = scan.next();
		
		
		for(int i = 0;i<list.size();i++) {
			if(Myid.equals(list.get(i).getID())) {
				System.out.println("�������������");
				System.out.println("�̹� �����ϴ� ID �Դϴ�.");
				System.out.println("�������������");
				return;
			}
		}
		
		list.add(new Best(Myname,Myid,Mypw));
	      System.out.println("��������");
	      System.out.println("ȸ������ �Ϸ�");
	      System.out.println("��������");
		
	      
	
	}
	public void MemberSub() {
		System.out.println("�����������");
		System.out.println("ȸ�� Ż�� �Ǽ̽��ϴ�");
		 System.out.println("�����������");
		list.remove(log);
	
	}
	
	
}