package arrayEx01;

import java.util.Arrays;

public class ArrayTest03 {

	public static void main(String[] args) {
		int[] arrAtt1 = {10,20,30,40,50};
		int[] arrAtt2 = null;
		int[] arrAtt3 = null;
		
		// �迭�� ���� ���
		     System.out.println("arrrAtt1.length :"+arrAtt1.length);
		 
		// �迭�� ��� ���
		    System.out.println("�迭�� ��� :"+ Arrays.toString(arrAtt1));
		
		// �迭�� ����
		// Arrays.copyOf(�����迭, �����迭���� �����ϰ� ���� ��ҵ��� ����)    
		    arrAtt3 = Arrays.copyOf(arrAtt1, arrAtt1.length);
		    System.out.println("����� arrAtt3 :"+Arrays.toString(arrAtt3));
		    
		// �迭 ���۷���
		    arrAtt2 = arrAtt1;
		    System.out.println("arrAtt1 :"+ arrAtt1);
		    System.out.println("arrAtt2 :"+ arrAtt2);
		    System.out.println("arrAtt3 :"+ arrAtt3);
	}

}
