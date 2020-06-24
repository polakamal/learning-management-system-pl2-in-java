/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import DB.Connection_DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.util.ArrayList;


/**
 *
 * @author lap
 */
public  class user {
    private  int id ;
    private  String username;
    private  String password;
    private  String usertype ;
    private static Connection_DB db;

    public user() {
        db= new Connection_DB(); 
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }    
    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getUsertype() {
        return usertype;
    }   
public static ArrayList<user> login(user u) {
db.SET_connection();
return db.login(u.getUsername(), u.getPassword());
}



}
