package cryptoTrader.entity.strategy;

import cryptoTrader.entity.TradingBroker;
import cryptoTrader.utils.strategyOperations.SellOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategyE implements Strategy{

    private List<String> coinsCanBePerformed = new ArrayList<String>();
    private String strategyName = "Strategy-D";

    public StrategyE() {
        coinsCanBePerformed.add("SOL");
        coinsCanBePerformed.add("XRP");
        coinsCanBePerformed.add("ADA");
        coinsCanBePerformed.add("LUNA");
        coinsCanBePerformed.add("AVAX");
    }

    @Override
    public void perform(TradingBroker broker) {
        SellOperation sellOperation = new SellOperation();
        // check if broker is valid to perform
        Map<String, Double> coinPrice = broker.getCoinPriceMap();

        for (String coinName : coinPrice.keySet()) {
            if (coinPrice.get(coinName) == -100 || !coinsCanBePerformed.contains(coinName)) {
                // if the provided coin name is not valid for data fetching
                sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
            } else if (coinsCanBePerformed.contains(coinName)){
                // trading rule
                if (coinName.equals("SOL")) {
                    if (coinPrice.get(coinName) > 125) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 200, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("XRP")) {
                    if (coinPrice.get(coinName) > 0.8) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 250, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("ADA")) {
                    if (coinPrice.get(coinName) > 1.2) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 300, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("LUNA")) {
                    if (coinPrice.get(coinName) > 105) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 400, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("AVAX")) {
                    if (coinPrice.get(coinName) > 98) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 20, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                }
            }
        }
    }
}
