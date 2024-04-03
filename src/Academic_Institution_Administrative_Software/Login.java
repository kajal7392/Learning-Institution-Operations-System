package Academic_Institution_Administrative_Software;

import javax.management.timer.TimerMBean;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login ,cancel;
    JTextField textUser ,textpass;

    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel username = new JLabel("Username:");
        username.setBounds(40,20,100,20);
        add(username);

        textUser = new JTextField();
        textUser.setBounds(150,20,150,20);
        add(textUser);

        JLabel password = new JLabel("Password:");
        password.setBounds(40,70,100,20);
        add(password);

        textpass = new JPasswordField();
        textpass.setBounds(150,70,150,20);
        add(textpass);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.white);
        login.setForeground(Color.red);
        login.addActionListener(this);
        login.setFont(new Font("SARIF",Font.PLAIN,15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        cancel.setFont(new Font("SARIF",Font.PLAIN,15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);


        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
        setTitle("Login Page");


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== login){
            String username = textUser.getText();
            String password = textpass.getText();

            String query = "Select * from login where username = '"+username+"' and password='"+password+"'";
            try{
                ConnectionJDBC c = new ConnectionJDBC();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Project();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username and password");
                    setVisible(false);

                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource()==cancel){
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
