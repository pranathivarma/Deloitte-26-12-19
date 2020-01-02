package jdbc;

public class user_sql {
	
	int user_Id;
	String fname;
	String user_Name;
	String password;
	String emailId;
	String roleId;
	String mobile;
	
	public user_sql(int user_Id, String fname, String user_Name, String password, String emailId, String roleId,
			String mobile) {
		super();
		this.user_Id = user_Id;
		this.fname = fname;
		this.user_Name = user_Name;
		this.password = password;
		this.emailId = emailId;
		this.roleId = roleId;
	}
	
	
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	


	@Override
	public String toString() {
		return "user_sql [user_Id=" + user_Id + ", fname=" + fname + ", user_Name=" + user_Name + ", password="
				+ password + ", emailId=" + emailId + ", roleId=" + roleId + " ]";
	}
	
	
	
	
	

}
