package collection.ArrayList;

import collection.Member;

public class ArrayListMemberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         MemberArrayList memberArrayList = new MemberArrayList();
         
       //  Member memberLee = new Member(1001,"�̼���");
       //  Member memberkim = new Member(1002,"������");
       //  Member membershin = new Member(1003,"�Ż��Ӵ�");
         
         memberArrayList.memberAdd(new Member(1001,"�̼���"));
         memberArrayList.memberAdd(new Member(1002,"������"));
         memberArrayList.memberAdd(new Member(1003,"�Ż��Ӵ�"));
         
         memberArrayList.showAll();
         System.out.println("------ ���� ---------");
         memberArrayList.memberRemove(1001);
         memberArrayList.showAll();
	}

}
