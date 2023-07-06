package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Store;

public class PilihStorePage extends JFrame{
    
    public PilihStorePage(){
        this.setTitle("Pilih Lokasi Store");
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //

        ArrayList<Store> stores = Controller.StoreFunction.getStores();
        // Show List Store
        for (int i = 0; i < stores.size(); i++) {
            JLabel namacabang = new JLabel("<html><h1>" + stores.get(i).getCabang() + "</h1>" + stores.get(i).getDeskripsi() + "</html>");
            namacabang.setFont(new Font("Arial", Font.PLAIN, 17));
            namacabang.setForeground(Color.white);
            namacabang.setBounds(20, 90*i, 250, 70);
            panel.add(namacabang);
            JButton pilihcabang = new JButton("Pilih Cabang Ini");
            pilihcabang.setFont(new Font("Arial", Font.PLAIN, 14));
            pilihcabang.setBounds(450, 90*i + 20, 150, 50);
            panel.add(pilihcabang);
        }

        //JFrame
        this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
