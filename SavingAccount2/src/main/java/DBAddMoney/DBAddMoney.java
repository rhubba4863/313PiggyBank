/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAddMoney;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Braden
 */
public class DBAddMoney {
    static final String DB_HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
    static final String DB_PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
    static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/savingsAccount";
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    static final String USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
    static final String PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
    
    
    public float connectAddFunds(float addAmount, int userId) {
        Connection conn = null;
        Statement stmt = null;
        float newAmount = (float) 0.0;
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
            sql = "SELECT budget FROM user WHERE id =" + userId;
            ResultSet rs = stmt.executeQuery(sql);
            float budget;

            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               budget = Float.parseFloat(rs.getString("budget"));
               newAmount = (float) (Math.round((addAmount + budget) * 100.0)/ 100.0);
               
               //Display values
               System.out.println("Budget: " + budget);
               System.out.println("newAmount: " + newAmount);
            }
            
            System.out.println("Creating Update statement...");
            stmt = conn.createStatement();
            sql = "UPDATE user SET budget = " + newAmount + " WHERE id = " + userId;
            stmt.executeUpdate(sql);
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
        return newAmount;
    }
    
}
