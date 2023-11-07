package seungJun_StreamEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// �ν��Ͻ�
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
				
				
				
				// [1] 2011�⿡ �Ͼ ��� Ʈ������� ã�� ���� ������������ ���� �Ͻÿ�
				List<Transaction> trans = transactions.stream() // ��Ʈ�� ����
										  .filter((Transaction t) -> t.getYear()==2011)
										  .sorted(Comparator.comparing((Transaction t) -> t.getValue()))
										  .collect(Collectors.toList());
				System.out.println("1�� ����");
				Object[] obj = trans.toArray();
				for(Object o : obj) {
					System.out.println(o);
				}
				System.out.println();
				
				
				// [2] �ŷ��ڰ� �ٹ��ϴ� ��� ���ø� �ߺ����� ���� �Ͻÿ�
				// map�� �̿��ؼ� �ۼ��� ��
				List<String> cities = transactions.stream()
						.map((Transaction t) -> t.getTrader().getCity())
						.distinct()
						.collect(Collectors.toList());
				System.out.println("2�� ����");		
				obj = cities.toArray();
				for(Object o : obj) {
					System.out.println(o);
				}
				System.out.println();
				
				// [3] ���Ӻ긮������ �ٹ��ϴ� ��� �ŷ��ڸ� ã�Ƽ� �̸������� �ߺ����� ���� �Ͻÿ�
				List<Trader> cambridgeTraders = transactions.stream()
												.map((Transaction t) -> t.getTrader())
												.filter((Trader t) -> t.getCity().equals("Cambridge"))
												.distinct()
												.sorted(Comparator.comparing((Trader t) -> t.getName()))
												.collect(Collectors.toList());
				System.out.println("3�� ����");
				obj = cambridgeTraders.toArray();
				for(Object o : obj) {
					System.out.println(o);
				}
				System.out.println();
				
				// [4] ��� �ŷ����� �̸��� ���ĺ������� �����ؼ� ��ȯ �Ͻÿ�
				List<String> allTradersName = transactions.stream()
											  .map((Transaction t) -> t.getTrader())
											  .distinct()
											  .sorted(Comparator.comparing((Trader t) -> t.getName()))
											  .map((Trader t) -> t.getName())
											  .collect(Collectors.toList());
				
				System.out.println("4�� ����"); 
				obj = allTradersName.toArray();
				for(Object o : obj) {
					System.out.println(o);
				}
				System.out.println();
				
				// [5] �ж�뿡 �ŷ��ڰ� �ִ°�?
				boolean milanTraderCheck = transactions.stream() // ��Ʈ�� ����
						  	.anyMatch((Transaction t) -> t.getTrader().getCity().equals("Milan"));
				System.out.println("5�� ����");
				System.out.println(milanTraderCheck);
				System.out.println();
				
				// [6] ���Ӻ긮���� �����ϴ� �ŷ����� ��� Ʈ����ǰ��� ��� �Ͻÿ�
				List<Transaction> cambridgeTrans = transactions.stream() // ��Ʈ�� ����
						  						   .filter((Transaction t) -> t.getTrader().getCity().equals("Cambridge"))
						  						   .collect(Collectors.toList());
				System.out.println("6�� ����");
				Object[] camTransObj = cambridgeTrans.toArray();
				for(Object o : camTransObj) {
					System.out.println(o);
				}
		
		// �߰�����
				// [7] ��ü Ʈ����� �� �ִ밪�� ���ΰ�?
				List<Integer> transValues = transactions.stream()
											.map((Transaction t) -> t.getValue())
											.collect(Collectors.toList());
				
				
//			    Optional<Integer> maxValue = transValues.stream()
//				  	      .mapToInt(s -> s)
//				  	      .max();
				System.out.println("7�� ����");
			    OptionalInt maxValue = transValues.stream()
										  	      .mapToInt(s -> s)
										  	      .max(); // getAsInt()�� �� ������.
			    System.out.println(maxValue.getAsInt()); // getAsInt()�� ����� �� ����Ѵ�.
				System.out.println();
				// [8] ��ü Ʈ����� �� �ּҰ��� ���ΰ�?
				transValues = transactions.stream()
							  .map((Transaction t) -> t.getValue())
							  .collect(Collectors.toList());

				System.out.println("8�� ����");
				OptionalInt minValue = transValues.stream()
												  .mapToInt(s -> s)
												  .min(); // getAsInt()�� �� ������.
				System.out.println(minValue.getAsInt());
				System.out.println();
				
				
				
	}

}
