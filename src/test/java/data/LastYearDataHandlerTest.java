package data;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LastYearDataHandlerTest {

    LastYearDataHandler underTest = new LastYearDataHandler("src/test/resources/last_year_allocations.json");

    @Test public void
    returnsParsedData() throws IOException {
        Map<Angel, Angel> allocations = underTest.transformData();

        assertThat(allocations).containsExactlyInAnyOrderEntriesOf(
        Map.of(new Angel("Fatemah","07785724488"), new Angel("Sara Dewji", "07703738469"),
        new Angel("Layla Merali", "07891683053"), new Angel("Zahra Mohamedali", "07962320328"),
        new Angel("Aaminah Dewji", "07841425581"),new Angel("Hadi Mohamedali", "07962320328")));
    }
}