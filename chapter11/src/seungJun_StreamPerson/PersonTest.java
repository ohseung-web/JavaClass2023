package seungJun_StreamPerson;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		// [1] groupingBy를 이용하여 각 나라별 출력
		System.out.println("=== 각 나라별로 출력 ===");
		// Map<String, List<Person>> personByCountry = Arrays.stream(personStream)
		// Map<String, List<Person>> personByCountry = Stream.of(personStream);
		Map<String, List<Person>> personByCountry = personStream.stream()
				.collect(Collectors.groupingBy((Person::getCountry),
						Collectors.toList()));
		
		List<Person> korea = personByCountry.get("한국");
		List<Person> china = personByCountry.get("중국");
		List<Person> america = personByCountry.get("미국");
		
		for(Person p : korea) {
			System.out.println(p);
		}
		System.out.println();
		for(Person p : china) {
			System.out.println(p);
		}
		System.out.println();
		for(Person p : america) {
			System.out.println(p);
		}
		System.out.println();
				
		// [2] groupingBy를 이용하여 각 나라별 거주 인원을 출력 하시오.
		System.out.println("=== 각 나라별 거주 인원 출력 ===");
		int korean = (int)personByCountry.get("한국").stream().count();
		int chinese = (int)personByCountry.get("중국").stream().count();
		int american = (int)personByCountry.get("미국").stream().count();
		
		System.out.println("한국인 수:"+korean);
		System.out.println("중국인 수:"+chinese);
		System.out.println("미국인 수:"+american);
		System.out.println();
		
		// [3] groupingBy를 이용하여 도시별로 출력 하시오.
		System.out.println("=== 각 도시별로 출력 ===");
		Map<String, List<Person>> personByCity = personStream.stream()
				.collect(Collectors.groupingBy((Person::getCity),
						Collectors.toList()));
		
		List<Person> seoul = personByCity.get("서울");
		List<Person> busan = personByCity.get("부산");
		List<Person> beijing = personByCity.get("베이징");
		List<Person> boston = personByCity.get("보스턴");
		List<Person> la = personByCity.get("LA");
		
		for(Person p : seoul) {
			System.out.println(p);
		}
		System.out.println();
		for(Person p : busan) {
			System.out.println(p);
		}
		System.out.println();
		for(Person p : beijing) {
			System.out.println(p);
		}
		System.out.println();
		for(Person p : boston) {
			System.out.println(p);
		}
		System.out.println();
		for(Person p : la) {
			System.out.println(p);
		}
		System.out.println();
		
		// [4] 미국 LA의 거주자를 모두 출력 하시오.
		System.out.println("=== 미국 LA 거주자만 출력 ===");
		Map<String,Map<String,List<Person>>> personByCountryAndCity = personStream.stream()
				.collect(Collectors.groupingBy((Person::getCountry),
						 Collectors.groupingBy((Person::getCity),
						 Collectors.toList()))
						 );
		List<Person> americaAndLA = personByCountryAndCity.get("미국").get("LA");
		for(Person p : americaAndLA) {
			System.out.println(p);
		}
	}

}
