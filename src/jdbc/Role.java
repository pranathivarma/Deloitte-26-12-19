package jdbc;

public class Role {
	
	private int role_id;
	private String name;
	private String priviliges;
	public Role(int role_id, String name, String priviliges) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.priviliges = priviliges;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPriviliges() {
		return priviliges;
	}
	public void setPriviliges(String priviliges) {
		this.priviliges = priviliges;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", name=" + name + ", priviliges=" + priviliges + "]";
	}
	
	

}