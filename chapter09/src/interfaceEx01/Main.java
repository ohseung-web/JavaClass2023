package interfaceEx01;
import java.util.*;
import java.text.*;
public class Main {

	public static void main(String[] args) {
		Buyable televison = new Television("MV-2020", "TV-samsung", 509000);
		Buyable refrigerator = new Refrigerator("MV-2020", "1���", 2000000);

		Buyable bu[]= {televison,refrigerator};

		DecimalFormat de = new DecimalFormat("#,##0");
		for(int i=0;i<bu.length;i++) {
			System.out.println("----"+bu[i].getName()+"���� -----");
			System.out.println(bu[i].getMaker());
			System.out.println(bu[i].getModel());
			System.out.println(de.format(bu[i].getPrice()));
			System.out.println("------------------------");
		}
	}

}
