package cryptoTrader.service.trading;

public class TradingActionsFacade {
    private DisplayCoinData displayCoinData;
    private FetchCoinData fetchCoinData;
    private NotifyBroker notifyBroker;

    public TradingActionsFacade () {
        displayCoinData = new DisplayCoinData();
        fetchCoinData = new FetchCoinData();
        notifyBroker = new NotifyBroker();
    }

    public void performDisplayingCoinData() {

    }
}
