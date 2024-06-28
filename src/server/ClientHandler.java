package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket client;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    ClientHandler(Socket client) {
        try {
            this.client = client;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (client.isConnected()) {
            // TODO
        }
    }
}
