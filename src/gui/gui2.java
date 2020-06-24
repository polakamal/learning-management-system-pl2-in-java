/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import system_components.Question;
import system_components.Exam;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import DB.Connection_DB;
import javax.swing.JOptionPane;


public class gui2 extends JFrame {
    
    public gui2 (){
        
    view();
     
     
}
  public void view()
  {
      setLocation(600,300);
           
     setTitle("Questions");
     setSize(1000,750);
     JPanel p1 = new JPanel();
     p1.setLayout(null);
     this.add(p1,BorderLayout.CENTER);
     p1.setBackground(Color.DARK_GRAY);
     JLabel l2 = new JLabel("ExamName:");
     p1.add(l2);
     l2.setBounds(300,100,200,30);
     l2.setForeground(Color.LIGHT_GRAY);
     JLabel l1 = new JLabel("Please, Complete this Fields.....!!");
     p1.add(l1);
     l1.setBounds(300,150,200,30);
     l1.setForeground(Color.LIGHT_GRAY);
     JTextField t1 = new JTextField();
     p1.add(t1);
     t1.setBounds(400,100,200,30);
     //
     JLabel l3 = new JLabel("Q1:");
     p1.add(l3);
     l3.setBounds(300,200,200,30);
     l3.setForeground(Color.LIGHT_GRAY);
     JLabel l4 = new JLabel("Q2:");
     p1.add(l4);
     l4.setBounds(300,350,200,30);
     l4.setForeground(Color.LIGHT_GRAY);
     JLabel l5 = new JLabel("Q3:");
     p1.add(l5);
     l5.setBounds(300,500,200,30);
     l5.setForeground(Color.LIGHT_GRAY);
     //
     JTextField t2 = new JTextField();
     p1.add(t2);
     t2.setBounds(350,200,350,30);
     JTextField t3 = new JTextField();
     p1.add(t3);
     t3.setBounds(350,350,350,30);
     JTextField t4 = new JTextField();
     p1.add(t4);
     t4.setBounds(350,500,350,30);
     //
     JTextField t5 = new JTextField();
     p1.add(t5);
     t5.setBounds(350,250,350,80);
     JTextField t6 = new JTextField();
     p1.add(t6);
     t6.setBounds(350,400,350,80);
     JTextField t7 = new JTextField();
     p1.add(t7);
     t7.setBounds(350,550,350,80);
     //
     JLabel d = new JLabel("Degree");
     p1.add(d);
     d.setBounds(750,170,200,30);
     d.setForeground(Color.LIGHT_GRAY);
     //
     JTextField a1 = new JTextField();
     p1.add(a1);
     a1.setBounds(750,200,30,30);
     JTextField a2 = new JTextField();
     p1.add(a2);
     a2.setBounds(750,350,30,30);
     JTextField a3 = new JTextField();
     p1.add(a3);
     a3.setBounds(750,500,30,30);
     //
     JButton b = new JButton("ADD");
     p1.add(b);
     b.setBounds(480,640,100,50);
     b.setBackground(Color.LIGHT_GRAY);
     
ArrayList<Question> q =new ArrayList();
    
  b.addActionListener(
  new ActionListener ()
    {
        @Override
              public void actionPerformed(ActionEvent m) {
   Connection_DB c= new  Connection_DB();
    c.SET_connection();
  
String name = t1.getText().toString();

Question q1 = new Question();        
q1.setExam_id(c.search_id(name));
q1.setQuestions(t2.getText().toString());
q1.setQuestion_answer(t5.getText().toString());
q1.setQuestion_degree(Integer.parseInt(a1.getText().toString()));
 q.add(q1);
Question q2 = new Question();  
q2.setExam_id(c.search_id(name));
q2.setQuestions(t3.getText().toString());
q2.setQuestion_answer(t6.getText().toString());
q2.setQuestion_degree(Integer.parseInt(a2.getText().toString()));
 q.add(q2);
Question q3= new Question(); 
q3.setExam_id(c.search_id(name));
q3.setQuestions(t4.getText().toString());
q3.setQuestion_answer(t7.getText().toString());
q3.setQuestion_degree(Integer.parseInt(a3.getText().toString()));
 q.add(q3);
      
       c.inser_question(q);
       JOptionPane.showMessageDialog(null,"questions added","Done",JOptionPane.INFORMATION_MESSAGE);
              
              }
    }
  
  );
  
  
  
          
  
  }

}
     
   