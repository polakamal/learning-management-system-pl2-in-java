
package users;

import DB.Connection_DB;
import gui.login_view_gui;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;


public class student extends user
{
     private final Connection_DB db;
    private course c;
     public student()
   {
   super();
        this.c = new course();
   db = new Connection_DB();
   } 
    
  
    public ArrayList<course> show_courses()
    {  
    return c.show_courses();
          
    }
     
    public void register_course(student s, course c)
   {
   db.SET_connection();
  
   
   db.register_course(s.getId(), c.getId(),c.getCoursename());
    
    
    }
 
   public void drop_course(course c)
   {
    db.SET_connection();
  
   db.drop_course(c.getId());
   
   }
    
}
