package cryptoTrader.service.trading;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.entity.TransactionRecord;
import cryptoTrader.service.resultVisualization.*;

import java.util.List;

public class DisplayCoinData {
    public void visualizationGenerator() {
        String[][] recordArr = TransactionRecord.returnTransactionRecord();
        List<ClientTradingRecord> list = TransactionRecord.returnClientRecordList();

        Subject transaction = new Subject();
        Observer table = new TableObserver();
        transaction.add(table);
        Observer diagram = new DiagramObserver();
        transaction.add(diagram);
        transaction.notifyObserver(recordArr, list);
    }
}
