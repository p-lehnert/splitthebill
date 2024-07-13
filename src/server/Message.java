package server;

import java.io.Serializable;

public class Message implements Serializable {

    private final MessageType messageType;

    private String message;

    private String sndMessage;

    public Message (MessageType messageType) {this.messageType = messageType;}

    public MessageType getMessageType() {return messageType;}

    public String getMessage() {return message;}

    public void setMessage(String editedMessage) {this.message = editedMessage;}

    public String getSndMessage() {return sndMessage;}

    public void setSndMessage(String editedMessage) {this.sndMessage = editedMessage;}

}
