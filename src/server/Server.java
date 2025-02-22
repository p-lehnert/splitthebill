package server;

import server.persistence.CreateDbs;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private ServerSocket server;

    private final List<Socket> clientList;

    public Server(final int port) {
        clientList = new ArrayList<>();
        try {
            server = new ServerSocket(port);
            if (System.getProperty("os.name").contains("Windows")) {
                CreateDbs.createDatabasesWin();
            } else {
                CreateDbs.createDatabasesLin();
            }
            server.setSoTimeout(1000000);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void runServer() {
        try {
            while (!server.isClosed()) {
                System.out.println("Waiting for clients at " + server.getLocalPort());
                Socket client = server.accept();
                System.out.println("Client connected");
                clientList.add(client);
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    public void closeServerSocket() {
        try {
            if (server != null) {
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s = new Server(4999);
        s.runServer();
    }
}
