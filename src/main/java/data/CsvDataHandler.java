package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class CsvDataHandler implements DataHandler {

    public static final String COMMA_DELIMITER = ",";
    private String path;


    public CsvDataHandler(String path) {
        this.path = path;
    }

    @Override
    public List<FormResponse> transformData() throws IOException {
        List<List<String>> data = retrieveData(path);
        List<FormResponse> responses = new ArrayList<>();
        data.forEach(row -> {
            int numberOfSiblingsPartaking = parseInt(row.get(3));

            IntStream.range(0, numberOfSiblingsPartaking)
                    .map(i -> i * 3)
                    .forEach(offset -> responses.add(new FormResponse(
                            row.get(offset + 4),
                            getMothersMobile(row, offset + 5),
                            row.get(2),
                            row.get(offset + 6)
                    )));
        });
        return responses;
    }

    private String getMothersMobile(List<String> row, int offset) {
        String mobile = row.get(offset);
        return mobile.replace("'", "");
    }


    private static List<List<String>> retrieveData(String path) throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        return records;
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}
