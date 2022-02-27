import domain.Child;
import domain.Selector;
import output.OutputHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.Random;

import static data.DataHandler.transformData;

public class App {

    public static void main(String... args) throws IOException, GeneralSecurityException {
        String responsesSheetId = "1CbVUmNPBoEjvDI1fWA2AsHnVO0NZk1QvFpzApBqlM6w";
        Selector selector = new Selector(transformData(responsesSheetId));
        Map<Child, Child> allocations = selector.assignAngels();
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("allocations-%d.txt", System.currentTimeMillis())));
        writer.write(OutputHandler.outputMessages(allocations).toString());

        writer.close();
    }

}
