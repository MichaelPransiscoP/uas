package Controller;

import Model.Store;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StoreFunction {
    static DatabaseHandler conn = new DatabaseHandler();
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
}
