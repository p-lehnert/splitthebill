package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket client;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    private int id;

    ClientHandler(Socket client) {
        this.client = client;
        try {
            this.bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (client.isConnected()) {
            try {
                bufferedWriter.write("Connection successful");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e) {
                closeClientHandler();
            }
        }
    }

    private void closeClientHandler() {
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
}
