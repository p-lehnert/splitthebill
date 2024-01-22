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
        loginPanel.setLayout(new GridLayout(2, 2));
        JTextArea usernameArea = new JTextArea();
        JTextArea passwordArea = new JTextArea();
        JButton loginBtn = new JButton("Log in");
        loginBtn.addActionListener(this);
        JButton register = new JButton("Register");
        loginPanel.add(usernameArea);
        loginPanel.add(passwordArea);
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
        this.panel = panel;
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setPanel(mainPanel());
    }
}
