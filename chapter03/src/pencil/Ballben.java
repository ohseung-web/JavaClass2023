package pencil;

public class Ballben extends ShapPencil{

	String c = "black";
	
	@Override
	 public void getinfo() {
		this.a = 25;
		this.b=2;
		this.name ="Ball";
		 System.out.println(name+": �ܿ��� :"+a+", �汽�� :"+b+", ����:"+c);
	 }
}
