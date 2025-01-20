package client;

import server.Message;
import server.MessageType;

public class MessageHandlerClient {

    public void handleMessage(Message messageToHandle) {
        switch (messageToHandle.getMessageType()) {
            case CONN_SUCCESS:
                System.out.println("Connection successful");
                break;
            case LOGIN_CONFIRM:
                System.out.println("Login successful");
                break;
            case LOGIN_ERROR:
                System.out.println("Login failed");
                break;
            case SIGNIN_ERROR_USERNAME:
                System.out.println();
        }
    }
}
