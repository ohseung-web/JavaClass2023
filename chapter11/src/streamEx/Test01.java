package streamEx;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test01 {

	public static void main(String[] args) {

		int[] arr = {5,7,1,9,10};
        
		// �⺻�� ��Ʈ��(IntStream, LongStream, DoubleStream)
		IntStream stream = Arrays.stream(arr);//Stream ����
		
		int sum = Arrays.stream(arr).sum();
		int count =(int)Arrays.stream(arr).count();
		
		System.out.println(sum);
		System.out.println(count);
		
	}

}
