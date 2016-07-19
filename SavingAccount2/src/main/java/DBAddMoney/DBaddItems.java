/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAddMoney;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Braden
 */
public class DBaddItems {
    static final String DB_HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
    static final String DB_PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
    static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/savingsAccount";
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    static final String USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
    static final String PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
    
    public void connectAddItems(int itemId, int userId){
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            String sql = null;
            
            System.out.println("Creating INSERT statement...");
            stmt = conn.createStatement();
            sql = "INSERT INTO item (walmartId, userId) VALUES ('" +itemId + "'," + userId + ")";
            stmt.execute(sql);
            System.out.println("Statement Executed...");
            
            //STEP 6: Clean-up environment
            //rs.close();
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
    }
}
