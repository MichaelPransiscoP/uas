/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import model.TODO;
import model.User;
public class ControllerDatabase {
    static DatabaseHandler conn = new DatabaseHandler();
   
    // SELECT WHERE 
    public static User getUser(String email) {
        conn.connect();
        String query = "SELECT * FROM User WHERE email='" + email + "'";
        User user = new User();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhoto(rs.getString("photo"));
                System.out.println("ini unamenya " + user.getName());
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return user;
    }
    
    public static TODO getTODO(int userId) {
        conn.connect();
        String query = "SELECT * FROM User WHERE userId='" + userId + "'";
        TODO todo = new TODO();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setNote(rs.getString("note"));
                todo.setUserId(rs.getInt("userId"));
                return todo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return todo;
    }
}
