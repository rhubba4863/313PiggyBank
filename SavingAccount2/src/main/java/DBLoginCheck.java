
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 */
public class DBLoginCheck {
    
    static final String DB_HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
    static final String DB_PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
    static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/savingsAccount";
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    static final String USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
    static final String PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
    
    
    public Integer checkAccount(String Username, String Password) {
        Connection conn = null;
        Statement stmt = null;
        Integer isPerson = 0;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user WHERE username = '" + Username + "' AND password = '" + Password + "'"; ;
            ResultSet rs = stmt.executeQuery(sql);
            

            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               String username = rs.getString("username");
               String password = rs.getString("password");
               Integer userId = Integer.parseInt(rs.getString("id"));
               
               //Display values
               System.out.println("username: " + username);
               System.out.println("password: " + password);
               System.out.println("userId: " + userId);
               
               if (username != null && password != null
                && username.equals(Username) && password.equals(Password)) {
                   isPerson = userId;
               }
            }
            
           
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            //return false;
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            //return false;
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
            }//end finally try
         }//end try
         System.out.println("Goodbye!");
        
        //return true;
        return isPerson;
    }
    
    public float getFunds(String username) {
        Connection conn = null;
        Statement stmt = null;
        float budget = (float) 0.0;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT budget FROM user WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               budget = Float.parseFloat(rs.getString("budget"));
               
               
               //Display values             
               System.out.println("username: " + username);
               System.out.println("Budget: " + budget);
            }
            
            
            System.out.println("Statement Executed...");
            
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            //return false;
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            //return false;
         }finally{
            //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
            }//end finally try
         }//end try
         System.out.println("Goodbye!");
        
        //return true;
        return budget;
    }
    
}
