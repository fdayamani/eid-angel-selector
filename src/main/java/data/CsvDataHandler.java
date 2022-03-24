package data;

import domain.Child;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.util.Optional.empty;

public class CsvDataHandler implements DataHandler {

    public static final String COMMA_DELIMITER = ",";
    private String path;


    public CsvDataHandler(String path) {
        this.path = path;
    }

    @Override
    public List<Child> transformData() throws IOException {
        List<List<String>> data = retrieveData(path);
        List<Child> unassigned = new ArrayList<>();
        data.forEach(row -> {
            int numberOfSiblingsPartaking = parseInt(row.get(3));

            IntStream.range(0, numberOfSiblingsPartaking)
                    .map(i -> i * 4)
                    .forEach(offset -> unassigned.add(new Child(
                            row.get(offset + 4),
                            getMothersMobile(row, offset + 5),
                            row.get(2),
                            Optional.of(new Child(
                                    row.get(offset + 6),
                                    null,
                                    getMothersMobile(row, offset + 7),
                                    empty())
                            ))));
        });
        return unassigned;
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
