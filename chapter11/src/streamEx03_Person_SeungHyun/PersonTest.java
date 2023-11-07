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
				new Person("�ѱ�","����","ȫ�浿"),
				new Person("�ѱ�","����","�ӿ���"),
				new Person("�ѱ�","�λ�","������"),
				new Person("�߱�","����¡","�ռ���"),
				new Person("�̱�","������","�̼�"),
				new Person("�̱�","LA","����Ŭ"),
				new Person("�̱�","LA","����"),
				new Person("�߱�","����¡","���̹�")
				);
	

		// 1. groupby�� �̿��Ͽ� �� ���� ��� => Collect �Ű����� 1��¥�� �����ؾ� ��
		// Collectors.groupingBy �޼��� 1��¥�� �̿�
		Map<String, List<Person>> countryStream = personStream.stream()
				.collect(Collectors.groupingBy(Person::getCountry));
		
		System.out.println("1. ���� �׷�");
		Object[] obj = countryStream.values().toArray();
		for(Object ob : obj) {
			System.out.println(ob);
		}
		System.out.println();
		
	    // 2. groupby�� �̿��Ͽ� �� ���� ���� �ο��� ����Ͻÿ�.
		// Collectors.groupingBy �޼��� 2��¥�� �̿�
		Map<String, Long> cntStream = personStream.stream()
				.collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));
		
	    System.out.println("2. ���� �ο���");
	    System.out.println("�̱�:"+cntStream.get("�̱�")+"��");
	    System.out.println("�߱�:"+cntStream.get("�߱�")+"��");
	    System.out.println("�ѱ�:"+cntStream.get("�ѱ�")+"��");
	  //  System.out.println(cntStream);
	    System.out.println();
	 
	 // 3. groupby�� �̿��Ͽ� ���ú��� ����Ͻÿ�.  
	    Map<String, List<Person>> cityStream = personStream.stream()
	    		.collect(Collectors.groupingBy(Person::getCity));
	    
	    System.out.println("3. ���ú� �׷�");
	    Object[] obj2 = cityStream.values().toArray();
	    for(Object ob2 :obj2) {
	    	System.out.println(ob2);
	    }
	    System.out.println();
	    
	    
	 // 4. �̱� LA�� �����ڸ� ��� ����Ͻÿ�.
	    List<Person> pStream = personStream.stream()
	    		.filter((Person p)->p.getCity().equals("LA"))
	    		.collect(Collectors.toList());
	    System.out.println("4. LA ������");
	    System.out.println(pStream);
	    
	    
	}

}
