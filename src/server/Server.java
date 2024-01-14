package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private ServerSocket server;

    private List<Socket> clientList;

    public Server(final int port) {
        clientList = new ArrayList<>();
        try {
            server = new ServerSocket(port);
            server.setSoTimeout(100000);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void runServer() {
        while (true) {
            try {
                System.out.println("Waiting for clients at " + server.getLocalPort());
                Socket client = server.accept();
                clientList.add(client);
                for(Socket c : clientList) {
                    System.out.println(c.getRemoteSocketAddress());
                }
                DataOutputStream output = new DataOutputStream(client.getOutputStream());
                output.writeUTF("Connection successful");
            } catch (IOException ioe) {
                ioe.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Server s = new Server(4999);
        s.runServer();
    }
}
