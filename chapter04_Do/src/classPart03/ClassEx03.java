package classPart03;

class Ex03{
	
	int[] arr = {87, 100, 11, 72, 92};
	
}



public class ClassEx03 {

	public static void main(String[] args) {
        
		/*
		 // ���� 1) ��ü �� ���
		// ���� 1) 362
		
		// ���� 2) 4�� ����� �� ���
		// ���� 2) 264
		
		// ���� 3) 4�� ����� ���� ���
		// ���� 3) 3
		
		// ���� 4) ¦���� ���� ���
		// ���� 4) 3
		*/
		
		Ex03  ex03 = new Ex03();
		int total = 0;
		int cnt = 0;
		int sum = 0;
		int even = 0;
		
		for(int i=0; i<ex03.arr.length; i++) {
		      total += ex03.arr[i];
		      if(ex03.arr[i] % 4 == 0) {
		    	   cnt ++;
		    	   sum += ex03.arr[i];
		      }
		      if(ex03.arr[i] % 2 == 0) {
		    	  even ++;
		      }
		}
		
		System.out.println("��ü �� :" + total);
		System.out.println("4�� ��� �� :" + sum);
		System.out.println("4�� ��� ���� :" + cnt);
		System.out.println("¦���� ���� :" + even);
		
	}

}
