package BasicJava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Login implements ActionListener {
    //Declare Items
    JFrame f;
    JPanel[] panel = new JPanel[2];
    JLabel[] label = new JLabel[5];
    JTextField textField = new JTextField();
    JButton[] button = new JButton[2];
    JPasswordField txtPassword;
    JCheckBox showPw = new JCheckBox("Show Password");
    JButton btnLogin, btnExit;
    JTextField txtUsername;
    JPanel pTitle, pItems;

    String[] user = new String[3];
    String[] pass = new String[3];

    Font myFont = new Font("Times New Roman", Font.ROMAN_BASELINE, 24);
    Font titleRight = new Font("Times New Roman", Font.BOLD, 82);
    Font titleLeft = new Font("Times New Roman", Font.BOLD, 60);
    Font shFont = new Font("Times New Roman", Font.ROMAN_BASELINE, 14);
    String username, password;

    Login() {
        f = new JFrame("Test.Login");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1200, 700);
        f.setLayout(null);
        f.setLocationRelativeTo(null);

        user[0] = "admin";
        user[1] = "Teacher";
        user[2] = "Student";

        pass[0] = "111";
        pass[1] = "222";
        pass[2] = "333";

        pTitle = new JPanel();
        pTitle.setBounds(0, 0, 500, 700);
        pTitle.setLayout(null);
        Color customColor = Color.decode("#163832");
        pTitle.setBackground(customColor);

        pItems = new JPanel();
        pItems.setBounds(500, 0, 700, 700);
        pItems.setLayout(null);
        Color customColor1 = Color.decode("#8EB69B");
        pItems.setBackground(customColor1);

        JLabel titleR = new JLabel("Login");
        titleR.setFont(titleRight);
        titleR.setForeground(customColor);
        titleR.setBounds(225, 50, 250, 100);

        JLabel titleL = new JLabel("LIBRARY");
        titleL.setFont(titleLeft);
        titleL.setForeground(customColor1);
        titleL.setBounds(75, 200, 490, 100);

        JLabel subTitle = new JLabel("MANAGEMENT SYSTEM");
        subTitle.setFont(myFont);
        subTitle.setForeground(customColor1);
        subTitle.setBounds(220, 275, 300, 50);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(myFont);
        lblUsername.setForeground(customColor);
        lblUsername.setBounds(150, 200, 250, 100);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(myFont);
        lblPassword.setForeground(customColor);
        lblPassword.setBounds(150, 310, 250, 100);

        txtUsername = new JTextField();
        txtUsername.setFont(myFont);
        txtUsername.setForeground(customColor);
        Color cl = Color.decode("#DAF1DE");
        txtUsername.setBackground(cl);
        txtUsername.setBorder(BorderFactory.createEmptyBorder());
        txtUsername.setBounds(150, 275, 400, 40);

        txtPassword = new JPasswordField();
        txtPassword.setFont(myFont);
        txtPassword.setForeground(customColor);
        txtPassword.setBackground(cl);
        txtPassword.setBorder(BorderFactory.createEmptyBorder());
        txtPassword.setBounds(150, 385, 400, 40);

        showPw.setFont(shFont);
        showPw.setForeground(customColor);
        showPw.setBackground(customColor1);
        showPw.setBounds(150, 425, 400, 40);

        btnLogin = new JButton("Test.Login");
        btnLogin.setFont(myFont);
        btnLogin.setForeground(customColor1);
        btnLogin.addActionListener(this);
        btnLogin.setBackground(customColor);
        btnLogin.setBounds(150, 475, 150, 50);
        btnLogin.setEnabled(false);

        btnExit = new JButton("Exit");
        btnExit.setFont(myFont);
        btnExit.setForeground(customColor1);
        btnExit.addActionListener(this);
        btnExit.setBackground(Color.darkGray);
        btnExit.setBounds(400, 475, 150, 50);

        pItems.add(titleR);
        pItems.add(lblUsername);
        pItems.add(txtUsername);
        pItems.add(lblPassword);
        pItems.add(txtPassword);
        pItems.add(showPw);
        pItems.add(btnLogin);
        pItems.add(btnExit);

        pTitle.add(titleL);
        pTitle.add(subTitle);

        f.add(pTitle);
        f.add(pItems);
        f.setVisible(true);

        showPw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPw.isSelected()) {
                    // Show password
                    txtPassword.setEchoChar((char) 0); // Set echo char to 0 (no masking)
                } else {
                    // Hide password (default echo character)
                    txtPassword.setEchoChar('*'); // Set echo char back to '*' (or any character you want)
                }
            }
        });

        //Action Enable Buttons
        txtUsername.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateBtn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateBtn();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateBtn();
            }
        });
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

    //Define buttons true false
    public void validateBtn(){
        if(txtUsername.getText().isEmpty() && txtPassword.getText().isEmpty()){
            btnLogin.setEnabled(false);
        }
        else {
            btnLogin.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int inputAttemps = 0;
        if (e.getSource() == btnLogin) {
            boolean loginSuccessful = false;

            if (txtUsername.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username");
            }
            if (txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter password");
            }
            for (int i = 0; i < user.length; i++) {
                if (txtUsername.getText().equals(user[i]) && txtPassword.getText().equals(pass[i])) {
                    JOptionPane.showMessageDialog(f, "Login Successfully");
                } else if (txtUsername.getText().equals(user[i]) && txtPassword.getText() != pass[i]) {
                    JOptionPane.showMessageDialog(f, "Invalid Password!!!");
                    inputAttemps++;
                    return;
                } else if (txtUsername.getText() != user[i] && txtPassword.getText() == pass[i]) {
                    JOptionPane.showMessageDialog(f, "Invalid Username!!!");
                    inputAttemps++;
                    return;
                }
            }
            if(!loginSuccessful){
                if(inputAttemps>=3){
                    inputAttemps++;
                    JOptionPane.showMessageDialog(f, "Out of Attempts! You entered incorrect information 3 times.");
                    btnLogin.setEnabled(false);
                }
            }
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
}