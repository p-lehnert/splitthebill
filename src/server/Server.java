package server;

import server.persistence.CreateDbs;

import java.io.DataOutputStream;
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
        if (System.getProperty("os.name").contains("Windows")) {
            CreateDbs.createDatabasesWin();
        } else {
            CreateDbs.createDatabasesLin();
        }
        try {
            server = new ServerSocket(port);
            server.setSoTimeout(100000);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void runServer() {
        try {
            while (!server.isClosed()) {
                System.out.println("Waiting for clients at " + server.getLocalPort());
                System.out.println(Constants.DATABASE_URL_WINDOWS);
                Socket client = server.accept();
                clientList.add(client);
                DataOutputStream output = new DataOutputStream(client.getOutputStream());
                output.writeUTF("Connection successful");
                ClientHandler clientHandler = new ClientHandler(client);
                Thread thread = new Thread(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
