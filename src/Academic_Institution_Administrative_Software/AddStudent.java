package Academic_Institution_Administrative_Software;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JLabel name,heading,fname,rollno, lablerollno,dob,address,phone,email,Xth,XIIth,adhaar,course,branch;
    JTextField textname,textfname,textaddress,textphone,textemail,textXth,textXIIth,textadhaar;
    JDateChooser dobchoose;
    JComboBox ccourse,cbranch;
    JButton submit ,cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddStudent(){

        setSize(900,700);
        setLocation(350,50);

        setLayout(null);

        heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("SARIF",Font.BOLD,30));
        add(heading);

        name = new JLabel("Name:");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("sarif",Font.BOLD,20));
        add(name);

        textname = new JTextField();
        textname.setBounds(200,150,150,30);
        add(textname);

        fname = new JLabel("Father's Name:");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("sarif",Font.BOLD,20));
        add(fname);

        textfname = new JTextField();
        textfname.setBounds(600,150,150,30);
        add(textfname);

        rollno = new JLabel("Roll Number:");
        rollno.setBounds(50,200,200,30);
        rollno.setFont(new Font("sarif",Font.BOLD,20));
        add(rollno);

        lablerollno = new JLabel("24"+first4);
        lablerollno.setBounds(200,200,200,30);
        lablerollno.setFont(new Font("sarif",Font.BOLD,20));
        add(lablerollno);

        dob = new JLabel("Date of Birth:");
        dob.setBounds(400,200,200,20);
        dob.setFont(new Font("SARIF",Font.BOLD,20));
        add(dob);

        dobchoose = new JDateChooser();
        dobchoose.setBounds(600,200,150,30);
        add(dobchoose);

        address = new JLabel("Address:");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SARIF",Font.BOLD,20));
        add(address);

        textaddress = new JTextField();
        textaddress.setBounds(200,250,150,30);
//        textaddress.setFont(new Font("SARIF",Font.BOLD,20));
        add(textaddress);

        phone = new JLabel("Phone:");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("SARIF",Font.BOLD,20));
        add(phone);

        textphone = new JTextField();
        textphone.setBounds(600,250,150,30);
        add(textphone);

        email = new JLabel("Email ID:");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("SARIF",Font.BOLD,20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200,300,150,30);
        add(textemail);

        Xth = new JLabel("Class X(%)");
        Xth.setBounds(400,300,200,30);
        Xth.setFont(new Font("SARIF",Font.BOLD,20));
        add(Xth);

        textXth = new JTextField();
        textXth.setBounds(600,300,150,30);
        add(textXth);

        XIIth = new JLabel("Class XII(%)");
        XIIth.setBounds(50,350,200,30);
        XIIth.setFont(new Font("SARIF",Font.BOLD,20));
        add(XIIth);

        textXIIth = new JTextField();
        textXIIth.setBounds(200,350,150,30);
        add(textXIIth);

        adhaar = new JLabel("Aadhar Number:");
        adhaar.setBounds(400,350,200,30);
        adhaar.setFont(new Font("SARIF",Font.BOLD,20));
        add(adhaar);

        textadhaar = new JTextField();
        textadhaar.setBounds(600,350,150,30);
        add(textadhaar);

        course = new JLabel("Course:");
        course.setBounds(50,400,200,30);
        course.setFont(new Font("SARIF",Font.BOLD,20));
        add(course);

        String Course[] = {"B.Tech","M.Tech","BCA","MCA","BBA","MBA","Diploma","B.Arch"};
        ccourse = new JComboBox(Course);
        ccourse.setBounds(200,400,150,30);
        ccourse.setBackground(Color.white);
        add(ccourse);

        branch = new JLabel("Branch:");
        branch.setBounds(400,400,150,30);
        branch.setFont(new Font("SARIF",Font.BOLD,20));
        add(branch);

        String Branch[] = {"CSE","CST","CSE-AI/ML","B.Tech (LEET)","CSE-DS","ME","ETCE","D.Pharma"};
        cbranch = new JComboBox(Branch);
        cbranch.setBounds(600,400,150,30);
        cbranch.setBackground(Color.white);
        add(cbranch);

        submit = new JButton("Submit");
        submit.setBounds(250,525,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.red);
        submit.addActionListener(this);
        submit.setFont(new Font("SARIF",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,525,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        cancel.setFont(new Font("SARIF",Font.BOLD,15));
        add(cancel);









        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = textname.getText();
            String fname = textfname.getText();
            String rollno = lablerollno.getText();
            String dob = ((JTextField) dobchoose.getDateEditor().getUiComponent()).getText();
            String address = textaddress.getText();
            String phone = textphone.getText();
            String email = textemail.getText();
            String x = textXth.getText();
            String xii = textXIIth.getText();
            String aadhar = textadhaar.getText();
            String course = (String) ccourse.getSelectedItem();
            String branch =(String) cbranch.getSelectedItem();

            try{
                String query = "INSERT INTO student VALUES('"+name+"' , '"+fname+"' ,'"+rollno+"','"+dob+"','"+address+"' , '"+phone+"' , '"+email+"' , '"+x+"','"+xii+"', '"+aadhar+"' , '"+course+"' , '"+branch+"')";

                ConnectionJDBC con = new ConnectionJDBC();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details submit successfully.");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}