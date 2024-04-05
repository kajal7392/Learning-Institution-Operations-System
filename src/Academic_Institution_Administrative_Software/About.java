package Academic_Institution_Administrative_Software;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){
        setSize(700,500);
        setLocation(400,150);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);

        JLabel heading = new JLabel("<html>Academic Institution<br/>Administrative Software</html>");
        heading.setBounds(70,20,250,150);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Developed by Team Member1: Divyansh , Roll Number:213042");
        name.setBounds(70,220,800,40);
        name.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(name);

        JLabel name1 = new JLabel("Developed by Team Member2: Kajal Sharma, Roll Number:223712");
        name1.setBounds(70,250,800,40);
        name1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(name1);

        JLabel project = new JLabel("Java Swing Project");
        project.setBounds(200,350,300,40);
        project.setFont(new Font("SARIF",Font.ITALIC,30));
        add(project);

        setVisible(true);

    }
    public static void main(String[] args) {
        new About();
    }
}
