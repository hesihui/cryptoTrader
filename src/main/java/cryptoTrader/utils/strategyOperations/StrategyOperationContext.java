package cryptoTrader.utils.strategyOperations;

import cryptoTrader.entity.strategy.Strategy;

public class StrategyOperationContext {
    private StrategyOperation strategyOperation;
    public StrategyOperationContext() {
    }

    public void setStrategyOp(StrategyOperation strategyOp) {
        this.strategyOperation = strategyOp;
    }


    public void executeOperation(Boolean isFail, String trader, String strategy, int quantity, String coin, double price) {
        if (!isFail) {
            strategyOperation.writeTransactionDB(trader, strategy,quantity,coin,price);
        } else {
            strategyOperation.handleInvalidBroker(trader,strategy,coin);
        }
    }
}
