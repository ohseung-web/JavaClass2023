package collection.ArrayList;

import collection.Member;

public class ArrayListMemberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         MemberArrayList memberArrayList = new MemberArrayList();
         
       //  Member memberLee = new Member(1001,"이순신");
       //  Member memberkim = new Member(1002,"김유신");
       //  Member membershin = new Member(1003,"신사임당");
         
         memberArrayList.memberAdd(new Member(1001,"이순신"));
         memberArrayList.memberAdd(new Member(1002,"김유신"));
         memberArrayList.memberAdd(new Member(1003,"신사임당"));
         
         memberArrayList.showAll();
         System.out.println("------ 삭제 ---------");
         memberArrayList.memberRemove(1001);
         memberArrayList.showAll();
	}

}
