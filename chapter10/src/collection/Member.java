package collection;

import java.util.Comparator;
import java.util.Objects;

public class Member implements  Comparable<Member>, Comparator<Member>{
	private int memberId;        //회원 아이디
	private String memberName;   //회원 이름

	public Member() {};
	public Member(int memberId, String memberName){ //생성자
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
	public String toString(){   //toString 메소드 오버로딩
		return memberName + " 회원님의 아이디는 " + memberId + "입니다";
	}
	

	// hashSet 작성시 중복허용 불가를 위해 반드시 equals와 hashcode를 오버라이딩한다.
	@Override
	public int hashCode() {
		//return this.memberId;
		return Objects.hash(memberId,memberName); 
		// return (this.memberId+this.memberName).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) { // obj가 Member인지 확인한다.
		     Member member = (Member)obj; // 다운캐스팅 한다.
		     
		     if( this.memberId  == member.memberId 
		    		 && this.memberName.equals(member.memberName)) {
		    	 return true;
		     }else {
		    	 return false; // memberid가 다르면 false 반환
		     }
		}
		return false;
	}

	@Override
	public int compareTo(Member member) {
		// 추가되는 나 this와 기존트리 구성하고있던 멤버들 중 한명과 비교
		// this.memberId인 내가  member.memberId 보더 더 클 때 양수를 반환하면 오름차순으로 트리구성 됨 
		// this.memberId인 내가  member.memberId 보더 더 작을 때 음수를 반환하면 내림차순으로 트리구성 됨 
		 return (this.memberId - member.memberId)*(-1);
		
		// return (this.memberName.compareTo(member.memberName)); 
		// 이름으로 정렬 시 이미 String메서드에 compareto가 구현되어 있다.
	}
	@Override
	public int compare(Member member1, Member member2) {
		// member1이 나이고 member2가 비교할 값
		return (member1.memberId-member2.memberId)*(-1);
	}
}
