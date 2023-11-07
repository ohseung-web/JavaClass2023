package arrayEx01;

import java.util.Arrays;

public class ArrayTest03 {

	public static void main(String[] args) {
		int[] arrAtt1 = {10,20,30,40,50};
		int[] arrAtt2 = null;
		int[] arrAtt3 = null;
		
		// 배열의 길이 출력
		     System.out.println("arrrAtt1.length :"+arrAtt1.length);
		 
		// 배열의 요소 출력
		    System.out.println("배열의 요소 :"+ Arrays.toString(arrAtt1));
		
		// 배열의 복사
		// Arrays.copyOf(원본배열, 원본배열에서 복사하고 싶은 요소들의 길이)    
		    arrAtt3 = Arrays.copyOf(arrAtt1, arrAtt1.length);
		    System.out.println("복사된 arrAtt3 :"+Arrays.toString(arrAtt3));
		    
		// 배열 레퍼런스
		    arrAtt2 = arrAtt1;
		    System.out.println("arrAtt1 :"+ arrAtt1);
		    System.out.println("arrAtt2 :"+ arrAtt2);
		    System.out.println("arrAtt3 :"+ arrAtt3);
	}

}
