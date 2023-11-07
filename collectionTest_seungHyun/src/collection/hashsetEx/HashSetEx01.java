package collection.hashsetEx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


class Student{
	String school; // �б� 
	int snum; // �й� 
	int num; // ��ȣ
	
	public Student() {	}
	public Student(String school, int snum, int num ) {
		this.school=school; this.snum=snum; this.num=num;
	}
	@Override
	public String toString() {
		return "Student [�б�=" + school + ", �й�=" + snum + ", ��ȣ=" + num + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + snum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (num != other.num)
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (snum != other.snum)
			return false;
		return true;
	}
	
	
}


public class HashSetEx01 {

	public static void main(String[] args) {

		//--------------------- Student 
		Set<Student> stu = new HashSet<Student>();
		stu.add(new Student("�����", 2018, 10));	
		stu.add(new Student("�����", 2018, 20));
		stu.add(new Student("�����", 2018, 15));
		stu.add(new Student("�����", 2018, 10));
		stu.add(new Student("���ִ�", 2020, 30));
		stu.add(new Student("���ִ�", 2020, 30));
		stu.add(new Student("���ִ�", 2020, 30));
		stu.add(new Student("�����", 2019, 10));
		stu.add(new Student("�����", 2019, 10));
		
		// ----- ��� 
		Iterator<Student> itstu = stu.iterator();
		while(itstu.hasNext() ) {
			Student objStu = itstu.next();
			System.out.println(objStu);
		}
	}

}
