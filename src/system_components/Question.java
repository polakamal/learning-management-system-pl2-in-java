/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_components;

import java.util.ArrayList;

import DB.Connection_DB;
import gui.*;
import system_components.Exam;

/**
 *
 * @author pola
 */
public class Question {
 private  String Questions;
 private   String  Question_answer;
 private   int    exam_id;   
 private String  stu_answer;
 private int question_degree;
 private  int Question_id;

    public Question(String Questions, String Question_answer, int exam_id, String stu_answer, int question_degree, int Question_id) {
        this.Questions = Questions;
        this.Question_answer = Question_answer;
        this.exam_id = exam_id;
        this.stu_answer = stu_answer;
        this.question_degree = question_degree;
        this.Question_id = Question_id;
    }

    public Question() {
    }

    

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String Questions) {
        this.Questions = Questions;
    }

    public String getQuestion_answer() {
        return Question_answer;
    }

    public void setQuestion_answer(String Question_answer) {
        this.Question_answer = Question_answer;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getStu_answer() {
        return stu_answer;
    }

    public void setStu_answer(String stu_answer) {
        this.stu_answer = stu_answer;
    }

    public int getQuestion_degree() {
        return question_degree;
    }

    public void setQuestion_degree(int question_degree) {
        this.question_degree = question_degree;
    }

    public int getQuestion_id() {
        return Question_id;
    }

    public void setQuestion_id(int Question_id) {
        this.Question_id = Question_id;
    }

    public Question( int Question_id, String Questions) {
        this.Questions = Questions;
        this.Question_id = Question_id;
    }


   

   

 
public int correct_exam(Connection_DB c , int exam_id)
{ 
int grade = 0;
   int eid = exam_id;


   for (int i=0; i<c.get_answer(eid).size();i++ ){
    

      if(c.get_student_answer(eid).get(i).getStu_answer().equals(c.get_answer(eid).get(i).getQuestion_answer()))
  
{
    
    
    
  grade  =  grade +c.get_answer_grade(eid).get(i) ;
     

}


}
 return grade ;
}

   


}