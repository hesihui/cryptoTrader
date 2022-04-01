package cryptoTrader.entity;

import java.util.HashMap;
import java.util.Map;

public class TradingBroker {
    private String clientName;
    private String[] coinList;
    private String strategy;
    private Map<String,Double> coinPrice;
    private boolean isValid;

    public TradingBroker(String clientName, String[] coinList, String strategy) {
        this.clientName = clientName;
        this.coinList = coinList;
        this.strategy = strategy;
        this.coinPrice = new HashMap<>();
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

    public boolean getBrokerStatus() {
        return this.isValid;
    }
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void updateCoinPrice(String coin, double price) {
        coinPrice.put(coin, price);
    }

    public Map<String, Double> getCoinPriceMap() {
        return this.coinPrice;
    }

    public void updateBrokerStatus(boolean status) {
        this.isValid = status;
    }

}
