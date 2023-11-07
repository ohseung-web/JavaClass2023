package mega_Movie;

public class Main {

	public static void main(String[] args) {

		//   Menu menu = new Menu();
		//   menu.run();
		
		double price = 3600;
		double update = 0;
		double update2 = 0;
		//update =price/10; // 1100/10 =1000 
		price =price*1.1; // 1100 인상
       price = price * 10/ 11; // 원래값 1000원으로 복귀
		price = price * 0.9; // 990
	   price = price * 100  ; // 원래값 1000원으로 복귀
	//   price = price / 10 ;
		System.out.printf("%.0f",price);
				
		
	/*	2023년 5월 15일 정보처리기사 필기 시험문제
		int i = 0;
		int[] arr = new int[10];
		
		arr[0] = 0;
		arr[1]  = 1;
		while(i<8) { // 0~7
			arr[i+2] = arr[i+1] + arr[i]; 
			// 0+2=> 1+0 , 1+2 => 1+1 , 2+2=> 2+1, 3+2 => 3+2, 4+2=>5+3
			// 5+2 => 8+5 , 6+2 => 13+8, 7+2 => 21+13
			i++;
			System.out.println("i값 :"+i+" "+arr[i]);
		}
		System.out.println();
		System.out.println("arr[9] : "+ arr[9]);
		
		
		int i = 0;
		int cnt = 0;
		do {
			cnt++;
		} while(cnt <0); 
			if(cnt == 1) {
				cnt++;
			}else {
				cnt = cnt + 3;
			}
		
		
		System.out.println(cnt);
*/		
	}

}
