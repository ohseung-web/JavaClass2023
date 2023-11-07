package scheduer;

import java.util.*;

public class ScheduerTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//RoundRobin �� ������ R��, 
		//LeastJob �� ������ L��
		//PrionrityAllocation �� ������ P��
		
		System.out.println("��ȭ ��� ��й���� �����ϼ��� R, L, P");
		
		String ch = scan.next();
		scheduer sch  = null;
		
		  if( ch.equals("R")   ||  ch.equals("r") ) {
				sch = new RoundRobin();
			}else if( "L".equals(ch) ||   "l".equals(ch)) {
				sch = new LeastJob();
			}else if( "P".equals(ch) ||  "p".equals(ch) ) {
				sch = new PriorityAllocation();
			}else {
				System.out.println("�������� �ʴ� ��� �Դϴ�.");
				return;
			}
		System.out.println(sch);
		sch.getNextCall();
		sch.sendCallToAgent();
		
	}

}
