package jdbc;

public class role_sql {
	
	int roleId;
	String role_Name;
	public role_sql(int roleId, String role_Name) {
		super();
		this.roleId = roleId;
		this.role_Name = role_Name;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole_Name() {
		return role_Name;
	}
	public void setRole_Name(String role_Name) {
		this.role_Name = role_Name;
	}
	@Override
	public String toString() {
		return "role_sql [roleId=" + roleId + ", role_Name=" + role_Name + "]";
	}
	
	
	

}