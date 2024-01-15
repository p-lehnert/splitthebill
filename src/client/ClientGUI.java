package client;

import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame {

    public static final Dimension SCREEN_SIZE =
            new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);

    private JPanel panel;

    public ClientGUI(JPanel panel) {
        this.panel = panel;
        this.add(panel);
        this.setPreferredSize(SCREEN_SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static JPanel loginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(2, 2));
        JTextArea usernameArea = new JTextArea();
        JTextArea passwordArea = new JTextArea();
        JButton loginBtn = new JButton("Log in");
        JButton register = new JButton("Register");
        loginPanel.add(usernameArea);
        loginPanel.add(passwordArea);
        loginPanel.add(loginBtn);
        loginPanel.add(register);


        return loginPanel;
    }

    private void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
