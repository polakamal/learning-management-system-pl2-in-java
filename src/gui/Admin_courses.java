/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import users.Admin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import users.course;


/**
 *
 * @author lap
 */
public class Admin_courses extends JFrame   {
    public Admin_courses(){
        Admin a =new Admin();
      setSize(650, 550);
        setTitle("courses Managment ");
        setLocation(600,300);
        Container cp = getContentPane();
        cp.setLayout(null);

        
       
        //label
        
        JLabel coursename = new JLabel("Course Name");
        cp.add(coursename);
        coursename.setBounds(20,285, 100, 40);
        coursename.setFont(new Font("Arial", Font.PLAIN, 16) );
        JLabel id = new JLabel("ID");
        cp.add(id);
        id.setBounds(200, 285, 100, 40);
        id.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel credithours = new JLabel("Credit Hours");
        cp.add(credithours);
        credithours.setBounds(270, 285, 100, 40);
        credithours.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel lectime = new JLabel("lecday");
        cp.add(lectime);
        lectime.setBounds(400, 285, 80, 40);
        lectime.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel lecday = new JLabel("lectime");
        cp.add(lecday);
        lecday.setBounds(500, 285, 80, 40);
        lecday.setFont(new Font("Arial", Font.PLAIN, 16));

        //line label
        JLabel line2 = new JLabel("_____________________________________________________");
        cp.add(line2);
        line2.setBounds(20, 330,1000, 50);
        line2.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel line3 = new JLabel("_____________________________________________________");
        cp.add(line3);
        line3.setBounds(20, 255, 1000, 50);
        line3.setFont(new Font("Arial", Font.PLAIN, 20));

        //taxt field
        //1
         JTextField cname = new JTextField();
        cp.add(cname);
        cname.setBounds(20, 315, 80, 40);
        cname.setFont(new Font("Arial", Font.PLAIN, 20));
        //2
         JTextField cid = new JTextField();
        cp.add(cid);
       cid.setBounds(170, 315, 80, 40);
       cid.setFont(new Font("Arial", Font.PLAIN, 20));
       //3
        JTextField chours = new JTextField();
        cp.add(chours);
        chours.setBounds(270, 315, 80, 40);
        chours.setFont(new Font("Arial", Font.PLAIN, 20));
        //4
        JTextField lday = new JTextField();
        cp.add(lday);
        lday.setBounds(400, 315, 80, 40);
        lday.setFont(new Font("Arial", Font.PLAIN, 20));
        //5
        JTextField ltime = new JTextField();
        cp.add(ltime);
        ltime.setBounds(500, 315, 80, 40);
        ltime.setFont(new Font("Arial", Font.PLAIN, 20));
        
         //buttons-----------
         //1
        JButton addcourse = new JButton("Add Course");
        cp.add(addcourse);
       addcourse.setBounds(5, 420, 170, 40);
       addcourse.setFont(new Font("Arial", Font.PLAIN, 20) );
         
        //----------------------------------------------------------
        
        
        
        JButton delcourse = new JButton("Delet Course");
        cp.add(delcourse);
        delcourse.setBounds(190, 420, 200, 40);
        delcourse.setFont(new Font("Arial", Font.PLAIN, 20));
        
        //----------------------------------------------------------------
        
        
        
        JButton updatecourse = new JButton("Update course");
        cp.add(updatecourse);
        updatecourse.setBounds(410, 420, 210, 40);
        updatecourse.setFont(new Font("Arial", Font.PLAIN, 20));
        
        //--------------------------------------------------------------


        //table
         DefaultTableModel dtm = new DefaultTableModel();
        String[] columnNames = {"name",
            "lec_day","lec_time","credit_hours","course_id"};
        Object[][] data = {};
        final JTable table = new JTable(data, columnNames);
        table.setModel(dtm);
        cp.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBounds(0, 42, 650, 230);
        cp.setLayout(new BorderLayout());
        cp.add(table, BorderLayout.PAGE_START);
        cp.add(table.getTableHeader(), BorderLayout.PAGE_START);
        table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 20));
        int HEADER_HEIGHT = 42;
        table.getTableHeader().setPreferredSize(new Dimension(1000, HEADER_HEIGHT));
        dtm.addColumn("name");
        dtm.addColumn("lec_day");
        dtm.addColumn("lec _time");
        dtm.addColumn("credit_hours");
        dtm.addColumn("course_id");
       course c = new course();
       ArrayList<course> course_list = c.show_courses();
        Object[] row = new Object[5];
       
        for( int i=0;i< course_list.size();i++ )
          {
     row[0]= course_list.get(i).getCoursename();
  row[1]= course_list.get(i).getLecday();
    row[2]     =course_list.get(i).getLectime();
   row[3]=  course_list.get(i).getCredithours();
   row[4] = course_list.get(i).getId();
     
   dtm.addRow(row);
          
          
          }
      
        table.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    int i = table.getSelectedRow();
                    chours.setText(dtm.getValueAt(i, 3).toString());
                   cid.setText(dtm.getValueAt(i, 4).toString());
                    cname.setText(dtm.getValueAt(i, 0).toString());
                    ltime.setText(dtm.getValueAt(i,2 ).toString());
                     lday.setText(dtm.getValueAt(i, 1).toString());
                }
            });
/*
            updatecourse.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    int i = table.getSelectedRow();
                    if (i >= 0) {
                        dtm.setValueAt(cname.getText(), i, 0);
                        dtm.setValueAt(cid.getText(), i, 4);
                        dtm.setValueAt(chours.getText(), i, 3);
                        dtm.setValueAt(ltime.getText().f, i, 2);
                        dtm.setValueAt(lday.getText(), i, 1);
                    }
                }

            });
            
            */
            
            //action of button add
           addcourse.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {          
           
           course n_c = new course ();
           n_c.setCoursename(cname.getText());
           n_c.setCredithours(Integer.parseInt(chours.getText()));
           n_c.setId(Integer.parseInt(cid.getText()));
           n_c.setLecday(lday.getText());
           n_c.setLectime(ltime.getText());
           c.add_course(n_c);
            clear_table(dtm);
            ArrayList<course> course_list = c.show_courses();
           for( int i=0;i< course_list.size();i++ )
          {
     row[0]= course_list.get(i).getCoursename();
  row[1]= course_list.get(i).getLecday();
    row[2]     =course_list.get(i).getLectime();
   row[3]=  course_list.get(i).getCredithours();
   row[4] = course_list.get(i).getId();
     
   dtm.addRow(row);
          
          
          }
          
        } 
        });
            
            //----------------------
            //action of del user
             delcourse.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {
            clear_table(dtm);
            c.setId(Integer.parseInt(cid.getText()));
            c.delete_course(c);  
              ArrayList<course> course_list = c.show_courses();
         dtm.removeRow(table.getSelectedRow());
          
         
        } 
        });
             
             //---------------------------
             //action of updatedate course
              updatecourse.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {
            c.setCoursename(cname.getText());
           c.setCredithours(Integer.parseInt(chours.getText()));
           c.setId(Integer.parseInt(cid.getText()));
           c.setLecday(lday.getText());
           c.setLectime(ltime.getText());
           c.update_course(c);
            clear_table(dtm);
            ArrayList<course> course_list = c.show_courses();
             for( int i=0;i< course_list.size();i++ )
          {
     row[0]= course_list.get(i).getCoursename();
  row[1]= course_list.get(i).getLecday();
    row[2]     =course_list.get(i).getLectime();
   row[3]=  course_list.get(i).getCredithours();
   row[4] = course_list.get(i).getId();
     
   dtm.addRow(row);
          
          
          }
          
        } 
        });
              
        }
    
    public void clear_table(DefaultTableModel dtm)
    {
         int rowCount = dtm.getRowCount();

             for (int i = rowCount - 1; i >= 0; i--) 
             {
                dtm.removeRow(i);
             }
    }
    
    
}
