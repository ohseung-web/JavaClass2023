package seungJun_StreamEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// 인스턴스
				Trader raoul = new Trader("Raoul","Cambridge");
				Trader mario = new Trader("Mario","Milan");
				Trader alan = new Trader("Alan","Cambridge");
				Trader brian = new Trader("Brian","Cambridge");
				
				List<Transaction> transactions = Arrays.asList(
						new Transaction(brian, 2011, 300),
						new Transaction(raoul, 2012, 1000),
						new Transaction(raoul, 2011, 400),
						new Transaction(mario, 2012, 710),
						new Transaction(mario, 2012, 700),
						new Transaction(alan, 2012, 950)
						);
				
				
				
				// [1] 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리 하시오
				List<Transaction> trans = transactions.stream() // 스트림 생성
										  .filter((Transaction t) -> t.getYear()==2011)
										  .sorted(Comparator.comparing((Transaction t) -> t.getValue()))
										  .collect(Collectors.toList());
				System.out.println("1번 정답");
				Object[] obj = trans.toArray();
				for(Object o : obj) {
					System.out.println(o);
				}
				System.out.println();
				
				
				// [2] 거래자가 근무하는 모든 도시를 중복없이 나열 하시오
				// map을 이용해서 작성할 것
				List<String> cities = transactions.stream()
						.map((Transaction t) -> t.getTrader().getCity())
						.distinct()
						.collect(Collectors.toList());
				System.out.println("2번 정답");		
				obj = cities.toArray();
				for(Object o : obj) {
					System.out.println(o);
				}
				System.out.println();
				
				// [3] 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 중복없이 정렬 하시오
				List<Trader> cambridgeTraders = transactions.stream()
												.map((Transaction t) -> t.getTrader())
												.filter((Trader t) -> t.getCity().equals("Cambridge"))
												.distinct()
												.sorted(Comparator.comparing((Trader t) -> t.getName()))
												.collect(Collectors.toList());
				System.out.println("3번 정답");
				obj = cambridgeTraders.toArray();
				for(Object o : obj) {
					System.out.println(o);
				}
				System.out.println();
				
				// [4] 모든 거래자의 이름을 알파벳순으로 정리해서 반환 하시오
				List<String> allTradersName = transactions.stream()
											  .map((Transaction t) -> t.getTrader())
											  .distinct()
											  .sorted(Comparator.comparing((Trader t) -> t.getName()))
											  .map((Trader t) -> t.getName())
											  .collect(Collectors.toList());
				
				System.out.println("4번 정답"); 
				obj = allTradersName.toArray();
				for(Object o : obj) {
					System.out.println(o);
				}
				System.out.println();
				
				// [5] 밀라노에 거래자가 있는가?
				boolean milanTraderCheck = transactions.stream() // 스트림 생성
						  	.anyMatch((Transaction t) -> t.getTrader().getCity().equals("Milan"));
				System.out.println("5번 정답");
				System.out.println(milanTraderCheck);
				System.out.println();
				
				// [6] 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력 하시오
				List<Transaction> cambridgeTrans = transactions.stream() // 스트림 생성
						  						   .filter((Transaction t) -> t.getTrader().getCity().equals("Cambridge"))
						  						   .collect(Collectors.toList());
				System.out.println("6번 정답");
				Object[] camTransObj = cambridgeTrans.toArray();
				for(Object o : camTransObj) {
					System.out.println(o);
				}
		
		// 추가숙제
				// [7] 전체 트랜잭션 중 최대값은 얼마인가?
				List<Integer> transValues = transactions.stream()
											.map((Transaction t) -> t.getValue())
											.collect(Collectors.toList());
				
				
//			    Optional<Integer> maxValue = transValues.stream()
//				  	      .mapToInt(s -> s)
//				  	      .max();
				System.out.println("7번 정답");
			    OptionalInt maxValue = transValues.stream()
										  	      .mapToInt(s -> s)
										  	      .max(); // getAsInt()가 안 먹힌다.
			    System.out.println(maxValue.getAsInt()); // getAsInt()는 출력할 때 사용한다.
				System.out.println();
				// [8] 전체 트랜잭션 중 최소값은 얼마인가?
				transValues = transactions.stream()
							  .map((Transaction t) -> t.getValue())
							  .collect(Collectors.toList());

				System.out.println("8번 정답");
				OptionalInt minValue = transValues.stream()
												  .mapToInt(s -> s)
												  .min(); // getAsInt()가 안 먹힌다.
				System.out.println(minValue.getAsInt());
				System.out.println();
				
				
				
	}

}
