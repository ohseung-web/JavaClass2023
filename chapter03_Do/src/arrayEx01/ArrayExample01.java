package arrayEx01;

public class ArrayExample01 {

	public static void main(String[] args) {
		int[]  arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i] =10*(i+1);
			System.out.print(arr[i]+" ");
		}

		System.out.println();
		// 4�� ����� ���
		System.out.println("-- 4�� ��� ��� --");

		for(int i=0;i<arr.length;i++) {
			arr[i] =10*(i+1);
			if(arr[i] % 4 == 0) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		// 4�� ����� ��
		System.out.println("-- 4�� ��� �� --");
		int total = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] =10*(i+1);
			if(arr[i] % 4 == 0) {
				total += arr[i];
			}
		}
		System.out.print("total :"+ total);
		
		System.out.println();
		// 4�� ����� ����
		System.out.println("-- 4�� ��� ���� --");
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] =10*(i+1);
			if(arr[i] % 4 == 0) {
				cnt ++;
			}
		}
		System.out.print("cnt :"+ cnt);
		
		System.out.println();
		// ¦���� ����
		System.out.println("-- ¦���� ���� --");
		int evencnt = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] =10*(i+1);
			if(arr[i] % 2 == 0) {
				evencnt ++;
			}
		}
		System.out.print("cnt :"+ evencnt);
		
	}

}
