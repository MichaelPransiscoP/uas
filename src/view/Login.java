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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.ControllerDatabase;
import controller.GlobalFunction;
import static controller.ControllerDatabase.getUser;
import javax.swing.JDialog;
import model.User;
/**
 *
 * @author CoffeeShop
 */
public class Login extends JFrame implements ActionListener {

    JTextField inputEmail, inputPass;
    JButton back;
    JFrame frame = this;
    public Login() {
        User ur = getUser("asep@gmail.com");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Landing Page"+ur.getName());

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);

        //Back button
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LandingPage();
            }   
        });

        JLabel masuk = new JLabel("Masuk/Login");
        masuk.setFont(new Font("Arial", Font.BOLD, 23));
        masuk.setForeground(Color.white);
        masuk.setBounds(230, 20, 250, 70);
        panel.add(masuk);
        JLabel masuk2 = new JLabel("Masuk/Login");
        masuk2.setFont(new Font("Arial", Font.BOLD, 23));
        masuk2.setForeground(Color.BLACK);
        masuk2.setBounds(232, 22, 250, 70);
        panel.add(masuk2);

        //Text
        JLabel labelInputEmail = new JLabel("Masukkan Email");
        labelInputEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputEmail.setForeground(Color.white);
        labelInputEmail.setBounds(155, 120, 290, 70);
        panel.add(labelInputEmail);

        //Input email
        inputEmail = new JTextField();
        inputEmail.setBounds(155, 170, 290, 40);
        panel.add(inputEmail);

        //Text
        JLabel labelInputPass = new JLabel("Masukkan Password");
        labelInputPass.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputPass.setForeground(Color.white);
        labelInputPass.setBounds(155, 200, 290, 70);
        panel.add(labelInputPass);

        //Input email
        inputPass = new JPasswordField();
        inputPass.setBounds(155, 250, 290, 40);
        panel.add(inputPass);

        //LoginButton
        JButton loginButton = new JButton("Lanjutkan");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
        loginButton.setBounds(255, 320, 190, 40);
        panel.add(loginButton);
        //--
        loginButton.addActionListener(this);
       
        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Check data input user dengan database
        
        User resultUser = GlobalFunction.checkEmailPassLogin(String.valueOf(inputEmail.getText()), String.valueOf(inputPass.getText()));
        if (resultUser instanceof User) {
            this.setVisible(false);
            new HomePage();
        } 
    }

    public static void main(String[] args) {
        new Login();
    }
}
