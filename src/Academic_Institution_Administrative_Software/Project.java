package Academic_Institution_Administrative_Software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener{

    Project(){
        setSize(1540,850);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/saitm.png"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.blue);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        newInformation.add(studentInfo);

        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.red);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.white);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.white);
        details.add(studentdetails);

        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.blue);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.white);
        leave.add(studentleave);

        //Leave Details
        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.red);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.white);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.white);
        leavedetails.add(studentleavedetails);

        //Exam
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.blue);
        mb.add(exam);

        JMenuItem examinationdetails = new JMenuItem("Examination Details");
        examinationdetails.setBackground(Color.white);
        exam.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.white);
        exam.add(entermarks);

        //UpdateInfo
        JMenu updateinfo = new JMenu("Update Details");
        updateinfo.setForeground(Color.red);
        mb.add(updateinfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.white);
        updateinfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.white);
        updateinfo.add(updatestudentinfo);

        //Fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.blue);
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.white);
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.white);
        fee.add(feeform);

        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.red);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        utility.add(calc);


        //Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.blue);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);


        setJMenuBar(mb);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){


    }

    public static void main(String[] args) {
        new Project();
    }
}


