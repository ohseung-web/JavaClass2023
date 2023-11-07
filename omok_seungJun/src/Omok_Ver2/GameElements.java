package Omok_Ver2;
import java.util.*;
public class GameElements {
	Random ran = new Random();
	int check = -1;
	int check2 = -1;
	int type = 0;
	int playerWin = 0; // �÷��̾�1�� �̱� Ƚ��
	int playerLose = 0; // �÷��̾�1�� �� Ƚ��
	int cpuWin = 0; // �÷��̾�2�� �̱� Ƚ��
	int cpuLose = 0; // �÷��̾�2�� �� Ƚ��
	
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
	
	public void playerPlaceStone(int row, int column) { // �÷��̾�1�� ���� ���� ��
		checkerboard[row-1][column-1] = "��";
	}
	
	public void cpuPlaceStone() { // ��ǻ�Ͱ� ���� ���� ��
		if(fourRowCheck()) { // �浹�� ���� ���� 4�� �þ������ �� (ex.�ۡܡܡܡ�-)
			fourRowPlaceStone();
		}
		else if(threeRowCheck1()) { // �浹�� ���� ���� 3�� �þ���Ұ� �翷�� �鵹�� �ϳ��� ���� ��(ex.-�ܡܡ�-)
			threeRowPlaceStone1();
		}
		else if(threeRowCheck2()) { // �浹�� ���� ���� 3�� �þ���Ұ� �翷�� �鵹�� �� �� �� ���� ���� ��(ex.�ۡܡܡ�-)
			threeRowPlaceStone2();
		}
		else if(twoRowCheck1()) { // �浹�� ���� ���� 2�� �þ���Ұ� �翩�� �鵹�� �ϳ��� ���� ��(ex.-�ܡ�-)
			twoRowPlaceStone1();
		}
		else if(twoRowCheck2()) { // �浹�� ���� ���� 2�� �þ���Ұ� �翷�� �鵹�� �� �� �� ���� ���� ��(ex.�ۡܡ�-)
			twoRowPlaceStone2();
		}
		else if(oneStoneCheck()) { // �浹 �ֺ��� ���� �ϳ��� ���� ��
			oneStonePlaceStone();
		}
		else {
			randomPlaceStone();
		}
	}
	
	public boolean fiveRowCheck() { // �浹 �Ǵ� �鵹�� ���� ���� 5�� �þ���Ҵ��� Ȯ��
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if((checkerboard[i][j].equals("��")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("��")
				&& checkerboard[i][j+4].equals("��"))
				||(checkerboard[i][j].equals("��")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("��")
				&& checkerboard[i][j+4].equals("��"))) {
					check = i;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("��")
				&& checkerboard[i+4][j].equals("��")
				||(checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("��")
				&& checkerboard[i+4][j].equals("��"))) {
					check = i;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("��")
				&& checkerboard[i+4][j+4].equals("��")
				||(checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("��")
				&& checkerboard[i+4][j+4].equals("��"))) {
					check = i;
				}
			}
		}
		
		for(int i=4;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("��")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
				&& checkerboard[i-3][j+3].equals("��")
				&& checkerboard[i-4][j+4].equals("��")
				||(checkerboard[i][j].equals("��")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
				&& checkerboard[i-3][j+3].equals("��")
				&& checkerboard[i-4][j+4].equals("��"))) {
					check = i;
				}
			}
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
	
	public boolean fourRowCheck() { // �浹�� ���� ���� 4�� �þ���Ҵ��� Ȯ��
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-5;j++) {
				if((checkerboard[i][j].equals("��")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("��")
				&& checkerboard[i][j+4].equals("��"))
				&& checkerboard[i][j+5].equals("-")
				||(checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("��")
				&& checkerboard[i][j+4].equals("��")
				&& checkerboard[i][j+5].equals("��"))) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-5;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("��")
				&& checkerboard[i+4][j].equals("��")
				&& checkerboard[i+5][j].equals("-")
				||(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("��")
				&& checkerboard[i+4][j].equals("��")
				&& checkerboard[i+5][j].equals("��"))) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-5;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-5;j++) {
				if(checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("��")
				&& checkerboard[i+4][j+4].equals("��")
				&& checkerboard[i+5][j+5].equals("-")
				||(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("��")
				&& checkerboard[i+4][j+4].equals("��")
				&& checkerboard[i+5][j+5].equals("��"))) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=5;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-5;j++) {
				if(checkerboard[i][j].equals("��")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
				&& checkerboard[i-3][j+3].equals("��")
				&& checkerboard[i-4][j+4].equals("��")
				&& checkerboard[i-5][j+5].equals("-")
				||(checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
				&& checkerboard[i-3][j+3].equals("��")
				&& checkerboard[i-4][j+4].equals("��")
				&& checkerboard[i-5][j+5].equals("��"))) {
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
	
	public void fourRowPlaceStone() { // �浹(�÷��̾�)�� ���� ���� 4�� �þ������ �� �鵹(��ǻ��)�� ���� �ڸ� ���ϱ�
		if(type==1) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+5] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+5][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+5][check2+5] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-5][check2+5] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean threeRowCheck1() { // �浹�� ���� ���� 3�� �þ���Ұ� �翷�� �鵹�� ���� �� Ȯ��
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("��")
				&& checkerboard[i][j+4].equals("-")) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("��")
				&& checkerboard[i+4][j].equals("-")) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("��")
				&& checkerboard[i+4][j+4].equals("-")) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=4;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
				&& checkerboard[i-3][j+3].equals("��")
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
	
	public void threeRowPlaceStone1() { // �浹(�÷��̾�)�� ���� ���� 3�� �þ������ �� �鵹(��ǻ��)�� ���� �ڸ� ���ϱ� (1)
		int random = ran.nextInt(2);
		if(type==1) {
			if(random==0) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+4] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(random==0) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+4][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(random==0) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+4][check2+4] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(random==0) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-4][check2+4] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean threeRowCheck2() { // �浹�� ���� ���� 3�� �þ���Ұ� �翷 �� �� ������ �鵹�� �ִ� �� Ȯ��
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("��")
				&& checkerboard[i][j+4].equals("��"))
				|| (checkerboard[i][j].equals("��")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("��")
				&& checkerboard[i][j+4].equals("-"))) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("��")
				&& checkerboard[i+4][j].equals("��"))
				|| (checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("��")
				&& checkerboard[i+4][j].equals("-"))) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("��")
				&& checkerboard[i+4][j+4].equals("��"))
				|| (checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("��")
				&& checkerboard[i+4][j+4].equals("-"))) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=4;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
				&& checkerboard[i-3][j+3].equals("��")
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
	
	public void threeRowPlaceStone2() { // �浹(�÷��̾�)�� ���� ���� 3�� �þ������ �� �鵹(��ǻ��)�� ���� �ڸ� ���ϱ� (2)
		if(type==1) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+4] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+4][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+4][check2+4] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-4][check2+4] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean twoRowCheck1() { // �浹�� ���� ���� 2�� �þ���Ұ� �翷�� �鵹�� ���� �� Ȯ��
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("-")) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-3;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("-")) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-3;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("-")) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=3;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if(checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
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
	
	public void twoRowPlaceStone1() { // �浹(�÷��̾�)�� ���� ���� 2�� �þ������ �� �鵹(��ǻ��)�� ���� �ڸ� ���ϱ� (1)
		int random = ran.nextInt(2);
		if(type==1) {
			if(random==0) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+3] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(random==0) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+3][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(random==0) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+3][check2+3] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(random==0) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-3][check2+3] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean twoRowCheck2() { // �浹�� ���� ���� 2�� �þ���Ұ� �翷 �� �� ������ �鵹�� �ִ� �� Ȯ��
		check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("��"))
				||(checkerboard[i][j].equals("��")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("-"))) {
					check = i;
					check2 = j;
					type = 1;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-3;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j].equals("��")
				&& checkerboard[i+2][j].equals("��")
				&& checkerboard[i+3][j].equals("��"))
				||(checkerboard[i][j].equals("��")
				&& checkerboard[i][j+1].equals("��")
				&& checkerboard[i][j+2].equals("��")
				&& checkerboard[i][j+3].equals("-"))) {
					check = i;
					check2 = j;
					type = 2;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-3;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("��"))
				||(checkerboard[i][j].equals("��")
				&& checkerboard[i+1][j+1].equals("��")
				&& checkerboard[i+2][j+2].equals("��")
				&& checkerboard[i+3][j+3].equals("-"))) {
					check = i;
					check2 = j;
					type = 3;
				}
			}
		}
		
		for(int i=3;i<checkerboard.length;i++) { // ( �� )
			for(int j=0;j<checkerboard[i].length-3;j++) {
				if((checkerboard[i][j].equals("-")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
				&& checkerboard[i-3][j+3].equals("��"))
				||(checkerboard[i][j].equals("��")
				&& checkerboard[i-1][j+1].equals("��")
				&& checkerboard[i-2][j+2].equals("��")
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
	
	public void twoRowPlaceStone2() { // �浹(�÷��̾�)�� ���� ���� 2�� �þ������ �� �鵹(��ǻ��)�� ���� �ڸ� ���ϱ� (2)
		if(type==1) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+3] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+3][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+3][check2+3] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else {
			if(checkerboard[check][check2].equals("-")) {
				checkerboard[check][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check-3][check2+3] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public boolean oneStoneCheck() { // �浹 �ֺ��� ���� �ϳ��� ������ Ȯ��
		check = -1;
		for(int i=0;i<checkerboard.length;i++) {
			for(int j=0;j<checkerboard[i].length;j++) { 
				if((i==0 && j==0) // (���� ��)
				&&(checkerboard[i][j].equals("��")
				&& checkerboard[i][j+1].equals("-")
				&& checkerboard[i+1][j+1].equals("-")
				&& checkerboard[i+1][j].equals("-"))) {
					check = i;
					check2 = j;
					type = 1;
				}
				else if((i==0 && j==checkerboard[i].length-1) // (������ ��)
					&&(checkerboard[i][j].equals("��")
					&& checkerboard[i][j-1].equals("-")
					&& checkerboard[i+1][j-1].equals("-")
					&& checkerboard[i+1][j].equals("-"))) {
						check = i;
						check2 = j;
						type = 2;
					}
				else if((i==checkerboard.length-1 && j==0) // (���� �Ʒ�)
					&&(checkerboard[i][j].equals("��")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j+1].equals("-")
					&& checkerboard[i][j+1].equals("-"))) {
						check = i;
						check2 = j;
						type = 3;
					}
				else if((i==checkerboard.length-1 && j==checkerboard[i].length-1) // (������ �Ʒ�)
					&&(checkerboard[i][j].equals("��")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j-1].equals("-")
					&& checkerboard[i][j-1].equals("-"))) {
						check = i;
						check2 = j;
						type = 4;
											}
				else if(i==0 && ((j==0)||(j==checkerboard[i].length-1)) // (���� �𼭸�)
					&&(checkerboard[i][j].equals("��")
					&& checkerboard[i][j-1].equals("-")
					&& checkerboard[i+1][j-1].equals("-")
					&& checkerboard[i+1][j].equals("-")
					&& checkerboard[i+1][j+1].equals("-")
					&& checkerboard[i][j+1].equals("-"))) {
						check = i;
						check2 = j;
						type = 5;
						}
				else if(i==checkerboard.length-1 && ((j==0)||(j==checkerboard[i].length-1)) // (�Ʒ��� �𼭸�)
					&&(checkerboard[i][j].equals("��")
					&& checkerboard[i][j-1].equals("-")
					&& checkerboard[i-1][j-1].equals("-")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j+1].equals("-")
					&& checkerboard[i][j+1].equals("-"))) {
						check = i;
						check2 = j;
						type = 6;
						}
				else if(((i==0)||(i==checkerboard.length-1)) && j==0 // (���� �𼭸�)
					&&(checkerboard[i][j].equals("��")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j+1].equals("-")
					&& checkerboard[i][j+1].equals("-")
					&& checkerboard[i+1][j+1].equals("-")
					&& checkerboard[i+1][j].equals("-"))) {
						check = i;
						check2 = j;
						type = 7;
						}
				else if(((i==0)||(i==checkerboard.length-1)) && j==checkerboard[i].length-1 // (������ �𼭸�)
					&&(checkerboard[i][j].equals("��")
					&& checkerboard[i-1][j].equals("-")
					&& checkerboard[i-1][j-1].equals("-")
					&& checkerboard[i][j-1].equals("-")
					&& checkerboard[i+1][j-1].equals("-")
					&& checkerboard[i+1][j].equals("-"))) {
						check = i;
						check2 = j;
						type = 8;
						}
				else if(((i>0)&&(i<checkerboard.length-1)) && ((j>0)||(j<checkerboard[i].length-1)) // (���)
						&&(checkerboard[i][j].equals("��")
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
	
	public void oneStonePlaceStone() { // �浹(�÷��̾�) �ֺ��� ���� �ϳ��� ���� �� �鵹(��ǻ��)�� ���� �ڸ� ���ϱ�
		if(type==1) {
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check+1][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==2) {
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check+1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==3) {
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check-1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==4){
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check-1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==4){
			int random = ran.nextInt(3);
			if(random==0) {
				checkerboard[check-1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==5){
			int random = ran.nextInt(5);
			if(random==0) {
				checkerboard[check][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check+1][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check+1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check+1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==6){
			int random = ran.nextInt(5);
			if(random==0) {
				checkerboard[check][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check-1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check-1][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==7){
			int random = ran.nextInt(5);
			if(random==0) {
				checkerboard[check-1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check+1][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else if(type==8){
			int random = ran.nextInt(5);
			if(random==0) {
				checkerboard[check-1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check+1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else {
				checkerboard[check+1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
		else{
			int random = ran.nextInt(8);
			if(random==0) {
				checkerboard[check-1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==1){
				checkerboard[check-1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==2){
				checkerboard[check-1][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==3){
				checkerboard[check][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==4){
				checkerboard[check+1][check2+1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==5){
				checkerboard[check+1][check2] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else if(random==6){
				checkerboard[check+1][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
			else{
				checkerboard[check][check2-1] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
			}
		}
	}
	
	public void randomPlaceStone() { // �鵹�� ������ ��ġ�� ����
		while(true) {
			int row = ran.nextInt(13);
			int column = ran.nextInt(13);
			if(checkerboard[row][column].equals("��") || checkerboard[row][column].equals("��")) {
				continue; // �ߺ��� ��ġ�� ������ ���� �ݺ�(����ó��)
			}
			else {
				checkerboard[row][column] = "��";
				printCheckerboard();
				cpuFiveRowCheck();
				break;
			}
		}
	}
	
	public void cpuFiveRowCheck() { // �鵹(��ǻ��)�� ���� ���� 5�� �þ���Ҵ��� Ȯ��
		if(fiveRowCheck()) {
			System.out.println("���� �� : ��ǻ�� �¸�");
			cpuWin++;
			playerLose++;
		}
	}
}
