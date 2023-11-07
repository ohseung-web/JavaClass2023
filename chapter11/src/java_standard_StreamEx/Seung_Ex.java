package java_standard_StreamEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Seung_Ex {

	public static void main(String[] args) {
/*
		Stream<Integer> evenStream = Stream.iterate(1, n->n+2);
		evenStream.limit(5).forEach(i->System.out.print(i+" "));
		
		Stream<Double> randomStream = Stream.generate(()->(Math.random()*5)+1);
		randomStream.limit(5).forEach(i->System.out.print(i+" "));
		
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream.limit(5).forEach(System.out::print);
		
		int[] arr = {7,7,6,5,5,4,3,3,2,1,1};
		String[] strArr = {"java","spring","database","javascript"};
		
		IntStream intStream = Arrays.stream(arr);
		IntStream intStream2 = Arrays.stream(arr);
		IntStream intStream3 = Arrays.stream(arr);
		IntStream intStream4 = Arrays.stream(arr);
		IntStream intStream5 = Arrays.stream(arr);
		
		Stream<String> strStream = Arrays.stream(strArr);
		Stream<String> strStream2 = Arrays.stream(strArr);
		Stream<String> strStream3 = Arrays.stream(strArr);
		Stream<String> strStream4 = Arrays.stream(strArr);
		
// filter, distinct, limit, skip, sorted, sorted(Comparator.comparing), peek
		intStream.filter(i->i>=3).distinct().forEach(i->System.out.println(i));
		System.out.println();
		intStream2.limit(5).forEach(i->System.out.println(i));
		System.out.println();
		intStream3.skip(3).forEach(i->System.out.println(i));
		System.out.println();
		intStream4.sorted().forEach(i->System.out.println(i));
		System.out.println();
//	map, flatmap, 
		strStream.map(s->s.length()).forEach(i->System.out.println(i));
		// String타입인 문자열을 char타입의 문자로 반환한다.
		strStream2.map(s->s.charAt(0)).forEach(i->System.out.print(i+" "));
		System.out.println();
		strStream3.flatMap(s->s.lines()).forEach(i->System.out.print(i));
		System.out.println();
		*/
		Stream<Student> stuStream = Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("인자바",2,100),
				new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("김자바",3,100)
				);

		stuStream.sorted(Comparator.comparing((Student s)->s.getBan())
				.thenComparing(Comparator.naturalOrder()))
		        .forEach(i->System.out.print(i+" "));
		System.out.println();
		
		// 반별 -> 이름별 오름차순 정렬
		List<Student> stuStream2 = Arrays.asList(
				new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("인자바",2,100),
				new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("김자바",3,100)
				);
		
		List<Student> stuSt2 = stuStream2.stream()
	               .sorted(Comparator.comparing((Student s)->s.getBan())
				   .thenComparing(Student::getName)
				   .thenComparing(Student::getTotalScore))
		           .collect(Collectors.toList());
		
		Object[] cc= stuSt2.toArray();
		for(Object s : cc) {System.out.println(s);}
		
		int[] arr = {7,7,6,5,5,4,3,3,2,1,1};
		
		IntStream intStream = Arrays.stream(arr);
		IntStream intStream3 = Arrays.stream(arr);
		IntStream intStream4 = Arrays.stream(arr);
		IntStream intStream5 = Arrays.stream(arr);
		
		intStream
		.peek(i->System.out.print(i+" "))
		.allMatch(i->i>=5);
		
		System.out.println(intStream3.min());
		
		intStream4.filter(i->i>3).peek(i->System.out.print(i+" ")).findFirst();
		OptionalInt result = intStream5.filter(i->i%2==0).findAny();
		System.out.println(result.getAsInt());
		
		String[] strArr = {"java","spring","database","javascript"};
		IntStream intstream = Stream.of(strArr).mapToInt(s->s.length());
		IntStream intstream2 = Stream.of(strArr).mapToInt(s->s.length());
		IntStream intstream3 = Stream.of(strArr).mapToInt(s->s.length());
		IntStream intstream4 = Stream.of(strArr).mapToInt(s->s.length());
		
		int count = intstream.reduce(0, (a,b)->a+1);
		int sum  = intstream2.reduce(0, (a,b)->a+b);
		int max  = intstream3.reduce(1, (a,b)->a>b?a:b);
		int min  = intstream4.reduce(max, (a,b)->a<b?a:b);
		System.out.println("count :"+count);
		System.out.println("sum :"+sum);
		System.out.println("max :"+max);
		System.out.println("min :"+min);
		
		Stream<String> ftmap = Stream.of(strArr);
		ftmap.flatMap(s->s.lines())
		.forEach(i->System.out.print(i));
		
	}

}
