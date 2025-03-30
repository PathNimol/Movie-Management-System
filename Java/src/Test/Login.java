package Test;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel titleR = new JLabel("Test.Login");
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
                    JOptionPane.showMessageDialog(f, "Test.Login Successfully");
                    Menu main = new Menu();
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

    public static class Menu implements ActionListener {
        JFrame frame;
        JPanel[] panel = new JPanel[4];
        JPanel pTitle,pThematic, pMenu, pBar;
        JLabel[] labels = new JLabel[5];
        JButton[] buttons = new JButton[11];
        JButton btnMembers, btnCategories, btnManageBook, btnLearnBook, btnReturn,
                btnAddUser, btnUpdateUser, btnReport, btnLogout, btnExit, btnHelp;

        Color cl = Color.decode("#8EB69B");
        Color cl1 = Color.decode("#163832");
        Font font = new Font("Segoe", Font.BOLD, 60);
        Menu(){
            frame = new JFrame();
            frame = new JFrame("Test.Login.Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1500,1000);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);

            //Initialize panel
            pTitle = new JPanel();
            pTitle.setBackground(cl1);
            pTitle.setLayout(null);
            pTitle.setBounds(0,0,1500,200);

            pThematic = new JPanel();
            pThematic.setBackground(cl1);
            pThematic.setLayout(null);
            pThematic.setBounds(0,210,1500,10);

            pMenu = new JPanel();
            pMenu.setBackground(cl1);
            pMenu.setLayout(null);
            pMenu.setBounds(0,230,1500,400);

            pBar = new JPanel();
            pBar.setBackground(cl1);
            pBar.setLayout(null);
            pBar.setBounds(0,320,1500,75);


            //Initialize Button
            btnMembers = new JButton("Manage Members");
            btnMembers.addActionListener(this);
            btnCategories = new JButton("Book Categories");
            btnCategories.addActionListener(this);
            btnManageBook = new JButton("Manage Books");
            btnManageBook.addActionListener(this);
            btnLearnBook = new JButton("Learn Books");
            btnLearnBook.addActionListener(this);
            btnReturn = new JButton("Return Books");
            btnReturn.addActionListener(this);
            btnAddUser = new JButton("Add User");
            btnAddUser.addActionListener(this);
            btnUpdateUser = new JButton("Update User");
            btnUpdateUser.addActionListener(this);
            btnReport = new JButton("Report");
            btnReport.addActionListener(this);
            btnLogout = new JButton("Logout");
            btnLogout.addActionListener(this);
            btnExit = new JButton("Exit");
            btnHelp = new JButton("Help");
            btnHelp.addActionListener(this);

            //Initialize Label
            labels[0] = new JLabel("Library Management Test.Login.Menu");
            labels[0].setForeground(cl);
            labels[0].setFont(font);
            labels[0].setBounds(20,20,100,1200);
            labels[1] = new JLabel("Logged in as: ");
            labels[2] = new JLabel("at: ");
            labels[3] = new JLabel("Test.Login date");
            labels[4] = new JLabel("Clock");

            //Add label to panel
            pTitle.add(labels[0]);


            //Add panel to frame
            frame.add(pTitle);
            frame.add(pThematic);
            frame.add(pMenu);
            frame.add(pBar);

            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}