package java_standard_StreamEx;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest01 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(3,1,5,4,2);
		List<Integer> sortedList = list.stream().sorted() //list�� �����ؼ� 
				                 .collect(Collectors.toList());//���ο� List�� ����
		System.out.println(list); // [3, 1, 5, 4, 2]
		System.out.println(sortedList);//[1, 2, 3, 4, 5]
		
		Stream<Integer> intStream1 = list.stream(); // �÷���
		Stream<String> strStream = Stream.of(new String[] {"a","b","c"});//�迭
		Stream<Integer> evenStream = Stream.iterate(0, n->n+2); //0,2,4,6,....
		Stream<Double> randomtream = Stream.generate(()->Math.random()*6+1); // ���ٽ�
		IntStream intStream2 = new Random().ints(5); //���� ��Ʈ��(ũ�Ⱑ:5)
		
		IntStream intStream = new Random().ints(1,46); //1~45���� ���ѽ�Ʈ��
		intStream.distinct().limit(6).sorted() // �߰� ����
		         .forEach(i->System.out.print(i+","));//���� ����
		System.out.println();
		
		IntStream intStream3 = new Random().ints(1,46); //1~45���� ���ѽ�Ʈ��
		intStream3.distinct().limit(5).sorted().forEach(i->System.out.println(i));
		
		String[] strArr = {"dd","aaa","cc","CC","b"};
		Stream<String> stream = Stream.of(strArr);//���ڿ� �迭�� �ҽ��� ��Ʈ��
		//Stream<String> filteredStream = stream.filter();//�ɷ�����(�߰� ����)
		Stream<String> distinctedStream = stream.distinct();//�ߺ�����(�߰� ����)
		Stream<String> sortedStream = stream.sorted();//����(�߰� ����)
		Stream<String> limitedStream = stream.limit(5);//��Ʈ�� �ڸ���(�߰� ����)
		int total = (int)stream.count();// ����� ���� ����(��������), cout�� long���̹Ƿ� (int)�� ����ȯ 
			
		strStream.forEach(i->System.out.println(i));//��� ��Ҹ� ȭ�鿡 ���(��������)
		Stream<String> strStream2 = Stream.of(new String[] {"a","b","c"});//�迭
		int numOfStr = (int)strStream2.count(); //����, ��Ʈ���� �̹� ������
		System.out.println(numOfStr);
		
		Stream<String> strStream3 = Stream.of("dd","aaa","cc","CC","b");
		int sum = strStream.parallel() // ���Ľ�Ʈ������ ��ȯ(�Ӽ��� ����)
				           .mapToInt(s -> s.length()).sum(); //��� ���ڿ��� ������ ��
		
		
		
		
//		������ ���ϴ� ���ο� Ŀ���� �ΰų� ����� �����ϰ�
//		<ctrl + alt + ��> �Ǵ� <ctrl + alt + ��>�� ������ ���Դϴ�.
		
				
		
	}

}
