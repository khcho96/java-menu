package menu.util;

import menu.constant.ErrorMessage;

public final class Validator {

    private static final String CSV_FORMAT = "^[가-힣\\s]+ *(, *[가-힣\\s]+ *)*$";

    private Validator() {}

    public static void validateCsvFormat(String rawInput) {
        if (!rawInput.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_ERROR.getErrorMessage());
        }
    }
}
