package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class user_dao {
	
	Connection con = null;

	public user_dao()
	{
		
	}
	
	public void listUsers()
	{
		DBConnector dbcon = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = dbcon.getConnection();
		String sql = "select u.fname,u.username,u.emailid,r.rolename from users u,roles r where u.roleid=r.roleid order by u.fname";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4));
			}
		}catch (SQLException e) {
				System.out.println(e);
			}
		
	
	}
	
	public static void main(String [] args)
	{
		user_dao udao = new user_dao();
		udao.listUsers();
	}
}
