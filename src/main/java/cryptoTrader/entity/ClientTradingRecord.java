package cryptoTrader.entity;

import java.util.*;

public class ClientTradingRecord {
    private String clientName;
    private Map<String, Integer> countMap = new HashMap<>();

    private List<Integer> count1 = new ArrayList<>();
    public ClientTradingRecord(String name) {
        this.clientName = name;
        // initialize the countMap
        countMap.put("Strategy-A", 0);
        countMap.put("Strategy-B", 0);
        countMap.put("Strategy-C", 0);
        countMap.put("Strategy-D", 0);
        countMap.put("Strategy-E", 0);
    }

    public void setClientName(String name) {
        this.clientName = name;
    }

    public String getClientName() {
        return clientName;
    }
    public void updateCount(String strategy, int count) {
        countMap.put(strategy, count);
    }

    public void increaseCountByOne(String strategy) {
        int count = countMap.get(strategy) + 1;
        countMap.put(strategy, count);
    }

    public int getStrategyACount() {
        return countMap.get("Strategy-A");
    }

    public int getStrategyBCount() {
        return countMap.get("Strategy-B");
    }

    public int getStrategyCCount() {
        return countMap.get("Strategy-C");
    }


    public int getStrategyDCount() {
        return countMap.get("Strategy-D");
    }

    public int getStrategyECount() {
        return countMap.get("Strategy-E");
    }
}
