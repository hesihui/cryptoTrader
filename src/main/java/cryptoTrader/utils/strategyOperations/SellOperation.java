package cryptoTrader.utils.strategyOperations;

import cryptoTrader.utils.DateConverter;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SellOperation implements StrategyOperation{
    public SellOperation() {

    }

    public void writeTransactionDB(String trader, String strategy, int quantity, String coin, double price) {
        String action = "Sell";
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

    private String currDateGenerator() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String dateStr = formatter.format(date);
        DateConverter dateConverter = new DateConverter();
        dateStr = dateConverter.convertDate(dateStr);
        return dateStr;
    }

    public void handleInvalidBroker(String trader, String strategy, String coin) {
        String message = "Cannot apply " + strategy + " with " + coin + " \nfor "+ trader;
        JOptionPane.showMessageDialog(null, message, "Strategy Can't Apply", JOptionPane.INFORMATION_MESSAGE);
        String action ="Fail (strategy not applied)";

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
