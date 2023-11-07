package streamEx02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// �ν��Ͻ�
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


		// ������ Ǯ������ stream.of�� ���� �����ؾ� �Ѵ�.
		//        Stream<Transaction> transactions = Stream.of(
		//        		new Transaction(brian, 2011, 300),
		//        		new Transaction(raoul, 2012, 1000),
		//        		new Transaction(raoul, 2011, 400),
		//        		new Transaction(mario, 2012, 710),
		//        		new Transaction(mario, 2012, 700),
		//        		new Transaction(alan, 2012, 950)
		//        		);

		// ������ Ǯ�� List<Transaction> tran = transactions.stream() : stream������ ���ٷ� ������. 


		//        ArrayList<Transaction> transactions = new ArrayList<>();
		//        Collections.addAll(transactions, 
		//            new Transaction(brian, 2011, 300),
		//       		new Transaction(raoul, 2012, 1000),
		//       		new Transaction(raoul, 2011, 400),
		//       		new Transaction(mario, 2012, 710),
		//       		new Transaction(mario, 2012, 700),
		//       		new Transaction(alan, 2012, 950)
		//       		); 



		/* <����>
		 * 2011�⿡ �Ͼ ��� Ʈ������� ã�� ���� ������������ �����Ͻÿ�.
           �ŷ��ڰ� �ٹ��ϴ� ��� ���ø� �ߺ����� �����Ͻÿ�
           ���Ӻ긮������ �ٹ��ϴ� ��� �ŷ��ڸ� ã�Ƽ� �̸������� �����Ͻÿ�
           ��� �ŷ����� �̸��� ���ĺ������� �����ؼ� ��ȯ�Ͻÿ�
           �ж�뿡 �ŷ��ڰ� �ִ°�?
           ���Ӻ긮���� �����ϴ� �ŷ����� ��� Ʈ����ǰ��� ����Ͻÿ�
           ��ü Ʈ����� �� �ִ��� ���ΰ�?
           ��ü Ʈ����� �� �ּڰ��� ���ΰ�?
		 * 
		 */
		//<����1> 2011�⿡ �Ͼ ��� Ʈ������� ã�� ���� ������������ �����Ͻÿ�.
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


		//<����2> �ŷ��ڰ� �ٹ��ϴ� ��� ���ø� �ߺ����� �����Ͻÿ�
		List<String> cityStream = transactions.stream()
				// .map(Trader::getName) �̰�� Transaction ������ �������� getName�� ���� ���� �ʴ´ٴ� ������ �߻��Ѵ�.
				// �׷��Ƿ� map(Transaction::getTrader) ���� mapping�� �ؾ� �Ѵ�.
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

		//<����3> ���Ӻ긮������ �ٹ��ϴ� ��� �ŷ��ڸ� ã�Ƽ� �̸������� �����Ͻÿ�
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

		// [4]  ��� �ŷ����� �̸��� ���ĺ������� �����ؼ� ��ȯ �Ͻÿ�
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


		//[5] �ж�뿡 �ŷ��ڰ� �ִ°�?
		boolean transaction5 = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(transaction5);

		// [6] ���Ӻ긮���� �����ϴ� �ŷ����� ��� Ʈ����ǰ��� ��� �Ͻÿ�
		List<Integer> transaction6 = transactions.stream()
				.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue)
				.collect(Collectors.toList());
		System.out.println(transaction6);

		// [7] ��ü Ʈ����� �� �ִ밪�� ���ΰ�?
		Integer transaction7 = transactions.stream()
				.map((Transaction t)->t.getValue())
				.reduce(0,(a,b)-> a>b?a:b);
		//		.reduce(Integer::max);
		System.out.println("�ִ밪 :"+transaction7);
//		if(transaction7.isPresent()){
//			System.out.println(transaction7.get());
//		}
		
		// [8] ��ü Ʈ����� �� �ּҰ��� ���ΰ�?
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
		System.out.println("�ּҰ� :"+transaction9);
	}

}
