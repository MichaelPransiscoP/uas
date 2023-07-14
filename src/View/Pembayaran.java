/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.CustomerFunction.getCustomer;
import Controller.StoreFunction;
import Model.Customer;
import Model.Item;
import Model.SingletonUserManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ASUS
 */
public class Pembayaran extends JFrame implements ActionListener {

    Customer cs;

    public Pembayaran() {
        ArrayList<Item> items = new ArrayList();

        items = StoreFunction.getItem();

        ArrayList<Integer> qty = new ArrayList();

        qty.add(1);
        qty.add(2);
        qty.add(1);
        qty.add(1);
        qty.add(2);
//        
//        qty.add(1);
//        qty.add(1);
//        qty.add(1);
//        qty.add(1);
//        qty.add(1);
//        qty.add(1);
//        qty.add(2);
//        qty.add(1);
//        qty.add(1);
//        qty.add(2);
        
        this.setTitle("Kofi Payment");

        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //
        SingletonUserManager.getInstance().setUser(getCustomer("micel@gmail.com"));
        cs = (Customer) SingletonUserManager.getInstance().getUser();

        //Title
        JLabel membersip = new JLabel("<html><b>Payment<hr></html>");
        membersip.setFont(new Font("Arial", Font.BOLD, 25));
        membersip.setForeground(Color.white);
        membersip.setBounds(240, 20, 280, 150);
        panel.add(membersip);
        //profile
        //Back button
        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new PanelProfile();
            }
        });

        JLabel headMenu = new JLabel("<html>&ensp;Item &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Qty &emsp;&ensp;X&ensp;&emsp; Price&ensp;&emsp;&ensp;&emsp;Tot.Price<br>--------------------------------------------------------------------------</html>");
        headMenu.setFont(new Font("Arial", Font.BOLD, 20));
        headMenu.setForeground(Color.white);
        headMenu.setBounds(42, 150, 600, 50);
        panel.add(headMenu);

        int spaceAntarText = 210;
        int totalPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            JLabel nameLabel = new JLabel("<html>" + (i + 1) + ".&ensp; " + items.get(i).getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            nameLabel.setBounds(65, spaceAntarText, 200, 25);
            nameLabel.setForeground(Color.white);
            panel.add(nameLabel);

            JLabel quantity = new JLabel(String.valueOf(qty.get(i)));
            quantity.setFont(new Font("Arial", Font.BOLD, 18));
            quantity.setBounds(250, spaceAntarText, 150, 25);
            quantity.setForeground(Color.white);
            panel.add(quantity);

            JLabel pricePerItem = new JLabel(String.valueOf(items.get(i).getPrice()));
            pricePerItem.setFont(new Font("Arial", Font.BOLD, 18));
            pricePerItem.setBounds(360, spaceAntarText, 150, 25);
            pricePerItem.setForeground(Color.white);
            panel.add(pricePerItem);

            JLabel priceLabel = new JLabel("<html>:&emsp;&emsp;&emsp;" + String.valueOf(items.get(i).getPrice() * qty.get(i)) + "<html>");
            priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
            priceLabel.setBounds(435, spaceAntarText, 150, 25);
            priceLabel.setForeground(Color.white);
            panel.add(priceLabel);
            //
            totalPrice += items.get(i).getPrice() * qty.get(i);
            //       
            spaceAntarText += 50;
        }

//        JScrollPane scrollableTextArea = new JScrollPane(panel);
//        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
//        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
//  
//        frame.add(scrollableTextArea);  
        
        
        JLabel garisBawah = new JLabel("--------------------------------------------------------------------------");
        garisBawah.setFont(new Font("Arial", Font.BOLD, 20));
        garisBawah.setForeground(Color.white);
        garisBawah.setBounds(42, spaceAntarText - 20, 600, 50);
        panel.add(garisBawah);

        JLabel textTotal = new JLabel("Total   :        " + totalPrice);
        textTotal.setFont(new Font("Arial", Font.BOLD, 20));
        textTotal.setForeground(Color.white);
        textTotal.setBounds(365, spaceAntarText + 20, 600, 50);
        panel.add(textTotal);

        //Footer
        JLabel footer = new JLabel("                         Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
        footer.setFont(new Font("Arial", Font.BOLD, 15));
        footer.setForeground(Color.white);
        footer.setBackground(Color.DARK_GRAY);
        footer.setOpaque(true);
        footer.setBounds(0, 820, 610, 90);
        panel.add(footer);

        //JFrame
        this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Pembayaran();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
