package classPart03;

class Ex03{
	
	int[] arr = {87, 100, 11, 72, 92};
	
}



public class ClassEx03 {

	public static void main(String[] args) {
        
		/*
		 // 문제 1) 전체 합 출력
		// 정답 1) 362
		
		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		
		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3
		
		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3
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
		
		System.out.println("전체 합 :" + total);
		System.out.println("4의 배수 합 :" + sum);
		System.out.println("4의 배수 개수 :" + cnt);
		System.out.println("짝수의 개수 :" + even);
		
	}

}
