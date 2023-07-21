/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LandingPage extends JFrame {

    public LandingPage() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Landing Page");
        
        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);

        
        
        //Login
        JButton login = new JButton("Login");
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setBounds(100, 315, 400, 50);
        panel.add(login);
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false); 
                new Login();
            }
        });
        
        //Register
        JButton register = new JButton("Register");
        register.setFont(new Font("Arial", Font.BOLD, 16));
        register.setBounds(100, 415, 400, 50);
        panel.add(register);
        register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Register();
            }
        });
        //JFrame
        this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
