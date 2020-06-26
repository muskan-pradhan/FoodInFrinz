package foodinfrinz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
private static Connection conn;
static
{
    try
    {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-HC79J05:1521/xe","foodinfrinz", "namura");
            System.out.println("Connection Opened!");
    }
    catch(Exception ex)
    { 
        JOptionPane.showMessageDialog(null,"DB Error in Opening Connection!","Error!",JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
 public static Connection getConnection()
    { 
        return conn;
    }
 public static void closeConnection()
 {  
    try
    {
    conn.close();
    System.out.println("Connection closed!");
    }
    catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null,"DB Error in Closing Connection!","Error!",JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
 }

}

