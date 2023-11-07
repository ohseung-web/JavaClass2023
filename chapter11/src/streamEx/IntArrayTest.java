package streamEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntArrayTest {

	public static void main(String[] args) {

		int[] arr = {5,7,1,9,10};
		
		// 기본형 스트림(IntStream, LongStream, DoubleStream)
		IntStream stream = Arrays.stream(arr);
		
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
		OptionalDouble avg = Arrays.stream(arr).average();
		//avg.ifPresent(System.out::print);
		System.out.println(avg.getAsDouble());
		
		OptionalInt max = Arrays.stream(arr).max();
		//max.ifPresent(System.out::print);
		System.out.println(max.getAsInt());
		
		OptionalInt min = Arrays.stream(arr).min();
		//min.ifPresent(System.out::print);
		System.out.println();
		System.out.println(min.getAsInt());
		
		int count =(int)Arrays.stream(arr).count();
		System.out.println(count);
		
		int[] arr2 = {7,5,5,2,1,2,3,5,4,6};
		
		IntStream stream1 = Arrays.stream(arr2);
		stream1.filter(n -> n % 2 !=0).forEach(e -> System.out.print(e + " "));
		System.out.println();
		System.out.println("=============");
		
		IntStream stream2 = Arrays.stream(arr2);
		stream2.distinct().forEach(e -> System.out.print(e + " "));
		System.out.println();
		System.out.println("=============");
		
		String[] arrString = {"book","book1","book3"};
		Stream<String> stream3 = Arrays.stream(arrString);
		stream3.map(s -> s.length()).forEach(e -> System.out.print(e+" "));
		System.out.println();
		System.out.println("=============");
		
		Stream<String> stream4 = Arrays.stream(arrString);
		stream4.flatMap(s->s.lines()).forEach(e -> System.out.print(e+" "));
		System.out.println();
		System.out.println("=============");
		
		IntStream stream5 = Arrays.stream(arr);
		stream5.limit(4).forEach(e -> System.out.print(e+" "));
		System.out.println();
		System.out.println("=============");
		
		IntStream stream6 = Arrays.stream(arr);
		stream6.skip(2).forEach(e -> System.out.print(e+" "));
		System.out.println();
		System.out.println("=============");
		
		Stream<String> stream7 = Arrays.stream(arrString);
		stream7.sorted().forEach(e -> System.out.print(e+" "));
		System.out.println();
		System.out.println("=============");
		Stream<String> stream8 = Arrays.stream(arrString);
		stream8.sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e+" "));
		System.out.println();
		System.out.println("=============");
		
		Stream<String> stream9 = Arrays.stream(arrString);
		stream9.peek(m -> System.out.println("My name is "+m)).allMatch(m ->m.equals("book"));
		
		IntStream stream10 = Arrays.stream(arr);
		stream10.peek(e->System.out.print(e+" ")).allMatch(e->e>=3);
	}

}
