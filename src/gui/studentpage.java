
package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import users.course;
import users.student;
import users.user;


public class studentpage  extends JFrame{
    ArrayList <course> u;
    public studentpage() throws MalformedURLException {
        setLocation(600,300);
        student s=new student();
         user l = new user();
       u = new ArrayList();
       
        setSize(650, 650);
        setTitle("Student Page");
        Container cp = getContentPane();
      

        //button
        JButton exam = new JButton("Exams");
        cp.add(exam);
        exam.setBounds(30, 460, 220, 40);
        exam.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton drop = new JButton(" Drop Course");
        cp.add(drop);
        drop.setBounds(350, 460, 210, 40);
        drop.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton add = new JButton("Add Course");
        cp.add(add);
        add.setBounds(200, 510, 210, 40);
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        
        
        //label
        JLabel l1 = new JLabel("Courae Name :");
        cp.add(l1);
        l1.setBounds(40, 310, 150, 50);
        l1.setFont(new Font("Arial", Font.PLAIN, 20));
       
        /*JLabel l2 = new JLabel("Time");
        cp.add(l2);
        l2.setBounds(350, 310, 100, 50);
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel l3 = new JLabel("Lecture");
        cp.add(l3);
        l3.setBounds(40, 370, 100, 50);
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel l4 = new JLabel("Time");
        cp.add(l4);
        l4.setBounds(350, 370, 100, 50);
        l4.setFont(new Font("Arial", Font.PLAIN, 20));*/
        
        
        //JTextField
        JTextField CourseName = new JTextField();
        cp.add(CourseName);
        CourseName.setBounds(190, 315, 180, 40);
        CourseName.setFont(new Font("Arial", Font.PLAIN, 20));
        
        
        
        
        //line label
        JLabel line2 = new JLabel("_____________________________________________________");
        cp.add(line2);
        line2.setBounds(20, 410,1000, 50);
        line2.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel line3 = new JLabel("_____________________________________________________");
        cp.add(line3);
        line3.setBounds(20, 255, 1000, 50);
        line3.setFont(new Font("Arial", Font.PLAIN, 20));

        //table
        final DefaultTableModel dtm = new DefaultTableModel();
        Object[][] data = {};
        final JTable table = new JTable();
        table.setModel(dtm);
        cp.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBounds(0, 43, 650, 230);
        cp.setLayout(new BorderLayout());
        cp.add(table, BorderLayout.PAGE_START);
        cp.add(table.getTableHeader(), BorderLayout.PAGE_START);
        table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 20));
        int HEADER_HEIGHT = 42;
        table.getTableHeader().setPreferredSize(new Dimension(10000, HEADER_HEIGHT));
        dtm.addColumn("Course Name");
        dtm.addColumn("Lec Day");
        dtm.addColumn("Time");
         dtm.addColumn("Credit Hours ");
       
       course c = new course();
        u = s.show_courses();
       
        Object[] row = new Object[4];
       
        for( int i=0;i< u.size();i++ )
          {
     row[0]= u.get(i).getCoursename();
  row[1]= u.get(i).getLecday();
    row[2]     =u.get(i).getLectime();
   row[3]=  u.get(i).getCredithours();
   
   dtm.addRow(row);
          
          
          }
          table.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    int i = table.getSelectedRow();
                    CourseName.setText(dtm.getValueAt(i,0).toString());
                }
            });
add.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                 c.setCoursename(CourseName.getText());
                  
                    for (course u1 : u) {
                        if (u1.getCoursename().equals(c.getCoursename())) {
                            c.setId(u1.getId());
                        }
                    }
     
                int log_id =login_view_gui.getId();
                    s.setId(log_id);
                    s.register_course(s, c);  
                } 


   }); 
drop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
      c.setCoursename(CourseName.getText());
                  
                    for (course u1 : u) {
                        if (u1.getCoursename().equals(c.getCoursename())) {
                            c.setId(u1.getId());
                        }
                    }
        s.drop_course(c);
                
            }
        });
exam.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gui3 exams =new gui3();
                exams.setVisible(true);
            }
        });

   }
}
