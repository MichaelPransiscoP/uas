package Controller;

import Model.Admin;
import Model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminFunction {
    static DatabaseHandler conn = new DatabaseHandler();
    public static boolean hapusCustomer(String customerEmail){
        conn.connect();
        String query = "DELETE FROM customer WHERE email='" + customerEmail + "'";
        try{
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
