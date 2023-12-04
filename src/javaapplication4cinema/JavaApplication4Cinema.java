package javaapplication4cinema;

import project.core.dao.connection.MySQLVerification;

public class JavaApplication4Cinema {
    
    public static void main(String[] args) {
        MySQLVerification verification = new MySQLVerification();
        verification.setVisible(true);
    }
}
