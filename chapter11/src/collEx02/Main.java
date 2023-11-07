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
		users.add(new UserVO("홍길동",34));
		users.add(new UserVO("개나리",21));
		users.add(new UserVO("진달래",38));
		users.add(new UserVO("최백합",16));
		users.add(new UserVO("이순신",16));
		
	    // 1. Collections.sort(users) 이방법은 UserVO 클래스에 implements Comparable<UserVO> 상속 받는다.
		// 그리고 아래 compareTo를 Override 한다.
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
		// 2. 기본 ArrayList 가지고 있는 sort를 이용하여 정렬 하려면 익명클래스를 사용해야 한다.
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
		
		// 3. Collections.sort를 익명클래스를 이용하여 정렬하는 방법
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
		System.out.println("람다식을 이용한 정렬 ");
		
		// 4. 람다식을 이용하여 ArrayList.sort를 이용하여 정렬하는 방법
		users.sort((o1,o2)-> o2.getAge()-o1.getAge());
		System.out.println(users);
		users.sort((o1, o2) -> o1.getAge() == o2.getAge()? o1.getName().compareTo(o2.getName()): o1.getAge()-o2.getAge());
		System.out.println(users); 
	}

}
