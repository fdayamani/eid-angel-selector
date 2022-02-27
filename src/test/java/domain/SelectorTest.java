package domain;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SelectorTest {

    Selector underTest;

    @Test public void
    onceAChildHasBeenMatchedDoNotMatchAgain() {
        List<Child> children = List.of(
                new Child("child1", "11", "some-number", Optional.empty()),
                new Child("child2", "11", "another-number", Optional.empty()),
                new Child("child3", "11", "some-other-number", Optional.empty()),
                new Child("child4", "11", "a-number", Optional.empty())
        );

        underTest = new Selector(children);

        Collection<Child> assignedChildren = underTest.assignAngels().values();
        assertThat(assignedChildren.size()).isEqualTo(assignedChildren.stream().distinct().count());
        assertThat(assignedChildren).containsAll(children);
    }

    @Test public void
    throwsExceptionIfFinalMatchIsSiblings() {
        List<Child> siblings = List.of(
           new Child("brother", "11", "07123456789", Optional.empty()),
           new Child("sister", "8", "07123456789", Optional.empty())
        );

        underTest = new Selector(siblings);

        assertThatExceptionOfType(InvalidMatchAttempt.class)
                .isThrownBy(() -> underTest.assignAngels())
                .withMessage("Could not find suitable match for brother")
                ;
    }

    @Test public void
    throwsExceptionIfFinalMatchIsLastYearsAngel() {
        List<Child> sameAsLastYear = List.of(
                new Child("child1", "2", "07123456789",
                        Optional.of(new Child("child2", null, "07987654321", Optional.empty()))),
                new Child("child2", null, "07987654321", Optional.empty())
        );

        underTest = new Selector(sameAsLastYear);

        assertThatExceptionOfType(InvalidMatchAttempt.class)
                .isThrownBy(() -> underTest.assignAngels())
                .withMessage("Could not find suitable match for child1");
    }
}
