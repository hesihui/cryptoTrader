package cryptoTrader.service.entity;

public class TradingBroker {
    private String clientName;
    private String[] coinList;
    private String strategy;

    public TradingBroker(String clientName, String[] coinList, String strategy) {
        this.clientName = clientName;
        this.coinList = coinList;
        this.strategy = strategy;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String[] getCoinList() {
        return coinList;
    }

    public void setCoinList(String[] coinList) {
        this.coinList = coinList;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
