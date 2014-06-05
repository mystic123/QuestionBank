/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package qbsth;

import java.sql.*;

/**
 *
 * @author supermaja
 */
public class QBSth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:dat.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "SELECT question from translations";
      ResultSet rs = stmt.executeQuery(sql);
         while(rs.next())
                        {
                            String sResult = rs.getString("question");
                            System.out.println(sResult);
                        }
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    //System.out.println("Table created successfully");
    }
    
}
