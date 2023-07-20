package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Voucher;

public class VoucherFunction {
    static DatabaseHandler conn = new DatabaseHandler();
    public static ArrayList<Voucher> getVouchersList(){
        conn.connect();
        String query = "SELECT * FROM voucher";
        ArrayList<Voucher> vouchers = new ArrayList<Voucher>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Voucher temp = new Voucher();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setDesc(rs.getString("desc"));
                temp.setDiscount(rs.getDouble("discount"));
                temp.setCondition(rs.getDouble("condition"));
                vouchers.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }
    public static Voucher getVoucherByID(String voucherID){
        conn.connect();
        String query = "SELECT * FROM voucher WHERE id=" + voucherID;
        Voucher voucher = new Voucher();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                voucher.setId(rs.getInt("id"));
                voucher.setName(rs.getString("name"));
                voucher.setDesc(rs.getString("desc"));
                voucher.setDiscount(rs.getDouble("discount"));
                voucher.setCondition(rs.getDouble("condition"));
            }
            return voucher;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
