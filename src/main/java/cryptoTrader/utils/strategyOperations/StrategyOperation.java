package cryptoTrader.utils.strategyOperations;

public interface StrategyOperation {
    public boolean BTC(String trader, String strategy, int quantity, double price);
    public boolean ETH(String trader, String strategy, int quantity, double price);
    public boolean USDT(String trader, String strategy, int quantity, double price);
    public boolean BNB(String trader, String strategy,int quantity, double price);
    public boolean USDC(String trader, String strategy, int quantity, double price);
    public boolean XRP(String trader, String strategy,int quantity, double price);
    public boolean ADA(String trader, String strategy, int quantity, double price);
    public boolean SOL(String trader, String strategy, int quantity, double price);
    public boolean LUNA(String trader, String strategy, int quantity, double price);
    public boolean AVAX(String trader, String strategy, int quantity, double price);
}
