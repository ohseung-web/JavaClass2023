package inheritance4;

import java.text.*;
public class Customer {

	DecimalFormat de = new DecimalFormat("#,###");
	
	//�ɹ�����
	protected int customerID; // ��ID
	protected String customerName;//���̸�
	protected String  customerGrade;//�����
	int bounsPoint;//���� ���ʽ� ����Ʈ
	double bonusRatio; //���ʽ� ����Ʈ ��������
	
	//������
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
	
	//�޼���
	/*
	 * public int calcprice(int price) { bounsPoint += price * bonusRatio; return
	 * price; }
	 */
	
	public int calcprice(int price) {
		bounsPoint += price * bonusRatio;
        return price;
	}
	
	public String ShowCustomerInfo() {
	  return 	customerName + "���� ����� " + customerGrade + "�̸�, ���ʽ� ����Ʈ�� " + de.format(bounsPoint) + "�Դϴ�.";
		
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
