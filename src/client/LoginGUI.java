package client;

import server.Message;
import server.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginGUI extends JFrame implements ActionListener {

    private final Client client;

    private JPanel panel;

    JTextField usernameArea;

    JPasswordField passwordField;

    public LoginGUI(Client client) {
        this.client = client;
        this.panel = loginPanel();
        this.add(panel);
        this.setPreferredSize(ClientConstants.SCREEN_SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel loginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        JLabel usernameLbl = new JLabel("Username:");
        usernameLbl.setBounds(10, 20, 80, 25);
        usernameArea = new JTextField();
        usernameArea.setBounds(100, 20, 200, 25);
        JLabel passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(10, 50, 80, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 200, 25);
        JButton loginBtn = new JButton("Log in");
        loginBtn.setBounds(100, 80, 90, 25);
        loginBtn.addActionListener(this);
        JButton register = new JButton("Sign up");
        register.setBounds(210, 80, 90, 25);
        loginPanel.add(usernameLbl);
        loginPanel.add(usernameArea);
        loginPanel.add(passwordLbl);
        loginPanel.add(passwordField);
        loginPanel.add(loginBtn);
        loginPanel.add(register);

        return loginPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Message loginMsg = new Message(MessageType.LOGIN_REQUEST);
        loginMsg.setMessage(usernameArea.getText());
        loginMsg.setSndMessage(String.valueOf(passwordField.getPassword()));
        client.sendMessage(loginMsg);

        new MainGUI();
        this.dispose();
    }
}
