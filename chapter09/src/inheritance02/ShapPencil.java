package inheritance02;

public class ShapPencil {
	int Residual = 10; //�ܿ���
	int thickness =1; // ����
	String name = "ShapPencil";
	public ShapPencil() {}
	
	public void Pencilinfo() {
		System.out.println(name+" : �ܿ��� : "+Residual+", ���� :"+thickness);
	}
}
