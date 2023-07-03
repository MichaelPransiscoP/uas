/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.EnumMember;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CoffeeShop
 */
public class CustomerFunction {
    static DatabaseHandler conn = new DatabaseHandler();
    // SELECT WHERE
    public static Customer getCustomer(String email) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE email='" + email + "'";
        Customer cust = new Customer();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cust.setId(rs.getInt("id"));
                cust.setUsername(rs.getString("username"));
                cust.setPassword(rs.getString("password"));
                cust.setEmail(rs.getString("email"));
                cust.setAddress(rs.getString("address"));
                cust.setNoHp(rs.getString("noHp"));
                cust.setMember(EnumMember.valueOf(EnumMember.class, rs.getString("member").toUpperCase()));
                cust.setSaldo(rs.getInt("saldo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (cust);
    }
}
