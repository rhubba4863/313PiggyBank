
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
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/savingsaccount";
    
    static final String USER = "legolas";
    static final String PASS = "arrows";
    
    
    public boolean checkAccount(String Username, String Password) {
        Connection conn = null;
        Statement stmt = null;
        boolean isPerson = false;
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
               
               //Display values
               System.out.println("username: " + username);
               System.out.println("password: " + password);
               
               if (username != null && password != null
                && username.equals(Username) && password.equals(Password)) {
                   isPerson = true;
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
