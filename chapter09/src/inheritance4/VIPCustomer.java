package inheritance4;

public class VIPCustomer extends Customer{
 private int agentID;
 double salePoint;
 
 //������
 public VIPCustomer() {}
 public VIPCustomer(int customerID, String customerName, int agentID ) {
	 super(customerID,customerName);
	// super.customerID = customerID;
	// super.customerName = customerName;
	 customerGrade ="VIP";
	 bonusRatio =0.05;
	 this.salePoint = 0.1;
	 this.agentID = agentID;
 }
 
 //�޼���
 @Override
 public int calcprice(int price) {
	 bounsPoint += 	price * bonusRatio;
	return price - (int)(price*this.salePoint);
 }
 
 /*
 @Override
public String ShowCustomerInfo() {
	return super.ShowCustomerInfo() + "\n, ��� ���� ����� " + getAgentID() + "���Դϴ�.";
}
*/
public int getAgentID() {
	 return agentID;
 }
}
