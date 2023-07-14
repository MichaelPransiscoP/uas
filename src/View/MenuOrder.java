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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author RAPHAEL
 */
public class MenuOrder extends JFrame implements ActionListener {

    JButton back;
    JFrame frame = this;

    public MenuOrder() {
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

        //Menu 1
        JLabel menu1 = new JLabel("Cappuccino");
        menu1.setFont(new Font("Arial", Font.PLAIN, 25));
        menu1.setForeground(Color.white);
        menu1.setBounds(110, 130, 200, 70);
        panel.add(menu1);

        JLabel menu1desc = new JLabel("Espresso shots dengan susu hangat");
        menu1desc.setFont(new Font("Arial", Font.PLAIN, 15));
        menu1desc.setForeground(Color.white);
        menu1desc.setBounds(110, 160, 250, 70);
        panel.add(menu1desc);

        JButton addButton1 = new JButton("Add");
        addButton1.setBounds(400, 170, 100, 30);
        panel.add(addButton1);
        
        //Menu 2
        JLabel menu2 = new JLabel("Americano");
        menu2.setFont(new Font("Arial", Font.PLAIN, 25));
        menu2.setForeground(Color.white);
        menu2.setBounds(110, 200, 200, 70);
        panel.add(menu2);

        JLabel menu2desc = new JLabel("Espresso shots dengan segelas air");
        menu2desc.setFont(new Font("Arial", Font.PLAIN, 15));
        menu2desc.setForeground(Color.white);
        menu2desc.setBounds(110, 230, 300, 70);
        panel.add(menu2desc);

        JButton addButton2 = new JButton("Add");
        addButton2.setBounds(400, 240, 100, 30);
        panel.add(addButton2);
        
        //Menu 3
        JLabel menu3 = new JLabel("Espresso");
        menu3.setFont(new Font("Arial", Font.PLAIN, 25));
        menu3.setForeground(Color.white);
        menu3.setBounds(110, 270, 200, 70);
        panel.add(menu3);

        JLabel menu3desc = new JLabel("Ekstrak biji kopi tanpa campuran");
        menu3desc.setFont(new Font("Arial", Font.PLAIN, 15));
        menu3desc.setForeground(Color.white);
        menu3desc.setForeground(Color.white);
        menu3desc.setBounds(110, 300, 300, 70);
        panel.add(menu3desc);

        JButton addButton3 = new JButton("Add");
        addButton3.setBounds(400, 310, 100, 30);
        panel.add(addButton3);
        
        //Menu 4
        JLabel menu4 = new JLabel("Matcha Latte");
        menu4.setFont(new Font("Arial", Font.PLAIN, 25));
        menu4.setForeground(Color.white);
        menu4.setBounds(110, 340, 200, 70);
        panel.add(menu4);

        JLabel menu4desc = new JLabel("Bubuk matcha yang lembut dengan susu");
        menu4desc.setFont(new Font("Arial", Font.PLAIN, 15));
        menu4desc.setForeground(Color.white);
        menu4desc.setForeground(Color.white);
        menu4desc.setBounds(110, 370, 300, 70);
        panel.add(menu4desc);

        JButton addButton4 = new JButton("Add");
        addButton4.setBounds(400, 380, 100, 30);
        panel.add(addButton4);
        
        

        //RegisterButton
        JButton RegisterButton = new JButton("Register");
        RegisterButton.setFont(new Font("Arial", Font.PLAIN, 20));
        RegisterButton.setBounds(255, 720, 190, 40);
        panel.add(RegisterButton);
        //--
        RegisterButton.addActionListener(this);
        //
        //copyright
        JLabel footer = new JLabel("                           Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new MenuOrder();
    }
}
