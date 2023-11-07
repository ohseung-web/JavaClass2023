package seung_Ex;

import java.util.Arrays;
import java.util.Comparator;

@FunctionalInterface
interface lambdaArr{
	public int sumArr(int[] arr);
}

public class lambdaEx02 {

	public int sumArr (int[] arr){
		int sum = 0;
		for (int i: arr){
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {

		int[] arr = new int[5];


		/*for(int i=0; i < arr.length; i++){
            arr[i] = getRandomNumber(i);
        }*/

//		for(int i=0; i<arr.length; i++) {
//			arr[i] = (int)(Math.random()*5)+1;
//		}
		
		//위의 내용을 아래의 한줄로 간단하게 표현할 수 있다.
		//Arrays.setAll(arr, i -> (int)(Math.random()*5) + 1);
        Arrays.asList(arr, 1,2,3,4,5); // 직접 수를 입력
        Arrays.setAll(arr, i -> (int)(Math.random()*5) + 1);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
                
		for(int i=0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		System.out.print("int[] arr 의 sum :");
		lambdaArr cc = arr1 -> {int sum=0; for(int i: arr1) sum += i; return sum;};
		System.out.println(cc.sumArr(arr));
	}
	  
	    
	public static int getRandomNumber(int i){
		return (int) (Math.random()*5) + 1;
	}

    
	
}


