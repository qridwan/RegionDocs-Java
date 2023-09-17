


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DBConnector {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static  String DB_USER="";
    private static  String DB_PASSWORD ="";
    private static  String DB_CONNECTION ="";
    public static Connection getDBConnection() {
        
    		DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/xNote";
    		DB_USER = "root";
    		DB_PASSWORD = "password";
    	
        Connection dbConnection = null ;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
   
    
}
