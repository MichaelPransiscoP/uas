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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends JFrame implements ActionListener {

    private JTextField inputName, inputEmail, inputPassword, inputGender, inputBirthday, inputPhoto;
    private JButton registerButton;

    public Register() {
        setTitle("Register Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("Name:"));
        inputName = new JTextField();
        panel.add(inputName);

        panel.add(new JLabel("Email:"));
        inputEmail = new JTextField();
        panel.add(inputEmail);

        panel.add(new JLabel("Password:"));
        inputPassword = new JPasswordField();
        panel.add(inputPassword);

        panel.add(new JLabel("Gender:"));
        inputGender = new JTextField();
        panel.add(inputGender);

        panel.add(new JLabel("Birthday:"));
        inputBirthday = new JTextField();
        panel.add(inputBirthday);

        panel.add(new JLabel("Photo:"));
        inputPhoto = new JTextField();
        panel.add(inputPhoto);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = inputName.getText();
        String email = inputEmail.getText();
        String password = inputPassword.getText();
        String gender = inputGender.getText();
        String birthday = inputBirthday.getText();
        String photo = inputPhoto.getText();

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_uas_sp", "root", "");

            // Prepare the INSERT INTO query
            String query = "INSERT INTO `user`(`name`, `email`, `password`, `gender`, `birthday`, `photo`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, birthday);
            preparedStatement.setString(6, photo);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            JOptionPane.showMessageDialog(this, "Registration successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Registration failed. Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}

