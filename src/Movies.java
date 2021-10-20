import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Movies {

	public static void main(String[] args)
	{
		getConnection();
	}
	
	public static Connection getConnection()
	{
		try 
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/movieslist";
			String username = "root";
			String password = "Integration1@";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established successfully");
			
			Statement stm = conn.createStatement();
			String sql = "select * from movies";
		    ResultSet mr = stm.executeQuery(sql);
		    
		   while(mr.next()) {
			   System.out.println(mr.getString(1) + " " + mr.getString(2) + " " + mr.getString(3) + " " + mr.getString(4) + " " + mr.getString(5) + " " + mr.getString(6));   
           }  
		}
		catch(Exception error) 
		{
			System.out.println(error);
		}
		return null;
	}
}
