package menu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    private static List<String> parseToElements(String rawInput) {
        Validator.validateCsvFormat(rawInput.strip());

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public static List<String> parseCoachNames(String rawInput) {
        List<String> names = parseToElements(rawInput);

        Validator.validateCoachNames(names);

        return names;
    }
}
