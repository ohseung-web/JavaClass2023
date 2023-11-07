package megabox;

public class MegaboxElements{
	public static final int row = 9; // 좌석의 행
	public static final int column = 8; // 좌석의 열
	protected int[][] screen = new int[row][column]; // 좌석
	protected String[] rowAlphabet = {"A","B","C","D","E","F","G","H","I"};
	protected int revenue = 0; // 매출액
	protected int personnel = 0; // 선택한 인원수
	protected String reserveRow = null;
	protected int reserveSeat1 = 0; // 예매좌석1
	protected int reserveSeat2 = 0; // 예매좌석2
	protected boolean run = true;

	public MegaboxElements() {}

	public int[][] getScreen() {
		return screen;
	}

	public void setScreen(int[][] screen) {
		this.screen = screen;
	}

	public String[] getRowAlphabet() {
		return rowAlphabet;
	}

	public void setRowAlphabet(String[] rowAlphabet) {
		this.rowAlphabet = rowAlphabet;
	}
	
	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}

	public String getReserveRow() {
		return reserveRow;
	}

	public void setReserveRow(String reserveRow) {
		this.reserveRow = reserveRow;
	}

	public int getReserveSeat1() {
		return reserveSeat1;
	}

	public void setReserveSeat1(int reserveSeat1) {
		this.reserveSeat1 = reserveSeat1;
	}

	public int getReserveSeat2() {
		return reserveSeat2;
	}

	public void setReserveSeat2(int reserveSeat2) {
		this.reserveSeat2 = reserveSeat2;
	}
	
	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	public void printScreen() {
		System.out.println("---------SCREEN---------");
		for(int i=0;i<row;i++) {
			System.out.print(rowAlphabet[i]);
			for(int j=0;j<column;j++) {
				if(screen[i][j]==0) {
					System.out.print("[ ]"); // 선택하지 않은 자리
				}
				else if(screen[i][j]==1) {
					System.out.print("[O]"); // 선택한 자리
				}
				else if(screen[i][j]==2) {
					System.out.print("[X]"); // 선택 불가능한 자리 (한 명 선택 or 홀수 명 중 마지막 사람 선택일 경우)
				}
				else {
					System.out.print("[-]"); // 다른 사람들이 예매한 자리
				}
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
	
	public void disableEvenColumns() { // 짝수 번째 자리를 선택 불가능한 자리로 설정
		for(int i=0;i<row;i++) {
			for(int j=0;j<column/2-1;j++) { // 열의 개수가 짝수일 경우 사용 가능
				// 짝수 번째 열 중에서 선택 가능한 자리가 있고, 그 자리 양옆에 선택한 자리가 하나도 없을 때 (마지막 열 제외)
				if(screen[i][2*j+1]==0 && screen[i][2*j]!=1 && screen[i][2*j+2]!=1) {
					screen[i][2*j+1]=2; // 그 자리를 선택 불가능한 자리로 표시
				}
			}
			if(screen[i][column-1]==0 && screen[i][column-2]!=1) { // 마지막 열의 경우도 포함하도록 해준다.
				screen[i][column-1]=2;
			}
		}
	}
	
	public void initializeDisabledColumns() { // 선택 불가능으로 표기됐던 자리 초기화
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(screen[i][j]==2) {
					screen[i][j]=0;
				}
			}
		}
	}
	
	public void convertReservedSeats() { // 선택한 자리를 예매된 자리로 변경
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(screen[i][j]==1) {
					screen[i][j]=3;
				}
			}
		}
	}
	
	public void cancelReservedSeats() { // 선택한 자리를 취소
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(screen[i][j]==1) {
					screen[i][j]=0;
					revenue -= 12000;
				}
			}
		}
	}
}
