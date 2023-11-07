package collection.hashsetEx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class HashSetEx02 {

	public static void main(String[] args) {
		 /*
	       *  �ζǹ�ȣ 1~45 ���� ������ �����ϰ� 6���� �ߺ� ���� ���� �ܼ�â�� ����ϴ� ���α׷����� ��
	       *  ������. 
	       */
	      
	      //������ ���ڸ� �� ��ü
	      Random ran=new Random();
	      //������ ���ڸ� ������ ��ü
	      Set<Integer> lottoSet=new HashSet<>();
	      
	      while(true) {
	         //1 ~ 45 ������ ������ ���� ���� 
	         int ranNum=ran.nextInt(45)+1;
	         //�� ���ڸ� Set �� �����ϱ� 
	         lottoSet.add(ranNum);
	         //���� lottoSet �� size �� 6 �̸� �ݺ��� Ż�� 
	         if(lottoSet.size() == 6) {
	            break;
	         }
	      }
	      
	      System.out.println(">> �ζǹ�ȣ");
	      Iterator<Integer> it=lottoSet.iterator();
	      while(it.hasNext()) {
	         int num=it.next();
	         System.out.print(num+",");
	      }
	}

}
