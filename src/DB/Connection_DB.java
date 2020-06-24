package DB ;
import users.*;
import system_components.Exam;
import system_components.Question;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import users.user;
import gui.*;

public class Connection_DB {
     
private  Connection mycon = null;
  private  Statement mystat= null;
  private  ResultSet myres = null;
 private String  query ="";



  
        
public void SET_connection() {
        try {

         mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
 
              } 
        
catch (SQLException e) {
    e.printStackTrace();

            
            }
}
public ArrayList<user> show_users (){
   ArrayList<user> user_list = new ArrayList();
    try{
    this.query = "select * from user";


      this.mystat =  this.mycon.createStatement();
    this.myres = this.mystat.executeQuery(this.query);
  while (this.myres.next()) 
  {
      user user = new user(); 
  user.setId(this.myres.getInt("id"));
  user.setUsername(this.myres.getString("username"));
  user.setPassword(this.myres.getString("password"));
  user.setUsertype(this.myres.getString("usertype"));
 user_list.add(user);
  }
    
    }
    catch (SQLException e)
    {
    e.printStackTrace();
    }
    return user_list;
}

    public  void add_users(String username,String password,String usertype,int id) {                                         
        try{
            Statement add= mycon.createStatement();
             this.query="insert into  user(username,password,usertype,id) VALUES('"+username+"','"+password+"','"+usertype+"',"+id+")"; 
            add.execute(this.query);
        } catch (SQLException e) {
            e.printStackTrace();
          JOptionPane.showMessageDialog(null,"user name already used ","Error",JOptionPane.ERROR_MESSAGE);
        }  
}
   
 //-------------------------------------------------   
     public void delete_user(int id)
    {
        try {
            this.mystat= mycon.createStatement();
            this.query="delete from user where id="+id;
           this.mystat.executeUpdate(this.query);
           JOptionPane.showMessageDialog(null,"user deleted ","Done",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) 
        {
             JOptionPane.showMessageDialog(null,"deleting error","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    //-------------------------------------------------
    public void update_user(String username,String password,String usertype,int id )
    {
      try {
            Statement delete = mycon.createStatement();
            String sql="update user set username='"+username+"',password='"+password+"',usertype='"+usertype+"' where id ="+id;
            delete.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"user updated ","Done",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) 
        {
            
        }  
    
    }
    //-------------------------------------------------------------------------------------
    //mange courses -------- 
    
    public  void add_course(String coursename,int credithours ,String lecday, String lectime,int id) {                                         
        try{
           this.mystat = this.mycon.createStatement();
           this.query="insert into  courses(name,lec_day,lec_time,credit_hours,course_id) VALUES('"+coursename+"','"+lecday+"','"+lectime+"',"+credithours+","+id+")";      
           System.out.println(this.query);
           this.mystat.executeUpdate(this.query);
           JOptionPane.showMessageDialog(null,"course added ","Error",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,"course name already existed ","Error",JOptionPane.ERROR_MESSAGE);

        }  
}
    //----------------------------------------------------------
     
 
    public ArrayList<course> show_courses()
    {   
        ArrayList<course> course_list = new ArrayList();
        try {
            this.mystat   = mycon.createStatement();
             this.query = "select * from courses";
           this.myres= this.mystat.executeQuery(this.query);
            while (this.myres.next()) {
           course  c = new course();     
      c.setCoursename(this.myres.getString("name"));
        c.setLecday(this.myres.getString("lec_day"));
     c.setLectime(this.myres.getString("lec_time"));
     c.setCredithours(this.myres.getInt("credit_hours"));
      c.setId(this.myres.getInt("course_id"));
      course_list.add(c);
            
            }
         } 
        catch (SQLException ex) {
             ex.printStackTrace();
         }
        return course_list;
    }
    
    //----------------------------------------------------------
    public void delete_course(int id)
    {
        try {
            this.mystat= mycon.createStatement();
            this.query ="delete from courses where course_id="+id;
            
            this.mystat.executeUpdate(this.query);
            JOptionPane.showMessageDialog(null,"course Deleted ","Done",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) 
        {
           JOptionPane.showMessageDialog(null,"delete error ","Done",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    //-------------------------------------------------
    public void update_course(String coursename,String lecday,String lecime,int credithours,int id )
    {
      try {
           this.mystat= mycon.createStatement();
            this.query="update courses set name='"+coursename+"',lec_day='"+lecday+"',lec_time='"+lecime+"',credit_hours='"+credithours+"' where course_id ="+id;
            
            System.out.println(this.query);
            this.mystat.executeUpdate(this.query);
            JOptionPane.showMessageDialog(null,"update complete","Done",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }  
    
    }
    //-------------------------------------------------------------------------------------admin
public ArrayList<user> login(String username, String password) 
    {
        ArrayList<user> ulist = new ArrayList(); 
        try {
            
            
           this.query = "SELECT * FROM user Where username = '" + username + "' and  password = '" + password + "'";

            this.mystat = mycon.createStatement();
            PreparedStatement pre = null;
            
            this.myres = this.mystat.executeQuery("SELECT * FROM user ");
          
   
            while (this.myres.next()) {
         user user = new user(); 
                if (this.myres.getString("username").equals(username) && this.myres.getString("password").equals(password)) {
                 user.setId(this.myres.getInt("id"));
                    user.setUsertype(this.myres.getString("usertype"));
         ulist.add(user);
                }
            }
            pre = mycon.prepareStatement(this.query);
            this.myres = pre.executeQuery();
               
            } 
catch (SQLException ex) {
            
  

        }
      return ulist;
    }
    //-------------------------------------------------------------------------------------
public void register_course(int u_id ,int c_id, String c_name)
{
    try {
    this.mystat = mycon.createStatement();
             this.query="insert into  registered_courses(course_name,course_id,user_id) VALUES('"+ c_name+"',"+ c_id+","+u_id+")"; 
            
            this.mystat.execute(this.query);
    }
catch (SQLException e) {
            e.printStackTrace();
          JOptionPane.showMessageDialog(null," course already used ","Error",JOptionPane.ERROR_MESSAGE);
        }  


}
public void drop_course(int registered_id) 
{
     try {
this.mystat = mycon.createStatement();
             this.query = "delete from courses where course_id="+registered_id;
System.out.println(this.query);
this.mystat.execute(this.query);
     }
catch (SQLException e) {
            e.printStackTrace();

  }


}



public void Inster_Exam(Exam e) 
      
      {
     try{   
       int id =e.getExam_id();
       String name =e.getExam_name();
      int max_Degree =e.getExam_Max_Degree();
       this.query = "INSERT INTO exam VALUES("+id+",'"+0+"','"+max_Degree+"','"+name+"','"+0+"','"+0+"',"+0+")";  
     
        mystat =  mycon.createStatement();
       
    mystat.execute(this.query);
      
    
    
     }
     catch(SQLException i)
    {

    JOptionPane.showMessageDialog(null, "please check your enteries ","Error Message",JOptionPane.ERROR_MESSAGE);
  
    }
     
      }
   public void delete_exam(Exam e)
   {
       try{ 
           
      int id =e.getExam_id(); 
   this.query = "DELETE FROM exam WHERE exam_Id = '"+id+"'";
   
   mystat =  mycon.createStatement();
    mystat.execute(this.query);
   
       }
   catch(SQLException i)
    {

   i.printStackTrace();
  
    }
   
   }   
      public void update_Exam(Exam e) 
      
      {
     try{   
       int id =e.getExam_id();
       String name =e.getExam_name();
      int max_Degree =e.getExam_Max_Degree();
       this.query = " UPDATE exam SET max_degree ="+max_Degree+",exam_name = '"+name+"' WHERE exam_id ='"+id+"'"; 
     
        mystat =  mycon.createStatement();
    mystat.execute(this.query);
     }
     catch(SQLException i)
    {

   i.printStackTrace();
  
    }
     
      }
      
         public void inser_question(ArrayList<Question> q) 
      
      {
     try{   
        
       
      int exam_id =  q.get(0).getExam_id();
      for(int i=0;i<q.size();i++)   
      {
       this.query = "INSERT INTO questions VALUES("+exam_id+",'"+q.get(i).getQuestions()+"','"+q.get(i).getQuestion_answer()+"','"+q.get(i).getStu_answer()+"',"+q.get(i).getQuestion_degree()+","+q.get(i).getQuestion_id()+")";  
 
        mystat=  mycon.createStatement();
     this.mystat.executeUpdate(this.query);
      }
      }
     catch(SQLException i)
    {

   JOptionPane.showMessageDialog(null, "please check your enteries ","Error Message",JOptionPane.ERROR_MESSAGE);
  
    }
     
      }
     public ArrayList<Question> get_answer(int eid)
     {
           int exam_id;
      exam_id = eid;
         Question q;
          ArrayList<Question> answer = new ArrayList();
         
         try{ 
         this.query = "select exam_id,answer from questions where exam_id = " +exam_id ;
       
   
        mystat =  mycon.createStatement();
    this.myres = this.mystat.executeQuery(query);
  
    while (this.myres.next())     
    {
        
        q = new Question();
        q.setExam_id(this.myres.getInt("exam_id"));
        q.setQuestion_answer(this.myres.getString("answer"));
        answer.add(q);
     
    }
         }
    catch (Exception i)  
    {

   i.printStackTrace();
  
    }
      return answer;
     
     }
      public  ArrayList<Question>  get_student_answer(int eid)
     {
         int exam_id;
      exam_id = eid;
          Question q;
          ArrayList<Question> stud_answer = new ArrayList();
         
         try{ 
         this.query = "select u_answer,exam_id from questions where exam_id =" +exam_id ;
        
   
        mystat=  mycon.createStatement();
    this.myres = this.mystat.executeQuery(this.query);
    while (this.myres.next())     
    {
        
        q = new Question();
                       
     q.setStu_answer(this.myres.getString("u_answer")); 
        q.setExam_id(this.myres.getInt("exam_id"));
       stud_answer.add(q);
    }
     
         }
          catch(SQLException i)
    {

   i.printStackTrace();
  
    }
      return stud_answer;
     
     }
        
   
    public  ArrayList<Integer>  get_answer_grade(int exam_id)
     {
        int eid =exam_id;
          ArrayList<Integer> stud_answer_grade = new ArrayList();
         try{ 
         this.query = "select mark from questions where exam_id = " +eid;
        
   
        mystat=  mycon.createStatement();
    this.myres = this.mystat.executeQuery(this.query);
    while (this.myres.next())     
    {
     stud_answer_grade.add(myres.getInt("mark"));
    }
       return stud_answer_grade;
         }
          catch(SQLException i)
    {

   i.printStackTrace();
  
    }
      return null;
     
     } 
    public void add_exam_degree (ArrayList<Exam> e , int y)
    {
        try{ 
            int x = y;
            int exam_id = e.get(y).getExam_id();
             double degree = e.get(y).getExam_Degree();  
          this.query = "INSERT INTO degree VALUES = "+degree+" where EXAM_ID ="+exam_id+"";
       
     mystat=  mycon.createStatement();
   this.mystat.executeUpdate(this.query);
          }
     catch(SQLException i)
        {
        i.printStackTrace();
        }
    }
   public ArrayList<Exam> get_data()
           
   {
 
      ArrayList<Exam> exam = new ArrayList(); 
       try{ 
         this.query = "select * from exam";
         Exam e;
   
       this.mystat =  this.mycon.createStatement();
    this.myres = this.mystat.executeQuery(this.query);
  
    while (this.myres.next())     
    {
         e = new Exam (this.myres.getInt("Exam_id") ,this.myres.getString("Exam_name"),this.myres.getInt("mark") ,this.myres.getInt("max_degree") ); 
      exam.add(e);
    }
       
         }
          catch(SQLException i)
    {

   i.printStackTrace();
  
    }
   
     return exam;
     } 
 public int search_id(String exam_name)
 {

     int id = 0;
   
     String name = exam_name;

      try {
          this.query= "select exam_id from exam where exam_name = '"+name+"'";
            this.mystat =  this.mycon.createStatement();
           
       myres = this.mystat.executeQuery(this.query);
       while (this.myres.next()){
    id= this.myres.getInt("exam_id");
       }
   
      }
      catch (SQLException i) {
          i.printStackTrace();
      }
      return id;
 
 }  
       
   public ArrayList<Question> get_questions(int id_exam)
           {
     int id = id_exam; 
    ArrayList<Question> questions = new ArrayList();
    ArrayList<String> qu =  new ArrayList();
     ArrayList<Integer> id_q =  new ArrayList();
        
         try {
          this.query= "select question,question_id from questions where exam_id = "+id+"";
          System.out.println(this.query);
            this.mystat =  this.mycon.createStatement();
           
       myres = this.mystat.executeQuery(this.query);
       while (this.myres.next()){
          Question q = new Question();
           
         q.setQuestion_id(this.myres.getInt("question_id"));
          q.setQuestions(this.myres.getString("question"));
        questions.add(q);
       
       }
   
      }
      catch (SQLException i) {
          i.printStackTrace();
      }
      return questions;
 
 }      
           
        public  void set_student_answer(ArrayList<Question> u_answer )
     {
         
     ArrayList <Question> q = u_answer;
       
      try{ 
         for(int i =0; i<q.size();i++)    
         {
         this.query = " update questions set u_answer = '"+q.get(i).getStu_answer()+"' where question_id ="+q.get(i).getQuestion_id()+" ";
          this.mystat =  this.mycon.createStatement();
           this.mystat.executeUpdate(this.query);
         
         }
         
         }
     catch(SQLException i)
    {

   i.printStackTrace();
  
    }
     
     }
public int get_maxDegree(int id)
{

  int E_id = id;
   int max_degree =0;
     

      try {
          this.query= "select max_degree from exam where exam_id = '"+E_id+"'";
            this.mystat =  this.mycon.createStatement();
       myres = this.mystat.executeQuery(this.query);
       while (this.myres.next()){
    max_degree= this.myres.getInt("max_degree");
      
       }
   
      }
      catch (SQLException i) {
          i.printStackTrace();
          
      }
      return max_degree;
 
 }    

}  
