/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import DB.Connection_DB;
import java.util.ArrayList;

/**
 *
 * @author pola
 */
public class course {
    
 private   String coursename;
 private   int credithours ;
 private   String lecday ;
  private  String lectime;
private final Connection_DB db;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
int id;

    public course() {
        this.db = new Connection_DB();
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCredithours() {
        return credithours;
    }

    public void setCredithours(int credithours) {
        this.credithours = credithours;
    }

    public String getLecday() {
        return lecday;
    }

    public void setLecday(String lecday) {
        this.lecday = lecday;
    }

    public String getLectime() {
        return lectime;
    }

    public void setLectime(String lectime) {
        this.lectime = lectime;
    }
    
     public  void add_course(course c)
     {
     db.SET_connection();
     db.add_course(c.getCoursename() , c.getCredithours(), c.getLecday(), c.getLectime(),c.getId());
    }//name,lec_day,lec_time,credit_hours,course_id
     public  void  update_course(course c)
     {
     db.SET_connection();
     db.update_course(c.getCoursename(), c.getLecday(),c.getLectime(),c.getCredithours(),c.getId());
    }
     public  void  delete_course(course c)
     {
     db.SET_connection();
     db.delete_course(c.getId());
    }
    public ArrayList<course> show_courses(){
  db.SET_connection();  
 return db.show_courses();
 
  }
       
}
