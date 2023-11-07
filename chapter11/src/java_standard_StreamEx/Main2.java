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
				new Student2("나자바", true, 1, 1, 300),  
				new Student2("김지미", false, 1, 1, 250), 
				new Student2("김자바", true, 1, 1, 200),  
				new Student2("이지미", false, 1, 2, 150),  
				new Student2("남자바", true, 1, 2, 100),  
				new Student2("안지미", false, 1, 2, 50),  
				new Student2("황지미", false, 1, 3, 100),  
				new Student2("강지미", false, 1, 3, 150),  
				new Student2("이자바", true, 1, 3, 200),
				new Student2("나자바", true, 2, 1, 300),  
				new Student2("김지미", false, 2, 1, 250),  
				new Student2("김자바", true, 2, 1, 200),  
				new Student2("이지미", false, 2, 2, 150),  
				new Student2("남자바", true, 2, 2, 100),  
				new Student2("안지미", false, 2, 2, 50),  
				new Student2("황지미", false, 2, 3, 100),  
				new Student2("강지미", false, 2, 3, 150),  
				new Student2("이자바", true, 2, 3, 200)
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
		
		long count = stuStream.count(); //전체 개수
		long count2 = stuStream2.collect(Collectors.counting()); //그룹별 개수
		
		int totalScore = stuStream3.mapToInt((Student2 s)->s.getScore()).sum();//전체 합계
		int totalScore2 = stuStream4.collect(Collectors.summingInt(Student2::getScore)); //그룹별 합계
		
		OptionalInt max1 = stuStream5.mapToInt((Student2 s)->s.getScore()).max();//전체 최대값
		Optional<Student2> max2 = stuStream6
				.collect(Collectors.maxBy(Comparator.comparingInt(Student2::getScore)));//그룹별 최대값
		
		int reduceTotal = intStream
				.mapToInt((Student2 s)->s.getScore())
				.reduce(0, (a,b)->a+b); //전체 reduce
		
		int reduceTotal2 = intStream2.mapToInt(Student2::getScore)
				           .boxed().collect(Collectors.reducing(0, (a,b)->a+b));//그룹별 reduce
		
		String strName = strStream.map((Student2 s)->s.getName())
				.collect(Collectors.joining());
		String strName2 = strStream2.map((Student2 s)->s.getName())
				.collect(Collectors.joining(",")); //StringBuilder와 같은 역활을 한다.
		
		System.out.println("-----------------------------------");
		System.out.println("Student2 전체개수 :"+count);
		System.out.println("Student2 그룹별개수 :"+count2);
		System.out.println("Student2 전체합계 :"+totalScore);
		System.out.println("Student2 그룹별 합계 :"+totalScore2);
		System.out.println("Student2 전체 최대값 :"+max1);
		System.out.println("Student2 그룹별 최대값 :"+max2);
		System.out.println("Student2 reduce합계 :"+reduceTotal);
		System.out.println("Student2 reduce그룹별 합계 :"+reduceTotal2);
		System.out.println("Student2 name  :"+strName2);
		
		System.out.println("-----------------------------------");
		
		System.out.println("1. 단순분할(성별로 분할)");
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
		System.out.println("2. 단순분할+통계(성별 학생수)");
		Map<Boolean, Long> stuNumGender = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student2 s)->s.isMale(), 
						 Collectors.counting()));
		
		System.out.println("남학생의 수:"+stuNumGender.get(true));
		System.out.println("여학생의 수:"+stuNumGender.get(false));
		System.out.println();
		
		//---------------------------------------------------------------------
		System.out.println("3. 단순분할+통계(성적 1등)");
		Map<Boolean, Optional<Student2>> topScoreGender = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student2 s)->s.isMale(), 
						 Collectors.maxBy(Comparator.comparing((Student2 s)->s.isMale()))));
		System.out.println("남학생1등:"+topScoreGender.get(true));
		System.out.println("여학생1등:"+topScoreGender.get(false));
		System.out.println();
		
		//---------------------------------------------------------------------
		System.out.println("4. 다중분할(성별불합격자, 100점 이하)");
		Map<Boolean, Map<Boolean, List<Student2>>> failedStuGender = Stream.of(stuArr)
				.collect(Collectors.partitioningBy((Student2 s)->s.isMale(), 
						 Collectors.partitioningBy((Student2 s)->s.getScore() <=100)));
		
		List<Student2> failedmale = failedStuGender.get(true).get(true);
		List<Student2> failedfemale = failedStuGender.get(false).get(true);
		
		for(Student2 s : failedmale) {System.out.println(s);}
		for(Student2 s : failedfemale) {System.out.println(s);}
		System.out.println();

		
		// ---- groupingBy( ) 관련 내용
		System.out.println("groupingBy 반별 출력");
		Map<Integer, List<Student2>> stuByBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy((Student2::getBan),
				      //  Collectors.toCollection(()->new ArrayList<>()))); 
		                  Collectors.toCollection(ArrayList::new))); 
		
		//출력방법 1. Collectors.toCollection(ArrayList::new)생성하여 출력
		
		for(int i=0;i<stuByBan.size();i++) {
		    if(stuByBan.get(i) != null) {
			   System.out.println(stuByBan.get(i));
			}
			
		}
		// 출력하는 방법2 : 다중 확장 for문을 이용하여 출력
		for(List<Student2> ban : stuByBan.values()) {
			for(Student2 s : ban) {
				System.out.println(s);
			}
		}
		System.out.println();
		System.out.println("groupingBy 학년, 반별");
		
		Map<Integer, Map<Integer, List<Student2>>> stuByHakAndBan = Stream.of(stuArr) //다중그룹화
				.collect(Collectors.groupingBy((Student2::getHak), //1. 학년별 그룹화
						Collectors.groupingBy((Student2::getBan),  //2. 반별 그룹화
						Collectors.toList()))); // toList() 생략가능
		// 출력하는 방법 1. 스트림을 -> Object[] 배열로 변환하여 출력
		Object[] obj2 = stuByHakAndBan.values().toArray();
		for(Object ob : obj2) {System.out.println(ob);}
		
		// 출력하는 방법2 : 다중 확장 for문을 이용하여 출력
		for(Map<Integer, List<Student2>> hakban : stuByHakAndBan.values()) {
			for(List<Student2> s: hakban.values()) {
				System.out.println(s);
			}
		}

		
		
		
//		.collect(Collectors.groupingBy((Student2 s)->s.getHak(), //1. 학년별 그룹화
				//			 Collectors.groupingBy(Student2::getBan)));      //2. 반별 그룹화
			
		
	}


	

}
