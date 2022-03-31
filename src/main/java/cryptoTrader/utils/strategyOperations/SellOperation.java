package cryptoTrader.utils.strategyOperations;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SellOperation implements StrategyOperation{
    public SellOperation() {

    }

    // (String trader,String strategy, int quantity, String coin, double price)
    @Override
    public boolean BTC(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "BTC", price);
        return isSuccessful;
    }

    @Override
    public boolean ETH(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "ETH", price);
        return isSuccessful;
    }

    @Override
    public boolean USDT(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "USDT", price);
        return isSuccessful;
    }

    @Override
    public boolean BNB(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "BNB", price);
        return isSuccessful;
    }

    @Override
    public boolean USDC(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "USDC", price);
        return isSuccessful;
    }

    @Override
    public boolean XRP(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "XRP", price);
        return isSuccessful;
    }

    @Override
    public boolean ADA(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "XRP", price);
        return isSuccessful;
    }

    @Override
    public boolean SOL(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "SOL", price);
        return isSuccessful;
    }

    @Override
    public boolean LUNA(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "LUNA", price);
        return isSuccessful;
    }

    @Override
    public boolean AVAX(String trader, String strategy, int quantity, double price) {
        boolean isSuccessful = writeTransactionDB(trader,strategy,quantity, "AVAX", price);
        return isSuccessful;
    }

    private boolean writeTransactionDB(String trader,String strategy, int quantity, String coin, double price) {
        String action = "Sell";
        try {
            FileWriter writer = new FileWriter("transactionDB.txt");
            String date = currDateGenerator();
            writer.write(trader+ "," + strategy + "," + coin + "," + action + "," + quantity + "," + price + "," + date);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String currDateGenerator() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return formatter.format(date);
    }
}
