package cryptoTrader.entity.strategy;

public class StrategyFactory {

    public Strategy getStrategy(String strategyName) {
        if (strategyName.equals("Strategy-A")) {
            return new StrategyA();
        }else if (strategyName.equals("Strategy-B")) {
            return new StrategyB();
        } else if (strategyName.equals("Strategy-C")) {
            return new StrategyC();
        } else if (strategyName.equals("Strategy-D")) {
            return new StrategyD();
        } else {
            return new StrategyE();
        }
    }
}
