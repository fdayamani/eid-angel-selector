package output;

import domain.Child;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputHandler {
    public static Map<String, List<String>> outputMessages(Map<Child, Child> allocations) {
        Map<String, List<String>> messages = new HashMap<>();
        allocations.forEach((child, match) -> {
            messages.computeIfAbsent(child.getMothersMobile(),
                    k -> new ArrayList<>()).add(matchMessage(child, match));
        });
        return messages;
    }

    private static String matchMessage(Child child, Child match) {
        return String.format("Salaam, hope you're well\n" +
                        "The Eid Angel for %s is %s! Age - %s.\n" +
                        "The mother's mobile number is %s\n",
                child.getName(), match.getName(), match.getAge(), match.getMothersMobile());
    }
}
