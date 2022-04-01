package cryptoTrader.entity.strategy;

import cryptoTrader.entity.TradingBroker;
import cryptoTrader.utils.strategyOperations.SellOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategyD implements Strategy{
    private List<String> coinsCanBePerformed = new ArrayList<String>();
    private String strategyName = "Strategy-D";

    public StrategyD() {
        coinsCanBePerformed.add("ETH");
        coinsCanBePerformed.add("BTC");
        coinsCanBePerformed.add("BNB");
        coinsCanBePerformed.add("USDC");
        coinsCanBePerformed.add("USDT");   
    }


    @Override
    public void perform(TradingBroker broker) {
        SellOperation sellOperation = new SellOperation();
        // check if broker is valid to perform
        Map<String, Double> coinPrice = broker.getCoinPriceMap();

        for (String coinName : coinPrice.keySet()) {
            if (coinPrice.get(coinName) == null || !coinsCanBePerformed.contains(coinName)) {
                // if the provided coin name is not valid for data fetching
                sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
            } else if (coinsCanBePerformed.contains(coinName)){
                // trading rule
                if (coinName.equals("BTC")) {
                    if (coinPrice.get(coinName) > 45800) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 200, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("ETH")) {
                    if (coinPrice.get(coinName) > 3300) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 500, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("BNB")) {
                    if (coinPrice.get(coinName) > 430) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 500, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("USDC")) {
                    if (coinPrice.get(coinName) > 1) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 400, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                } else if (coinName.equals("USDT")) {
                    if (coinPrice.get(coinName) > 1) {
                        sellOperation.BTC(broker.getClientName(), strategyName, 500, coinPrice.get(coinName));
                    } else {
                        sellOperation.handleInvalidBroker(broker.getClientName(), strategyName, coinName);
                    }
                }
            }
        }
    }
}