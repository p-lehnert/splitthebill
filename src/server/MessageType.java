package server;

public enum MessageType {
    // Clientside
    LOGIN_REQUEST,
    SIGNIN_REQUEST,

    // Serverside
    CONN_SUCCESS,
    LOGIN_CONFIRM,
    LOGIN_ERROR,
    SIGNIN_ERROR_USERNAME
}
