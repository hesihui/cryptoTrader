package cryptoTrader.service.resultVisualization;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.entity.CurrentClientsInfo;

import java.util.List;

public abstract class Observer {
    protected Subject transaction;
    public abstract void generate(String[][] data, List<ClientTradingRecord> list);
}
