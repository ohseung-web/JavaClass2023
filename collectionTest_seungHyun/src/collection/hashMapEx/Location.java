package collection.hashMapEx;

public class Location {
  
	private String cityName; //���ø�
	private int Latitude; //����
	private int Hardness; // �浵
	
	public Location() {}
	public Location(String cityName, int Latitude, int Hardness) {
		this.cityName = cityName;
		this.Latitude = Latitude;
		this.Hardness = Hardness;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getLatitude() {
		return Latitude;
	}
	public void setLatitude(int latitude) {
		Latitude = latitude;
	}
	public int getHardness() {
		return Hardness;
	}
	public void setHardness(int hardness) {
		Hardness = hardness;
	}
	
	@Override
	public String toString() {
		return cityName + " "+ Latitude + " " + Hardness;
	}
	
	
	
}
