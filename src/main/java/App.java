import data.DataHandler;
import domain.Child;
import domain.Selector;
import output.OutputHandler;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;

import static data.DataHandler.transformData;

public class App {

    public static void main(String... args) throws IOException, GeneralSecurityException {
        String responsesSheetId = "1CbVUmNPBoEjvDI1fWA2AsHnVO0NZk1QvFpzApBqlM6w";
        Selector selector = new Selector(transformData(responsesSheetId));
        Map<Child, Child> allocations = selector.assignAngels();
        System.out.println(OutputHandler.outputMessages(allocations));
    }

}
