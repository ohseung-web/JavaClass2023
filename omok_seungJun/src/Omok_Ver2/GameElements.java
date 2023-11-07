package Omok_Ver2;
import java.util.*;
public class GameElements {
	Random ran = new Random();
	int check = -1;
	int check2 = -1;
	int type = 0;
	int playerWin = 0; // 플레이어1이 이긴 횟수
	int playerLose = 0; // 플레이어1이 진 횟수
	int cpuWin = 0; // 플레이어2가 이긴 횟수
	int cpuLose = 0; // 플레이어2가 진 횟수
	
	String[][] checkerboard = new String[13][13];
	
	public void setCheckerboard(){
		for(int i=0;i<checkerboard.length;i++) {
			for(int j=0;j<checkerboard[i].length;j++) {
				checkerboard[i][j] = "-";
			}
		}
	}
	
	public void printCheckerboard() {
		System.out.println();
		for(int i=0;i<checkerboard.length;i++) {
			for(int j=0;j<checkerboard[i].length;j++) {
				System.out.print(checkerboard[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void playerPlaceStone(int row, int column) { // 플레이어1이 돌을 놓을 때
		checkerboard[row-1][column-1] = "●";
	}
	
	public void cpuPlaceStone() { // 컴퓨터가 돌을 놓을 때
		if(fourRowCheck()) { // 흑돌이 같은 돌을 4개 늘어놓았을 때 (ex.○●●●●-)
			fourRowPlaceStone();
		}
		else if(threeRowCheck1()) { // 흑돌이 같은 돌을 3개 늘어놓았고 양옆에 백돌이 하나도 없을 때(ex.-●●●-)
			threeRowPlaceStone1();
		}
		else if(threeRowCheck2()) { // 흑돌이 같은 돌을 3개 늘어놓았고 양옆에 백돌이 둘 중 한 곳만 있을 때(ex.○●●●-)
			threeRowPlaceStone2();
		}
		else if(twoRowCheck1()) { // 흑돌이 같은 돌을 2개 늘어놓았고 양여에 백돌이 하나도 없을 때(ex.-●●-)
			twoRowPlaceStone1();
		}
		else if(twoRowCheck2()) { // 흑돌이 같은 돌을 2개 늘어놓았고 양옆에 백돌이 둘 중 한 곳만 있을 때(ex.○●●-)
			twoRowPlaceStone2();
		}
		else if(oneStoneCheck()) { // 흑돌 주변에 돌이 하나도 없을 때
			oneStonePlaceStone();
		}
		else {
			randomPlaceStone();
		}
	}
	
	public boolean fiveRowCheck() { // 흑돌 또는 백돌이 같은 돌을 5개 늘어놓았는지 확인
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( → )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if((checkerboard[i][j].equals("●")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("●")
				&& checkerboard[i][j+4].equals("●"))
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i][j+1].equals("○")
				&& checkerboard[i][j+2].equals("○")
				&& checkerboard[i][j+3].equals("○")
				&& checkerboard[i][j+4].equals("○"))) {
					check = i;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( ↓ )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("●")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("●")
				&& checkerboard[i+4][j].equals("●")
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j].equals("○")
				&& checkerboard[i+2][j].equals("○")
				&& checkerboard[i+3][j].equals("○")
				&& checkerboard[i+4][j].equals("○"))) {
					check = i;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( ↘ )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("●")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("●")
				&& checkerboard[i+4][j+4].equals("●")
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j+1].equals("○")
				&& checkerboard[i+2][j+2].equals("○")
				&& checkerboard[i+3][j+3].equals("○")
				&& checkerboard[i+4][j+4].equals("○"))) {
					check = i;
				}
			}
		}
		
		for(int i=4;i<checkerboard.length;i++) { // ( ↗ )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("●")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("●")
				&& checkerboard[i-4][j+4].equals("●")
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i-1][j+1].equals("○")
				&& checkerboard[i-2][j+2].equals("○")
				&& checkerboard[i-3][j+3].equals("○")
				&& checkerboard[i-4][j+4].equals("○"))) {
					check = i;
				}
			}
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
	
	public boolean fourRowCheck() { // 흑돌이 같은 돌을 4개 늘어놓았는지 확인
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( → )
			for(int j=0;j<checkerboard[i].length-5;j++) {
				if((checkerboard[i][j].equals("○")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("●")
				&& checkerboard[i][j+4].equals("●"))
				&& checkerboard[i][j+5].equals("-")
				||(checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("●")
				&& checkerboard[i][j+4].equals("●")
				&& checkerboard[i][j+5].equals("○"))) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-5;i++) { // ( ↓ )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("●")
				&& checkerboard[i+4][j].equals("●")
				&& checkerboard[i+5][j].equals("-")
				||(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("●")
				&& checkerboard[i+4][j].equals("●")
				&& checkerboard[i+5][j].equals("○"))) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-5;i++) { // ( ↘ )
			for(int j=0;j<checkerboard[i].length-5;j++) {
				if(checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("●")
				&& checkerboard[i+4][j+4].equals("●")
				&& checkerboard[i+5][j+5].equals("-")
				||(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("●")
				&& checkerboard[i+4][j+4].equals("●")
				&& checkerboard[i+5][j+5].equals("○"))) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=5;i<checkerboard.length;i++) { // ( ↗ )
			for(int j=0;j<checkerboard[i].length-5;j++) {
				if(checkerboard[i][j].equals("○")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("●")
				&& checkerboard[i-4][j+4].equals("●")
				&& checkerboard[i-5][j+5].equals("-")
				||(checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("●")
				&& checkerboard[i-4][j+4].equals("●")
				&& checkerboard[i-5][j+5].equals("○"))) {
					check = i;
					check2 = j;
					type = 4;
				}
			}
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
	
	public void fourRowPlaceStone() { // 흑돌(플레이어)이 같은 돌을 4개 늘어놓았을 때 백돌(컴퓨터)이 놓을 자리 정하기
		if(type==1) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+5] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+5][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+5][check2+5] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-5][check2+5] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean threeRowCheck1() { // 흑돌이 같은 돌을 3개 늘어놓았고 양옆에 백돌이 없는 지 확인
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( → )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("●")
				&& checkerboard[i][j+4].equals("-")) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( ↓ )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("●")
				&& checkerboard[i+4][j].equals("-")) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( ↘ )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("●")
				&& checkerboard[i+4][j+4].equals("-")) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=4;i<checkerboard.length;i++) { // ( ↗ )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("●")
				&& checkerboard[i-4][j+4].equals("-")) {
					check = i;
					check2 = j;
					type = 4;
				}
			}
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
	
	public void threeRowPlaceStone1() { // 흑돌(플레이어)이 같은 돌을 3개 늘어놓았을 때 백돌(컴퓨터)이 놓을 자리 정하기 (1)
		int random = ran.nextInt(2);
		if(type==1) {
			if(random==0) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+4] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(random==0) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+4][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(random==0) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+4][check2+4] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(random==0) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-4][check2+4] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean threeRowCheck2() { // 흑돌이 같은 돌을 3개 늘어놓았고 양옆 중 한 곳에만 백돌이 있는 지 확인
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( → )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("●")
				&& checkerboard[i][j+4].equals("○"))
				|| (checkerboard[i][j].equals("○")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("●")
				&& checkerboard[i][j+4].equals("-"))) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( ↓ )
			for(int j=0;j<checkerboard[i].length;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("●")
				&& checkerboard[i+4][j].equals("○"))
				|| (checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("●")
				&& checkerboard[i+4][j].equals("-"))) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( ↘ )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("●")
				&& checkerboard[i+4][j+4].equals("○"))
				|| (checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("●")
				&& checkerboard[i+4][j+4].equals("-"))) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=4;i<checkerboard.length;i++) { // ( ↗ )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("●")
				&& checkerboard[i-4][j+4].equals("-")) {
					check = i;
					check2 = j;
					type = 4;
				}
			}
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
	
	public void threeRowPlaceStone2() { // 흑돌(플레이어)이 같은 돌을 3개 늘어놓았을 때 백돌(컴퓨터)이 놓을 자리 정하기 (2)
		if(type==1) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+4] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+4][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+4][check2+4] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-4][check2+4] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean twoRowCheck1() { // 흑돌이 같은 돌을 2개 늘어놓았고 양옆에 백돌이 없는 지 확인
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( → )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("-")) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-3;i++) { // ( ↓ )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("-")) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-3;i++) { // ( ↘ )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("-")) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=3;i<checkerboard.length;i++) { // ( ↗ )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("-")) {
					check = i;
					check2 = j;
					type = 4;
				}
			}
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
	
	public void twoRowPlaceStone1() { // 흑돌(플레이어)이 같은 돌을 2개 늘어놓았을 때 백돌(컴퓨터)이 놓을 자리 정하기 (1)
		int random = ran.nextInt(2);
		if(type==1) {
			if(random==0) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+3] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(random==0) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+3][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(random==0) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+3][check2+3] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(random==0) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-3][check2+3] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean twoRowCheck2() { // 흑돌이 같은 돌을 2개 늘어놓았고 양옆 중 한 곳에만 백돌이 있는 지 확인
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( → )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("○"))
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("-"))) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-3;i++) { // ( ↓ )
			for(int j=0;j<checkerboard[i].length;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("○"))
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("-"))) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-3;i++) { // ( ↘ )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("○"))
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("-"))) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=3;i<checkerboard.length;i++) { // ( ↗ )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("○"))
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("-"))) {
					check = i;
					check2 = j;
					type = 4;
				}
			}
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
	
	public void twoRowPlaceStone2() { // 흑돌(플레이어)이 같은 돌을 2개 늘어놓았을 때 백돌(컴퓨터)이 놓을 자리 정하기 (2)
		if(type==1) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+3] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+3][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+3][check2+3] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-3][check2+3] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean oneStoneCheck() { // 흑돌 주변에 돌이 하나도 없는지 확인
		check = -1;
		for(int i=0;i<checkerboard.length;i++) {
			for(int j=0;j<checkerboard[i].length;j++) { 
				if((i==0 && j==0) // (왼쪽 위)
				&&(checkerboard[i][j].equals("●")
				&& checkerboard[i][j+1].equals("-")
				&& checkerboard[i+1][j+1].equals("-")
				&& checkerboard[i+1][j].equals("-"))) {
					check = i;
					check2 = j;
					type = 1;
				}
				else if((i==0 && j==checkerboard[i].length-1) // (오른쪽 위)
					&&(checkerboard[i][j].equals("●")
					&& checkerboard[i][j-1].equals("-")
					&& checkerboard[i+1][j-1].equals("-")
					&& checkerboard[i+1][j].equals("-"))) {
						check = i;
						check2 = j;
						type = 2;
					}
				else if((i==checkerboard.length-1 && j==0) // (왼쪽 아래)
					&&(checkerboard[i][j].equals("●")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j+1].equals("-")
					&& checkerboard[i][j+1].equals("-"))) {
						check = i;
						check2 = j;
						type = 3;
					}
				else if((i==checkerboard.length-1 && j==checkerboard[i].length-1) // (오른쪽 아래)
					&&(checkerboard[i][j].equals("●")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j-1].equals("-")
					&& checkerboard[i][j-1].equals("-"))) {
						check = i;
						check2 = j;
						type = 4;
											}
				else if(i==0 && ((j==0)||(j==checkerboard[i].length-1)) // (위쪽 모서리)
					&&(checkerboard[i][j].equals("●")
					&& checkerboard[i][j-1].equals("-")
					&& checkerboard[i+1][j-1].equals("-")
					&& checkerboard[i+1][j].equals("-")
					&& checkerboard[i+1][j+1].equals("-")
					&& checkerboard[i][j+1].equals("-"))) {
						check = i;
						check2 = j;
						type = 5;
						}
				else if(i==checkerboard.length-1 && ((j==0)||(j==checkerboard[i].length-1)) // (아래쪽 모서리)
					&&(checkerboard[i][j].equals("●")
					&& checkerboard[i][j-1].equals("-")
					&& checkerboard[i-1][j-1].equals("-")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j+1].equals("-")
					&& checkerboard[i][j+1].equals("-"))) {
						check = i;
						check2 = j;
						type = 6;
						}
				else if(((i==0)||(i==checkerboard.length-1)) && j==0 // (왼쪽 모서리)
					&&(checkerboard[i][j].equals("●")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j+1].equals("-")
					&& checkerboard[i][j+1].equals("-")
					&& checkerboard[i+1][j+1].equals("-")
					&& checkerboard[i+1][j].equals("-"))) {
						check = i;
						check2 = j;
						type = 7;
						}
				else if(((i==0)||(i==checkerboard.length-1)) && j==checkerboard[i].length-1 // (오른쪽 모서리)
					&&(checkerboard[i][j].equals("●")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j-1].equals("-")
					&& checkerboard[i][j-1].equals("-")
					&& checkerboard[i+1][j-1].equals("-")
					&& checkerboard[i+1][j].equals("-"))) {
						check = i;
						check2 = j;
						type = 8;
						}
				else if(((i>0)&&(i<checkerboard.length-1)) && ((j>0)||(j<checkerboard[i].length-1)) // (가운데)
						&&(checkerboard[i][j].equals("●")
						&& checkerboard[i-1][j-1].equals("-")
						&& checkerboard[i-1][j].equals("-")
						&& checkerboard[i-1][j+1].equals("-")
						&& checkerboard[i][j+1].equals("-")
						&& checkerboard[i+1][j+1].equals("-")
						&& checkerboard[i+1][j].equals("-")
						&& checkerboard[i+1][j-1].equals("-")
						&& checkerboard[i][j-1].equals("-"))) {
							check = i;
							check2 = j;
							type = 9;
							}
			}
			
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
	
	public void oneStonePlaceStone() { // 흑돌(플레이어) 주변에 돌이 하나도 없을 때 백돌(컴퓨터)이 놓을 자리 정하기
		if(type==1) {
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check+1][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check+1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check-1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==4){
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check-1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==4){
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check-1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==5){
			int random = ran.nextInt(5);
			if(random==0) {
				checkerboard[check][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check+1][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check+1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check+1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==6){
			int random = ran.nextInt(5);
			if(random==0) {
				checkerboard[check][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check-1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check-1][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==7){
			int random = ran.nextInt(5);
			if(random==0) {
				checkerboard[check-1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check+1][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==8){
			int random = ran.nextInt(5);
			if(random==0) {
				checkerboard[check-1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check+1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else{
			int random = ran.nextInt(8);
			if(random==0) {
				checkerboard[check-1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check-1][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==4){
				checkerboard[check+1][check2+1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==5){
				checkerboard[check+1][check2] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==6){
				checkerboard[check+1][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else{
				checkerboard[check][check2-1] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public void randomPlaceStone() { // 백돌을 랜덤한 위치에 놓기
		while(true) {
			int row = ran.nextInt(13);
			int column = ran.nextInt(13);
			if(checkerboard[row][column].equals("●") || checkerboard[row][column].equals("○")) {
				continue; // 중복된 위치에 놓았을 때는 반복(예외처리)
			}
			else {
				checkerboard[row][column] = "○";
				printCheckerboard();
				cpuFiveRowCheck();
				break;
			}
		}
	}
	
	public void cpuFiveRowCheck() { // 백돌(컴퓨터)이 같은 돌을 5개 늘어놓았는지 확인
		if(fiveRowCheck()) {
			System.out.println("게임 끝 : 컴퓨터 승리");
			cpuWin++;
			playerLose++;
		}
	}
}
