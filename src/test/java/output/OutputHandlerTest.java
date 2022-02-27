package output;

import domain.Child;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static output.OutputHandler.outputMessages;

public class OutputHandlerTest {

    @Test public void
    suitableMessageForEachMother() {
        Map<Child, Child> allocations = Map.of(new Child("child1", "2", "number", Optional.empty()), new Child("child2", "1", "another-number", Optional.empty()),
                new Child("child2", "5", "some-number", Optional.empty()), new Child("child5", "7m", "yet-another-number", Optional.empty()));
        Map<String, String> messages = outputMessages(allocations);

        assertThat(messages).containsAllEntriesOf(Map.of(
                "number", "The Eid Angel for child1 is child2! Age - 1. The mother's mobile number is another-number",
                "some-number", "The Eid Angel for child2 is child5! Age - 7m. The mother's mobile number is yet-another-number"));
    }
}
