
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 */
public class DBUserList {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/savingsaccount";
    
    static final String USER = "legolas";
    static final String PASS = "arrows";
    
    public String getUserName(Integer userId) {
        Connection conn = null;
        Statement stmt = null;
        String userName = "";
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
            sql = "SELECT * FROM user WHERE id = " + userId ;
            ResultSet rs = stmt.executeQuery(sql);
            

            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               String id = rs.getString("username");
               
               userName = id;
               
               //Display values
               System.out.println("userName: " + id);
               
               
               
            }
            //Integer removeComma = currentList.lastIndexOf(",");
            /*if (currentList.length() > 0 && currentList.charAt(currentList.length()-1)==',') {
                 currentList = currentList.substring(0, currentList.length()-1);
            }*/
            
            //System.out.println("walmartlist : " + currentList);
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
         
         return userName;
    }
    
    public String getUserList(Integer UserID) {
        Connection conn = null;
        Statement stmt = null;
        String currentList = "";
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
            sql = "SELECT * FROM item WHERE userId = " + UserID ;
            ResultSet rs = stmt.executeQuery(sql);
            

            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               String id = rs.getString("walmartId");
               
               currentList += id;
               
               
               currentList += ",";
               //Display values
               System.out.println("walmartId: " + id);
               System.out.println("currentList: " + currentList);
               
               
               
            }
            //Integer removeComma = currentList.lastIndexOf(",");
            if (currentList.length() > 0 && currentList.charAt(currentList.length()-1)==',') {
                 currentList = currentList.substring(0, currentList.length()-1);
            }
            
            System.out.println("walmartlist : " + currentList);
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
        return currentList;
    }
    
    public float checkFunds(Integer userId) {
        
        Connection conn = null;
        Statement stmt = null;
        float currentFunds = (float)0.0;
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
            sql = "SELECT * FROM user WHERE id = " + userId ;
            ResultSet rs = stmt.executeQuery(sql);
            

            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               String id = rs.getString("budget");
               
               currentFunds = Float.parseFloat(id);
               
               //Display values
               System.out.println("budget: " + id);
               System.out.println("currentFunds: " + currentFunds);
               
               
               
            }
            //Integer removeComma = currentList.lastIndexOf(",");
            /*if (currentList.length() > 0 && currentList.charAt(currentList.length()-1)==',') {
                 currentList = currentList.substring(0, currentList.length()-1);
            }*/
            
            //System.out.println("walmartlist : " + currentList);
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
        
        return currentFunds;
    }
    
}
