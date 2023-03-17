package domain;

import data.Angel;
import data.FormResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataCombiner {
    public static List<Child> combineData(List<FormResponse> responses, Map<Angel, Angel> lastYearsAllocations) {
        return responses.stream()
                .map(r ->
                        new Child(
                                r.getName(),
                                r.getAge(),
                                r.getMothersMobile(),
                                Optional.ofNullable(lastYearsAllocations.get(new Angel(
                                        r.getName(),
                                        r.getMothersMobile()
                                )))
                        )).collect(Collectors.toList());
    }
}
