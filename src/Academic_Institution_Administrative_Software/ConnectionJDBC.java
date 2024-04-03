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
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/AcademicAdminDB","root","Divyansh#213042");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
