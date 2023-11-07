package omokgame;

import java.util.*;

public class Omokpan extends Log{

	Scanner scan =new Scanner(System.in);
	int [][] omok = new int [13][13];
	Random random=new Random();

	
	public void omokpan() {
		System.out.println("[ 1][ 2 ][ 3][4 ][5 ][6 ][7 ][8 ][9 ][10][11][12][13]");
		for(int i =0;i<omok.length;i++) {
			for(int j =0;j<omok.length;j++) {

				omok[i][j] = 1;

			}
		}

		for(int i =0;i<omok.length;i++) {
			for(int j =0;j<omok.length;j++) {
				if(omok[i][j] == 1) {
					System.out.print("[  ]");
				}
			}

			if(omok[i][0] ==1) {
				System.out.println("["+(i+1)+"]");
			}
		}

	}
}
