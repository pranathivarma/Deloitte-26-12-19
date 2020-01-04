package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class EmpSalaryDisplayer {
	
	public static void main(String[] args)
	{
		displaySalary(100);
	}
	
public static void displaySalary(int id)
	{
		Connection con=null;
		DBConnector dbc = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con = dbc.getConnection();		
		String sql="{call DISPempsalary(?,?)}";
		try{
			CallableStatement cst=con.prepareCall(sql);
			cst.setInt(1,id);
			cst.registerOutParameter(2, Types.INTEGER);
			cst.execute();
			System.out.println(cst.getInt(2));
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}