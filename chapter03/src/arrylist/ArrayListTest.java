package arrylist;
import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		
      ArrayList<Integer> number = new ArrayList<>();
      // add(E element)�޼���� �迭�� ���Է�
      number.add(10);
      number.add(20);
      number.add(30);
      number.add(40);
      number.add(50);
      
      //  add(index, E element)�޼��� index�� ��ġ�� �� ����
      number.add(1, 60);//
      System.out.println(number);//�迭���
      
      //remove(index)�޼���� �迭�� �� ����
      number.remove(1);
      System.out.println(number);
      
      //set(index, value) : ArrayList�� index��° ��ġ�� value�� �����Ѵ�.
      number.set(1, 25);
      System.out.println(number);
      
      //�迭�� ũ�����
      System.out.println(number.size());
      
      //������ index�� ���� ���
      System.out.println(number.get(3));
      
      //indexOf(Object o)�� ���ڷ� ��ü�� �޽��ϴ�. 
      //����Ʈ�� ���ʺ��� ���ڿ� ������ ��ü�� �ִ��� ã����, �����Ѵٸ� �� �ε����� �����մϴ�. 
      //�������� �ʴ´ٸ� -1�� �����մϴ�.
      System.out.println(number.indexOf(30)); 
      // 30�� �����ϹǷ� index��ȣ 2���
      System.out.println(number.indexOf(60)); 
      // 60�� �������� �����Ƿ� -1 ���
      
      // for������ ����ϴ� ���
      for(int i=0;i<number.size();i++) {
    	  System.out.print(number.get(i)+" ");
      }
      System.out.println();
      System.out.println("==========================");
      /*
		 * # ���� for��
		 *   1) �迭�̳� ArrayList ��ü �����͸� ������� �۾��� ��� ����Ѵ�.
		 *   2) ����
		 *   	for(�ڷ��� ������ : �迭 or ArrayList){
		 *   		 �ݺ��� ����;
		 *   	}
		 */
      
      // number�� 0��° ���� num�� ������ �� �ݺ��� �����ϸ�
      // number�� ������ ���� num�� ������ �� �ݺ��� ���� ����ȴ�.
      for(int num : number) {
			System.out.println(num);
		}
      
      
      //Clear �� �޼ҵ�� ������ ���� �۾��� �ϰ� ���� ������� ������ ��.��. �ϰ� ����ݴϴ�.
      number.clear();
      System.out.println(number);
      
      // �迭�� ����ִ� �� Ȯ���ϴ� �޼��� isEmpty
      // ��� ������ true, �ƴϸ� false�� ��µȴ�.
      if(number.isEmpty()) {
    	  System.out.println("�迭�� ���� ��� Null");
      };
      
	}

}
