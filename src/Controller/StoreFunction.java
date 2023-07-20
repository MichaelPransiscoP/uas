package Controller;

import Model.Item;
import Model.Store;
import Model.Voucher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StoreFunction {
    static DatabaseHandler conn = new DatabaseHandler();
    
    //get all stores
    public static ArrayList<Store> getStores(){
        conn.connect();
        String query = "SELECT * FROM store";
        ArrayList<Store> stores = new ArrayList<Store>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Store temp = new Store();
                temp.setId(rs.getInt("id"));
                temp.setIdDetailTransaction(rs.getInt("idDetailTransaction"));
                temp.setCabang(rs.getString("cabang"));
                temp.setDeskripsi(rs.getString("deskripsi"));
                temp.setIncome(rs.getDouble("income"));
                stores.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stores;
    }
    
    public static ArrayList<Item> getItem(){
        conn.connect();
        String query = "SELECT * FROM item";
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Item temp = new Item();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setDesc(rs.getString("desc"));
                temp.setPrice(rs.getInt("price"));
                items.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    
    public static ArrayList<Item> getAvailItem(int idStore){
        conn.connect();
        String query = "SELECT * FROM item JOIN detailitem ON item.id = detailitem.idItem WHERE detailitem.idStore = '" + idStore + "' AND detailitem.available = 'AVAILABLE';";
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Item temp = new Item();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setDesc(rs.getString("desc"));
                temp.setPrice(rs.getInt("price"));
                items.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    
    public static ArrayList<Voucher> getVoucher(){
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
}
