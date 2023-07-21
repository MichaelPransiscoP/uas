package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import Model.Customer;

public class HapusCustomerPage extends JFrame{
    public HapusCustomerPage(){
        this.setTitle("Hapus Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //

        ArrayList<Customer> custs = Controller.CustomerFunction.getCustomersList();
        // Show List Customer
        for (int i = 0; i < custs.size(); i++) {
            String custEmail = custs.get(i).getEmail();
            JLabel namaCustomer = new JLabel("<html><h1>" + custs.get(i).getUsername() + "</h1>" + custs.get(i).getEmail() + "</html>");
            namaCustomer.setFont(new Font("Arial", Font.PLAIN, 17));
            namaCustomer.setForeground(Color.white);
            namaCustomer.setBounds(20, 90*i, 250, 70);
            panel.add(namaCustomer);
            JButton pilihCustomer = new JButton("Hapus Customer Ini");
            pilihCustomer.setFont(new Font("Arial", Font.PLAIN, 14));
            pilihCustomer.setBounds(400, 90*i + 20, 200, 50);
            pilihCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin anda ingin menghapus customer ini?", "Hapus Customer?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    if (Controller.AdminFunction.hapusCustomer(custEmail)){
                        JOptionPane.showMessageDialog(null, "Customer dengan e-mail " + custEmail + " telah berhasil dihapus.", "Successfully Deleted!", JOptionPane.INFORMATION_MESSAGE, null);
                        frame.dispose();
                        new HapusCustomerPage();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Customer gagal untuk dihapus", "Failed to Delete", JOptionPane.ERROR_MESSAGE, null);
                    }
                }
            }
        });
            panel.add(pilihCustomer);
        }

        // Back Button
        JButton back = new JButton("Back");
        back.setBounds(20, 90*custs.size()+20, 150, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                // new MainMenuAdmin();
            }
        });
        panel.add(back);

        this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(650, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new HapusCustomerPage();
    }
}
