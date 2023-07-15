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
import javax.swing.JOptionPane;
import Model.EnumMember;
import Model.SingletonUserManager;
import Model.Store;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                System.out.println("ini unamenya " + cust.getUsername());
                String mem = rs.getString("member");
                System.out.println("ini apa" + mem);
                cust.setMember(EnumMember.valueOf(mem));
                cust.setSaldo(rs.getInt("saldo"));
                return cust;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return cust;
    }

    public static ArrayList<Customer> getCustomersList(){
        conn.connect();
        String query = "SELECT * FROM customer";
        ArrayList<Customer> custs = new ArrayList<Customer>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Customer temp = new Customer();
                temp.setId(rs.getInt("id"));
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setEmail(rs.getString("email"));
                temp.setAddress(rs.getString("address"));
                temp.setNoHp(rs.getString("noHp"));
                temp.setMember(EnumMember.valueOf(rs.getString("member")));
                temp.setSaldo(rs.getInt("saldo"));
                custs.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return custs;
    }

    public static boolean register(String username, String password, String email, String address, String noHp) {
        conn.connect();

        String sql = "SELECT COUNT(*) AS count FROM customer WHERE email = ?";
        PreparedStatement statement;
        int count = 0;
        try {
            statement = conn.con.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            count = resultSet.getInt("count");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (count > 0) {
            System.out.println("aha");
            return false;
        } else {
            String query = "Insert INTO customer (username,password,email,address,nohp, member, saldo) VALUES(?,?,?,?,?,?,?)";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, email);
                stmt.setString(4, address);
                stmt.setString(5, noHp);
                EnumMember enumIn = EnumMember.ISNOTMEMBER;
                stmt.setString(6, enumIn.name());
                stmt.setInt(7, 100000);

                stmt.executeUpdate();
                Customer cs = new Customer(username, password, email, address, EnumMember.ISNOTMEMBER, noHp, 100000);
                SingletonUserManager.getInstance().setUser(cs);

                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        }

    }

    // UPDATE Customer
    public static boolean updateCustomer(Customer cust, String addressBaru) {
        conn.connect();
        String query = "UPDATE customer SET address='" + addressBaru + "' "
                + "WHERE email='" + cust.getEmail() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean updateMembership(Customer cust){
        conn.connect();
        String query = "UPDATE customer SET member='" + EnumMember.ISMEMBER + "' "
                + "WHERE email='" + cust.getEmail() + "'";
         try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

}
