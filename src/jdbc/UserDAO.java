package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {
	
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Role> roles = new ArrayList<Role>();
	private static Map<Integer,Role> checkRoles = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllUsers();
		
	}

	private static void printAllUsers() {
		// TODO Auto-generated method stub
		Connection con=null;
		con = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		
		String sql = "select userid,fname,username,password,email,users.role_id,role_name, from users join roles on users.role_id=roles.role_id";
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Role r=null;
				if(checkRoles.containsKey(rs.getInt(6))) {
					r = checkRoles.get(rs.getInt(6));
				}
				else {
					r = new Role(rs.getInt(6),rs.getString(8),rs.getString(9));
					roles.add(r);
				}
				users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),r));
			}
			
			for(User u:users) {
				System.out.println(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}