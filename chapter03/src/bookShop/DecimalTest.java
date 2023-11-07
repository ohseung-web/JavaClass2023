package bookShop;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.*;

public class DecimalTest {

	public static void main(String[] args) {
       
		Scanner scan = new Scanner(System.in);
        int number ;
        
        DecimalFormat num1 = new DecimalFormat("0,000");
        DecimalFormat num2 = new DecimalFormat("#,###");
        DecimalFormat num3 = new DecimalFormat("#,###%");
        DecimalFormat num4 = new DecimalFormat("#,##0.#");
        DecimalFormat num5 = new DecimalFormat("0,000.00");
        DecimalFormat num6 = new DecimalFormat("\u00A4#,###");
        DecimalFormat num7 = new DecimalFormat("��#,###");
               
        System.out.println("���� �Է��Ͻÿ�");
        number = scan.nextInt();
        		
        //õ�������� ���б�ȣ ,(�޸�)�� ��� ��, 0�� 0���� ���
        System.out.println(num1.format(number));
        //õ�������� ���б�ȣ ,(�޸�)�� ��� ��, #�� �������� ���
        System.out.println(num2.format(number));
        //������� ��� �� 1200�̸� => 120,000%
        System.out.println(num3.format(number));
        //�Ҽ� ��°�ڸ����� �ݿø��Ͽ� ù°�ڸ���ġ ��� ��, #�� �������� ���
        System.out.println(num4.format(number));
        //�Ҽ� ��°�ڸ����� �ݿø��Ͽ� ��°�ڸ���ġ ��� ��, 0�� 0���� ���
        System.out.println(num5.format(number));
        //��ȭ��ȣ \ ���
        System.out.println(num6.format(number));
        System.out.println(num7.format(number));
     scan.close();   
	}
}
