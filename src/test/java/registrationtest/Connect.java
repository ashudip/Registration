package registrationtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {

	public static String Value = null;  
 	public static String DB_connection(String query, int Columnvalue)throws ClassNotFoundException {
	        try {
	        System.out.println("Value of query received="+query +" and "+"column number ="+Columnvalue+".");
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("2:Traversed through database connection method");
	        Connection con = DriverManager.getConnection("jdbc:mysql://204.204.204.1:3306/moneynet_rest_main", "moneynet_rest", "2nPCQhiltkPtut7N");
	        System.out.println("connection is "+con);
	        Statement smt =con.createStatement();
	        ResultSet rs=smt.executeQuery(query);
	        
	        while (rs.next()){
	           Value = rs.getString(Columnvalue);
	           
	        }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();    
	        }
	        
	        return Value;   
	    }	
}
