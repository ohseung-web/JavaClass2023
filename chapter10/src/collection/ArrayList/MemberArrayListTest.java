package collection.ArrayList;

import collection.Member;

public class MemberArrayListTest {

	public static void main(String[] args) {
                   
		MemberArrayList memberarraylist = new MemberArrayList();
		
		Member memberLee = new Member(1001,"이순신");
		Member memberkim = new Member(1002,"김유신");
		Member memberpark = new Member(1003,"박홍식");
		Member membershin = new Member(1004,"신사임당");
		
		memberarraylist.addMember(memberLee);
		memberarraylist.addMember(memberkim);
		memberarraylist.addMember(memberpark);
		memberarraylist.addMember(membershin);
		
		memberarraylist.showAll();
		
		System.out.println("데이터 삭제");
		memberarraylist.removeMember(memberLee.getMemberId());
		memberarraylist.showAll();
	}

}
