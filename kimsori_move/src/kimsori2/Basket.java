package kimsori2;

import java.util.*;

public class Basket {
	Scanner scan = new Scanner(System.in);
	
	String[] item = {"����", "��   ġ", "��   ��", "��   ġ", "��   ��"};
	int[] price = {1500,2500,3000,4000,5000};
	int[][] cart = new int[100][3]; ////��ٱ���
	int cnt = 0; //��ٱ��� ���� ����
	int[][] count = new int[5][item.length]; //[ȸ�� ��] [������ ����]: ȸ������ �� �� ������ ����
	
//	������ ��ǰ ����
	public int selectItem() {
		int log = Shopping.log;
		
		System.out.print("��ǰ��ȣ ����: ");
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
	
//	��ٱ��� ���
	public void Cart() {
		int log = Shopping.log;
		
		System.out.println("-------------------");
		System.out.println("ǰ   ��\t�ܰ�\t����");
		System.out.println("-------------------");
		for(int i=0; i<item.length; i++) { 
			for(int j=0; j<cnt; j++) { 
				if(count[log][i]!=0 && cart[j][0]==log) { //�α��� �� ����� ��ٱ��Ͽ� �����͸� ���̱�
					System.out.printf("%s:\t%d��\t%s��\n", item[i], price[i], count[log][i]);
				} 
				break; //�ߺ��ؼ� ������ ������ break!
			}
		}
	}

}
