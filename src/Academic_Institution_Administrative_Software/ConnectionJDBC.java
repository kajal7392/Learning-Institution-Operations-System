package Academic_Institution_Administrative_Software;

import javax.swing.*;
import javax.sql.*;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionJDBC  {
    Connection c;
    Statement s;
    ConnectionJDBC() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Update the JDBC URL, username, and password
            String url = "jdbc:mysql://localhost:3306/AcademicAdmin";
            String username = "root"; 
            String password = "Admin";
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
