package assignments;

public class Department {
	
	protected String location;

	public Department(String location) {
		super();
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [location=" + location + "]";
	}
	

}
