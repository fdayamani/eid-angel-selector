package domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SelectorTest {

    Selector underTest;

    @Test public void
    throwsExceptionIfFinalMatchIsSiblings() {
        List<Child> siblings = List.of(
           new Child("brother", "11", "07123456789", Optional.empty()),
           new Child("sister", "8", "07123456789", Optional.empty())
        );

        underTest = new Selector(siblings);

        assertThatExceptionOfType(InvalidMatchAttempt.class)
                .isThrownBy(() -> underTest.assignAngels())
                .withMessage("Attempting to match siblings")
                ;
    }

    @Test public void
    throwsExceptionIfFinalMatchIsLastYearsAngel() {
        //TODO: implement
    }
}
