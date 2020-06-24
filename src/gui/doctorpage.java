/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class doctorpage extends  JFrame
{

    public doctorpage()  {
 
         setSize(650, 550);
         setTitle("Doctor page ");
         setLocation(600,300);
         Container dp = getContentPane();
         dp.setLayout(null);
         JButton exam = new JButton("Exam");
         dp.add(exam);
         exam.setBounds(300,200, 200, 40);
        exam.setFont(new Font("Arial", Font.PLAIN, 20) );
        
        exam.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
                    
        {
            gui manageexams=new  gui();
            manageexams.setVisible(true);
        } 
        });
        
        
        
        
        //-----------------------------------------------------------
         
     }
    
}
