package client;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client {

    private Socket client;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    public Client (Socket client) {
        try {
            this.client = client;
            this.bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            closeClient();
        }
    }

    private void closeClient() {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoginGUI gui = new LoginGUI();
        try {
            new Client(new Socket("localhost", 4999));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
