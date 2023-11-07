package collEx02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		
		
		ArrayList<UserVO> users = new ArrayList<UserVO>();
		users.add(new UserVO("ȫ�浿",34));
		users.add(new UserVO("������",21));
		users.add(new UserVO("���޷�",38));
		users.add(new UserVO("�ֹ���",16));
		users.add(new UserVO("�̼���",16));
		
	    // 1. Collections.sort(users) �̹���� UserVO Ŭ������ implements Comparable<UserVO> ��� �޴´�.
		// �׸��� �Ʒ� compareTo�� Override �Ѵ�.
		/*
		   @Override
	      public int compareTo(UserVO uservo) {
		
		   //return (this.age - uservo.age);
		
		   if(this.age == uservo.age) {
			return this.name.compareTo(uservo.name);
		   }
		  return (this.age - uservo.age);
		
	     }
		
		
		
		*/
		// 2. �⺻ ArrayList ������ �ִ� sort�� �̿��Ͽ� ���� �Ϸ��� �͸�Ŭ������ ����ؾ� �Ѵ�.
		users.sort(new Comparator<UserVO>() {

			@Override
			public int compare(UserVO o1, UserVO o2) {
				return o1.getAge()-o2.getAge();
			}
			
		});
		
		for(UserVO user : users) {
		   System.out.println(user.getName() + ":"+ user.getAge());
		}
		System.out.println("==========");
		
		// 3. Collections.sort�� �͸�Ŭ������ �̿��Ͽ� �����ϴ� ���
		Collections.sort(users, new Comparator<UserVO>() {

			@Override
			public int compare(UserVO o1, UserVO o2) {
				if(o1.getAge() == o2.getAge()){ 				
					return o1.getName().compareTo(o2.getName()); 			
				} 			
				return o1.getAge() - o2.getAge(); 
			}
		});
		
		for(UserVO user : users) {
			   System.out.println(user.getName() + ":"+ user.getAge());
			}
		System.out.println("==========");
		System.out.println("���ٽ��� �̿��� ���� ");
		
		// 4. ���ٽ��� �̿��Ͽ� ArrayList.sort�� �̿��Ͽ� �����ϴ� ���
		users.sort((o1,o2)-> o2.getAge()-o1.getAge());
		System.out.println(users);
		users.sort((o1, o2) -> o1.getAge() == o2.getAge()? o1.getName().compareTo(o2.getName()): o1.getAge()-o2.getAge());
		System.out.println(users); 
	}

}
