
package users;

import DB.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public   class  Admin extends user{
   private final Connection_DB db; 
   public Admin()
   {
   super();
      db= new Connection_DB(); 
   } 
  public void add_user(Admin a)
  {
   db.SET_connection();  
   
 db.add_users(a.getUsername(),a.getPassword(),a.getUsertype(),a.getId());
  }
   public void update_user(Admin a)
  {
   db.SET_connection();  
  
 db.update_user(a.getUsername(),a.getPassword(),a.getUsertype(),a.getId());
  }
   public void delete_user(Admin a)
  {
   db.SET_connection();  
   
 db.delete_user(a.getId());
  }
   
  public ArrayList<user> show_user(){
  db.SET_connection();  
 return db.show_users();
 
  }
  
}
