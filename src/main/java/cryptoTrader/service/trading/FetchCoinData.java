package cryptoTrader.service.trading;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cryptoTrader.entity.CurrentClientsInfo;
import cryptoTrader.utils.CoinSimplify;
import cryptoTrader.utils.DataFetcher;

public class FetchCoinData {
    private static List<String> CoinList = new ArrayList<>();

    public static Map<String, Double> getCoinPrice() {
        Map<String, String> coinMap = CoinSimplify.getCoinNameMap();
        Map<String, Double> coinPrice = new HashMap<String, Double>();
        CoinList = CurrentClientsInfo.returnInterstedCoins();
        for (int i = 0; i < CoinList.size(); i++) {
            String coin = CoinList.get(i);
            for (String key: coinMap.keySet()) {

                if (coin.equals(key)){
                    String coinFullName = coinMap.get(key);
                    DataFetcher fetcher = new DataFetcher();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = new Date();
                    double price = fetcher.getPriceForCoin(coinFullName, formatter.format(date));
                    price = Math.round(price * 100.0) / 100.0;
                    coinPrice.put(key, price);
                }
            }
        }
        return coinPrice;
    }

    // if return false the coins in the interested list can not get price.
    public boolean checkinterested(String coin) {
        return CoinSimplify.check(coin);
    }

}