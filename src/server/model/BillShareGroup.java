package server.model;

import java.util.List;

public class BillShareGroup {

    private static long instances = 0;

    private long id;

    private User[] users;

    private List<Transaction> transactions;

    public BillShareGroup() {
        id = instances;
        instances++;
    }

    public BillShareGroup(User[] users, List<Transaction> transactions) {
        id = instances;
        instances++;
        this.users = users;
        this.transactions = transactions;
    }
}
