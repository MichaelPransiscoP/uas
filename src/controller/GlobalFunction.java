/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.User;
import static controller.ControllerDatabase.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GlobalFunction {

    //Function Login
    public static User checkEmailPassLogin(String email, String pass) {
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            String query = "SELECT * FROM user WHERE email='" + email + "' AND password='" + pass + "'";
            String nameQuery = "user";

            for (int i = 1; i <= 2; i++) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    if (nameQuery.equals("user")) {
                        User user = new User();
                        user.setId(rs.getInt("id"));
                        user.setName(rs.getString("username"));
                        user.setEmail(rs.getString("email"));
                        user.setPassword(rs.getString("password"));
                        user.setGender(rs.getInt("gender"));
                        user.setBirthday(rs.getDate(""));
                        user.setPhoto(rs.getString("photo"));
                        System.out.println("ini unamenya " + user.getName());
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,
                "User not founds. Try again.",
                "Error Message",
                JOptionPane.ERROR_MESSAGE);
        return null;
    }

}
