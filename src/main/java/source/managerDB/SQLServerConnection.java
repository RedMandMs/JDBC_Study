package source.managerDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConnection{
	
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Fields;user=sergey;password=lenoblgissergey";
		
		Connection con = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    
	    try {
	        // Establish the connection.
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        con = DriverManager.getConnection(connectionUrl);
	        System.out.println("Hello");
	        
	        //String SQL = "INSERT INTO Organization_Table (id, name, INN, address) VALUES('1', 'LenOblGis', '12345', 'Torgkovskaya 15')";
	        String SQL = "SELECT * FROM Organization_Table";
	        stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
	        rs = stmt.executeQuery(SQL);
	        rs.next();
	        System.out.println(rs.getInt("id"));
	        System.out.println(rs.getString("name"));
	    }
	
	    // Handle any errors that may have occurred.
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    finally {
	       try {
			con.close();
	       } 
	       catch (SQLException e) {
			e.printStackTrace();
		   }
	    }
	}
}
