package streamEx02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// 인스턴스
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);


		// 문제를 풀때마다 stream.of를 새로 생성해야 한다.
		//        Stream<Transaction> transactions = Stream.of(
		//        		new Transaction(brian, 2011, 300),
		//        		new Transaction(raoul, 2012, 1000),
		//        		new Transaction(raoul, 2011, 400),
		//        		new Transaction(mario, 2012, 710),
		//        		new Transaction(mario, 2012, 700),
		//        		new Transaction(alan, 2012, 950)
		//        		);

		// 문제를 풀때 List<Transaction> tran = transactions.stream() : stream생성이 한줄로 끝난다. 


		//        ArrayList<Transaction> transactions = new ArrayList<>();
		//        Collections.addAll(transactions, 
		//            new Transaction(brian, 2011, 300),
		//       		new Transaction(raoul, 2012, 1000),
		//       		new Transaction(raoul, 2011, 400),
		//       		new Transaction(mario, 2012, 710),
		//       		new Transaction(mario, 2012, 700),
		//       		new Transaction(alan, 2012, 950)
		//       		); 



		/* <문제>
		 * 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
           거래자가 근무하는 모든 도시를 중복없이 나열하시오
           케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
           모든 거래자의 이름을 알파벳순으로 정리해서 반환하시오
           밀라노에 거래자가 있는가?
           케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오
           전체 트랜잭션 중 최댓값은 얼마인가?
           전체 트랜잭션 중 최솟값은 얼마인가?
		 * 
		 */
		//<문제1> 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
		List<Transaction> tran = transactions.stream()
				.filter(y->y.getYear()==2011)
				.sorted(Comparator.comparing((Transaction t)->t.getValue()))
				.collect(Collectors.toList());
		//         List<Transaction> tran2 = transactions.filter(y->y.getYear()==2011)
		//                    .sorted(Comparator.comparing((Transaction t)->t.getValue()))
		//                    .collect(Collectors.toList());
		Object[] obj = tran.toArray();
		for(Object serach : obj) {
			System.out.println(serach);
		}
		// System.out.println(tran);
		System.out.println();

		//         List<Transaction> tran1 = transactions.stream()
		//        		     .filter(Transaction->Transaction.getYear()==2011)
		//                     .sorted(Comparator.comparing((Transaction t)->t.getValue()))
		//                     .collect(Collectors.toList());


		//<문제2> 거래자가 근무하는 모든 도시를 중복없이 나열하시오
		List<String> cityStream = transactions.stream()
				// .map(Trader::getName) 이경우 Transaction 데이터 유형에는 getName이 존재 하지 않는다는 오류가 발생한다.
				// 그러므로 map(Transaction::getTrader) 먼저 mapping를 해야 한다.
				.map((Transaction t)->t.getTrader().getCity())
				//.map((Trader c)->c.getCity())
				.distinct()
				.collect(Collectors.toList()); 
		//         List<String> cityStream2 = transaction2
		//        		                     .map((Transaction t)->t.getTrader())
		//        		                     .map((Trader c)->c.getCity())
		//        		                     .distinct()
		//        		                     .collect(Collectors.toList());
		System.out.println(cityStream);

		//<문제3> 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
		List<Trader> nameStream = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.map((Transaction t)->t.getTrader())
				.sorted(Comparator.comparing((Trader n)->n.getName()))
				.distinct()
				.collect(Collectors.toList());
		//         List<Trader> nameStream2 = transaction3
		//        		                   .filter(t -> t.getTrader().getCity().endsWith("Cambridge"))
		//        		                   .map((Transaction t)->t.getTrader())
		//        		                   .sorted(Comparator.comparing((Trader n)->n.getName()))
		//        		                   .distinct()
		//        		                   .collect(Collectors.toList());
		System.out.println(nameStream);

		// [4]  모든 거래자의 이름을 알파벳순으로 정리해서 반환 하시오
		ArrayList<String> trans4 = transactions.stream()
				.map((Transaction t)->t.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(trans4);
		
		for(int i=0;i<trans4.size();i++) {
			System.out.println("Trader Name :"+ trans4.get(i)+" ");
		}
		
		
	//	Object[] aa = trans4.toArray();
	//	for(Object ob : aa) {
	//		System.out.println(ob);
	//	}
				
		String transcation4 = transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.peek(i->System.out.print(i+" "))
				.reduce("", (a,b)->a+b);
		
		//System.out.println(transcation4);


		//[5] 밀라노에 거래자가 있는가?
		boolean transaction5 = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(transaction5);

		// [6] 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력 하시오
		List<Integer> transaction6 = transactions.stream()
				.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue)
				.collect(Collectors.toList());
		System.out.println(transaction6);

		// [7] 전체 트랜잭션 중 최대값은 얼마인가?
		Integer transaction7 = transactions.stream()
				.map((Transaction t)->t.getValue())
				.reduce(0,(a,b)-> a>b?a:b);
		//		.reduce(Integer::max);
		System.out.println("최대값 :"+transaction7);
//		if(transaction7.isPresent()){
//			System.out.println(transaction7.get());
//		}
		
		// [8] 전체 트랜잭션 중 최소값은 얼마인가?
		Optional<Integer> transaction8 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        if(transaction8.isPresent()){
            System.out.println(transaction8.get());
        }
		

        Integer transaction9 = transactions.stream()
				.map(Transaction::getValue)
				.reduce(transaction7,(a,b)-> a<b?a:b);
		//		.reduce(Integer::max);
		System.out.println("최소값 :"+transaction9);
	}

}
