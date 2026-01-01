package menu.util;

import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parseCoachNames(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateCoachNamesFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .toList();
    }

    public static List<String> parseNoEatMenus(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateNoEatMenusFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .toList();
    }
}
