package healthmate;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class database extends Thread{

    Connection con;
    Statement stmt;

    void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
           // con = DriverManager.getConnection("jdbc:mysql://amolbhy.no-ip.biz:3306/hmdb", "healthmate", "healthmate");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8889/hmdb", "healthmate", "healthmate");
      
            stmt = con.createStatement();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection to Server is lost!!");
            System.out.println("INSIDE CONNECT" + e);
        }
    }

    void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    

    ResultSet retrivefromdb(String id1) throws SQLException {
        connect();
        ResultSet resultSet = stmt.executeQuery("select * from `hmdb`.`table2` where id='" + id1 + "'");
        if(resultSet.next()) {
            System.out.println("HAVE REC------------");
        }
        return resultSet;

    }
    
}
