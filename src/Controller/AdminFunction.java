package Controller;

import static Controller.CustomerFunction.conn;
import Model.Admin;
import Model.Item;
import Model.EnumCheckItem;
import Model.EnumMember;
import Model.SingletonUserManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminFunction {

    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean hapusCustomer(String customerEmail) {
        conn.connect();
        String query = "DELETE FROM customer WHERE email='" + customerEmail + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean AddMakananMinuman(String name, String harga, String deskripsi) {
        conn.connect();
        String query = "Insert INTO item (name,price,desc,availability) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, harga);
            stmt.setString(3, deskripsi);
            EnumCheckItem enumIn = EnumCheckItem.NOTAVAILABLE;
            stmt.setString(4, enumIn.name());

            stmt.executeUpdate();
            Item menu = new Item(name, harga, deskripsi, EnumCheckItem.NOTAVAILABLE);
            SingletonUserManager.getInstance().setUser(menu);

            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
