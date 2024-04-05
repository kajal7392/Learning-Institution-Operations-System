package Academic_Institution_Administrative_Software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox cbsemsester;
    JButton submit,cancel;
    JTextField textsub1,textsub2,textsub3,textsub4,textsub5,textmarks1,textmarks2,textmarks3,textmarks4,textmarks5;

    EnterMarks(){

        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
        add(heading);

        JLabel rollNumber = new JLabel("Select Roll Number");
        rollNumber.setBounds(50, 70, 150, 20);
        add(rollNumber);

        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);

        try {
            ConnectionJDBC c = new ConnectionJDBC();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel semester = new JLabel("Select Semester");
        semester.setBounds(50, 110, 150, 20);
        add(semester);


        String semester1[] = {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester","9th Semester","10th Semester"};
        cbsemsester = new JComboBox(semester1);
        cbsemsester.setBounds(200,110,150,20);
        cbsemsester.setBackground(Color.white);
        add(cbsemsester);

        JLabel enetrsubject = new JLabel("Enter Subject");
        enetrsubject.setBounds(100, 150, 200, 40);
        add(enetrsubject);

        JLabel entermarks = new JLabel("Enter Marks");
        entermarks.setBounds(320, 150, 200, 40);
        add(entermarks);

        textsub1 = new JTextField();
        textsub1.setBounds(50,200,200,20);
        add(textsub1);

        textsub2 = new JTextField();
        textsub2.setBounds(50,230,200,20);
        add(textsub2);

        textsub3 = new JTextField();
        textsub3.setBounds(50,260,200,20);
        add(textsub3);

        textsub4 = new JTextField();
        textsub4.setBounds(50,290,200,20);
        add(textsub4);

        textsub5 = new JTextField();
        textsub5.setBounds(50,320,200,20);
        add(textsub5);



        textmarks1 = new JTextField();
        textmarks1.setBounds(250,200,200,20);
        add(textmarks1);

        textmarks2 = new JTextField();
        textmarks2.setBounds(250,230,200,20);
        add(textmarks2);

        textmarks3 = new JTextField();
        textmarks3.setBounds(250,260,200,20);
        add(textmarks3);

        textmarks4 = new JTextField();
        textmarks4.setBounds(250,290,200,20);
        add(textmarks4);

        textmarks5 = new JTextField();
        textmarks5.setBounds(250,320,200,20);
        add(textmarks5);


        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.red);
        submit.addActionListener(this);
        submit.setFont(new Font("SARIF",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        cancel.setFont(new Font("SARIF",Font.BOLD,15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            try{
                ConnectionJDBC c = new ConnectionJDBC();
                String query1 = "INSERT INTO subject VALUES ('"+crollno.getSelectedItem()+"', '"+cbsemsester.getSelectedItem()+"', '"+textsub1.getText()+"','"+textsub2.getText()+"','"+textsub3.getText()+"','"+textsub4.getText()+"','"+textsub5.getText()+"')";
                String query2 = "INSERT INTO marks VALUES ('"+crollno.getSelectedItem()+"', '"+cbsemsester.getSelectedItem()+"', '"+textmarks1.getText()+"','"+textmarks2.getText()+"','"+textmarks3.getText()+"','"+textmarks4.getText()+"','"+textmarks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully.");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
