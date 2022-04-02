package cryptoTrader.entity;

import java.util.*;

public class CurrentClientsInfo {
    private static CurrentClientsInfo instance = null;
    private static List<TradingBroker> tradingBrokerList = new ArrayList<>();
    private static List<String> clientNames = new ArrayList<>();
    private static List<String> interestedCoinList = new ArrayList<>();

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

    public static void addTradingName(String newName) {
        clientNames.add(newName);
    }

    public static boolean ifBrokerNameDuplicated(String newName) {
        for (String name : clientNames) {
            if (newName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void clearLists() {
        tradingBrokerList = new ArrayList<>();
        clientNames = new ArrayList<>();
    }

    public static List<String> returnInterstedCoins() {
        Set<String> tradingSet = new HashSet<>();
        for (TradingBroker broker : tradingBrokerList) {
            List<String> coins = Arrays.asList(broker.getCoinList());
            for (String item : coins) {
                tradingSet.add(item);
            }
        }
        return new ArrayList<>(tradingSet);
    }
}
