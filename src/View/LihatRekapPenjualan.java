package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Controller.AdminFunction;
import Controller.CustomerFunction;
import Controller.StoreFunction;
import Controller.VoucherFunction;
import Model.Transaction;

public class LihatRekapPenjualan extends JFrame{
    public LihatRekapPenjualan(){
        setTitle("Rekap Penjualan");
        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //

        // Back Button
        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MainMenuAdmin();
            }
        });

        // Show List Transactions
        ArrayList<Transaction> transactions = AdminFunction.getTransactionsList();
        int i = 0;
        for (i = 0; i < transactions.size(); i++) {
            JLabel text = new JLabel("<html>ID Transaction: " + transactions.get(i).getId() + "<br>Customer: " + CustomerFunction.getCustomerById(transactions.get(i).getIdCustomer()).getUsername() + "<br>Store: " + StoreFunction.getStoreById(transactions.get(i).getIdStore()).getCabang() + "<br>Item: " + StoreFunction.getItemById(transactions.get(i).getIdItem()).getName() + "<br>Voucher: " + VoucherFunction.getVoucherByID(String.valueOf(transactions.get(i).getIdVoucher())).getName() + "<br>Transaction Date: " + transactions.get(i).getDate() + "<br>==============================================</html>");
            text.setFont(new Font("Arial", Font.PLAIN, 17));
            text.setForeground(Color.white);
            text.setBounds(20, 150*i + 100, 250, 150);
            panel.add(text);
        }

        JScrollPane scroll = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(573, 0, 20, 1500);
        panel.setPreferredSize(new Dimension(0, 150*i + 250));
        add(scroll);

        //JFrame
        add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LihatRekapPenjualan();
    }
}
