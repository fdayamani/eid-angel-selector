package data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LastYearDataHandler {
    private final String path;

    public LastYearDataHandler(String path) {
        this.path = path;
    }

    public Map<Angel, Angel> transformData() throws IOException {
        Map<Angel, Angel> allocations = new HashMap<>();
        JsonElement jsonElement = JsonParser.parseReader(new FileReader(path));
        JsonArray array = jsonElement.getAsJsonArray();

        array.iterator().forEachRemaining(e -> {
            JsonObject jsonAllocation = e.getAsJsonObject();
            JsonObject lastYearsAngelJson = jsonAllocation.get("lastYearsAngel").getAsJsonObject();
            allocations.put(new Angel(
                        jsonAllocation.get("name").getAsString(),
                        jsonAllocation.get("mothersMobile").getAsString()
                    ), new Angel(
                            lastYearsAngelJson.get("name").getAsString(),
                            lastYearsAngelJson.get("mothersMobile").getAsString()
                    ));
        });
        return allocations;
}

}
