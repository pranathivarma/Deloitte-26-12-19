package assessment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private String url;
	private String user;
	private String password;
	public DBConnector(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public Connection getConnection() {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Connect success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection failed. "+e.getMessage());
		}
		return con;
		
	}
		
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DBConnector [url=" + url + ", user=" + user + ", password=" + password + "]";
	}
	
	
}