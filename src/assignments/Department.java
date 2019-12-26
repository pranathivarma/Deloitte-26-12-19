package assignments;

public class Department {
	protected String name;
	protected String location;


	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}


	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + "]";
	}


}
