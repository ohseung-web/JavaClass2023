package classpart06;
import java.util.*;
public class ClassEx06 {
	String name = "";		// ���� �̸�
	int[] arPrice   = {2500,3800,1500,1000};
	String[] arMenu = {"ġ�����  ","�Ұ�����","����Ƣ��  ","��     ��"};
	int[] arCount = new int[4]; //�� �޴��� ī��Ʈ����
	int total = 0;

    
	public void run() {
		Scanner scan = new Scanner(System.in);
		int size = arPrice.length;
		while(true) {
			System.out.println("    [" + name + " �ܹ���]");
			for(int i=0; i<size; i++) {
				System.out.println((i+1) + "." + arMenu[i] + "\t" + arPrice[i] + "��");
			}
			System.out.println("----------------------");
			System.out.println("5.�ֹ��ϱ�");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if(1 <= sel && sel <= size) {
				sel -= 1;
				arCount[sel] += 1;
			}else if(sel == 5) {

				for(int i=0; i<size; i++) {
					total += arPrice[i] * arCount[i];
				}

				System.out.print("�� �ݾ��� " + total + "�� �Դϴ�.");
				System.out.print("���� �Է��ϼ��� : ");
				int money = scan.nextInt();

				if(money >= total) {

					int charge = money - total;

					System.out.println();
					System.out.println("\t������ġ");
					System.out.println("----------------------");
					System.out.println("ITEM\tQTY\tAMT");
					for(int i=0; i<size; i++) {
						System.out.println(arMenu[i] + "\t" + arCount[i] + "\t" + (arPrice[i]*arCount[i]));
					}
					System.out.println("----------------------");
					System.out.println("�հ�ݾ�\t\t" + total);
					System.out.println("�����ݾ�\t\t" + money);
					System.out.println("----------------------");
					System.out.println("��       ��\t" + charge);

				}else {
					System.out.println("���� �����մϴ�.");
				}

				break;
			}
		}
		scan.close();
	}

}

