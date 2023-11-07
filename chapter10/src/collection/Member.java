package collection;

import java.util.Comparator;
import java.util.Objects;

public class Member implements  Comparable<Member>, Comparator<Member>{
	private int memberId;        //ȸ�� ���̵�
	private String memberName;   //ȸ�� �̸�

	public Member() {};
	public Member(int memberId, String memberName){ //������
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public int getMemberId() {  
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString(){   //toString �޼ҵ� �����ε�
		return memberName + " ȸ������ ���̵�� " + memberId + "�Դϴ�";
	}
	

	// hashSet �ۼ��� �ߺ���� �Ұ��� ���� �ݵ�� equals�� hashcode�� �������̵��Ѵ�.
	@Override
	public int hashCode() {
		//return this.memberId;
		return Objects.hash(memberId,memberName); 
		// return (this.memberId+this.memberName).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) { // obj�� Member���� Ȯ���Ѵ�.
		     Member member = (Member)obj; // �ٿ�ĳ���� �Ѵ�.
		     
		     if( this.memberId  == member.memberId 
		    		 && this.memberName.equals(member.memberName)) {
		    	 return true;
		     }else {
		    	 return false; // memberid�� �ٸ��� false ��ȯ
		     }
		}
		return false;
	}

	@Override
	public int compareTo(Member member) {
		// �߰��Ǵ� �� this�� ����Ʈ�� �����ϰ��ִ� ����� �� �Ѹ�� ��
		// this.memberId�� ����  member.memberId ���� �� Ŭ �� ����� ��ȯ�ϸ� ������������ Ʈ������ �� 
		// this.memberId�� ����  member.memberId ���� �� ���� �� ������ ��ȯ�ϸ� ������������ Ʈ������ �� 
		 return (this.memberId - member.memberId)*(-1);
		
		// return (this.memberName.compareTo(member.memberName)); 
		// �̸����� ���� �� �̹� String�޼��忡 compareto�� �����Ǿ� �ִ�.
	}
	@Override
	public int compare(Member member1, Member member2) {
		// member1�� ���̰� member2�� ���� ��
		return (member1.memberId-member2.memberId)*(-1);
	}
}
