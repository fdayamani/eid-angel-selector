package output;

import domain.Child;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static output.OutputHandler.outputJson;
import static output.OutputHandler.outputMessages;

public class OutputHandlerTest {

    @Test public void
    suitableMessageForEachMother() {
        Map<Child, Child> allocations = Map.of(
                new Child("child1", "2", "number", Optional.empty()), new Child("child2", "1", "another-number", Optional.empty()),
                new Child("child2", "5", "some-number", Optional.empty()), new Child("child5", "7m", "yet-another-number", Optional.empty()),
                new Child("child3", "6", "some-number", Optional.empty()), new Child("child21", "5", "0712345806", Optional.empty())
                );
        Map<String, List<String>> messages = outputMessages(allocations);

        assertThat(messages.get("number")).containsExactly("Salaam, hope you're well\nThe Eid Angel for child1 is child2! Age - 1.\nThe mother's mobile number is another-number\n");
        assertThat(messages.get("some-number")).containsExactlyInAnyOrder("Salaam, hope you're well\nThe Eid Angel for child2 is child5! Age - 7m.\nThe mother's mobile number is yet-another-number\n", "Salaam, hope you're well\nThe Eid Angel for child3 is child21! Age - 5.\nThe mother's mobile number is 0712345806\n");
    }

//    @Test public void
//    outputsJson() {
//        Map<Child, Child> allocations = Map.of(
//                new Child("child1", "2", "number", Optional.empty()), new Child("child2", "1", "another-number", Optional.empty()),
//                new Child("child2", "5", "some-number", Optional.empty()), new Child("child5", "7m", "yet-another-number", Optional.empty()),
//                new Child("child3", "6", "some-number", Optional.empty()), new Child("child21", "5", "0712345806", Optional.empty())
//        );
//        String json = outputJson(allocations);
//        assertThat(json).isEqualTo("[{\"name\": \"child1\", \"mothersMobile\": \"number\", \"lastYearsAngel\":  {\"name\": \"child2\", \"mothersMobile\": \"another-number\"}},\n" +
//                "{\"name\": \"child2\", \"mothersMobile\": \"some-number\", \"lastYearsAngel\":  {\"name\": \"child5\", \"mothersMobile\": \"yet-another-number\"}},\n" +
//                "{\"name\": \"child3\", \"mothersMobile\": \"some-number\", \"lastYearsAngel\":  {\"name\": \"child21\", \"mothersMobile\": \"0712345806\"}}]\n");
//    }
}
