package withArraylist;

public class GoldCustomer extends Customer{

	double salePoint;
	
	public GoldCustomer(int customerID, String customerName) {
		super(customerID,customerName);
		customerGrade ="GOLD";
		bonusRatio = 0.02;
		salePoint = 0.1;
	}

	@Override
	public int calcprice(int price) {
		bounsPoint = (int)(bounsPoint + ((double)price * bonusRatio)); 
		//bounsPoint += (price * bonusRatio);
		return price - (int)(price *salePoint );
	}
	
}
