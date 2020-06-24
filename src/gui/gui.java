/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import system_components.Exam;
import system_components.Question;
import system_components.Exam;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import DB.Connection_DB;


public class gui extends JFrame  {
    Connection_DB c= new  Connection_DB();
          Exam exam = new Exam();
      JButton b1;
      JButton b2;
      JButton b3;
      JTextField t1;
       JTextField t2;
       JTextField t3;
       JPanel p1;
        JLabel l1;
         JLabel l2;
          JLabel l3;
DefaultTableModel dtm ;
          JTable t;
    public gui ()
            {
                
       view();  
    
    
    }
 
      public void view()
      {
  
   setLocation(600,300);
           setTitle("EXAMS");
        setSize(1000,750);
         p1 = new JPanel();
        p1.setLayout(null);
        this.add(p1,BorderLayout.CENTER);
        p1.setBackground(Color.DARK_GRAY);
         b1 = new JButton("ADD");
        p1.add(b1);
        b1.setBounds(100, 600, 100, 50);
        b1.setBackground(Color.LIGHT_GRAY);
   
         b2 = new JButton("DELETE");
        p1.add(b2);
        b2.setBounds(300, 600, 100, 50);
        b2.setBackground(Color.LIGHT_GRAY);
         b3 = new JButton("UPDATE");
        p1.add(b3);
        b3.setBounds(500, 600, 100, 50);
        b3.setBackground(Color.LIGHT_GRAY);
          
        
        
        JButton b4 = new JButton("add exam qusetions");
        p1.add(b4);
        b4.setBounds(700, 600, 200, 50);
        b4.setBackground(Color.LIGHT_GRAY);
        
        
        
        
        //-------------------------------------------------------------------------------
         t1 = new JTextField();
        p1.add(t1);
        t1.setBounds(750, 200, 200, 35);
         t2 = new JTextField();
        p1.add(t2);
        t2.setBounds(750,300,200,35);
         t3 = new JTextField();
        p1.add(t3);
        t3.setBounds(750,400,200,35);
         l1 = new JLabel("ID :");
        p1.add(l1);
        l1.setBounds(650,200,150,35);
        l1.setForeground(Color.LIGHT_GRAY);
         l2 = new JLabel("ExamName :");
        p1.add(l2);
        l2.setBounds(650,300,150,35);
        l2.setForeground(Color.LIGHT_GRAY);
         l3 = new JLabel("max_degree :");
        p1.add(l3);
        l3.setBounds(650,400,150,35);
        l3.setForeground(Color.LIGHT_GRAY);
          t  = new JTable();
        JScrollPane js= new JScrollPane(t);
        p1.add(t);
         t.setBounds(0,60, 600, 400);
        p1.setLayout(new BorderLayout());
        p1.add(t,BorderLayout.PAGE_START);
        p1.add(t.getTableHeader(),BorderLayout.PAGE_START);
        
       
        
        int HEADER_HEIGHT = 60;
       t.getTableHeader().setPreferredSize(new Dimension (1000,HEADER_HEIGHT));
       dtm=(DefaultTableModel)t.getModel();
       
        dtm.addColumn("id");
        dtm.addColumn("name");
        dtm.addColumn("degree");
        dtm.addColumn("exam_max_degree");
         c= new  Connection_DB();
           exam = new Exam();
        c.SET_connection();
         c.get_data();
          ArrayList<Exam> e = c.get_data();
          Object[] row = new Object[4];
       
         for( int i=0;i< e.size();i++ )
          {
     
   row[0]= e.get(i).getExam_id();
   row[1]= e.get(i).getExam_name();
   row[2]=e.get(i).getExam_Degree();
   row[3]= e.get(i).getExam_Max_Degree();
     
   dtm.addRow(row);
          
          
          }
           t.addMouseListener(
          new MouseListener()
          {
    

               @Override
               public void mouseClicked(MouseEvent e) {
                int p =  t.getSelectedRow();
            TableModel dmt = t.getModel();   
                    t1.setText(dtm.getValueAt(p, 0).toString());
                  t2.setText(dtm.getValueAt(p, 1).toString());
                  t3.setText(dtm.getValueAt(p, 3).toString());
               }

               @Override
               public void mousePressed(MouseEvent e) {
                   //To change body of generated methods, choose Tools | Templates.
               }

               @Override
               public void mouseReleased(MouseEvent e) {
                    //To change body of generated methods, choose Tools | Templates.
               }

               @Override
               public void mouseEntered(MouseEvent e) {
                  //To change body of generated methods, choose Tools | Templates.
               }

               @Override
               public void mouseExited(MouseEvent e) {
                   //To change body of generated methods, choose Tools | Templates.
               }
          

   
      
    });
          
           
           b1.addActionListener( new ActionListener ()
    {
        @Override
              public void actionPerformed(ActionEvent m) {
           Exam exam1 = new Exam();
               
                exam1.setExam_id(Integer.parseInt(t1.getText()));
             //    System.out.println(t1.getText());
                
             exam1.setExam_name(t2.getText());
           //  System.out.println(t2.getText());
             exam1.setExam_Max_Degree(Integer.parseInt(t3.getText()));
            // System.out.println(t3.getText());
            c.Inster_Exam(exam1);
           gui x= new gui();
         
         Object[] row = new Object[4];
                  
         row[0]= Integer.parseInt(t1.getText());
         row[1]= t2.getText();
         row[2]=0.0;
         row[3]= Integer.parseInt(t3.getText());
     
         dtm.addRow(row);
     
      
              }
    
    }
    );
          
          
        b2.addActionListener(
        new ActionListener ()
    {
        @Override
              public void actionPerformed(ActionEvent m) {
                  int v = Integer.parseInt(t1.getText());
                  exam.setExam_id(v);
          c.delete_exam(exam);
             gui x= new gui();
             dtm.removeRow(t.getSelectedRow());
              }
    
    }
        
        
        ); 
        
         b3.addActionListener(
        new ActionListener ()
    {
        @Override
              public void actionPerformed(ActionEvent m) {
                  int v = Integer.parseInt(t1.getText());
                  int i = Integer.parseInt(t3.getText());
                  exam.setExam_id(v);
                  exam.setExam_name(t2.getText().toString());
                  exam.setExam_Max_Degree(i);
                  c.update_Exam(exam);
                  
                if (dtm.getRowCount() > 0) {
          for (int x = dtm.getRowCount() - 1; x > -1; x--) {
        dtm.removeRow(x);
    }
}
                  c= new  Connection_DB();
           exam = new Exam();
        c.SET_connection();
         c.get_data();
          ArrayList<Exam> e = c.get_data();
          Object[] row = new Object[4];
       
         for( int x=0;x< e.size();x++ )
          {
     
   row[0]= e.get(x).getExam_id();
   row[1]= e.get(x).getExam_name();
   row[2]=e.get(x).getExam_Degree();
   row[3]= e.get(x).getExam_Max_Degree();
     
   dtm.addRow(row);
          
          
          }
             
              }
    
    }
        
        
        ); 
         
         
         
         
           b4.addActionListener(
        new ActionListener ()
    {
        @Override
              public void actionPerformed(ActionEvent m) {
                  gui2 addquestions =new gui2();
                  addquestions.setVisible(true);
                  
              }
    
    });

          }

  
      
              }

    

     