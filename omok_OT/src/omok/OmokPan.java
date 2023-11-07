package omok;


public class OmokPan {

	int [][] omok = new int [14][14];
	//Random random=new Random();

	

	public void omokpan() {
		// i 가 0인 첫 번째행은 오목을 두지 않고 열번호 1~13까지 출력 
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
				// j가 13인 14번째 열은 오목을 두지 않고 행번호 1~13 출력
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