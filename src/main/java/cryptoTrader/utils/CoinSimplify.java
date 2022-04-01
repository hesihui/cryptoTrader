package cryptoTrader.utils;
import java.util.*;

public class CoinSimplify {

	static Hashtable<String, String> cryptoCoin = null;
	public CoinSimplify() {
		// TODO Auto-generated constructor stub
	}

	public static Hashtable<String, String> getCoinNameMap() {
		cryptoCoin = new Hashtable<String, String>();
		cryptoCoin.put("BTC","bitcoin");
		cryptoCoin.put("ETH","ethereum");
		cryptoCoin.put("USDT","tether");
		cryptoCoin.put("BNB","bnb");
		cryptoCoin.put("USDC","usd coin");
		cryptoCoin.put("XRP","xrp");
		cryptoCoin.put("ADA","cardano");
		cryptoCoin.put("SOL","solana");
		cryptoCoin.put("LUNA","terra");
		cryptoCoin.put("AVAX","avalanche");
		cryptoCoin.put("DOT","polkadot");
		cryptoCoin.put("DOGE","dogecoin");
		cryptoCoin.put("BUSD","binance usd");
		cryptoCoin.put("UST","terra usd");
		cryptoCoin.put("SHIB","shiba inu");
		cryptoCoin.put("MATIC","polygon");
		cryptoCoin.put("WBTC","wrapped bitcoin");
		cryptoCoin.put("CRO","cronos");
		cryptoCoin.put("DAI","dai");
		cryptoCoin.put("NEAR","near protocol");

		return cryptoCoin;
	}

	public static boolean check(String coin) {
		// TODO Auto-generated method stub
		String coin2 = null;
		List<String> coinAvaliable = new ArrayList<>();
		coin2 = coin;
		Map<String, String> coinMap = getCoinNameMap();
		for (String key: coinMap.keySet()) {
			coinAvaliable.add(key);
		}
		if (!coinAvaliable.contains(coin)) {
			return false;
		}
		return true;
	}
}