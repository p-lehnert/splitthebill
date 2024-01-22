package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) {
        ClientGUI gui = new ClientGUI();
        try {
            Socket client = new Socket("localhost", 4999);

            DataInputStream input = new DataInputStream(client.getInputStream());
            System.out.println(input.readUTF());
            TimeUnit.SECONDS.sleep(30);
            client.close();
        } catch (IOException | InterruptedException ioe) {
            ioe.printStackTrace();
        }
    }
}
