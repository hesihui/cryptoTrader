package cryptoTrader.entity.strategy;

import cryptoTrader.entity.TradingBroker;
import cryptoTrader.utils.strategyOperations.BuyOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategyB implements Strategy{
    private List<String> coinsCanBePerformed = new ArrayList<String>();
    private String strategyName = "Strategy-B";

    public StrategyB() {
        coinsCanBePerformed.add("ETH");
        coinsCanBePerformed.add("BTC");
        coinsCanBePerformed.add("SOL");
        coinsCanBePerformed.add("XRP");
        coinsCanBePerformed.add("ADA");  
    }

    @Override
    public void perform(TradingBroker broker) {
        BuyOperation buyOperation = new BuyOperation();
        // check if broker is valid to perform
        Map<String, Double> coinPrice = broker.getCoinPriceMap();

        for (String coinName : coinPrice.keySet()) {
            if (coinPrice.get(coinName) == -100 || !coinsCanBePerformed.contains(coinName)) {
                // if the provided coin name is not valid for data fetching
                buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
            } else if (coinsCanBePerformed.contains(coinName)){
                // trading rule
                if (coinName.equals("BTC")) {
                    if (coinPrice.get(coinName) < 45600) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 1000, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("ETH")) {
                    if (coinPrice.get(coinName) < 3200) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 300, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("SOL")) {
                    if (coinPrice.get(coinName) < 122) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 500, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("XRP")) {
                    if (coinPrice.get(coinName) < 0.8) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 30000, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("ADA")) {
                    if (coinPrice.get(coinName) < 1.15) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 20000, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                }

            }
        }
    }
}
