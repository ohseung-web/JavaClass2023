package streamEx03_Person_SeungHyun;

public class Person {

	    private String Country; // 나라
	    private String City; // 도시 
	    private String name; // 이름
	    
	    public Person(String Country, String City, String name) {
	    	this.Country = Country;
	    	this.City = City;
	    	this.name = name;
	    }
	    
		public String getCountry() {return Country;}
		public void setCountry(String country) {Country = country;}
		public String getCity() {return City;}
		public void setCity(String city) {City = city;}
		public String getName() {return name;}
		public void setName(String name) {this.name = name;}

		@Override
		public String toString() {
			return "Country:"+ this.Country+" "+
					"City:"+this.City+" "+"Name:"+this.name;
		}
	    
}
