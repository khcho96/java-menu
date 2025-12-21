package menu.util;

import static menu.constant.ErrorMessage.COACH_COUNT_MAX_ERROR;
import static menu.constant.ErrorMessage.COACH_COUNT_MIN_ERROR;
import static menu.constant.ErrorMessage.FORMAT_ERROR;

import java.util.List;

public final class Validator {

    private static final String CSV_FORMAT = "^ *[가-힣a-zA-Z]+ *(, *[가-힣a-zA-Z]+ *)*$";

    private Validator() {}

    public static void validateCsvFormat(String input) {
        if (!input.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateCoachNames(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(COACH_COUNT_MIN_ERROR.getErrorMessage());
        }

        if (names.size() > 5) {
            throw new IllegalArgumentException(COACH_COUNT_MAX_ERROR.getErrorMessage());
        }
    }
}
