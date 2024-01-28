package server.model;

public class Transaction {

    private static long instances = 0;

    private long id;

    private double amount;

    private Balance[] balances;

    public Transaction(){
        id = instances;
        instances++;
    }

    public Transaction(double amount, Balance[] balances) {
        id = instances;
        instances++;
        this.amount = amount;
        this.balances = balances;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
