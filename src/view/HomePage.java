/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import model.TODO;

public class HomePage extends JFrame {
    private TODO todo;
    public HomePage(){
        
    }
    public HomePage(TODO todo) {
        this.todo = todo;
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append("ID: " + todo.getId() + "\n");
        textArea.append("Title: " + todo.getTitle() + "\n");
        textArea.append("Note: " + todo.getNote() + "\n");
        textArea.append("User ID: " + todo.getUserId() + "\n");

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new HomePage();
    }

    
}
