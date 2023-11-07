package java_standard_StreamEx;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx02 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();// list를 Stream으로 생성
		intStream.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		// Stream은 1회용, Stream에 대해 최종연산을 수행하면 Stream은 닫힌다.
		intStream = list.stream(); // list로부터 stream 생성
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
		int cnt = (int)intStream2.count(); //count가 long형 이기때문에 int로 형변환 필요
		System.out.println("count :"+cnt);
		
		intStream2 = Arrays.stream(intArr); //Stream 재생성 함
		int total = intStream2.sum();
		System.out.println("sum :"+total);
		System.out.println();
		
		Integer[] intArr2 = {3,5,6,4,2};
		Stream<Integer> intStream3 = Arrays.stream(intArr2);
		intStream3.forEach(i->System.out.print(i+" "));
		System.out.println();
		
		//난수발생
		IntStream intStream7 = new Random().ints(); // 무한 스트림
	    IntStream intStream8 = new Random().ints(10, 3, 10);
	    intStream8
	    .limit(10)
	    .forEach(i->System.out.print(i+" "));
		System.out.println();
//		
		IntStream intStream9 = IntStream.range(1, 5);//1,2,3,4
		IntStream intStream10 = IntStream.rangeClosed(1, 5);//1,2,3,4,5
//		
		// iterate(T seed, UnarOperator f) 단항 연산자
        Stream<Integer> evenStream = Stream.iterate(0, n->n+2);//2,4,6...
        evenStream
        .limit(5)
        .forEach(i->System.out.println(i+" "));
        
        // generate(Supplier s) : 주기만 하는것 입력x, 출력o
        Stream<Double>  randomStream = Stream.generate(()->Math.random()*6);
        randomStream
        .limit(5)
        .forEach(i->System.out.println(i+" "));
        Stream<Integer>  oneSteam = Stream.generate(()->1);
		oneSteam
		.limit(5)
		.forEach(i->System.out.println(i+" "));
		
		
		Stream emptyStream = Stream.empty(); // empty()는 빈 스트림을 생성하여 반환한다.
		long count = emptyStream.count(); // count의 값은 0
		
	}

}
