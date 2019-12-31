package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBReader {

	public static void main(String[] args) {
		//1.Load the driver
		Connection con = null;
		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver not found"+e.getMessage());
		}
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "hr";
		String password = "hr";
		//2.Get connection
		try {
			con = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			System.out.println("Connection failed. "+e.getMessage());
		}
		
		//database metadata
		try {
			DatabaseMetaData dbmeta = con.getMetaData();
			System.out.println(dbmeta.toString());
			System.out.println(dbmeta.getDatabaseMajorVersion());
			System.out.println(dbmeta.getDatabaseProductName());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//3.Create a statement object
		String sql = "select First_name, Last_name , employee_id from employees where last_name='King'";
		
		try {
			Statement st= con.createStatement();
			//4.pass sql query string and execute statement
			ResultSet rs = st.executeQuery(sql);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			System.out.println(colCount);
			
			int type = rsmd.getColumnType(3);
			if(type == Types.INTEGER) {
				System.out.println("col has integer type");
			}else if(type == Types.VARCHAR) {
				System.out.println("col is a string(varchar)");
			}else if(type == Types.NUMERIC) {
				System.out.println("col is of type numeric");
			}
			System.out.println(rsmd.getColumnTypeName(3));
			
			while(rs.next()) {
				int id = rs.getInt(3);
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				System.out.println(id+":"+fname+":"+lname);
			}
			rs.close();
			st.close();
			con.close();
		}catch(SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}

}
