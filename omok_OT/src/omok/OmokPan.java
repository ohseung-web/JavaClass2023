package omok;


public class OmokPan {

	int [][] omok = new int [14][14];
	//Random random=new Random();

	

	public void omokpan() {
		// i �� 0�� ù ��°���� ������ ���� �ʰ� ����ȣ 1~13���� ��� 
		for(int i =0;i<omok.length;i++) {
			if(i == 0) {
				for(int j=1;j<omok.length;j++) {
					if(j>=1 && j<=5) {
						System.out.print("[ "+j+"]");
					}else {
						System.out.print("["+j+"]");
					}
				}
			}else {
				// j�� 13�� 14��° ���� ������ ���� �ʰ� ���ȣ 1~13 ���
				for(int j=0;j<omok.length;j++) {
					if(j==13) {
						System.out.print("["+i+"]");
					}else {
						System.out.print("[ ]");
					}
				}
			}
			System.out.println();
		}
		/*	
		for(int i =0;i<omok.length;i++) {
			for(int j =0;j<omok.length;j++) {
				omok[0][j] = 1;
			}
					}

		for(int i =0;i<omok.length;i++) {
			for(int j =0;j<omok.length;j++) {
				if(omok[i][j] == 1) {
					System.out.print("[  ]");
				}
			}

			if(omok[i][0] ==1) {
				System.out.println((i+1));
			}
		}

		 */

	}
}		