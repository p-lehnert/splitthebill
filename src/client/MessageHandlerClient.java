package client;

import server.Message;
import server.MessageType;

public class MessageHandlerClient {

    public static void handleMessage(Message messageToHandle) {
        if (messageToHandle.getMessageType() == MessageType.CONN_SUCCESS) {
            System.out.println("Connection successful");
        }
    }
}
