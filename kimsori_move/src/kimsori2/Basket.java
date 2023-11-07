package kimsori2;

import java.util.*;

public class Basket {
	Scanner scan = new Scanner(System.in);
	
	String[] item = {"고등어", "갈   치", "조   기", "삼   치", "병   어"};
	int[] price = {1500,2500,3000,4000,5000};
	int[][] cart = new int[100][3]; ////장바구니
	int cnt = 0; //장바구니 갯수 세기
	int[][] count = new int[5][item.length]; //[회원 수] [물건의 갯수]: 회원들이 산 각 물건의 갯수
	
//	선택한 상품 세기
	public int selectItem() {
		int log = Shopping.log;
		
		System.out.print("상품번호 선택: ");
		int select = scan.nextInt();
	
		for(int i=0; i<item.length; i++) {
			if(select==i+1) {
				cart[cnt][0] = log;
				cart[cnt][1] = select-1;
				cart[cnt][2] = select-1;
				count[log][select-1]++;
				cnt++;
			}
		}
		return select;
	}
	
//	장바구니 출력
	public void Cart() {
		int log = Shopping.log;
		
		System.out.println("-------------------");
		System.out.println("품   목\t단가\t수량");
		System.out.println("-------------------");
		for(int i=0; i<item.length; i++) { 
			for(int j=0; j<cnt; j++) { 
				if(count[log][i]!=0 && cart[j][0]==log) { //로그인 한 사람이 장바구니에 넣은것만 보이기
					System.out.printf("%s:\t%d원\t%s개\n", item[i], price[i], count[log][i]);
				} 
				break; //중복해서 나오기 때문에 break!
			}
		}
	}

}
