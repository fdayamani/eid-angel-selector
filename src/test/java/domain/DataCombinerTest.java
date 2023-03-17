package domain;

import data.Angel;
import data.FormResponse;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static domain.DataCombiner.combineData;
import static org.assertj.core.api.Assertions.assertThat;

class DataCombinerTest {

    @Test public void
    combinesDataCorrectly() {
        List<FormResponse> responses = List.of(
                new FormResponse("name", "age", "some-number", "Yes"),
                new FormResponse("took-part-name", "took-part-age", "took-part-number", "Don't remember"),
                new FormResponse("first-year-name", "first-year-age", "first-year-number", "Don't remember"),
                new FormResponse("another-name", "another-age", "some-new-number", "No")
        );
        Map<Angel, Angel> allocations = Map.of(
                new Angel("name", "some-number"), new Angel("angel", "some-other-number"),
                new Angel("took-part-name", "took-part-number"), new Angel("another-angel", "another-number")
        );
        List<Child> children = combineData(responses, allocations);

        assertThat(children).containsExactlyInAnyOrder(
                new Child("name", "age", "some-number", Optional.of(new Angel("angel", "some-other-number"))),
                new Child("took-part-name", "took-part-age", "took-part-number", Optional.of(new Angel("another-angel", "another-number"))),
                new Child("first-year-name", "first-year-age", "first-year-number", Optional.empty()),
                new Child("another-name", "another-age", "some-new-number", Optional.empty())
        );
    }

}