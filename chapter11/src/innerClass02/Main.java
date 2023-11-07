package innerClass02;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		class User {
			String name;
			int age;

			public User(String name, int age) {
				this.name = name;
				this.age = age;
			}
		}

		 
	
		User[] users = {
				new User("홍길동", 32),
				new User("김춘추", 64),
				new User("임꺽정", 48),
				new User("박혁거세", 14),
		};

		// Arrays.sort(배열, Comparator 익명 구현 객체);
		Arrays.sort(users, new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				/// Integer 클래스에 정의된 compare 함수로 두 나이 정수 원시값을 비교
				return Integer.compare(u1.age, u2.age); 
			}
		});

		// 출력
		for (User u : users) { 
			System.out.println(u.name + " " + u.age + "세");
		}


	}

}
