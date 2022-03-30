package cryptoTrader.service.entity;

import java.util.ArrayList;
import java.util.List;

public class CurrentClientsInfo {
    private static CurrentClientsInfo instance = null;
    private static List<TradingBroker> tradingBrokerList = new ArrayList<>();

    private CurrentClientsInfo() {

    }

    public static CurrentClientsInfo getInstance() {
        if (instance == null) {
            instance = new CurrentClientsInfo();
        }
        return instance;
    }

    public static void addTradingBroker(TradingBroker newBroker) {
        tradingBrokerList.add(newBroker);
    }

    public static List<TradingBroker> returnBrokerList() {
        return tradingBrokerList;
    }
}
