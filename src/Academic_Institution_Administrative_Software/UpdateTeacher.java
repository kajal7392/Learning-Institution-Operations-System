package Academic_Institution_Administrative_Software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {
    JLabel labelEmpID;
    JTextField textaddress,textphone,textemail,textcourse,textbranch;

    JButton submit ,cancel;
    Choice cempid;

    UpdateTeacher() {

        setSize(900, 650);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("TAHOMA", Font.ITALIC, 35));
        add(heading);

        JLabel rollNumber = new JLabel("Select Employee ID");
        rollNumber.setBounds(50, 100, 200, 20);
        rollNumber.setFont(new Font("SARIF", Font.ITALIC, 20));
        add(rollNumber);

        cempid = new Choice();
        cempid.setBounds(250, 100, 200, 20);
        add(cempid);

        try {
            ConnectionJDBC c = new ConnectionJDBC();
            ResultSet rs = c.s.executeQuery("SELECT * FROM teacher");
            while (rs.next()) {
                cempid.add(rs.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("sarif", Font.BOLD, 20));
        add(name);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("sarif", Font.BOLD, 20));
        add(fname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);

        JLabel rollno = new JLabel("Employee ID:");
        rollno.setBounds(50, 200, 200, 30);
        rollno.setFont(new Font("sarif", Font.BOLD, 20));
        add(rollno);

        labelEmpID = new JLabel();
        labelEmpID.setBounds(200, 200, 200, 30);
        labelEmpID.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelEmpID);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("SARIF", Font.BOLD, 20));
        add(dob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        add(labeldob);

        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SARIF", Font.BOLD, 20));
        add(address);

        textaddress = new JTextField();
        textaddress.setBounds(200, 250, 150, 30);
//        textaddress.setFont(new Font("SARIF",Font.BOLD,20));
        add(textaddress);

        JLabel phone = new JLabel("Phone:");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("SARIF", Font.BOLD, 20));
        add(phone);

        textphone = new JTextField();
        textphone.setBounds(600, 250, 150, 30);
        add(textphone);

        JLabel email = new JLabel("Email ID:");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("SARIF", Font.BOLD, 20));
        add(email);

        textemail = new JTextField();
        textemail.setBounds(200, 300, 150, 30);
        add(textemail);

        JLabel Xth = new JLabel("Class X(%)");
        Xth.setBounds(400, 300, 200, 30);
        Xth.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(Xth);

        JLabel labelXth = new JLabel();
        labelXth.setBounds(600, 300, 150, 30);
        labelXth.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelXth);

        JLabel XIIth = new JLabel("Class XII(%)");
        XIIth.setBounds(50, 350, 200, 30);
        XIIth.setFont(new Font("SARIF", Font.BOLD, 20));
        add(XIIth);

        JLabel labelXIIth = new JLabel();
        labelXIIth.setBounds(200, 350, 150, 30);
        labelXIIth.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelXIIth);

        JLabel adhaar = new JLabel("Aadhar Number:");
        adhaar.setBounds(400, 350, 200, 30);
        adhaar.setFont(new Font("SARIF", Font.BOLD, 20));
        add(adhaar);

        JLabel labeladhaar = new JLabel();
        labeladhaar.setBounds(600, 350, 150, 30);
        labeladhaar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeladhaar);

        JLabel course = new JLabel("Education:");
        course.setBounds(50, 400, 200, 30);
        course.setFont(new Font("SARIF", Font.BOLD, 20));
        add(course);

//        String Course[] = {"B.Tech","M.Tech","BCA","MCA","BBA","MBA","Diploma","B.Arch"};
        textcourse = new JTextField();
        textcourse.setBounds(200, 400, 150, 30);
//        textcourse.setBackground(Color.white);
        add(textcourse);

        JLabel branch = new JLabel("Department:");
        branch.setBounds(400, 400, 150, 30);
        branch.setFont(new Font("SARIF", Font.BOLD, 20));
        add(branch);

//        String Branch[] = {"none","CSE","CST","CSE-AI/ML","B.Tech (LEET)","CSE-DS","ME","ETCE","D.Pharma"};
        textbranch = new JTextField();
        textbranch.setBounds(600, 400, 150, 30);
//        textbranch.setBackground(Color.white);
        add(textbranch);

        try {
            ConnectionJDBC c = new ConnectionJDBC();
            String query = "SELECT * FROM teacher WHERE empid = '" + cempid.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                textaddress.setText(rs.getString("address"));
                textphone.setText(rs.getString("phone"));
                textemail.setText(rs.getString("email"));
                labelXth.setText(rs.getString("x"));
                labelXIIth.setText(rs.getString("xii"));
                labeladhaar.setText(rs.getString("aadhar"));
                labelEmpID.setText(rs.getString("empid"));
                textcourse.setText(rs.getString("qualification"));
                textbranch.setText(rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                try {
                    ConnectionJDBC c = new ConnectionJDBC();
                    String query = "SELECT * FROM teacher WHERE empid = '" + cempid.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        textaddress.setText(rs.getString("address"));
                        textphone.setText(rs.getString("phone"));
                        textemail.setText(rs.getString("email"));
                        labelXth.setText(rs.getString("x"));
                        labelXIIth.setText(rs.getString("xii"));
                        labeladhaar.setText(rs.getString("aadhar"));
                        labelEmpID.setText(rs.getString("empid"));
                        textcourse.setText(rs.getString("qualification"));
                        textbranch.setText(rs.getString("department"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        submit = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.red);
        submit.addActionListener(this);
        submit.setFont(new Font("SARIF",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.red);
        cancel.addActionListener(this);
        cancel.setFont(new Font("SARIF",Font.BOLD,15));
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String empid = labelEmpID.getText();
            String address = textaddress.getText();
            String phone = textphone.getText();
            String email = textemail.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();

            try{
                String query = "UPDATE teacher SET address='" + address + "', phone='" + phone + "', email='" + email + "', qualification='" + course + "', department='" + branch + "' WHERE empid='" + empid + "'";
//                String query = "UPDATE student SET address'"+address+"' ,phone='"+phone+"' ,email='"+email+"',course='"+course+"',branch='"+branch+"' where rollno='"+rollno+"'";
                ConnectionJDBC con = new ConnectionJDBC();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully.");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}
