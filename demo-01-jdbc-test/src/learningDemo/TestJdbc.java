package learningDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to Database: "+jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection established");
			
			Statement theQuery = myConn.createStatement();
			
			//String pw_hash = BCrypt.hashpw("sample", BCrypt.gensalt());
			
			System.out.println(theQuery.executeUpdate
					("INSERT INTO hb_student_tracker.student VALUES (0,\"Trial2\",\"Attempt2\",\"fake2@gmail.com\")"));
			
			theQuery.close();
			
		}
		catch(Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}

	}

}
