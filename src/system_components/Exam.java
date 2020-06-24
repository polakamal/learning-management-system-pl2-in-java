/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_components;

import java.util.ArrayList;
import system_components.Question;

public class Exam {
 private int Exam_id;
 private String Exam_name;
 private  double Exam_Degree ;
 private  int  Exam_Max_Degree;
 private   double Exam_Pass_Precentage;
 private ArrayList<Question> questions;
   public Exam() {
    }
    public Exam(int Exam_id, String Exam_name, int Exam_Max_Degree) {
        this.Exam_id = Exam_id;
        this.Exam_name = Exam_name;
        this.Exam_Max_Degree = Exam_Max_Degree;
        this.questions = questions;
   
      
    }

    public Exam(int Exam_id, String Exam_name, int Exam_Degree, int Exam_Max_Degree) {
        this.Exam_id = Exam_id;
        this.Exam_name = Exam_name;
        this.Exam_Degree = Exam_Degree;
        this.Exam_Max_Degree = Exam_Max_Degree;
    }
   
    public int getExam_id() {
        return Exam_id;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setExam_id(int Exam_id) {
        this.Exam_id = Exam_id;
    }

    public String getExam_name() {
        return Exam_name;
    }

    public void setExam_name(String Exam_name) {
        this.Exam_name = Exam_name;
    }

    public int getExam_Max_Degree() {
        return Exam_Max_Degree;
    }

    public void setExam_Max_Degree(int Exam_Max_Degree) {
        this.Exam_Max_Degree = Exam_Max_Degree;
    }

 
    public double getExam_Degree() {
        return Exam_Degree;
    }

    public void setExam_Degree(double Exam_Degree) {
        this.Exam_Degree = Exam_Degree;
    }



}
