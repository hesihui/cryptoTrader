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
    public void BTC(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "BTC", price);
    }

    @Override
    public void ETH(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "ETH", price);
    }

    @Override
    public void USDT(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "USDT", price);
    }

    @Override
    public void BNB(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "BNB", price);
    }

    @Override
    public void USDC(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "USDC", price);
    }

    @Override
    public void XRP(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "XRP", price);
    }

    @Override
    public void ADA(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "XRP", price);
    }

    @Override
    public void SOL(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "SOL", price);
    }

    @Override
    public void LUNA(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "LUNA", price);
    }

    @Override
    public void AVAX(String trader, String strategy, int quantity, double price) {
        writeTransactionDB(trader,strategy,quantity, "AVAX", price);
    }

    private void writeTransactionDB(String trader, String strategy, int quantity, String coin, double price) {
        String action = "Buy";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactionDB.txt", true));
            String date = currDateGenerator();
            writer.write(trader+ "," + strategy + "," + coin + "," + action + "," + quantity + "," + price + "," + date);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleInvalidBroker(String trader, String strategy, String coin) {
        String action = "Fail (strategy can not be applied)";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactionDB.txt", true));
            String date = currDateGenerator();
            writer.write(trader+ "," + strategy + "," + coin + "," + action + "," + "Null" + "," + "Null" + "," + date);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
