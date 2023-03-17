package output;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import data.Angel;
import domain.Child;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class OutputHandler {
    public static Map<String, List<String>> outputMessages(Map<Child, Child> allocations) {
        Map<String, List<String>> messages = new HashMap<>();
        allocations.forEach((child, match) -> {
            messages.computeIfAbsent(child.getMothersMobile(),
                    k -> new ArrayList<>()).add(matchMessage(child, match));
        });
        return messages;
    }

    public static String outputJson(Map<Child, Child> allocations) {
        List<Child> allocatedChildren = allocations.entrySet()
                .stream()
                .map(e ->
                        new Child(
                                e.getKey().getName(),
                                e.getKey().getAge(),
                                e.getKey().getMothersMobile(),
                                Optional.of(new Angel(
                                        e.getValue().getName(),
                                        e.getValue().getMothersMobile()
                                )))
                ).collect(Collectors.toList());
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
        return gson.toJson(allocatedChildren);
    }

    private static String matchMessage(Child child, Child match) {
        return String.format("Salaam, hope you're well\n" +
                        "The Eid Angel for %s is %s! Age - %s.\n" +
                        "The mother's mobile number is %s\n",
                child.getName(), match.getName(), match.getAge(), match.getMothersMobile());
    }

}
