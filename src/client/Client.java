package client;

import server.Message;

import java.io.*;
import java.net.Socket;

/**
 * Client-class
 *
 * This class is responsible for communicating with the server.
 */
public class Client {

    private Socket client;

    private ObjectInputStream objectInputStream;

    private ObjectOutputStream objectOutputStream;

    /**
     * Client constructor.
     *
     * Gets a socket and initialises the client, reader and writer.
     * Prints out 'Connection successful', if everything works fine.
     *
     * @param client The given socket
     */
    public Client (Socket client) {
        try {
            this.client = client;
            this.objectInputStream = new ObjectInputStream(client.getInputStream());
            this.objectOutputStream = new ObjectOutputStream(client.getOutputStream());
        } catch (IOException e) {
            closeClient();
        }
    }

    /**
     * Sends message to the server.
     *
     * @param message The message to be sent
     */
    public void sendMessage(Message message) {
        try {
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Receives server responses.
     *
     * !BLOCKING OPERATION!
     */
    public Message receiveMessage() {
        Message receivedMessage;
        try {
            receivedMessage = (Message) objectInputStream.readObject();
            return receivedMessage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Close everything.
     */
    private void closeClient() {
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

    /**
     * Main-method. Opens the GUI and establishes connection to the server.
     *
     * @param args Standard parameter for psvm.
     */
    public static void main(String[] args) {
        //LoginGUI gui = new LoginGUI(client);
        try {
            new LoginGUI(new Client(new Socket("localhost", 4999)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
