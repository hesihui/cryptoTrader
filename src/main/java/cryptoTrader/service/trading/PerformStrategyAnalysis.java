package cryptoTrader.service.trading;

import cryptoTrader.entity.CurrentClientsInfo;
import cryptoTrader.entity.TradingBroker;
import cryptoTrader.entity.strategy.Strategy;
import cryptoTrader.entity.strategy.StrategyFactory;

import java.util.List;

public class PerformStrategyAnalysis {

    // Trigger the computation of the specific trading strategy associated with each trading broker.
    public void AnalyzeStrategy() {
        List<TradingBroker> tradingBrokerList = CurrentClientsInfo.returnBrokerList();
        StrategyFactory strategyFactory = new StrategyFactory();
        for (TradingBroker broker : tradingBrokerList) {
            String strategyChoice = broker.getStrategy();
            Strategy strategy = strategyFactory.getStrategy(strategyChoice);
            strategy.perform(broker);
        }
    }
}
