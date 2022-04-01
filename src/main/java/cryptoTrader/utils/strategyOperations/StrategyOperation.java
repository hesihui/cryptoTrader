package cryptoTrader.utils.strategyOperations;

public interface StrategyOperation {
	public void BTC(String trader, String strategy, int quantity, double price);
    public void ETH(String trader, String strategy, int quantity, double price);
    public void USDT(String trader, String strategy, int quantity, double price);
    public void BNB(String trader, String strategy,int quantity, double price);
    public void USDC(String trader, String strategy, int quantity, double price);
    public void XRP(String trader, String strategy,int quantity, double price);
    public void ADA(String trader, String strategy, int quantity, double price);
    public void SOL(String trader, String strategy, int quantity, double price);
    public void LUNA(String trader, String strategy, int quantity, double price);
    public void AVAX(String trader, String strategy, int quantity, double price);
    public void handleInvalidBroker(String trader, String strategy, String coin);
}