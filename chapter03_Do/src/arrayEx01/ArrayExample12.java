package arrayEx01;

public class ArrayExample12 {

	public static void main(String[] args) {

		// ��������, ��������
		   int[] arr = {90,23,67,100,34};
		   int[] temp = new int[5];
		   
		   for(int i=0; i< arr.length; i++) {
			   for(int j=i; j<arr.length; j++) {
				   if(arr[i]>arr[j]) {
					   temp[i] = arr[i];
					   arr[i] =arr[j];
					   arr[j] = temp[i];
				   }
			   }
			   System.out.print(arr[i]+" ");
		   }
		   
		  
	}

}
