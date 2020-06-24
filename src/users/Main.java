
package users;


import gui.*;
import java.sql.Statement;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import gui.Admin_dashboard;
import gui.studentpage;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    public static void main(String[] args) throws MalformedURLException, SQLException {
         /*Admin_users admin =new Admin_users();
         admin.setVisible(true);*/
         
       login_view_gui l=new login_view_gui();
       l.setVisible(true);
        /* Admin_dashboard admin =new Admin_dashboard();
         admin.setVisible(true); }*/
    
}
}
