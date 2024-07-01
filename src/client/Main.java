package client;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        LoginGUI gui = new LoginGUI();
        try {
            Client client = new Client(new Socket("localhost", 4999));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
