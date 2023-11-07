package java_standard_StreamEx;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx04 {

	public static void main(String[] args) {

		IntStream.range(1, 10)
		.parallel()
		.forEach(i->System.out.print(i+" "));
		
		System.out.println();
		IntStream.range(1, 10)
		.parallel()
		.forEachOrdered(i->System.out.print(i+" "));
		System.out.println();
		System.out.println("===========");
		
		int[] arr = {1,2,3,4,5};
		IntStream intStream	= Arrays.stream(arr);
		intStream.peek(i->System.out.print(i+" ")).allMatch(i->i>=3); // 1
		System.out.println();
		
		intStream = Arrays.stream(arr);
		intStream.peek(i->System.out.print(i+" ")).anyMatch(i->i>=3); // 1 2 3
		System.out.println();
		
		intStream = Arrays.stream(arr);
		intStream.peek(i->System.out.print(i+" ")).noneMatch(i->i>=6); // 1 2 3 4 5
		System.out.println();
		 
		intStream = Arrays.stream(arr);
		OptionalInt result = intStream.filter(i->i>=2).findFirst();
		System.out.println(result.getAsInt()); // 2
		
		intStream = Arrays.stream(arr);
		OptionalInt result2 = intStream.filter(i->i<=2).findAny();
		System.out.println(result2.getAsInt()); // 1
		System.out.println();
		
		//                     11          4       6       6        5      3
		String[] strArr= {"Inheritance","java","Lambda","stream","count","sum"};
		
		// Stream<String[]>을 IntStream으로 변환
		IntStream intStream2 = Stream.of(strArr).mapToInt(s->s.length());
		IntStream intStream3 = Stream.of(strArr).mapToInt(s->s.length());
		IntStream intStream4 = Stream.of(strArr).mapToInt(s->s.length());
		IntStream intStream5 = Stream.of(strArr).mapToInt(s->s.length());
		
		int count = intStream2.reduce(0, (a,b)->a+1);
		int sum = intStream3.reduce(0, (a,b)->a+b);
		int max = intStream4.reduce(1,(a,b)->a>b?a:b);
		int min = intStream5.reduce(max,(a,b)->a<b?a:b);
		System.out.println("count :"+count);
		System.out.println("sum :"+sum);
		System.out.println("max :"+max);
		System.out.println("min :"+min);
		
		
		
		
		
		
	}

}
