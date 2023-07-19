/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controller.CustomerFunction;
import Model.Customer;
import Model.Item;
import View.LandingPage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author RAPHAEL
 */
public class MenuOrder extends JFrame implements ActionListener {

    JButton back;
    JFrame frame = this;

    public MenuOrder(int idStore) {
        
        ArrayList<Item> items = Controller.StoreFunction.getAvailItem(idStore);
        ArrayList<Item> customerItems = new ArrayList<>();

        this.setTitle("Order Menu");

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);

        //Back button
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LandingPage();
            }
        });

        JLabel masuk = new JLabel("Menu Order");
        masuk.setFont(new Font("Arial", Font.BOLD, 23));
        masuk.setForeground(Color.white);
        masuk.setBounds(230, 20, 250, 70);
        panel.add(masuk);
        JLabel masuk2 = new JLabel("Menu Order");
        masuk2.setFont(new Font("Arial", Font.BOLD, 23));
        masuk2.setForeground(Color.BLACK);
        masuk2.setBounds(232, 22, 250, 70);
        panel.add(masuk2);

        int startY = 130;
        int height = 130;

        for (int i = 0; i < items.size(); i++) {
            JLabel menu = new JLabel(items.get(i).getName());
            menu.setFont(new Font("Arial", Font.PLAIN, 25));
            menu.setForeground(Color.white);
            menu.setBounds(110, startY + 10 + (i * height), 200, height);
            panel.add(menu);

            JLabel menuharga = new JLabel("| Rp. " + String.valueOf(items.get(i).getPrice()));
            menuharga.setFont(new Font("Arial", Font.PLAIN, 15));
            menuharga.setForeground(Color.white);
            menuharga.setBounds(110, startY + 32 + (i * height), 300, height);
            panel.add(menuharga);

            JLabel menudesc = new JLabel("<html>" + items.get(i).getDesc() + " <br><br><br><br><br></html>");
            menudesc.setFont(new Font("Arial", Font.PLAIN, 15));
            menudesc.setForeground(Color.white);
            menudesc.setBounds(110, startY + 110 + (i * height), 300, height);
            panel.add(menudesc);

            JButton addButton = new JButton("Add");
            addButton.setBounds(400, startY + 80 + (i * height), 100, 30);
            addButton.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(addButton);

            final int index = i;
            this.add(panel);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    customerItems.add(items.get(index));
                }
            });
        }
        this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new MenuOrder(1);
    }
}
