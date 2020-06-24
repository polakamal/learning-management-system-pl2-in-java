/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import DB.Connection_DB;

    
public class gui3 extends JFrame {
      
     
    public gui3() {
 view();
 
             }

        public void view(){
     setLocation(600,300);
     setTitle("Correct");
     setSize(1000,750);
     setLayout(new BorderLayout());
     JLabel p1 = new JLabel(new ImageIcon("C:\\Users\\pola\\Documents\\NetBeansProjects\\Project\\background.JPG"));
     add(p1);
     p1.setLayout(null);
     JButton b1 = new JButton("Search");
     p1.add(b1);
     b1.setBounds(600,50,100,30);
     b1.setBackground(Color.LIGHT_GRAY);
     JTextField t1 = new JTextField();
     p1.add(t1);
     t1.setBounds(350,50,250,30);
     JPanel p2 = new JPanel();
     p1.add(p2);
     p2.setBounds(150,100,700,600);
     p2.setBackground(Color.white);

     panel1 p3 = new panel1();
     p2.setLayout(null);
     GridBagConstraints c = new GridBagConstraints();
     c.gridx = 0;
     c.gridy = 0;
     p2.add(p3, c);
     p3.setVisible(false);
      Connection_DB b; 
        b= new Connection_DB();
         b.SET_connection();
         
         
     b1.addActionListener( new ActionListener(){
 
            
       @Override
         public void actionPerformed(ActionEvent ae){
        
              try
           { 
               int id=0;
               String name  = t1.getText();
                  id  =   b.search_id(name);
              
           if (id != 0){
              
            p3.setVisible(true);
     p3.set_id(id);
     p3.set_question();
   
            
     }
   else  JOptionPane.showMessageDialog(null, "Not Found","Error Message",JOptionPane.INFORMATION_MESSAGE);
             
           } 
             
             catch(Exception e) 
             {
              e.printStackTrace();
         
        } 
         }
      
           
         });
           
}
      


}
             