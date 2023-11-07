package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class CollectionMethod {

	public static void main(String[] args) {

		 List list = new ArrayList<>();
		 System.out.println(list);
		
		 Collections.addAll(list, 1,2,3,4,5);
		 Collections.rotate(list, 2); // ���������� �� ĭ�� �̵�
		 System.out.println(list); // [4,5,1,2,3]
		 
		 Collections.swap(list, 0, 2); //ù ��°�� �� ��°�� ��ȯ(swap)
		 System.out.println(list); //[1,5,4,2,3]
		 
		 Collections.shuffle(list); // ����� ��ġ�� ��Ҹ� ���Ƿ� ����
		 System.out.println(list); // ������
		 
		 Collections.sort(list); // �������� ����
		 System.out.println(list); // [1,2,3,4,5]
		 
		 Collections.sort(list, Collections.reverseOrder()); //��������
		 System.out.println(list); //[5.4.3.2.1]
		 
		 Collections.fill(list,9); // list�� 9�� ä���.
		 System.out.println(list); //[9,9,9,9,9]
		 
		 //list�� ���� ũ���� ���ο� list�� �����ϰ� 2�� ä���. ��, ����� ����Ұ�
		 List newList = Collections.nCopies(list.size(), 2);
		 System.out.println(newList); // [2,2,2,2,2]
		 
		 System.out.println(Collections.disjoint(list, newList)); //�����Ұ� ������ true
		 
		 Collections.copy(list, newList);
		 System.out.println(newList); //[2,2,2,2,2]
		 System.out.println(list); //[2,2,2,2,2]
		 
		 Collections.replaceAll(list, 2, 1); // ��� ��ü�� ã�� 2�� ������ 1�� �����Ѵ�.
		 System.out.println(list);
		 
		 Enumeration e = Collections.enumeration(list);//����Ʈ�� Enumeration(����)�� ��ȯ�Ѵ�.
		 
		 ArrayList list2 = Collections.list(e); // Enumeration(����)�� ����Ʈ�� ��ȯ�Ѵ�.
		 
		 System.out.println(e);
		 System.out.println(list2);
		 
		 //-----------------------------------------------------------------------------------
		 Scanner scan = new Scanner(System.in);
		 ArrayList<String> listStr = new ArrayList<>();
		 
		 Collections.addAll(listStr, "����","���","����","��","���");
		 Collections.sort(listStr);
		 System.out.println(listStr);
		 //binarySearch�� �ݵ�� ������ ���� �����ؾ� �Ѵ�.
		 System.out.println("Key �Է�");
		 String myKey = scan.next();
	     System.out.println(myKey+"�� ��ġ(�ε�����)? : ["+ Collections.binarySearch(listStr, myKey)+"]");
	     /*
	     System.out.println("��� ��ġ(�ε�����)? : ["+ Collections.binarySearch(listStr, "���")+"]");
	     System.out.println("������ ��ġ(�ε�����)? : ["+ Collections.binarySearch(listStr, "������")+"]");
	     System.out.println("�� ��ġ(�ε�����)? : ["+ Collections.binarySearch(listStr, "��")+"]");
		 */
		 
	    //  frequency(��) : Collection �ȿ� �ִ� ��ü�� ��� �����ߴ����� �������ش�.
		 System.out.println(Collections.frequency(listStr, "����"));
	}

}
