package cryptoTrader.service.resultVisualization;

import cryptoTrader.entity.ClientTradingRecord;

import java.util.*;

public class Subject {
    protected  List<Observer> observerList = new ArrayList<Observer>();

    public void add(Observer observer) {
        observerList.add(observer);
    }

    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObserver(String[][] data, List<ClientTradingRecord> list) {
        for (Observer observer : observerList) {
            ((Observer)observer).generate(data, list);
        }
    }

}
