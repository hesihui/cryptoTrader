package cryptoTrader.entity.strategy;

import cryptoTrader.entity.TradingBroker;
import cryptoTrader.utils.strategyOperations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StrategyA implements Strategy {
    private List<String> coinsCanBePerformed = new ArrayList<String>();
    private String strategyName = "Strategy-A";
    String choice;

    public StrategyA() {
        choice = "Buy";
        coinsCanBePerformed.add("ETH");
        coinsCanBePerformed.add("BTC");
        coinsCanBePerformed.add("BNB");
        coinsCanBePerformed.add("USDC");
        coinsCanBePerformed.add("USDT");
    }

    @Override
    public void perform(TradingBroker broker) {
        StrategyOperationContext context = new StrategyOperationContext();
        // create strategy obj by the type of operations
        if (choice.equals("Buy")) {
            context.setStrategyOp(new BuyOperation());
        } else {
            context.setStrategyOp(new SellOperation());
        }

        // map for checking if broker is valid to perform
        Map<String, Double> coinPrice = broker.getCoinPriceMap();
        Boolean isFail = true;
        for (String coinName : coinPrice.keySet()) {
            if (coinPrice.get(coinName) == -100) {
                // if the provided coin name is not valid for data fetching
                isFail = true;
                context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
            } else if (!coinsCanBePerformed.contains(coinName)) {
                isFail = true;
                context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
            } else if (coinsCanBePerformed.contains(coinName)){
                // trading rule
                if (coinName.equals("BTC")) {
                    System.out.println(coinPrice.get(coinName) );
                    if (coinPrice.get(coinName) < 60000) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 100, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("ETH")) {
                    if (coinPrice.get(coinName) < 3500) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 100, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("BNB")) {
                    if (coinPrice.get(coinName) < 450) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 100, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("USDC")) {
                    if (coinPrice.get(coinName) < 1) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 100, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                } else if (coinName.equals("USDT")) {
                    if (coinPrice.get(coinName) < 1) {
                        isFail = false;
                        context.executeOperation(isFail, broker.getClientName(), strategyName, 100, coinName, coinPrice.get(coinName));
                    } else {
                        isFail = true;
                        context.executeOperation(isFail,broker.getClientName(),strategyName, 0, coinName, 0.0 );
                    }
                }

            }
        }
    }
}
