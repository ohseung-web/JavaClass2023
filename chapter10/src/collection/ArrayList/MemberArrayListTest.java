package collection.ArrayList;

import collection.Member;

public class MemberArrayListTest {

	public static void main(String[] args) {
                   
		MemberArrayList memberarraylist = new MemberArrayList();
		
		Member memberLee = new Member(1001,"�̼���");
		Member memberkim = new Member(1002,"������");
		Member memberpark = new Member(1003,"��ȫ��");
		Member membershin = new Member(1004,"�Ż��Ӵ�");
		
		memberarraylist.addMember(memberLee);
		memberarraylist.addMember(memberkim);
		memberarraylist.addMember(memberpark);
		memberarraylist.addMember(membershin);
		
		memberarraylist.showAll();
		
		System.out.println("������ ����");
		memberarraylist.removeMember(memberLee.getMemberId());
		memberarraylist.showAll();
	}

}
