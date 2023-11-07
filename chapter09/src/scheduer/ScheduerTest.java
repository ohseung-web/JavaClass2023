package scheduer;

import java.util.*;

public class ScheduerTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//RoundRobin 이 들어오면 R로, 
		//LeastJob 이 들어오면 L로
		//PrionrityAllocation 이 들어오면 P로
		
		System.out.println("전화 상담 배분방식을 선택하세요 R, L, P");
		
		String ch = scan.next();
		scheduer sch  = null;
		
		  if( ch.equals("R")   ||  ch.equals("r") ) {
				sch = new RoundRobin();
			}else if( "L".equals(ch) ||   "l".equals(ch)) {
				sch = new LeastJob();
			}else if( "P".equals(ch) ||  "p".equals(ch) ) {
				sch = new PriorityAllocation();
			}else {
				System.out.println("지원하지 않는 기능 입니다.");
				return;
			}
		System.out.println(sch);
		sch.getNextCall();
		sch.sendCallToAgent();
		
	}

}
