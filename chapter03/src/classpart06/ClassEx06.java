package classpart06;
import java.util.*;
public class ClassEx06 {
	String name = "";		// 가게 이름
	int[] arPrice   = {2500,3800,1500,1000};
	String[] arMenu = {"치즈버거  ","불고기버거","감자튀김  ","콜     라"};
	int[] arCount = new int[4]; //각 메뉴별 카운트개수
	int total = 0;

    
	public void run() {
		Scanner scan = new Scanner(System.in);
		int size = arPrice.length;
		while(true) {
			System.out.println("    [" + name + " 햄버거]");
			for(int i=0; i<size; i++) {
				System.out.println((i+1) + "." + arMenu[i] + "\t" + arPrice[i] + "원");
			}
			System.out.println("----------------------");
			System.out.println("5.주문하기");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if(1 <= sel && sel <= size) {
				sel -= 1;
				arCount[sel] += 1;
			}else if(sel == 5) {

				for(int i=0; i<size; i++) {
					total += arPrice[i] * arCount[i];
				}

				System.out.print("총 금액은 " + total + "원 입니다.");
				System.out.print("돈을 입력하세요 : ");
				int money = scan.nextInt();

				if(money >= total) {

					int charge = money - total;

					System.out.println();
					System.out.println("\t맘스터치");
					System.out.println("----------------------");
					System.out.println("ITEM\tQTY\tAMT");
					for(int i=0; i<size; i++) {
						System.out.println(arMenu[i] + "\t" + arCount[i] + "\t" + (arPrice[i]*arCount[i]));
					}
					System.out.println("----------------------");
					System.out.println("합계금액\t\t" + total);
					System.out.println("받은금액\t\t" + money);
					System.out.println("----------------------");
					System.out.println("잔       돈\t" + charge);

				}else {
					System.out.println("돈이 부족합니다.");
				}

				break;
			}
		}
		scan.close();
	}

}

