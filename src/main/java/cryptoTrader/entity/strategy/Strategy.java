package cryptoTrader.entity.strategy;

import cryptoTrader.entity.TradingBroker;

public interface Strategy {

    public void perform(TradingBroker broker);

}