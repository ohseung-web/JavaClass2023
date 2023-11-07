package hashMapEx;

public class Location {
	private String city; // 도시 이름
	private int latitude; // 위도
	private int longitude; // 경도
	
	public Location() {}
	public Location(String city, int latitude, int longitude) {
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return city+" "+latitude+" "+longitude;
	}
	
	
}
