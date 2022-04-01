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

//		CoinList.add("BTC");
//		CoinList.add("ETH");
//		System.out.println(CoinList.toString());
//		System.out.println(CoinList.size());
//		System.out.println(coinMap.keySet());
        for (int i = 0; i < CoinList.size(); i++) {
            String coin = CoinList.get(i);
            for (String key: coinMap.keySet()) {

                if (coin.equals(key)){
                    String coinFullName = coinMap.get(key);
                    DataFetcher fetcher = new DataFetcher();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = new Date();
                    double price = fetcher.getPriceForCoin(coinFullName, formatter.format(date));
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
//
//    public static void main(String[] args) {
//    	List<String> coinList2 = new ArrayList<>();
//    	coinList2.add("BTC");
//    	coinList2.add("ETH");
//    	boolean flag = checkinterestedList(coinList2);
//    	System.out.println(flag);
//	}
}