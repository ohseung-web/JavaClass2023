package java_standard_StreamEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
  
		// Student클래스를 stream으로 생성
		/*
		Stream<Student> studentStream = Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("인자바",2,100),
		    	new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("김자바",3,100)
				);
	    */
        List<Student> studentStream = Arrays.asList(
        		new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("인자바",2,100),
				new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("김자바",3,100)
				);
        		      
		
//		studentStream.sorted(Comparator.comparing((Student s)->s.getBan())//반별로 정렬
//				     .thenComparing(Comparator.naturalOrder())) // 기본정렬
//				     .forEach(i->System.out.println(i));
	
       
        List<Student> stStream = studentStream.stream()
        		     .sorted(Comparator.comparing((Student s)->s.getBan()).reversed()//반별로 역순정렬
				     .thenComparing((Student s)->s.getName()) // 반이 같으면 이름으로 정렬
				     .thenComparing((Student s)->s.getTotalScore())) // 총점별로 정렬
        		     .collect(Collectors.toList());
        //System.out.println(stStream);
        
        Object[] obj = stStream.toArray();
        for(Object student : obj) {
        	System.out.println(student.toString());
        }
		
        // 3학년을 모두 추출
        List<Student> stStream2 = studentStream.stream()
        		       .filter((Student s)->s.getBan()==3)
        		       .collect(Collectors.toList());
        System.out.println(stStream2);
		
        
        // 총점이 200이상인 데이터 모두 추출
        List<Student> stStream3 = studentStream.stream()
        		      .filter((Student s)->s.getTotalScore()>=200)
        		      .collect(Collectors.toList());
        
        Object[] obj2 = stStream3.toArray();        
        for(Object score : obj2) {
        	System.out.println(score);
        }
        
    
//		studentStream.sorted(Comparator.comparing((Student s)->s.getBan()).reversed()//반별로 역순정렬
//				     .thenComparing((Student s)->s.getName()) // 반이 같으면 이름으로 정렬
//				     .thenComparing((Student s)->s.getTotalScore())) // 총점별로 정렬
//				     .forEach(i->System.out.println(i));
				     
		        
		        
		         
		         
		
		
	}

	

}
