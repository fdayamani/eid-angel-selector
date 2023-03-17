import data.*;
import domain.Child;
import domain.DataCombiner;
import domain.Selector;
import output.OutputHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String... args) throws IOException, GeneralSecurityException {
        DataHandler dataHandler = new CsvDataHandler("src/main/resources/responses.csv");
        LastYearDataHandler lastYearDataHandler = new LastYearDataHandler("src/main/resources/last_year_allocations.json");
        List<FormResponse> responses = dataHandler.transformData();
        Map<Angel, Angel> lastYearsAllocations = lastYearDataHandler.transformData();

        List<Child> children = DataCombiner.combineData(responses, lastYearsAllocations);

        Selector selector = new Selector(children);
        Map<Child, Child> allocations = selector.assignAngels();
        saveAllocations(allocations);
    }

    private static void saveAllocations(Map<Child, Child> allocations) throws IOException {
        BufferedWriter rawWriter = new BufferedWriter(new FileWriter(String.format("raw_allocations-%d.txt", System.currentTimeMillis())));
        BufferedWriter messageWriter = new BufferedWriter(new FileWriter(String.format("allocations-%d.txt", System.currentTimeMillis())));
        rawWriter.write(OutputHandler.outputJson(allocations));
        messageWriter.write(OutputHandler.outputMessages(allocations).toString());
        rawWriter.close();
        messageWriter.close();
    }

}
