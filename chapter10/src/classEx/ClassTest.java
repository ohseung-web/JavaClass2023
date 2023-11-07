package classEx;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Person  person = new Person();
		
		// getClass()는 Object 클래스의 메서드 이다.
		// getClass()는 Class 클래스를 반환해주는 일을 한다.
		Class pclass1 = person.getClass();
		System.out.println(pclass1.getName());
		
		Class pclass2 = Person.class;
		System.out.println(pclass2.getName());
		
		// 컴파일이 될 떄 forName 이 실행되는 순간  classEx.Person을 메모리에 로딩시킨다.
		// 존재하면 사용 , 존재하지 않으면 Error 처리 된다. 
		// 이를 동적로딩이라 한다.
		Class pclass3 = Class.forName("classEx.Person");
		System.out.println(pclass3.getName());
		
		
	}

}
