package cryptoTrader.utils.strategyOperations;
import cryptoTrader.utils.DateConverter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyOperation implements StrategyOperation {
    public BuyOperation() {

    }

    private String currDateGenerator() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String dateStr = formatter.format(date);
        DateConverter dateConverter = new DateConverter();
        dateStr = dateConverter.convertDate(dateStr);
        return dateStr;
    }

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

    private boolean writeTransactionDB(String trader, String strategy, int quantity, String coin, double price) {
        String action = "Buy";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactionDB.txt", true));
            String date = currDateGenerator();
            writer.write(trader+ "," + strategy + "," + coin + "," + action + "," + quantity + "," + price + "," + date + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void handleInvalidBroker(String trader, String strategy, String coin) {
        String action = "Fail";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactionDB.txt", true));
            String date = currDateGenerator();
            writer.write(trader+ "," + strategy + "," + coin + "," + action + "," + "Null" + "," + "Null" + "," + date + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

