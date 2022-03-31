package cryptoTrader.service.trading;

import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;    

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
	static List<String> CoinList = new ArrayList<>();
	
	private static Map<String, Double> getCoinPrice() {
		Map<String, String> coinMap = CoinSimplify.getCoinNameMap();
		Map<String, Double> coinPrice = new HashMap<String, Double>();
		CoinList = CurrentClientsInfo.returnInterstedCoins();
		CoinList.add("BTC");
		CoinList.add("ETH");
//		System.out.println(CoinList.toString());
//		System.out.println(CoinList.size());
//		System.out.println(coinMap.keySet());
		for (int i =0; i < CoinList.size(); i++) {
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
    public static void main(String[] args) {
	Map<String, Double> buffer = getCoinPrice();
	for (Entry entry: buffer.entrySet()) {
	    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
	}
	}
}