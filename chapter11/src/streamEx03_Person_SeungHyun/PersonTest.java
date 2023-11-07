package streamEx03_Person_SeungHyun;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java_standard_StreamEx.Student2;

public class PersonTest {

	public static void main(String[] args) {

		List<Person> personStream = Arrays.asList(
				new Person("한국","서울","홍길동"),
				new Person("한국","서울","임영웅"),
				new Person("한국","부산","김태희"),
				new Person("중국","베이징","왕서방"),
				new Person("미국","보스턴","미셀"),
				new Person("미국","LA","마이클"),
				new Person("미국","LA","케인"),
				new Person("중국","베이징","나미미")
				);
	

		// 1. groupby를 이용하여 각 나라별 출력 => Collect 매개변수 1개짜리 선택해야 함
		// Collectors.groupingBy 메서드 1개짜리 이용
		Map<String, List<Person>> countryStream = personStream.stream()
				.collect(Collectors.groupingBy(Person::getCountry));
		
		System.out.println("1. 나라별 그룹");
		Object[] obj = countryStream.values().toArray();
		for(Object ob : obj) {
			System.out.println(ob);
		}
		System.out.println();
		
	    // 2. groupby를 이용하여 각 나라별 거주 인원을 출력하시오.
		// Collectors.groupingBy 메서드 2개짜리 이용
		Map<String, Long> cntStream = personStream.stream()
				.collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));
		
	    System.out.println("2. 나라별 인원수");
	    System.out.println("미국:"+cntStream.get("미국")+"명");
	    System.out.println("중국:"+cntStream.get("중국")+"명");
	    System.out.println("한국:"+cntStream.get("한국")+"명");
	  //  System.out.println(cntStream);
	    System.out.println();
	 
	 // 3. groupby를 이용하여 도시별로 출력하시오.  
	    Map<String, List<Person>> cityStream = personStream.stream()
	    		.collect(Collectors.groupingBy(Person::getCity));
	    
	    System.out.println("3. 도시별 그룹");
	    Object[] obj2 = cityStream.values().toArray();
	    for(Object ob2 :obj2) {
	    	System.out.println(ob2);
	    }
	    System.out.println();
	    
	    
	 // 4. 미국 LA의 거주자를 모두 출력하시오.
	    List<Person> pStream = personStream.stream()
	    		.filter((Person p)->p.getCity().equals("LA"))
	    		.collect(Collectors.toList());
	    System.out.println("4. LA 거주자");
	    System.out.println(pStream);
	    
	    
	}

}
