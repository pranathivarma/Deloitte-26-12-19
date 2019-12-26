package assignments;

public class Address {
	
	protected int Hno;
	protected String Street;
	protected String City;
	protected String state;
	public Address(int hno, String street, String city, String state) {
		super();
		Hno = hno;
		Street = street;
		City = city;
		this.state = state;
	}
	public int getHno() {
		return Hno;
	}
	public void setHno(int hno) {
		Hno = hno;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [Hno=" + Hno + ", Street=" + Street + ", City=" + City + ", state=" + state + "]";
	}

}

