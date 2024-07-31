package client;

import server.Message;
import server.MessageType;

public class MessageHandlerClient {

    public void handleMessage(Message messageToHandle) {
        switch (messageToHandle.getMessageType()) {
            case CONN_SUCCESS: System.out.println("Connection successful");
            case LOGIN_CONFIRM: System.out.println("Login successful");
            case LOGIN_ERROR: System.out.println("Login failed");
        }
    }
}
