package client;

import server.Message;
import server.MessageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignInGUI extends JFrame implements ActionListener {

    private final Client client;

    JPanel signInPanel;

    JTextField usernameField;

    JPasswordField password1;

    JPasswordField password2;

    public SignInGUI(Client client) {
        this.client = client;
        this.signInPanel = signInPanel();
        this.add(signInPanel);
        this.setPreferredSize(ClientConstants.SIGNIN_SIZE);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JPanel signInPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        usernameField = new JTextField();
        usernameField.setBounds(200, 20, 150, 25);
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 150, 25);
        password1 = new JPasswordField();
        password1.setBounds(200, 50, 150, 25);
        JLabel password1Label = new JLabel("Password:");
        password1Label.setBounds(10, 50, 150, 25);
        password2 = new JPasswordField();
        password2.setBounds(200, 80, 150, 25);
        JLabel password2Label = new JLabel("Repeat password:");
        password2Label.setBounds(10, 80, 150, 25);
        JButton submitButton = new JButton("Confirm");
        submitButton.setBounds(200, 110, 150, 25);

        submitButton.addActionListener(this);
        panel.add(usernameField);
        panel.add(usernameLabel);
        panel.add(password1);
        panel.add(password1Label);
        panel.add(password2);
        panel.add(password2Label);
        panel.add(submitButton);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Arrays.equals(password1.getPassword(), password2.getPassword())) {
            Message register = new Message(MessageType.SIGNIN_REQUEST);
            register.setMessage(usernameField.getText());
            register.setSndMessage(String.valueOf(password1.getPassword()));
            client.sendMessage(register);
        }
    }
}
