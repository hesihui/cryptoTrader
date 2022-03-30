package cryptoTrader.service.trading;

public class TradingActionsFacade {
    private DisplayCoinData displayCoinData;
    private FetchCoinData fetchCoinData;
    private NotisfyBroker notisfyBroker;

    public TradingActionsFacade () {
        displayCoinData = new DisplayCoinData();
        fetchCoinData = new FetchCoinData();
        notisfyBroker = new NotisfyBroker();
    }

    public void performDisplayingCoinData() {

    }
}
