package project.core.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/cinema";
    private static String USER; //For recurrent use of the application: private static final String USER = "";
    private static String PASSWORD; //For recurrent use of the application: private static final String PASSWORD = "";

    public void setUSER(String USER) {
        ConnectionJDBC.USER = USER;
    }

    public void setPASSWORD(String PASSWORD) {
        ConnectionJDBC.PASSWORD = PASSWORD;
    }
    
    public static Connection conn;
    public static Connection getConnection() {
        try {
            if(conn == null){
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return conn;
            }else {
                return conn;
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to connect to Database", "SQL Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
}
