package server;

import server.model.User;

import java.io.*;
import java.net.Socket;

/**
 * Class for handling the Client-Server-communication.
 */
public class ClientHandler implements Runnable {

    private Socket client;

    private ObjectInputStream objectInputStream;

    private ObjectOutputStream objectOutputStream;

    private User user;

    /**
     * Constructor.
     * Initializing client and streams.
     *
     * @param client The connected client
     */
    ClientHandler(Socket client) {
        try {
            this.client = client;
            this.objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            this.objectInputStream = new ObjectInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * "Main"-method for each thread.
     * Confirms connection and waits for Message from client.
     */
    @Override
    public void run() {
        try {
            if (client.isConnected()) {
                // confirm connection
                objectOutputStream.writeObject(new Message(MessageType.CONN_SUCCESS));
                objectOutputStream.flush();
            }
            while (client.isConnected()) {
                // wait for user input
                objectInputStream.readObject();
            }
        } catch (IOException e) {
            closeClientHandler();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Closing-operation.
     */
    private void closeClientHandler() {
        try {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}
}
