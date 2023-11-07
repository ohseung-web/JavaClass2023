package classpart10;
import java.util.*;
public class ClassEx10 {
	//	�ɹ����� -------------------------------
	Scanner scan = new Scanner(System.in);
	String name = "";

	int[] arHakbun = {1001, 1002, 1003, 1004, 1005};
	int[] arScore  = {  92,   38,   87,  100,   11};
	// �޼���(=�Լ�) -- �������� ��� �Լ�
	public void choice1() {
		for(int i=0; i<arHakbun.length; i++) {
			System.out.println((i+1) + "." + arHakbun[i] + "�й�(" + arScore[i] + "��)");
		}
	}
	//  ------- ����1�� ���� ��� �Լ� ---------------------
	public void choice2() {
		int maxScore = 0;
		int maxIdx = 0;
		for(int i=0; i<arScore.length; i++) {
			if(maxScore < arScore[i]) {
				maxScore = arScore[i];
				maxIdx = i;
			}
		}
		System.out.println("1�� �л� = " + arHakbun[maxIdx] + "�й�(" + arScore[maxIdx] + "��)");		
	}

	//	-------------- ���� �õ� ���� ��� �Լ� ----------------------
	public void choice3() {
		int minScore = arScore[0];
		int minIdx = 0;
		for(int i=0; i<arScore.length; i++) {
			if(minScore > arScore[i]) {
				minScore = arScore[i];
				minIdx = i;
			}
		}
		System.out.println("�õ� �л� = " + arHakbun[minIdx] + "�й�(" + arScore[minIdx] + "��)");
	}

	//	--------------------- �й� �Է� �޾� ���� ��� �Լ� -------------
	//	��, ���� ���� �ʴ� �й� ����ó�� �� ��
	public void choice4() {

		System.out.print("�й��� �Է��ϼ��� : ");
		int hakbun = scan.nextInt();

		int idx = -1;
		for(int i=0; i<arHakbun.length; i++) {
			if(arHakbun[i] == hakbun) {
				idx = i;
			}
		}

		if(idx == -1) {
			System.out.println("�ش� �й��� �������� �ʽ��ϴ�.");
		}else {
			System.out.println(arScore[idx]);
		}
	}
	//	�޴���  ���� �Լ� ��� ����ϴ� �Լ� ---------------------------------------
	public void run() {
		while(true) {
			// �޴� ���
			System.out.println("=== �ް�IT ����б� ===");
			System.out.println("1.������ ����Ȯ��");
			System.out.println("2.1���л� ����Ȯ��");
			System.out.println("3.�õ��л� ����Ȯ��");
			System.out.println("4.(�й��� �Է¹޾�)����Ȯ���ϱ�");
			System.out.println("5.�����ϱ�");

			// �޴� ����
			System.out.print("�޴� ���� : ");
			int select = scan.nextInt();

			if(select == 1) { choice1(); }
			else if(select == 2) { choice2(); }
			else if(select == 3) { choice3(); }
			else if(select == 4) { choice4(); }
			else if(select == 5) {
				System.out.println("���α׷� ����");
				break;
			}
		}

	}
}
