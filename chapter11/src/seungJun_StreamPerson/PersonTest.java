package seungJun_StreamPerson;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonTest {

	public static void main(String[] args) {
		List<Person> personStream = Arrays.asList(
				new Person("�ѱ�","����","ȫ�浿"),
				new Person("�ѱ�","����","�ӿ���"),
				new Person("�ѱ�","�λ�","������"),
				new Person("�߱�","����¡","�ռ���"),
				new Person("�̱�","������","�̼�"),
				new Person("�̱�","LA","����Ŭ"),
				new Person("�̱�","LA","����"),
				new Person("�߱�","����¡","���̹�")
				);
		
		// [1] groupingBy�� �̿��Ͽ� �� ���� ���
		System.out.println("=== �� ���󺰷� ��� ===");
		// Map<String, List<Person>> personByCountry = Arrays.stream(personStream)
		// Map<String, List<Person>> personByCountry = Stream.of(personStream);
		Map<String, List<Person>> personByCountry = personStream.stream()
				.collect(Collectors.groupingBy((Person::getCountry),
						Collectors.toList()));
		
		List<Person> korea = personByCountry.get("�ѱ�");
		List<Person> china = personByCountry.get("�߱�");
		List<Person> america = personByCountry.get("�̱�");
		
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
				
		// [2] groupingBy�� �̿��Ͽ� �� ���� ���� �ο��� ��� �Ͻÿ�.
		System.out.println("=== �� ���� ���� �ο� ��� ===");
		int korean = (int)personByCountry.get("�ѱ�").stream().count();
		int chinese = (int)personByCountry.get("�߱�").stream().count();
		int american = (int)personByCountry.get("�̱�").stream().count();
		
		System.out.println("�ѱ��� ��:"+korean);
		System.out.println("�߱��� ��:"+chinese);
		System.out.println("�̱��� ��:"+american);
		System.out.println();
		
		// [3] groupingBy�� �̿��Ͽ� ���ú��� ��� �Ͻÿ�.
		System.out.println("=== �� ���ú��� ��� ===");
		Map<String, List<Person>> personByCity = personStream.stream()
				.collect(Collectors.groupingBy((Person::getCity),
						Collectors.toList()));
		
		List<Person> seoul = personByCity.get("����");
		List<Person> busan = personByCity.get("�λ�");
		List<Person> beijing = personByCity.get("����¡");
		List<Person> boston = personByCity.get("������");
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
		
		// [4] �̱� LA�� �����ڸ� ��� ��� �Ͻÿ�.
		System.out.println("=== �̱� LA �����ڸ� ��� ===");
		Map<String,Map<String,List<Person>>> personByCountryAndCity = personStream.stream()
				.collect(Collectors.groupingBy((Person::getCountry),
						 Collectors.groupingBy((Person::getCity),
						 Collectors.toList()))
						 );
		List<Person> americaAndLA = personByCountryAndCity.get("�̱�").get("LA");
		for(Person p : americaAndLA) {
			System.out.println(p);
		}
	}

}
