package Controller;

import static Controller.CustomerFunction.conn;
import Model.Admin;
import Model.Item;
import Model.EnumCheckItem;
import Model.EnumMember;
import Model.SingletonUserManager;
import Model.Transaction;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String query = "INSERT INTO item (name,desc,price,availability) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, deskripsi);
            stmt.setString(3, harga);
            EnumCheckItem enumIn = EnumCheckItem.NOTAVAILABLE;
            stmt.setString(4, enumIn.name());

            stmt.executeUpdate();
            Item menu = new Item(name, deskripsi, harga, EnumCheckItem.NOTAVAILABLE);
            SingletonUserManager.getInstance().setUser(menu);

            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public static ArrayList<Transaction> getTransactionsList(){
        conn.connect();
        String query = "SELECT * FROM transaction";
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Transaction temp = new Transaction();
                temp.setId(rs.getInt(1));
                temp.setIdCustomer(rs.getInt(2));
                temp.setIdStore(rs.getInt(3));
                temp.setIdItem(rs.getInt(4));
                temp.setIdVoucher(rs.getInt(5));
                temp.setDate(rs.getDate(6));
                transactions.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
