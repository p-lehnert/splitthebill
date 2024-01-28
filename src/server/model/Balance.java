package server.model;

public class Balance {

    private long userId;

    private double balance;

    public Balance(long id, double balance) {
        userId = id;
        this.balance = balance;
    }

    public long getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
