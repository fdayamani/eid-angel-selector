package data;

import domain.Child;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.assertj.core.api.Assertions.assertThat;

public class SheetsDataHandlerTest {

    private String testSheetId = "1GEaYs6ERiAylHa9lKlzYLHD8EoTtSxlfo1Oe-zHvyrk";
    private DataHandler dataHandler = new SheetsDataHandler(testSheetId);

    @Test public void
    correctlySelectsDataFromAGoogleSheet() throws GeneralSecurityException, IOException {
        List<Child> unassigned = dataHandler.transformData();

        assertThat(unassigned).containsExactlyInAnyOrder(
                new Child("Safina Zahra Damani", "3", "'07595119703",
                        Optional.of(new Child("Hadi Khimji", "Not set", "07962320328", empty()))),
                new Child("Asadali Walji", "11", "07850610204",
                        Optional.of(new Child("Ayaan Ali Kassam", "Not set", "07751694480", empty()))),
                new Child ("Adil Walji", "8", "07850610204",
                        Optional.of(new Child("Safina Zahra Damani", "Not set", "07595119703", empty())))
        );
    }

}
