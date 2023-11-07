package objectTest;

class Student{
	int studentID;
	String studentName;

	public Student(int studentID, String studenName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}
	
	 @Override public boolean equals(Object obj) {
	 
	  // �ٿ�ĳ������ �Ѵ�. 
	if(obj instanceof Student) { 
		Student std = (Student)obj;
	       if(studentID == std.studentID) { 
	    	   return true;
	    	   } else { return false; }
	       }
	 return false; 
	 }
	 
	 public int hashCode() {
		 // equals �޼��带 ������ �Ҷ� ����� ������� �̿��Ͽ� �ۼ���
		 return studentID; // �� �л��� ���� �� studentID ���� ��ȯ
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
			
			System.out.println("hashCode ���� �� �޸� �ּ� �� ");
			System.out.println(System.identityHashCode(str1));
			System.out.println(System.identityHashCode(str2));
			
			/*
			 * 
			 * System.out.println( str1 == str2); //str1�� str2�� �ּҰ� �ٸ��⶧���� false ��µ�
			 * System.out.println(str1.equals(str2)); // str1�� str2�� ���ڿ��� ���⶧���� true ��µ�
			 * //������ ���ϼ��� ������ �� �� equals�� �����
			 * System.out.println(str1.equalsIgnoreCase(str2)); // ��ҹ��ڿ� ������� ��ġ�� �� �ֵ��� �Ѵ�
			 */
	}

}
