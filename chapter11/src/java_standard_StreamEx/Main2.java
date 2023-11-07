package java_standard_StreamEx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {

	public static void main(String[] args) {

		Student2[] stuArr = {
				new Student2("���ڹ�", true, 1, 1, 300),  
				new Student2("������", false, 1, 1, 250), 
				new Student2("���ڹ�", true, 1, 1, 200),  
				new Student2("������", false, 1, 2, 150),  
				new Student2("���ڹ�", true, 1, 2, 100),  
				new Student2("������", false, 1, 2, 50),  
				new Student2("Ȳ����", false, 1, 3, 100),  
				new Student2("������", false, 1, 3, 150),  
				new Student2("���ڹ�", true, 1, 3, 200),
				new Student2("���ڹ�", true, 2, 1, 300),  
				new Student2("������", false, 2, 1, 250),  
				new Student2("���ڹ�", true, 2, 1, 200),  
				new Student2("������", false, 2, 2, 150),  
				new Student2("���ڹ�", true, 2, 2, 100),  
				new Student2("������", false, 2, 2, 50),  
				new Student2("Ȳ����", false, 2, 3, 100),  
				new Student2("������", false, 2, 3, 150),  
				new Student2("���ڹ�", true, 2, 3, 200)
				}; 
		
		
		Stream<Student2> stuStream = Stream.of(stuArr);
		Stream<Student2> stuStream2 = Stream.of(stuArr);
		Stream<Student2> stuStream3 = Stream.of(stuArr);
		Stream<Student2> stuStream4 = Stream.of(stuArr);
		Stream<Student2> stuStream5 = Stream.of(stuArr);
		Stream<Student2> stuStream6 = Stream.of(stuArr);
		Stream<Student2> intStream = Stream.of(stuArr);
		Stream<Student2> intStream2 = Stream.of(stuArr);
		Stream<Student2> strStream = Stream.of(stuArr);
		Stream<Student2> strStream2 = Stream.of(stuArr);
		Stream<Student2> strStream3 = Stream.of(stuArr);
		
		long count = stuStream.count(); //��ü ����
		long count2 = stuStream2.collect(Collectors.counting()); //�׷캰 ����
		
		int totalScore = stuStream3.mapToInt((Student2 s)->s.getScore()).sum();//��ü �հ�
		int totalScore2 = stuStream4.collect(Collectors.summingInt(Student2::getScore)); //�׷캰 �հ�
		
		OptionalInt max1 = stuStream5.mapToInt((Student2 s)->s.getScore()).max();//��ü �ִ밪
		Optional<Student2> max2 = stuStream6
				.collect(Collectors.maxBy(Comparator.comparingInt(Student2::getScore)));//�׷캰 �ִ밪
		
		int reduceTotal = intStream
				.mapToInt((Student2 s)->s.getScore())
				.reduce(0, (a,b)->a+b); //��ü reduce
		
		int reduceTotal2 = intStream2.mapToInt(Student2::getScore)
				           .boxed().collect(Collectors.reducing(0, (a,b)->a+b));//�׷캰 reduce
		
		String strName = strStream.map((Student2 s)->s.getName())
				.collect(Collectors.joining());
		String strName2 = strStream2.map((Student2 s)->s.getName())
				.collect(Collectors.joining(",")); //StringBuilder�� ���� ��Ȱ�� �Ѵ�.
		
		System.out.println("-----------------------------------");
		System.out.println("Student2 ��ü���� :"+count);
		System.out.println("Student2 �׷캰���� :"+count2);
		System.out.println("Student2 ��ü�հ� :"+totalScore);
		System.out.println("Student2 �׷캰 �հ� :"+totalScore2);
		System.out.println("Student2 ��ü �ִ밪 :"+max1);
		System.out.println("Student2 �׷캰 �ִ밪 :"+max2);
		System.out.println("Student2 reduce�հ� :"+reduceTotal);
		System.out.println("Student2 reduce�׷캰 �հ� :"+reduceTotal2);
		System.out.println("Student2 name  :"+strName2);
		
		System.out.println("-----------------------------------");
		
		System.out.println("1. �ܼ�����(������ ����)");
		Map<Boolean, List<Student2>> stuByGender = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student2 s)->s.isMale));
		
		List<Student2> maleStudent = stuByGender.get(true);
		List<Student2> femaleStudent = stuByGender.get(false);
		
		for(Student2 s:maleStudent) {
			System.out.println(s);
		}
		for(Student2 f:femaleStudent) {
			System.out.println(f);
		}
		System.out.println();
		
		//---------------------------------------------------------------------
		System.out.println("2. �ܼ�����+���(���� �л���)");
		Map<Boolean, Long> stuNumGender = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student2 s)->s.isMale(), 
						 Collectors.counting()));
		
		System.out.println("���л��� ��:"+stuNumGender.get(true));
		System.out.println("���л��� ��:"+stuNumGender.get(false));
		System.out.println();
		
		//---------------------------------------------------------------------
		System.out.println("3. �ܼ�����+���(���� 1��)");
		Map<Boolean, Optional<Student2>> topScoreGender = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student2 s)->s.isMale(), 
						 Collectors.maxBy(Comparator.comparing((Student2 s)->s.isMale()))));
		System.out.println("���л�1��:"+topScoreGender.get(true));
		System.out.println("���л�1��:"+topScoreGender.get(false));
		System.out.println();
		
		//---------------------------------------------------------------------
		System.out.println("4. ���ߺ���(�������հ���, 100�� ����)");
		Map<Boolean, Map<Boolean, List<Student2>>> failedStuGender = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student2 s)->s.isMale(), 
						 Collectors.partitioningBy((Student2 s)->s.getScore() <=100)));
		
		List<Student2> failedmale = failedStuGender.get(true).get(true);
		List<Student2> failedfemale = failedStuGender.get(false).get(true);
		
		for(Student2 s : failedmale) {System.out.println(s);}
		for(Student2 s : failedfemale) {System.out.println(s);}
		System.out.println();

		
		// ---- groupingBy( ) ���� ����
		System.out.println("groupingBy �ݺ� ���");
		Map<Integer, List<Student2>> stuByBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy((Student2::getBan),
				      //  Collectors.toCollection(()->new ArrayList<>()))); 
		                  Collectors.toCollection(ArrayList::new))); 
		
		//��¹�� 1. Collectors.toCollection(ArrayList::new)�����Ͽ� ���
		
		for(int i=0;i<stuByBan.size();i++) {
		    if(stuByBan.get(i) != null) {
			   System.out.println(stuByBan.get(i));
			}
			
		}
		// ����ϴ� ���2 : ���� Ȯ�� for���� �̿��Ͽ� ���
		for(List<Student2> ban : stuByBan.values()) {
			for(Student2 s : ban) {
				System.out.println(s);
			}
		}
		System.out.println();
		System.out.println("groupingBy �г�, �ݺ�");
		
		Map<Integer, Map<Integer, List<Student2>>> stuByHakAndBan = Stream.of(stuArr) //���߱׷�ȭ
				.collect(Collectors.groupingBy((Student2::getHak), //1. �г⺰ �׷�ȭ
						Collectors.groupingBy((Student2::getBan),  //2. �ݺ� �׷�ȭ
						Collectors.toList()))); // toList() ��������
		// ����ϴ� ��� 1. ��Ʈ���� -> Object[] �迭�� ��ȯ�Ͽ� ���
		Object[] obj2 = stuByHakAndBan.values().toArray();
		for(Object ob : obj2) {System.out.println(ob);}
		
		// ����ϴ� ���2 : ���� Ȯ�� for���� �̿��Ͽ� ���
		for(Map<Integer, List<Student2>> hakban : stuByHakAndBan.values()) {
			for(List<Student2> s: hakban.values()) {
				System.out.println(s);
			}
		}

		
		
		
//		.collect(Collectors.groupingBy((Student2 s)->s.getHak(), //1. �г⺰ �׷�ȭ
				//			 Collectors.groupingBy(Student2::getBan)));      //2. �ݺ� �׷�ȭ
			
		
	}


	

}
