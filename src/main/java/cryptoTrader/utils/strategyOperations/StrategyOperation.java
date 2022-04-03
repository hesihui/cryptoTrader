package cryptoTrader.utils.strategyOperations;

public interface StrategyOperation {
    public void writeTransactionDB(String trader, String strategy, int quantity, String coin, double price);
    public void handleInvalidBroker(String trader, String strategy, String coin);
}