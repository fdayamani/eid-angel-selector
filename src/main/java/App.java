import data.DataHandler;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class App {

    public static void main(String... args) throws IOException, GeneralSecurityException {
        DataHandler.transformData("1CbVUmNPBoEjvDI1fWA2AsHnVO0NZk1QvFpzApBqlM6w");
        /*
        Eventually, this would look like:
        selector.selectEidAngelsFrom(DataHandler.transformData());
         */
    }

}
