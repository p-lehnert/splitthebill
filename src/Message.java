import java.io.Serializable;

public class Message implements Serializable {

    private final MessageType messageType;

    private String message;

    public Message (MessageType messageType) {this.messageType = messageType;}

    public MessageType getMessageType() {return messageType;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

}
