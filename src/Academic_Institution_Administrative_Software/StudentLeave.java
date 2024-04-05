package Academic_Institution_Administrative_Software;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {
    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    StudentLeave(){

        setLayout(null);
        setSize(500,550);
        setLocation(550,100);


        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(heading);

        JLabel rollno = new JLabel("Search by Roll Number");
        rollno.setBounds(60,100,200,20);
        rollno.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(rollno);

        crollno = new Choice();
        crollno.setBounds(60,130,200,20);
        add(crollno);

        try{
            ConnectionJDBC c = new ConnectionJDBC();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student");
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }

        JLabel date = new JLabel("Date");
        date.setBounds(60,180,200,20);
        date.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(date);

        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);

        JLabel time = new JLabel("Time Duration");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(time);

        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.red);
        submit.addActionListener(this);
        submit.setFont(new Font("SARIF",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        cancel.setFont(new Font("SARIF",Font.BOLD,15));
        add(cancel);


        setVisible(true);

    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()==submit){
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "INSERT INTO studentleave VALUES ('"+rollno+"','"+date+"','"+duration+"')";
            try{
                ConnectionJDBC c = new ConnectionJDBC();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new StudentLeave();
    }
}
