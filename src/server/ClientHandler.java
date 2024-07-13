package server;

import server.model.User;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;

    private BufferedReader bufferedReader;

    private BufferedWriter bufferedWriter;

    private User user;

    ClientHandler(Socket client) {
        try {
            this.client = client;
            this.bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            if (client.isConnected()) {
                // confirm connection
                bufferedWriter.write("Connection successful");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            while (client.isConnected()) {
                // wait for user input
                bufferedReader.readLine();
            }
        } catch (IOException e) {
            closeClientHandler();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
