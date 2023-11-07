package inheritance02;

public class Customer {

	//맴버변수
	protected int customerID; // 고객ID
	protected String customerName;//고객이름
	protected String  customerGrade;//고객등급
	int bounsPoint;//고객의 보너스 포인트
	double bonusRatio; //보너스 포인트 적립비율
	
	//생성자
	public Customer() {
		customerGrade ="SILVER";
		bonusRatio =0.01;
	}
	public Customer(int customerID, String customerName ) {
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade ="SILVER";
		bonusRatio =0.01;
	}
	
	//메서드
	public int calcprice(int price) {
		bounsPoint += 	price * bonusRatio;
		return price;
	}
	
	public String ShowCustomerInfo() {
	  return 	customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bounsPoint + "입니다.";
		
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	
}
