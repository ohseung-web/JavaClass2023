package inheritance3;

public class IPTV extends ColorTV{
	
	String ip;
	public IPTV() {}
	public IPTV(String ip, int size, int resolution) {
		this.ip = ip;
		super.size = size;
		super.resolution = resolution;
	}
	@Override
	public void printProperty() {
		System.out.print("나의 IPTV는 "+ ip + "주소의 ");
		super.printProperty();
	}
	
    
}
