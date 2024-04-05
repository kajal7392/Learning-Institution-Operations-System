package Academic_Institution_Administrative_Software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox ccourse,cbranch,cbsemsester;
    JLabel labeltotal;
    JButton update,pay,back;

    StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel rollNumber = new JLabel("Select Roll No");
        rollNumber.setBounds(40, 60, 150, 20);
        rollNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(rollNumber);

        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
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

        JLabel name = new JLabel("Name");
        name.setBounds(40, 100, 150, 20);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(name);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(40, 140, 150, 20);
        fname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(fname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(200, 140, 150, 20);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfname);


        try {
            ConnectionJDBC c = new ConnectionJDBC();
            String query = "SELECT * FROM student WHERE rollno = '" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                try {
                    ConnectionJDBC c = new ConnectionJDBC();
                    String query = "SELECT * FROM student WHERE rollno = '" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        JLabel course = new JLabel("Course");
        course.setBounds(40,180,150,20);
        course.setFont(new Font("Tahoma",Font.BOLD,16));
        add(course);

        String Course[] = {"B.Tech","BCA","BBA","M.Tech","MBA","MCA","D.Pharma","B.Arch."};
        ccourse = new JComboBox(Course);
        ccourse.setBounds(200,180,150,20);
        ccourse.setBackground(Color.white);
        add(ccourse);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(40,220,150,20);
        branch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(branch);

        String Branch[] = {"none","CSE","CST","CSE-AI/ML","B.Tech (LEET)","CSE-DS","ME","ETCE","D.Pharma"};
        cbranch = new JComboBox(Branch);
        cbranch.setBounds(200,220,150,20);
        cbranch.setBackground(Color.white);
        add(cbranch);


        JLabel semester = new JLabel("Select Semester");
        semester.setBounds(40, 260, 150, 20);
        semester.setFont(new Font("Tahoma",Font.BOLD,16));
        add(semester);


        String semester1[] = {"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8","Semester9","Semester10"};
        cbsemsester = new JComboBox(semester1);
        cbsemsester.setBounds(200,260,150,20);
        cbsemsester.setBackground(Color.white);
        add(cbsemsester);

        JLabel total = new JLabel("Total Payable");
        total.setBounds(40,300,150,20);
        total.setFont(new Font("Tahoma",Font.BOLD,16));
        add(total);

        labeltotal = new JLabel();
        labeltotal.setBounds(200,300,500,20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labeltotal);

        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.black);
        update.setForeground(Color.red);
        update.addActionListener(this);
        update.setFont(new Font("SARIF",Font.BOLD,15));
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.black);
        pay.setForeground(Color.red);
        pay.addActionListener(this);
        pay.setFont(new Font("SARIF",Font.BOLD,15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.black);
        back.setForeground(Color.red);
        back.addActionListener(this);
        back.setFont(new Font("SARIF",Font.BOLD,15));
        add(back);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==update){
            String course = (String)ccourse.getSelectedItem();
            String semester = (String) cbsemsester.getSelectedItem();
            try{
                ConnectionJDBC c = new ConnectionJDBC();
                ResultSet rs = c.s.executeQuery("SELECT * FROM fee WHERE course = '"+course+"' ");
                while (rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource()==pay){
            String rollno = (String) crollno.getSelectedItem();
            String course = (String) ccourse.getSelectedItem();
            String semester = (String) cbsemsester.getSelectedItem();
            String branch = (String) cbranch.getSelectedItem();
            String total = labeltotal.getText();

            try{
                ConnectionJDBC c = new ConnectionJDBC();
                String query = "INSERT INTO collegefee VALUES ('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"College Fee Submitted Successfully.");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
