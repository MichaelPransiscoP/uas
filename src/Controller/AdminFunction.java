package Controller;

import Model.Admin;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminFunction {
    static DatabaseHandler conn = new DatabaseHandler();
    public static void hapusCustomer(String username){
        conn.connect();
        String query = "DELETE FROM customer WHERE username='" + username + "'";
        try{
            Statement stmt = conn.con.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
