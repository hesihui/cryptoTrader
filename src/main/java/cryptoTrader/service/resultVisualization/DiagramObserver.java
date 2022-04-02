package cryptoTrader.service.resultVisualization;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.utils.DataVisualizationCreator;

import java.util.List;

public class DiagramObserver extends Observer{
    public DiagramObserver() {

    }

    public DiagramObserver(Subject transaction){
        this.transaction = transaction;
    }

    @Override
    public void generate(String[][] data, List<ClientTradingRecord> list) {
        DataVisualizationCreator creator = new DataVisualizationCreator();
        creator.createBar(list);
    }
}
