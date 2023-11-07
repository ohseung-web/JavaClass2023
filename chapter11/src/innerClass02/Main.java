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
				new User("ȫ�浿", 32),
				new User("������", 64),
				new User("�Ӳ���", 48),
				new User("�����ż�", 14),
		};

		// Arrays.sort(�迭, Comparator �͸� ���� ��ü);
		Arrays.sort(users, new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				/// Integer Ŭ������ ���ǵ� compare �Լ��� �� ���� ���� ���ð��� ��
				return Integer.compare(u1.age, u2.age); 
			}
		});

		// ���
		for (User u : users) { 
			System.out.println(u.name + " " + u.age + "��");
		}


	}

}
