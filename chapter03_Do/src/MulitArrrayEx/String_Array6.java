package MulitArrrayEx;
import java.util.*;
public class String_Array6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[][] items = new String[100][2];
		for(int i=0; i<items.length; i++) {
			items[i][0] = "";
			items[i][1] = "";
		}

		int itemCount = 0;

		while(true) {

			System.out.println("[������ ���]");
			System.out.println("[1]ī�װ� ����");
			System.out.println("[2]�� �� ��  ����");
			System.out.println("[3]��üǰ�� ���");

			System.out.print(": ");
			int sel = scan.nextInt();

			if(sel == 1) {
				System.out.print("�߰��� ī�װ� �Է� : ");
				String category = scan.next();
				items[itemCount][0] = category;
				itemCount += 1;
			}
			else if(sel == 2) {
				for(int i=0; i<itemCount; i++) {
					System.out.println("[" + i + "] " + items[i][0]);
				}
				System.out.print("ī�װ��� �����ϼ��� : ");
				int choice = scan.nextInt();

				System.out.print("�߰��� �������� �Է��ϼ��� : ");
				String item = scan.next();

				items[choice][1] += item;
				items[choice][1] += "/";

			}
			else if(sel == 3) {
				for(int i=0; i<itemCount; i++) {
					System.out.println(items[i][0] + " : " + items[i][1]);
				}
			}
		}
	}

}
