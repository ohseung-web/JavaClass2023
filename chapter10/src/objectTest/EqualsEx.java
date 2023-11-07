package objectTest;

class Student{
	int studentID;
	String studentName;

	public Student(int studentID, String studenName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}
	
	 @Override public boolean equals(Object obj) {
	 
	  // 다운캐스팅을 한다. 
	if(obj instanceof Student) { 
		Student std = (Student)obj;
	       if(studentID == std.studentID) { 
	    	   return true;
	    	   } else { return false; }
	       }
	 return false; 
	 }
	 
	 public int hashCode() {
		 // equals 메서드를 재정의 할때 사용한 멤버변수 이용하여 작성함
		 return studentID; // 두 학생이 같을 때 studentID 값을 반환
	 }
}

public class EqualsEx {

	public static void main(String[] args) {

		
		 Student student1 = new Student(1001, "Anny"); 
		 Student student2 = new Student(1001, "Anny"); 
		// System.out.println(student1 == student2);
		 //System.out.println(student1.equals(student2));
		
		System.out.println(student1.hashCode());
		System.out.println(student2.hashCode());
		 
		 System.out.println("=================");

			String str1 = new String("test1"); 
			String str2 = new String("test1");
			
			System.out.println(str1.hashCode());
			System.out.println(str2.hashCode());
			
			System.out.println("hashCode 실제 힙 메모리 주소 값 ");
			System.out.println(System.identityHashCode(str1));
			System.out.println(System.identityHashCode(str2));
			
			/*
			 * 
			 * System.out.println( str1 == str2); //str1과 str2의 주소가 다르기때문에 false 출력됨
			 * System.out.println(str1.equals(str2)); // str1과 str2의 문자열이 같기때문에 true 출력됨
			 * //논리적인 동일성을 묻고자 할 때 equals를 사용함
			 * System.out.println(str1.equalsIgnoreCase(str2)); // 대소문자에 관계없이 매치할 수 있도록 한다
			 */
	}

}
