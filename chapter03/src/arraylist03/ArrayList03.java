package arraylist03;
import java.util.*;
public class ArrayList03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // ��ĳ�� �ҷ�����
        ArrayList<String> names = new ArrayList<>(); // ArrayList ����
        int cnt = 0; // �� ������ ���� ����

        for(int i = 0 ; i <= 4 ; i++) { // ��ĳ�ʷ� �̸� 5�� �Է� �ޱ�
            System.out.println("�̸��� �Է��� �ּ���");
            names.add(scan.nextLine());
        }

        System.out.println("���� '��'�� ���� �̸��� ��� ����մϴ�.");

        for(int i = 0 ; i <= 4 ; i++) {
            String name = names.get(i); // �迭�� ��(�̸�)�� ������ ����
            if (name.startsWith("��")) { // ���� "��"���� �����Ѵٸ�, 
            	cnt++; // �ε����� +1
                System.out.printf("[%s]\t",names.get(i)); // �̸��� ��µ�
            }
        }
        System.out.println();
        System.out.println("�达 ���� ���� ���� ��� " + cnt + " �� �Դϴ�.");
      	// �� �������� �ε����� ���� ��µ�
        
        scan.close();
	}

}
