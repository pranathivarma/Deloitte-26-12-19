package assessment;

public class Department {
	private String name;
	private String area;
	public Department(String name, String location) {
		super();
		this.name = name;
		this.area = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String area() {
		return area;
	}
	public void setarea(String location) {
		this.area = location;
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", area=" + area + "]";
	}
	
	

}
