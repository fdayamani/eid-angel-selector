package data;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvDataHandlerTest {

    private final DataHandler dataHandler = new CsvDataHandler("src/test/resources/responses.csv");

    @Test
    public void
    correctlySelectsDataFromACsv() throws GeneralSecurityException, IOException {
        List<FormResponse> unassigned = dataHandler.transformData();

        assertThat(unassigned).containsExactlyInAnyOrder(
                new FormResponse("Safina Zahra Damani", "4", "07595119703", "Yes"),
                new FormResponse("Ayah Imaan Damani", "5m", "07595119703", "No"),
                new FormResponse("Adil Walji", "10", "07850610204", "Don't remember")
        );
    }


}
