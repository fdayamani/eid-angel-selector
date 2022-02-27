package output;

import domain.Child;

import java.util.HashMap;
import java.util.Map;

public class OutputHandler {
    public static Map<String, String> outputMessages(Map<Child, Child> allocations) {
        Map<String, String> messages = new HashMap<>();
        allocations.forEach((child, match) -> {
            messages.put(child.getMothersMobile(),
                    String.format("The Eid Angel for %s is %s! Age - %s. The mother's mobile number is %s",
                            child.getName(), match.getName(), match.getAge(), match.getMothersMobile()));
        });
        return messages;
    }
}
