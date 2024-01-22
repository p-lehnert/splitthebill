package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame implements ActionListener {

    public static final Dimension SCREEN_SIZE =
            new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);

    private JPanel panel;

    public ClientGUI() {
        this.panel = loginPanel();
        this.add(panel);
        this.setPreferredSize(SCREEN_SIZE);
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
        JTextField usernameArea = new JTextField();
        usernameArea.setBounds(100, 20, 200, 25);
        JLabel passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(10, 50, 80, 25);
        JPasswordField passwordField = new JPasswordField();
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

    public JPanel mainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("-- In Arbeit --");
        mainPanel.add(label);
        return mainPanel;
    }

    private void setPanel(JPanel panel) {
        this.remove(panel);
        this.panel = new JPanel();
        this.panel = panel;
        this.add(panel);
        this.revalidate();
        this.setVisible(true);
        System.out.println("Eigentlich sollte sich das Panel ändern. Hm.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setPanel(mainPanel());
    }
}
