package menu.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parseCoachNames(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateCsvFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public static List<String> parseNoEatMenus(String rawInput) {
        rawInput = rawInput.strip();

        if (rawInput.isBlank()) {
            return List.of();
        }

        Validator.validateCsvFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
