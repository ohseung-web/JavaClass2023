package exception;

public class IDFormatTest {
      
	private String userID;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) throws IDFormatException {
		if(userID==null)  {
			// throw 는 Exception을 발생시키는 키워드 이다.
			throw new IDFormatException("아이디는 null일 수 없습니다.");
		}else if(userID.length()<8 || userID.length()>20) {
			throw new IDFormatException("아이디는 8자이상 20자이하로 작성하세요.");
		}
		this.userID = userID;
	}

	public static void main(String[] args) {

		IDFormatTest idTest = new IDFormatTest();
		String userID = null;
		
		try {
			idTest.setUserID(userID);
		} catch (IDFormatException e) {
			System.out.println(e);
		}
		
		userID = "1234567";
		try {
			idTest.setUserID(userID);
		} catch (IDFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
