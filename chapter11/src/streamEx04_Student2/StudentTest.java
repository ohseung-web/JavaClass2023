package streamEx04_Student2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTest {

	public static void main(String[] args) {

		Student[] stuArr = {
				new Student("���ڹ�", true, 1, 1, 300),  
				new Student("������", false, 1, 1, 250), 
				new Student("���ڹ�", true, 1, 1, 200),  
				new Student("������", false, 1, 2, 150),  
				new Student("���ڹ�", true, 1, 2, 100),  
				new Student("������", false, 1, 2, 50),  
				new Student("Ȳ����", false, 1, 3, 100),  
				new Student("������", false, 1, 3, 150),  
				new Student("���ڹ�", true, 1, 3, 200),
				new Student("���ڹ�", true, 2, 1, 300),  
				new Student("������", false, 2, 1, 250),  
				new Student("���ڹ�", true, 2, 1, 200),  
				new Student("������", false, 2, 2, 150),  
				new Student("���ڹ�", true, 2, 2, 100),  
				new Student("������", false, 2, 2, 50),  
				new Student("Ȳ����", false, 2, 3, 100),  
				new Student("������", false, 2, 3, 150),  
				new Student("���ڹ�", true, 2, 3, 200)
				}; 
		
		// collect �������� Collectors�� �Լ��� 
		Stream<Student> stuStream1 = Stream.of(stuArr);
		Stream<Student> stuStream2 = Stream.of(stuArr);
		Stream<Student> stuStream3 = Stream.of(stuArr);
		Stream<Student> stuStream4 = Stream.of(stuArr);
		Stream<Student> stuStream5 = Stream.of(stuArr);
		Stream<Student> stuStream6 = Stream.of(stuArr);
		Stream<Student> stuStream7 = Stream.of(stuArr);
		Stream<Student> stuStream8 = Stream.of(stuArr);
		Stream<Student> stuStream9 = Stream.of(stuArr);
		
		
		long cnt = stuStream1.count();
		long cnt2 = stuStream2.collect(Collectors.counting());
		
		long totScore = stuStream3.mapToInt(Student::getScore).sum();
		long totScore2 = stuStream4.collect(Collectors.summingInt(Student::getScore));
		
		OptionalInt max = stuStream5.mapToInt(Student::getScore).max();
		Optional<Student> max2 = stuStream6
				.collect(Collectors.maxBy(Comparator.comparing(Student::getScore)));
         
		int sum1 = stuStream7
				.mapToInt(Student::getScore)
				.reduce(0, (a,b)->a+b);
		
		int sum2 = stuStream8
				.mapToInt(Student::getScore)
				.boxed()
				.collect(Collectors.reducing(0, (a,b)->a+b));
		
		String studentNames = stuStream9.map(Student::getName)
				              .collect(Collectors.joining(","));
		
		System.out.println("-----------------------------------");
		System.out.println("Student2 ��ü���� :"+cnt);
		System.out.println("Student2 �׷캰���� :"+cnt2);
		System.out.println("Student2 ��ü�հ� :"+totScore);
		System.out.println("Student2 �׷캰 �հ� :"+totScore2);
		System.out.println("Student2 ��ü �ִ밪 :"+max);
		System.out.println("Student2 �׷캰 �ִ밪 :"+max2);
		System.out.println("Student2 reduce�հ� :"+sum1);
		System.out.println("Student2 reduce�׷캰 �հ� :"+sum2);
		System.out.println("Student2 name  :"+studentNames);
		
		System.out.println("-----------------------------------");		
		
		// pratitingBy ���� : Map���� return����
		System.out.println("1. �ܼ�����(������ ����)");
		Map<Boolean, List<Student>> strStream = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student::isMale));

		Object[] obj = strStream.values().toArray();
		for(Object ob : obj) {
			System.out.println(ob);
		}
		System.out.println("2. �ܼ�����+���(���� �л���)");
		Map<Boolean,Long> strStream2 = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student::isMale),
						 Collectors.counting()));
		System.out.println("����:"+strStream2.get(true)+"��");
		System.out.println("����:"+strStream2.get(false)+"��");
		
		System.out.println("3. �ܼ�����+���(���� 1��)");
		Map<Boolean, Optional<Student>> strStream3 = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student::isMale), 
						 Collectors.maxBy(Comparator.comparing(Student::getScore))));
		System.out.println("���� 1��"+strStream3.get(true));
		System.out.println("���� 1��"+strStream3.get(false));
		
		System.out.println("4. ���ߺ���(�������հ���, 100�� ����)");
		// �հ� : true, ���հ� : false
		Map<Boolean, Map<Boolean,List<Student>>> strStream4 = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student::isMale), 
						 Collectors.partitioningBy((Student s)->s.getScore()<=100)));
		List<Student> failman = strStream4.get(true).get(true); 
		List<Student> failwoman = strStream4.get(false).get(true);
		
		for(Student s : failman) {
			System.out.println(s);
		}
		for(Student s : failwoman) {
			System.out.println(s);
		}
		
		// groupby ����
		System.out.println("groupingBy �ݺ� ���");
		Map<Integer, List<Student>> strStream5 = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student::getBan));
		
		Object[] obj3 = strStream5.values().toArray();
		for(Object ob3 : obj3) {
			System.out.println(ob3);
		}
		System.out.println();
		
		System.out.println("groupingBy �г�, �ݺ�");
		Map<Integer, Map<Integer, List<Student>>> strStream6 = Stream.of(stuArr)
				.collect(Collectors.groupingBy((Student::getHak), 
						Collectors.groupingBy((Student::getBan), 
						Collectors.toList())));

       for(Map<Integer, List<Student>> hak : strStream6.values()) {
    	   for(List<Student> ban : hak.values()) {
    		   System.out.println(ban);
    	   }
       }
		
	}

}
