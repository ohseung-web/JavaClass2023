package collection;

import java.util.Comparator;

public class Member implements Comparable<Member>,Comparator<Member> {
       private int memberid;
       private String membername;
       
       public Member() {}
       public Member(int memberid, String membername) {
    	   this.memberid = memberid;
    	   this.membername = membername;
       }
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	
	@Override
	public String toString() {
		return membername +"의 아이디는"+ memberid +"입니다.";
	}
	
	@Override
	public int hashCode() {
		return memberid;
	}
	@Override
	public boolean equals(Object obj) {
		// memberid 같으면 true
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(this.memberid == member.memberid) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	// comparable 메서드 반드시 override 할것
	@Override
	public int compareTo(Member member) {
		// memberid로 정렬시
		//return (this.memberid-member.memberid);// 양수는 오름차순
	//	 return (this.memberid-member.memberid)*(-1);// 음수는 내림차순
		// membername 정렬시 
		 return this.membername.compareTo(member.membername)*(-1);
	}
	@Override
	public int compare(Member member1, Member member2) {
		// TODO Auto-generated method stub
		return (member1.memberid-member2.memberid);
	}
	
	
       
}
