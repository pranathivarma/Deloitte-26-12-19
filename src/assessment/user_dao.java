package assessment;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class user_dao {

	private static ArrayList<book> books = new ArrayList<book>();
	private static ArrayList<author> authors = new ArrayList<author>();
	private static ArrayList<publisher> publishers = new ArrayList<publisher>(); 
	public static void main(String[] args) {
		
		getData();
		listBooks();
		listBooksGroupByAuthor(authors.get(0));
		listPoemsGivenCity("Hyderabad");
		listBooksPublishedAfterGivenYear(1950);
		sortBooksbyAuthorAndTitle();


	}
	private static void sortBooksbyAuthorAndTitle() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Books sorted by Author and title are: ");
		Connection con = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql1 = "select * from book order by author_name,title";
		try {
			PreparedStatement pst = con.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("ISBN: "+rs.getInt(1)+" Title: "+rs.getString(2)+" Pages: "+rs.getInt(3)+" Pulished_year: "+rs.getInt(4)+" Type: "+rs.getString(5)+" Author: "+rs.getString(6)+" Publisher: "+rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		
	}
	
	private static void listBooksPublishedAfterGivenYear(int year) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Books published after "+year+" are:");
		for(book b:books) {
			if(b.getPub_year()>year)
			System.out.println(b);
		}
	}
	private static void listPoemsGivenCity(String city) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Poems in "+city+" are:");
		for(book b: books) {
			if(b.getPublisher().getCity().equalsIgnoreCase(city)&&b.getType().equalsIgnoreCase("Poems")) {
				System.out.println(b);
			}
		}
		
	}
	private static void listBooksGroupByAuthor(author a) {
		// TODO Auto-generated method stub
		System.out.println();
		Connection con = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql = " {call giveNumberOfBooks(?,?)}";
		try {
			CallableStatement cst = con.prepareCall(sql);
			cst.setString(1,a.getName());
			cst.registerOutParameter(2,Types.INTEGER);
			cst.execute();
			System.out.println("Number of books by "+a.getName()+" are: "+cst.getInt(2));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	private static void getData() {
	
		Connection con = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql1 = "select p_name,city from publisher";
		try {
			PreparedStatement pst = con.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				publishers.add(new publisher(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
		
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		String sql2 = "select name,nationality from author";
		try {
			PreparedStatement pst = con.prepareStatement(sql2);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				authors.add(new author(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		String sql3 = "select isbn,title,pages,pub_year,type,author_name,publisher_name from book";
		try {
			PreparedStatement pst = con.prepareStatement(sql3);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				author a = null;
				for(author i: authors) {
					if(i.getName().equalsIgnoreCase(rs.getString(6))) {
						a=i;
						break;
					}
				}
				publisher p = null;
				for(publisher i: publishers) {
					if(i.getName().equalsIgnoreCase(rs.getString(7))) {
						p=i;
						break;
					}
				}
				books.add(new book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),a,p));
			}
		} catch (SQLException e) {
			
			System.out.println("Could not Prepare Statement "+e.getMessage());
		}
		
		
	}
	private static void listBooks() {
		System.out.println();
		System.out.println("List of Books: ");
		for(book b: books) {
			System.out.println("ISBN: "+b.getIsbn()+" Title: "+b.getTitle()+" Pages: "+b.getPages()+" Author Name: "+b.getAuthor().getName()+" Publisher: "+b.getPublisher().getName()+" City: "+b.getPublisher().getCity());
		}
		
	}
	
}

