package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server;

    public Server(final int port) {
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
                System.out.println("Waiting for client at " + server.getLocalPort());
                Socket client = server.accept();
                System.out.println(client.getRemoteSocketAddress());
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
