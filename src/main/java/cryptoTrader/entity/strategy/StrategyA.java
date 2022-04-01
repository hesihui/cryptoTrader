package cryptoTrader.entity.strategy;

import cryptoTrader.entity.TradingBroker;
import cryptoTrader.utils.strategyOperations.BuyOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategyA implements Strategy {
    private List<String> coinsCanBePerformed = new ArrayList<String>();
    private String strategyName = "Strategy-A";

    public StrategyA() {
        coinsCanBePerformed.add("ETH");
        coinsCanBePerformed.add("BTC");
        coinsCanBePerformed.add("BNB");
        coinsCanBePerformed.add("USDC");
        coinsCanBePerformed.add("USDT");
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
                    if (coinPrice.get(coinName) < 57000) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 100, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("ETH")) {
                    if (coinPrice.get(coinName) < 3100) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 100, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("BNB")) {
                    if (coinPrice.get(coinName) < 429) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 100, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("USDC")) {
                    if (coinPrice.get(coinName) < 1) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 100, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("USDT")) {
                    if (coinPrice.get(coinName) < 1) {
                        buyOperation.BTC(broker.getClientName(), strategyName, 100, coinPrice.get(coinName));
                    } else {
                        buyOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                }

            }
        }
    }
}
