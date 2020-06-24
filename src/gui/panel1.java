/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import system_components.Question;
import system_components.Exam;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import DB.Connection_DB;
import system_components.Exam;
import system_components.Question;

/**
 *
 * @author pola
 */
   public class panel1 extends JPanel {
 
    private final Question q = new Question();;
       private final Connection_DB b=new Connection_DB(); 
     
   private  JLabel t2;
   private   JLabel t3;
    private   JLabel t4;
   private    JTextArea t5;
   private    JTextArea t6;
    private   JTextArea t7;
    JButton b2;
               
    public panel1 (){
       
     view();
     
    }
    public void view()
    {
       setSize(700,600);
        setLayout(null);
        JLabel l1 = new JLabel("Please, Complete this Fields.....!!");
        add(l1);
        l1.setBounds(150,50,200,30);
        //
        JLabel l3 = new JLabel("Q1:");
        add(l3);
        l3.setBounds(150,100,200,30);
        JLabel l4 = new JLabel("Q2:");
        add(l4);
        l4.setBounds(150,250,200,30);
        JLabel l5 = new JLabel("Q3:");
        add(l5);
        l5.setBounds(150,400,200,30);
       //
       t2 = new JLabel();
        add(t2);
        t2.setBounds(200,100,350,30);
         t3 = new JLabel();
        add(t3);
        t3.setBounds(200,250,350,30);
        t4 = new JLabel();
        add(t4);
        t4.setBounds(200,400,350,30);
       //
         t5 = new JTextArea();
        add(t5);
        t5.setBounds(200,150,350,80);
         t6 = new JTextArea();
        add(t6);
        t6.setBounds(200,300,350,80);
         t7 = new JTextArea();
        add(t7);
        t7.setBounds(200,450,350,80);
       //
         b2 = new JButton("Correct");
        add(b2);
        b2.setBounds(320,540,100,50);
        b2.setBackground(Color.ORANGE);
    }
    public void set_id(int id)
    {
    
     this.q.setExam_id(id);
    
    }
    
   public void set_question()
   {   
 
    b.SET_connection();
   int  id =q.getExam_id();
int max_degree = b.get_maxDegree(id) ;
   ArrayList <Question> qu = new ArrayList();
qu = b.get_questions(id);

t2.setText(qu.get(0).getQuestions());
t3.setText(qu.get(1).getQuestions());
t4.setText(qu.get(2).getQuestions());
int id1 =qu.get(0).getQuestion_id();
int id2 =qu.get(1).getQuestion_id();
int id3 =qu.get(2).getQuestion_id();

 b2.addActionListener(
  new ActionListener ()
    {
        @Override
              public void actionPerformed(ActionEvent m) {

ArrayList<Question> stu_ans = new ArrayList(); 
Question q1= new Question();
q1.setQuestion_id(id1);
q1.setStu_answer(t5.getText());
stu_ans.add(q1);
Question q2= new Question();
q2.setQuestion_id(id2);
q2.setStu_answer(t6.getText());
stu_ans.add(q2);
Question q3 = new Question();
q3.setQuestion_id(id3);
q3.setStu_answer(t7.getText());
stu_ans.add(q3);

b.set_student_answer(stu_ans);
 int degree = q.correct_exam(b,q.getExam_id());
 JOptionPane.showMessageDialog(null, "ur degree is "+degree+"/"+max_degree+"","mark exam",JOptionPane.INFORMATION_MESSAGE);

              }
              });
   
 
   }   
    

   }