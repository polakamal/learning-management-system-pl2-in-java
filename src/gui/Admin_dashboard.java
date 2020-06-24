
package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;



public class Admin_dashboard extends  JFrame
{

    public Admin_dashboard()  {
 
         setSize(650, 550);
         setTitle("Admin Dashboard");
         setLocation(600,300);
         Container dp = getContentPane();
         dp.setLayout(null);
         JButton manageusers = new JButton("Manage Users");
         dp.add(manageusers);
         manageusers.setBounds(50,200, 200, 40);
        manageusers.setFont(new Font("Arial", Font.PLAIN, 20) );
        
        manageusers.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {
            Admin_users showusers=new  Admin_users();
            showusers.setVisible(true);
        } 
        });
        
        
        
        
        //--------------------------------------------------------------
        
        
        
          JButton managecourses = new JButton("Manage Courses");
         dp.add(managecourses);
        managecourses.setBounds(375,200, 200, 40);
        managecourses.setFont(new Font("Arial", Font.PLAIN, 20) );
        managecourses.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {
            Admin_courses showcourses=new  Admin_courses();
            showcourses.setVisible(true);
 
                     
        } 
        });
        
    
         
         
         
         
         
     }
    
}
