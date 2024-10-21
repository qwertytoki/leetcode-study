
import java.util.*;

public class Wise_TransactionAggregation {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("tx1", "user1", 100.0, "USD", 1620918902000L),
                new Transaction("tx2", "user2", 250.0, "USD", 1620918922000L),
                new Transaction("tx3", "user1", 50.0, "USD", 1620918942000L),
                new Transaction("tx4", "user3", 300.0, "USD", 1620918962000L),
                new Transaction("tx5", "user2", 150.0, "USD", 1620918982000L)
        );
        TransactionService service = new TransactionService();
        Map<String, Double> result = service.aggregateTransactions(transactions);
        System.out.println(result.get("user1")); // user1 -> 150.0
        System.out.println(result.get("user2")); // user2 -> 400.0
        System.out.println(result.get("user3")); // user3 -> 300.0

    }
}

class Transaction {

    private final String transactionId;
    private final String userId;
    private final double amount;
    private final String currency;
    private final long timestamp;

    Transaction(String transactionId, String userId, double amount, String currency, long timestamp) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public double getAmount() {
        return this.amount;
    }
}

class TransactionService {

    public Map<String, Double> aggregateTransactions(List<Transaction> transactions) {
        Map<String, Double> result = new HashMap<>();
        for (Transaction transaction : transactions) {
            double amount = result.getOrDefault(transaction.getUserId(), 0.0) + transaction.getAmount();
            result.put(transaction.getUserId(), amount);
        }
        return result;
    }

}
