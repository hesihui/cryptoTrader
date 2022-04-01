package cryptoTrader.entity.strategy;

import cryptoTrader.entity.TradingBroker;
import cryptoTrader.utils.strategyOperations.BuyOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategyC implements Strategy{
    private List<String> coinsCanBePerformed = new ArrayList<String>();
    private String strategyName = "Strategy-C";

    public StrategyC() {
        coinsCanBePerformed.add("ETH");
        coinsCanBePerformed.add("BTC");
        coinsCanBePerformed.add("LUNA");
        coinsCanBePerformed.add("AVAX");
        coinsCanBePerformed.add("BNB");
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
                    if (coinPrice.get(coinName) < 45500) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 20, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("ETH")) {
                    if (coinPrice.get(coinName) < 3150) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 150, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("BNB")) {
                    if (coinPrice.get(coinName) < 428) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 50, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("LUNA")) {
                    if (coinPrice.get(coinName) < 103) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 2500, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("AVAX")) {
                    if (coinPrice.get(coinName) < 95) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 30, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                }

            }
        }
    }
}