package server;

public enum MessageType {
    // Clientside
    LOGIN_REQUEST,

    // Serverside
    CONN_SUCCESS,
    LOGIN_CONFIRM,
    LOGIN_ERROR
}
