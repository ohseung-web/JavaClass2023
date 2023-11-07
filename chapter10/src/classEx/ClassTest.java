package classEx;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Person  person = new Person();
		
		// getClass()�� Object Ŭ������ �޼��� �̴�.
		// getClass()�� Class Ŭ������ ��ȯ���ִ� ���� �Ѵ�.
		Class pclass1 = person.getClass();
		System.out.println(pclass1.getName());
		
		Class pclass2 = Person.class;
		System.out.println(pclass2.getName());
		
		// �������� �� �� forName �� ����Ǵ� ����  classEx.Person�� �޸𸮿� �ε���Ų��.
		// �����ϸ� ��� , �������� ������ Error ó�� �ȴ�. 
		// �̸� �����ε��̶� �Ѵ�.
		Class pclass3 = Class.forName("classEx.Person");
		System.out.println(pclass3.getName());
		
		
	}

}
