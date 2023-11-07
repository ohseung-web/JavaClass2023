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
		List<Integer> sortedList = list.stream().sorted() //list를 정렬해서 
				                 .collect(Collectors.toList());//새로운 List에 저장
		System.out.println(list); // [3, 1, 5, 4, 2]
		System.out.println(sortedList);//[1, 2, 3, 4, 5]
		
		Stream<Integer> intStream1 = list.stream(); // 컬렉션
		Stream<String> strStream = Stream.of(new String[] {"a","b","c"});//배열
		Stream<Integer> evenStream = Stream.iterate(0, n->n+2); //0,2,4,6,....
		Stream<Double> randomtream = Stream.generate(()->Math.random()*6+1); // 람다식
		IntStream intStream2 = new Random().ints(5); //난수 스트림(크기가:5)
		
		IntStream intStream = new Random().ints(1,46); //1~45범위 무한스트림
		intStream.distinct().limit(6).sorted() // 중간 연산
		         .forEach(i->System.out.print(i+","));//최종 연산
		System.out.println();
		
		IntStream intStream3 = new Random().ints(1,46); //1~45범위 무한스트림
		intStream3.distinct().limit(5).sorted().forEach(i->System.out.println(i));
		
		String[] strArr = {"dd","aaa","cc","CC","b"};
		Stream<String> stream = Stream.of(strArr);//문자열 배열이 소스인 스트림
		//Stream<String> filteredStream = stream.filter();//걸러내기(중간 연산)
		Stream<String> distinctedStream = stream.distinct();//중복제거(중간 연산)
		Stream<String> sortedStream = stream.sorted();//정렬(중간 연산)
		Stream<String> limitedStream = stream.limit(5);//스트림 자르기(중간 연산)
		int total = (int)stream.count();// 요소의 개수 세기(최종연산), cout는 long형이므로 (int)로 형변환 
			
		strStream.forEach(i->System.out.println(i));//모든 요소를 화면에 출력(최종연산)
		Stream<String> strStream2 = Stream.of(new String[] {"a","b","c"});//배열
		int numOfStr = (int)strStream2.count(); //에러, 스트림이 이미 닫혔음
		System.out.println(numOfStr);
		
		Stream<String> strStream3 = Stream.of("dd","aaa","cc","CC","b");
		int sum = strStream.parallel() // 병렬스트릠으로 변환(속성만 변경)
				           .mapToInt(s -> s.length()).sum(); //모든 문자열의 길이의 합
		
		
		
		
//		복붙을 원하는 라인에 커서를 두거나 블록을 지정하고
//		<ctrl + alt + ↑> 또는 <ctrl + alt + ↓>를 누르는 것입니다.
		
				
		
	}

}
