package data;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static data.DataHandler.transformData;
import static data.DataHandler.values;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class DataHandlerTest {

    private String testSheetId = "1cqDAzwh03eyaKvMd23UGx4TTBI1rH6d0fZvTy2B-cKQ";

    @Test public void
    correctlySelectsDataFromAGoogleSheet() throws GeneralSecurityException, IOException {
        transformData(testSheetId);

        List<Object> mothers = values.stream().map(row -> row.get(0)).collect(toList());

        assertThat(mothers).containsExactlyInAnyOrder("Siddika Walji", "Fatema Damani");
    }

}
