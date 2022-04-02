package cryptoTrader.service.resultVisualization;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.utils.DataVisualizationCreator;

import java.util.List;

public class TableObserver extends Observer{
    public TableObserver() {

    }

    public TableObserver(Subject transaction){
        this.transaction = transaction;
    }

    @Override
    public void generate(String[][] data, List<ClientTradingRecord> list) {
        DataVisualizationCreator creator = new DataVisualizationCreator();
        creator.createTableOutput(data);
//        creator.createBar();
    }
}
