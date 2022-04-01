package cryptoTrader.service.trading;

public class TradingActionsFacade {
    private DisplayCoinData displayCoinData;
    private NotifyBroker notifyBroker;
    private PerformStrategyAnalysis performStrategyAnalysis;

    public TradingActionsFacade () {
        displayCoinData = new DisplayCoinData();
        notifyBroker = new NotifyBroker();
        performStrategyAnalysis = new PerformStrategyAnalysis();
    }

    public void performTradingActions() {
        // step1&2: initiate the retieval of the current cryptocoin prices
        // Notify the different trading brokers by passing the appropriate prices to the right trading broker.
        notifyBroker.updateBrokerCoinPrice();
        // step3: perform strategy computations
        performStrategyAnalysis.AnalyzeStrategy();
    }
}