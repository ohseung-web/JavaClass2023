package classpart07;

public class Return02 {

	public int test(int[] arr) {
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] % 4 == 0) {
				cnt += 1;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
      Return02 re = new Return02();
      int[] arr = {10,13,14,56,70,100};
      System.out.println(re.test(arr));
	}

}
