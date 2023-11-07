package java_standard_StreamEx;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx02 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();// list�� Stream���� ����
		intStream.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		// Stream�� 1ȸ��, Stream�� ���� ���������� �����ϸ� Stream�� ������.
		intStream = list.stream(); // list�κ��� stream ����
		intStream.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		String[] strArr = {"a","b","c","d"};
		//Stream<String> strStream = Stream.of(strArr);
		Stream<String> strStream = Arrays.stream(strArr);
		strStream.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		int[] intArr = {1,2,3,4,5};
		IntStream intStream2 = Arrays.stream(intArr);
	//	intStream2.forEach(i->System.out.print(i+" "));
		int cnt = (int)intStream2.count(); //count�� long�� �̱⶧���� int�� ����ȯ �ʿ�
		System.out.println("count :"+cnt);
		
		intStream2 = Arrays.stream(intArr); //Stream ����� ��
		int total = intStream2.sum();
		System.out.println("sum :"+total);
		System.out.println();
		
		Integer[] intArr2 = {3,5,6,4,2};
		Stream<Integer> intStream3 = Arrays.stream(intArr2);
		intStream3.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		//�����߻�
		IntStream intStream7 = new Random().ints(); // ���� ��Ʈ��
	    IntStream intStream8 = new Random().ints(10, 3, 10);
	    intStream8
	    .limit(10)
	    .forEach(i->System.out.print(i+" "));
		System.out.println();
//		
		IntStream intStream9 = IntStream.range(1, 5);//1,2,3,4
		IntStream intStream10 = IntStream.rangeClosed(1, 5);//1,2,3,4,5
//		
		// iterate(T seed, UnarOperator f) ���� ������
        Stream<Integer> evenStream = Stream.iterate(0, n->n+2);//2,4,6...
        evenStream
        .limit(5)
        .forEach(i->System.out.println(i+" "));
        
        // generate(Supplier s) : �ֱ⸸ �ϴ°� �Է�x, ���o
        Stream<Double>  randomStream = Stream.generate(()->Math.random()*6);
        randomStream
        .limit(5)
        .forEach(i->System.out.println(i+" "));
        Stream<Integer>  oneSteam = Stream.generate(()->1);
		oneSteam
		.limit(5)
		.forEach(i->System.out.println(i+" "));
		
		
		Stream emptyStream = Stream.empty(); // empty()�� �� ��Ʈ���� �����Ͽ� ��ȯ�Ѵ�.
		long count = emptyStream.count(); // count�� ���� 0
		
	}

}
