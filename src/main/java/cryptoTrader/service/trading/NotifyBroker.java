package cryptoTrader.service.trading;

import cryptoTrader.entity.CurrentClientsInfo;
import cryptoTrader.entity.TradingBroker;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class NotifyBroker {

    public void updateBrokerCoinPrice() {
        // get all the prices of coins in the list of interested coins
        Map<String, Double> coinPriceMap =  FetchCoinData.getCoinPrice();
        // pass the appropriate prices to the right trading broker
        List<TradingBroker> tradingBrokerList = CurrentClientsInfo.returnBrokerList();
        for (TradingBroker broker : tradingBrokerList) {
            List<String> coins = Arrays.asList(broker.getCoinList()); // stores interested coin list for single broker
            // check if broker's interested list contains all the valid coins
            if (!FetchCoinData.checkinterestedList(coins)) {
                broker.updateBrokerStatus(false);
                continue;
            } else {
                broker.updateBrokerStatus(true);
            }
            // update coin price
            for (String coin : coins) {
                double price = coinPriceMap.get(coins);
                broker.updateCoinPrice(coin, price);
            }
        }
    }

    public static void main(String[] args) {

    }
}
