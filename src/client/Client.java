package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 4999);

            DataInputStream input = new DataInputStream(client.getInputStream());
            System.out.println(input.readUTF());
            client.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
