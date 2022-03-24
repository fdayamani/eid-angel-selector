import data.CsvDataHandler;
import data.DataHandler;
import data.SheetsDataHandler;
import domain.Child;
import domain.Selector;
import output.OutputHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Map;

public class App {

    public static void main(String... args) throws IOException, GeneralSecurityException {
//        DataHandler dataHandler = new SheetsDataHandler("1CbVUmNPBoEjvDI1fWA2AsHnVO0NZk1QvFpzApBqlM6w");
        DataHandler dataHandler = new CsvDataHandler("src/main/resources/responses.csv");
        Selector selector = new Selector(dataHandler.transformData());
        Map<Child, Child> allocations = selector.assignAngels();
        saveAllocations(allocations);
    }

    private static void saveAllocations(Map<Child, Child> allocations) throws IOException {
        BufferedWriter rawWriter = new BufferedWriter(new FileWriter(String.format("raw_allocations-%d.txt", System.currentTimeMillis())));
        BufferedWriter messageWriter = new BufferedWriter(new FileWriter(String.format("allocations-%d.txt", System.currentTimeMillis())));
        rawWriter.write(allocations.toString());
        messageWriter.write(OutputHandler.outputMessages(allocations).toString());
        rawWriter.close();
        messageWriter.close();
    }

}
