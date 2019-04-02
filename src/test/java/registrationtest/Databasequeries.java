package registrationtest;

import java.sql.Statement;



public class Databasequeries {

	static String query=null;
    static Statement smt=null;
    static int Columnvalue;
    static String Columnnum=null;
    static String Value=null;
    static String token;
    static String[] Result;
    static String userid_query = null;
    static String user_id = null;
    static String email_id = null;
    public static String token_query(String emailid ) throws ClassNotFoundException{
    	Columnvalue=1;
    	email_id = emailid;
    	userid_query = "SELECT id FROM moneynet_rest_main.users where email='"+email_id+"'";
        user_id = Connect.DB_connection(userid_query, Columnvalue);
        query="SELECT token FROM moneynet_rest_main.tokens where `user_id`= "+user_id+" and `type` = 'VERIFY_INDIVIDUAL'";
        String token = Connect.DB_connection(query,Columnvalue);
        return token;    
    }
}
